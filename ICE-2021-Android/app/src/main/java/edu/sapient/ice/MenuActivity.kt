package edu.sapient.ice

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun onUnaryClicked(view: View) {
        val intent = Intent(this, UnaryDemo::class.java)
        startActivity(intent)
    }

    fun biDirectionalClicked(view: View) {
        val intent = Intent(this, BiDirectionalDemo::class.java)
        startActivity(intent)
    }
}