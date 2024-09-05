package com.mbialowas.layoutdemos279

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConstraintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_constraint)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn_submit = findViewById<Button>(R.id.btn_submit) // register our btn in code
        val et_name = findViewById<EditText>(R.id.et_name)
        val cb_registered = findViewById<CheckBox>(R.id.cb_registered)

        val btn_param = findViewById<Button>(R.id.btn_param)

        val btn_ext_ctrl = findViewById<Button>(R.id.btn_ext_ctrl)

        btn_submit.setOnClickListener {
            intent = Intent(this, RelativeActivity::class.java)
            startActivity(intent)
        }

        btn_param.setOnClickListener {
            intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("name", et_name.text.toString())
            intent.putExtra("registered", cb_registered.isChecked)
            startActivity(intent)
        }

        btn_ext_ctrl.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.cnn.com"))
            //intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cnn.com"))
            startActivity(intent)
        }






    }
}