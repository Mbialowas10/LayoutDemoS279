package com.mbialowas.layoutdemos279

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // receive the intent
        val bundle: Bundle? = intent.extras
        val input = bundle?.getString("name")
        val registered = bundle?.getBoolean("registered")

        findViewById<TextView>(R.id.tv_results).setText("Hello $input! ${if (registered == false) "Please register for exciting event on gardening:)" else "Thank you for registering!"}")
    }
}