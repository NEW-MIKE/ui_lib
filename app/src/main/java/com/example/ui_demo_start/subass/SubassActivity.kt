package com.example.ui_demo_start.subass

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_demo_start.R
import com.example.ui_demo_start.databinding.ActivityStartBinding
import com.example.ui_demo_start.databinding.ActivitySubassBinding
import com.example.ui_demo_start.util.inflate

class SubassActivity : AppCompatActivity() {

    val binding: ActivitySubassBinding by inflate(ActivitySubassBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subass)
        init()
    }

    fun init(){
        binding.btnbtn.setOnClickListener {
            BtnActivity.actionStart(this)
        }
    }

    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context,SubassActivity::class.java)
            context.startActivity(intent)
        }
    }
}