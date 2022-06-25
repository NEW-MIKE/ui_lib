package com.example.ui_demo_start

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.air_setting_layout)
    }

    companion object{
        fun actionStart(context: Context) {
            val intent = Intent(context, MainActivity2::class.java)
            context.startActivity(intent)
        }
    }

}