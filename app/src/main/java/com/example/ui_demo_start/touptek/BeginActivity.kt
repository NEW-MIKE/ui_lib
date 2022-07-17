package com.example.ui_demo_start.touptek

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_demo_start.R
import com.example.ui_demo_start.databinding.ActivityBeginBinding
import com.example.ui_demo_start.util.inflate

class BeginActivity  : BaseActivity() {
    val binding:ActivityBeginBinding by inflate(ActivityBeginBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_begin)
        init()
    }

    fun init() {
        binding.enter.setOnClickListener {
            MainDeviceActivity.actionStart(this)
        }
    }

    companion object{
        fun actionStart(context:Context){
            val intent = Intent(context,BeginActivity::class.java)
            context.startActivity(intent)
        }
    }
}