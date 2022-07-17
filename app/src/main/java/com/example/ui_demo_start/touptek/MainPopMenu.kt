package com.example.ui_demo_start.touptek

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.PopupWindow
import com.example.ui_demo_start.databinding.MaindevicemenuLayoutBinding
import com.example.ui_demo_start.databinding.MenuPopLayoutBinding

class MainPopMenu(context: Context?) : PopupWindow()  {

    val binding: MaindevicemenuLayoutBinding
    init {
        binding = MaindevicemenuLayoutBinding.inflate(LayoutInflater.from(context))
        contentView = binding.root
        isFocusable = true
        isOutsideTouchable = true
        setBackgroundDrawable(ColorDrawable())
        binding.planPhotoBtn.setOnClickListener {
            TaskActivity.actionStart(context!!)
        }
    }

}