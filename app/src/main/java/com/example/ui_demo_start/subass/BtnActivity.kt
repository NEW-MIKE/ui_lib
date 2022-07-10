package com.example.ui_demo_start.subass

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator.ofFloat
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_demo_start.R
import com.example.ui_demo_start.databinding.ActivityBtnBinding
import com.example.ui_demo_start.event.MessageInfo
import com.example.ui_demo_start.util.inflate
import org.greenrobot.eventbus.EventBus

class BtnActivity : AppCompatActivity() {

    val binding:ActivityBtnBinding by inflate(ActivityBtnBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btn)
        init()
    }

    fun init(){
        binding.btn0.setOnClickListener {
            val msg = MessageInfo("dd")
            val objectAnimation = AnimatorInflater.loadAnimator(this,R.animator.animator_translation)
            objectAnimation.setTarget(binding.btn0)
            objectAnimation.start()
            EventBus.getDefault().post(msg)
        }
        binding.btn1.setOnClickListener {
        }

       
       // objectAnimation.setTarget(this)
       // objectAnimation.start()

    }

    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context,BtnActivity::class.java)
            context.startActivity(intent)
        }
    }
}