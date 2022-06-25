package com.example.ui_demo_start.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.ui_demo_start.R
class ImagePreviewVideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_preview_video)
    }
    companion object{
        fun actionStart(context: Context) {
            val intent = Intent(context, ImagePreviewVideoActivity::class.java)
            context.startActivity(intent)
        }
    }
}