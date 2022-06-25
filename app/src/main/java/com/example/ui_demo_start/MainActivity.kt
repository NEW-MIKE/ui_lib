package com.example.ui_demo_start

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.ui_demo_start.activity.AirActivity
import com.example.ui_demo_start.activity.ChooseObjectActivity
import com.example.ui_demo_start.activity.ConnectGuideStepActivity
import com.example.ui_demo_start.databinding.ActivityMainBinding
import com.example.ui_demo_start.util.inflate

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by inflate(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        binding.Air.setOnClickListener {
            AirActivity.actionStart(this)
        }
        binding.AlbumSelect.setOnClickListener {

        }
        binding.BigImage.setOnClickListener {

        }
        binding.ChooseObject.setOnClickListener {
            ChooseObjectActivity.actionStart(this)
        }
        binding.Connect.setOnClickListener {

        }
        binding.ConnectGuideStep.setOnClickListener {
            ConnectGuideStepActivity.actionStart(this)
        }
        binding.CropImage.setOnClickListener {

        }
        binding.Dream.setOnClickListener {

        }
        binding.Empty.setOnClickListener {

        }
        binding.ImageManagement.setOnClickListener {

        }
        binding.ImagePreview.setOnClickListener {

        }
        binding.ImagePreviewVideo.setOnClickListener {

        }
        binding.LedAbnormal.setOnClickListener {

        }
        binding.LogList.setOnClickListener {

        }
        binding.LogViewer.setOnClickListener {

        }
        binding.PlanRunObjectSeqs.setOnClickListener {

        }
        binding.PlanRunSetting.setOnClickListener {

        }
        binding.SearchObject.setOnClickListener {

        }
        binding.SkMap.setOnClickListener {

        }
        binding.StackImage.setOnClickListener {

        }
        binding.StackVideoInfo.setOnClickListener {

        }
        binding.StackVideoShow.setOnClickListener {

        }
        binding.Web.setOnClickListener {

        }
    }
}