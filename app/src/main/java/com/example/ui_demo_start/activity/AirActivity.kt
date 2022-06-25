package com.example.ui_demo_start.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_demo_start.MainActivity2

import com.example.ui_demo_start.R
class AirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_air)
    }

    companion object{
        fun actionStart(context: Context) {
            val intent = Intent(context, AirActivity::class.java)
            context.startActivity(intent)
        }
    }
}