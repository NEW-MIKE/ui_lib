package com.example.ui_demo_start.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.ui_demo_start.R
class LedAbnormalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_led_abnormal)
    }
    companion object{
        fun actionStart(context: Context) {
            val intent = Intent(context, LedAbnormalActivity::class.java)
            context.startActivity(intent)
        }
    }
}