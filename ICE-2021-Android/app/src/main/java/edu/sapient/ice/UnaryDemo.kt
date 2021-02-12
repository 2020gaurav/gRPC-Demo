package edu.sapient.ice

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.ice.grpc.protos.*
import edu.sapient.ice.UIUtils.PaginationScrollListener
import io.grpc.ManagedChannel
import io.grpc.android.AndroidChannelBuilder
import kotlinx.android.synthetic.main.product_layout.*
import kotlinx.android.synthetic.main.product_list_item.*
import kotlinx.coroutines.*


//import com.ice.grpc.protos.ProductCatalogServiceGrpc

class UnaryDemo : AppCompatActivity() {
    private lateinit var listener: PaginationScrollListener
    private var totalPages: Int = 0
    private var currentPage: Int = 1
    private var isLoading: Boolean = false
    private var category: ProductCategory = ProductCategory.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_layout)
        setToolbar()
        initProductList()
        getProducts(ProductCategory.ALL, currentPage)
    }

    private fun setToolbar() {
        setSupportActionBar(appBar);
        supportActionBar?.setDisplayShowTitleEnabled(true);
        appBar.inflateMenu(R.menu.menu);
    }

    /**
     * Prepare gRPC channel (Android specific in this case) to connect with gRPC server
     */
    private fun getChannel() : ManagedChannel? {
        return AndroidChannelBuilder.forAddress("192.168.1.161", 30071)
            .context(this)
            .usePlaintext()     // To Disable SSL, but not recommended for production
            .executor(Dispatchers.Default.asExecutor())
            .build()
    }

    private val productService by lazy {
        ProductCatalogServiceGrpc.newBlockingStub(getChannel()) // Option 1 to get blocking stub
//        ProductCatalogServiceGrpc.newFutureStub(getChannel()) // Option 2 to get future stub

    }

    private fun getProducts(category: ProductCategory = ProductCategory.ALL, pageNumber: Int) {
        val request = ProductListRequest.newBuilder().setProductType(category).setPageNumber(
            pageNumber
        ).build()
        try {
            val productDetailResponse: ProductListResponse
            runBlocking {
                productDetailResponse = productService.filterProductByCategory(request) // This is RPC call
            }
            totalPages = productDetailResponse.totalPages
            updateDataOnList(productDetailResponse)
        } catch (e: Exception) {
            // Network or specific exception handling
            Utils.showErrorPopup(this::getProducts, this, request)
        }
    }

    private fun initProductList() {
        val adapter = ProductAdapter(onClick = {

        }, mutableListOf())
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.isNestedScrollingEnabled = false;
        nestedScrollView.viewTreeObserver.addOnScrollChangedListener(
            object : PaginationScrollListener(recyclerView.layoutManager as LinearLayoutManager, nestedScrollView) {
                override fun loadMoreItems() {
                    if (currentPage <= totalPages) {
                        this@UnaryDemo.isLoading = true
                        progress.visibility = View.VISIBLE
                        getProducts(category, ++currentPage)
                    } else {
                        progress.visibility = View.GONE
                        Toast.makeText(this@UnaryDemo, "End of List", Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }

    private fun updateDataOnList(productResponse: ProductListResponse) {
        progress.visibility = View.GONE
        isLoading = false
        (recyclerView.adapter as ProductAdapter).addMore(productResponse.productsList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        enumValues<ProductCategory>().forEach {
            if (it != ProductCategory.ALL && it != ProductCategory.UNRECOGNIZED)
                menu?.add(Menu.NONE, it.ordinal, Menu.NONE, it.name)
        }
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        category = ProductCategory.values()[item.itemId]
        (recyclerView.adapter as ProductAdapter).clear()
        currentPage = 0
        getProducts(category, currentPage)
        return super.onOptionsItemSelected(item)
    }
}