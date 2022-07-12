package com.example.ui_demo_start.subass

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_demo_start.R
import com.example.ui_demo_start.databinding.ActivitySubassBinding
import com.example.ui_demo_start.event.MessageInfo
import com.example.ui_demo_start.util.inflate
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class SubassActivity : AppCompatActivity() {

    val binding: ActivitySubassBinding by inflate(ActivitySubassBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subass)
        EventBus.getDefault().register(this)
        init()
    }

    fun init(){
        binding.btnbtn.setOnClickListener {
            BtnActivity.actionStart(this)
        }

        binding.btndialog.setOnClickListener {
            DialogActivity.actionStart(this)
        }

        binding.popwindowBtn.setOnClickListener{
            PopWindowActivity.actionStart(this)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onReceiveMsg(message: MessageInfo) {
        Toast.makeText(this,"sbb",Toast.LENGTH_LONG).show()
        Log.e("TAG", "onReceiveMsg: ", )
    }

    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context,SubassActivity::class.java)
            context.startActivity(intent)
        }
    }
}