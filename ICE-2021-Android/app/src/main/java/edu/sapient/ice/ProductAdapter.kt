package edu.sapient.ice

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ice.grpc.protos.Product

class ProductAdapter(private val onClick: (Product) -> Unit, val products: MutableList<Product>) : RecyclerView.Adapter<ProductViewHolder>() {

    /* Creates and inflates view and return FlowerViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_item, parent, false)
        return ProductViewHolder(view, onClick)
    }

    /* Gets current flower and uses it to bind view. */
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val flower = products[position]
        holder.bind(flower)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    public fun addMore(products: List<Product>) {
        this.products.addAll(products)
        notifyDataSetChanged()
    }

    public fun clear() {
        this.products.clear()
        notifyItemRangeRemoved(0, this.products.size)
    }
}