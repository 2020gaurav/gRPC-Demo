package edu.sapient.ice

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ice.grpc.protos.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_list_item.view.*

class ProductViewHolder (itemView: View, val onClick: (Product) -> Unit) :
    RecyclerView.ViewHolder(itemView)  {

    private var productItem: Product? = null

    init {
        itemView.setOnClickListener {
            productItem?.let {
                onClick(it)
            }
        }
    }

    /* Bind flower name and image. */
    fun bind(flower: Product) {
        productItem = flower
        itemView.name.text = flower.name
        itemView.price.text = flower.price.toString()
        itemView.category.text = flower.category.name
        Picasso.get()
            .load(flower.imageUrlBig)
            .error(R.drawable.image_error_icon)
            .into(itemView.display_img);

    }

}