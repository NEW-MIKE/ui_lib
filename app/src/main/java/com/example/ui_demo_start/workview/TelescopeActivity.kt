package com.example.ui_demo_start.workview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_demo_start.R

class TelescopeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telescope)
    }

    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context,TelescopeActivity::class.java)
            context.startActivity(intent)
        }
    }
}