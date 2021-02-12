package edu.sapient.ice

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.ice.grpc.protos.*


//import com.ice.grpc.protos.ProductCatalogServiceGrpc

class Utils {

    companion object {
        fun showErrorPopup(function: (category: ProductCategory, pageNumber: Int) -> Unit, context: Context, request: ProductListRequest) {
            // build alert dialog
            val dialogBuilder = AlertDialog.Builder(context)

            // set message of alert dialog
            dialogBuilder.setMessage("Network Error, Please try again")
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Retry", DialogInterface.OnClickListener { dialog, id ->
                    function(request.productType, request.pageNumber)
                })
                // negative button text and action
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                    (context as Activity).finish()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("ICE-2021")
            // show alert dialog
            alert.show()
        }

    }

}