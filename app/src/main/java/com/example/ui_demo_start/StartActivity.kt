package com.example.ui_demo_start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_demo_start.databinding.ActivityStartBinding
import com.example.ui_demo_start.subass.SubassActivity
import com.example.ui_demo_start.touptek.BeginActivity
import com.example.ui_demo_start.util.inflate
import com.example.ui_demo_start.workview.WorkActivity

class StartActivity : AppCompatActivity() {

    val binding: ActivityStartBinding by inflate(ActivityStartBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        init()
    }

    fun init()
    {
        binding.touptek.setOnClickListener {
            BeginActivity.actionStart(this)
        }

        binding.layout.setOnClickListener {
            MainActivity.actionStart(this)
        }

        binding.subass.setOnClickListener {
            SubassActivity.actionStart(this)
        }

        binding.workView.setOnClickListener {
            WorkActivity.actionStart(this)
        }
    }
}