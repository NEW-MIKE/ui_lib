package com.example.ui_demo_start.touptek

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.ui_demo_start.R
class GuideActivity  : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
    }

    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context,GuideActivity::class.java)
            context.startActivity(intent)
        }
    }
}