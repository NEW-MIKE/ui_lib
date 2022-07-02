package com.example.ui_demo_start.subass

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_demo_start.R

class BtnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btn)
    }

    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context,BtnActivity::class.java)
            context.startActivity(intent)
        }
    }
}