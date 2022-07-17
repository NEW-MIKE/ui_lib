package com.example.ui_demo_start.touptek

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

import com.example.ui_demo_start.R
import com.example.ui_demo_start.databinding.ActivitySettingBinding
import com.example.ui_demo_start.touptek.fragments.*
import com.example.ui_demo_start.util.inflate
import com.google.android.material.tabs.TabLayout

class SettingActivity : BaseActivity() {
    val binding :ActivitySettingBinding by inflate(ActivitySettingBinding::inflate)
    val TAG = "SettingActivity"
    private val fragments = ArrayList<Fragment>()
    private val tabs = arrayOf(
        TabItem("main camera", MainCameraFragment::class.java),
        TabItem("guide camera", GuideCameraFragment::class.java),
        TabItem("scope", ScopeFragment::class.java),
        TabItem("focuser", FocuserFragment::class.java),
        TabItem("filter wheel", FilterWheelFragment::class.java)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        Log.e(TAG, "onCreate: ", )

        Toast.makeText(this,"onCreate: ",Toast.LENGTH_SHORT).show()
        init()
    }




    fun init(){
        initFragement()

        binding.settingMainCamera.setOnClickListener {
            initTab(0)
        }
        binding.settingGuideCamera.setOnClickListener {
            initTab(1)
        }
        binding.settingTelescope.setOnClickListener {
            initTab(2)
        }
        binding.settingFocuser.setOnClickListener {
            initTab(3)
        }
        binding.settingFilterWheel.setOnClickListener {
            initTab(4)
        }
    }

    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context,SettingActivity::class.java)
            context.startActivity(intent)
        }
    }

    private fun initFragement() {
        if (fragments.isEmpty()) {
            tabs.forEach {
                val f = it.fragmentCls.newInstance()
                fragments.add(f)
            }
        }
        val transaction = supportFragmentManager.beginTransaction()
        fragments.forEach {
            if (!it.isAdded) transaction.add(
                R.id.fl_content, it, it.javaClass
                    .simpleName
            ).hide(it)
        }
        transaction.commit()

        initTab(0)
    }


    private fun initTab(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        fragments.forEachIndexed { index, fragment ->
            Log.e("TAG", "initTab: index is " + index+" position is " +position, )
            if (index == position) {
                Log.e("TAG", "initTab: show", )
                Toast.makeText(this,"position: " + position,Toast.LENGTH_SHORT).show()
                transaction.show(fragment)
            } else {
                Log.e("TAG", "initTab: hide1", )
                transaction.hide(fragment)
            }

            if (fragment.isVisible) Toast.makeText(this,"isVisible: ",Toast.LENGTH_SHORT).show()
        }
        transaction.commit()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"onRestart: ",Toast.LENGTH_SHORT).show()
        Log.e(TAG, "onRestart: ", )
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"onStart: ",Toast.LENGTH_SHORT).show()
        Log.e(TAG, "onStart: ", )
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"onResume: ",Toast.LENGTH_SHORT).show()
        Log.e(TAG, "onResume: ", )
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"onPause: ",Toast.LENGTH_SHORT).show()
        Log.e(TAG, "onPause: ", )
    }

    override fun onStop() {
        Toast.makeText(this,"onStop: ",Toast.LENGTH_SHORT).show()
        Log.e(TAG, "onStop: ", )
        super.onStop()
    }

    override fun onDestroy() {
        Toast.makeText(this,"onDestroy: ",Toast.LENGTH_SHORT).show()
        Log.e(TAG, "onDestroy: ", )
        super.onDestroy()
    }
}