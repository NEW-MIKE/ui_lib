package com.example.ui_demo_start.touptek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui_demo_start.R
import com.example.ui_demo_start.databinding.FragmentGuideCameraBinding

class GuideCameraFragment :  BaseFragment<FragmentGuideCameraBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_guide_camera

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}