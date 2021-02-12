package edu.sapient.ice

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.ice.grpc.protos.ProductCatalogServiceGrpc
import com.ice.grpc.protos.ProductCategory
import com.ice.grpc.protos.ProductListRequest
import com.ice.grpc.protos.ProductListResponse
import edu.sapient.ice.UIUtils.PaginationScrollListener
import io.grpc.ManagedChannel
import io.grpc.android.AndroidChannelBuilder
import io.grpc.stub.StreamObserver
import kotlinx.android.synthetic.main.product_layout.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.runBlocking

class BiDirectionalDemo : AppCompatActivity() {
    private var totalPages: Int = 0
    private var currentPage: Int = 1
    private var isLoading: Boolean = false
    private var category: ProductCategory = ProductCategory.ALL
    private lateinit var requestStream: StreamObserver<ProductListRequest>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_layout)
        setToolbar()
        initProductList()
        connectToProductsStream(ProductCategory.ALL, currentPage)
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

    private val productService by lazy { ProductCatalogServiceGrpc.newStub(getChannel()) }

    private fun connectToProductsStream(category: ProductCategory = ProductCategory.ALL, pageNumber: Int) {

        try {
            requestStream = productService.getProductList(
                object : StreamObserver<ProductListResponse> {
                    override fun onNext(response: ProductListResponse) {
                        // Product Streamed response
                        totalPages = response.totalPages
                        updateDataOnList(response)
                    }

                    override fun onError(t: Throwable?) {
                        // Error in product stream
                        Utils.showErrorPopup(
                            this@BiDirectionalDemo::connectToProductsStream,
                            this@BiDirectionalDemo,
                            getProductListRequest(category, pageNumber)
                        )
                    }

                    override fun onCompleted() {
                        // Server closed the stream
                        Toast.makeText(
                            this@BiDirectionalDemo, "No More data on Server",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            )
            requestStream.onNext(getProductListRequest(category, pageNumber))
        } catch (e: Exception) {
            Utils.showErrorPopup(this::connectToProductsStream, this,
                getProductListRequest(category, pageNumber)
            )
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
                        this@BiDirectionalDemo.isLoading = true
                        progress.visibility = View.VISIBLE
                        getNextPage(category, ++currentPage)
                    } else {
                        progress.visibility = View.GONE
                        Toast.makeText(this@BiDirectionalDemo, "End of List", Toast.LENGTH_SHORT).show()
                        requestStream.onCompleted()
                    }
                }
            })
    }

    private fun getNextPage(category: ProductCategory, pageNumber: Int) {
        requestStream.onNext(getProductListRequest(category, pageNumber))
    }

    private fun updateDataOnList(productResponse: ProductListResponse) {
        runOnUiThread {
            progress.visibility = View.GONE
            isLoading = false
            (recyclerView.adapter as ProductAdapter).addMore(productResponse.productsList)
        }
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
        connectToProductsStream(category, currentPage)
        return super.onOptionsItemSelected(item)
    }

    fun getProductListRequest(category: ProductCategory, pageNumber: Int): ProductListRequest {
        return ProductListRequest.newBuilder().setProductType(category).setPageNumber(
            pageNumber
        ).build()
    }

    override fun onDestroy() {
        requestStream.onCompleted()
        super.onDestroy()
    }
}