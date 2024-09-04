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
        // receive parameters from the previous activity
        val name = intent.getStringExtra("name")
        val registered = intent.getBooleanExtra("registered", false)

        // display the parameters in a TextView
        findViewById<TextView>(R.id.tv_result).setText(
            "Hello $name! ${if (registered) "You are registered" else "You are not registered yet"}"
        )
    }
}