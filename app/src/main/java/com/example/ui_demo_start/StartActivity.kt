package com.example.ui_demo_start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_demo_start.databinding.ActivityStartBinding
import com.example.ui_demo_start.util.inflate

class StartActivity : AppCompatActivity() {

    val binding: ActivityStartBinding by inflate(ActivityStartBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        init()
    }

    fun init()
    {
        binding.layout.setOnClickListener {
            MainActivity.actionStart(this)
        }
    }
}