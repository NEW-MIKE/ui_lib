package com.example.ui_demo_start.touptek

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import com.example.ui_demo_start.R
import com.example.ui_demo_start.databinding.ActivityMainDeviceBinding
import com.example.ui_demo_start.touptek.view.CoverFlowLayoutManager
import com.example.ui_demo_start.util.inflate

class MainDeviceActivity : BaseActivity() {
    val binding:ActivityMainDeviceBinding by inflate(ActivityMainDeviceBinding::inflate)
    lateinit var MenuPopWindows:MainPopMenu
    private val mDatas = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_device)
        init()
    }
    fun init(){
        for (i in 0..199) {
            mDatas.add("第 $i 个item")
        }
        MenuPopWindows = MainPopMenu(this)
        MenuPopWindows.width = 400
        MenuPopWindows.height = ViewGroup.LayoutParams.WRAP_CONTENT
        binding.photobtn.setOnClickListener {
            if (!MenuPopWindows.isShowing)
                MenuPopWindows.showAtLocation(it, Gravity.TOP or Gravity.LEFT,it.width,800)
            else   MenuPopWindows.dismiss()
        }

        binding.dockPanel.setOnClickListener {
            GuideActivity.actionStart(this)
        }

        binding.setting.setOnClickListener {
            SettingActivity.actionStart(this)
        }

        binding.browserBtn.setOnClickListener {
            BrowserActivity.actionStart(this)
        }

        binding.screenBtn.setOnClickListener {
            LibraryActivity.actionStart(this)
        }

        binding.volumeUp.setOnClickListener {
            binding.volumeUp.volumeUp()
        }

        binding.coverFlowRv.apply {
            layoutManager = CoverFlowLayoutManager()

        }
    }

    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context,MainDeviceActivity::class.java)
            context.startActivity(intent)
        }
    }

}