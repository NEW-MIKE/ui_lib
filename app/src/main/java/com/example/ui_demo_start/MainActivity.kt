package com.example.ui_demo_start

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.ui_demo_start.activity.*
import com.example.ui_demo_start.databinding.ActivityMainBinding
import com.example.ui_demo_start.util.inflate

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by inflate(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    companion object{
        fun actionStart(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
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
            ConnectActivity.actionStart(this)
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
            ImagePreviewVideoActivity.actionStart(this)
        }
        binding.LedAbnormal.setOnClickListener {
            LedAbnormalActivity.actionStart(this)
        }
        binding.LogList.setOnClickListener {
            LogListActivity.actionStart(this)
        }
        binding.LogViewer.setOnClickListener {
            LogViewerActivity.actionStart(this)
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
        binding.update.setOnClickListener {
            UpdateActivity.actionStart(this)
        }
    }
}