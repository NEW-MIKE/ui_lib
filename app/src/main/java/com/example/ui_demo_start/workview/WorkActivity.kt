package com.example.ui_demo_start.workview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_demo_start.R
import com.example.ui_demo_start.databinding.ActivityWorkBinding
import com.example.ui_demo_start.util.inflate

class WorkActivity : AppCompatActivity() {

    val binding : ActivityWorkBinding by inflate(ActivityWorkBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)
        init()
    }

    fun init(){
        binding.enterGuide.setOnClickListener {

        }
        binding.enterSequence.setOnClickListener {

        }
        binding.enterTelescope.setOnClickListener {
            TelescopeActivity.actionStart(this)
        }
        binding.enterDialog.setOnClickListener {

        }
    }

    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context,WorkActivity::class.java)
            context.startActivity(intent)
        }
    }
}