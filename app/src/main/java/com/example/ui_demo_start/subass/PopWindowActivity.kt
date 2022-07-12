package com.example.ui_demo_start.subass

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_demo_start.R
import com.example.ui_demo_start.databinding.ActivityPopWindowBinding
import com.example.ui_demo_start.util.inflate


class PopWindowActivity : AppCompatActivity() {
    val binding : ActivityPopWindowBinding by inflate(ActivityPopWindowBinding::inflate)
    lateinit var menu_popwindows:menu_popwindow
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_window)
        init()
    }

    fun init(){
        menu_popwindows = menu_popwindow(this)
        menu_popwindows.width = ViewGroup.LayoutParams.WRAP_CONTENT
        menu_popwindows.height = 700

        binding.textId1.setOnClickListener {
            menu_popwindows.showAtLocation(it, Gravity.TOP or Gravity.RIGHT,420,0)
        }
    }

    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context,PopWindowActivity::class.java)
            context.startActivity(intent)
        }
    }
}