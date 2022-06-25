package com.example.ui_demo_start.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.ui_demo_start.R
class UpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
    }
    companion object{
        fun actionStart(context: Context) {
            val intent = Intent(context, UpdateActivity::class.java)
            context.startActivity(intent)
        }
    }
}