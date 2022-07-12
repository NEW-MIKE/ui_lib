package com.example.ui_demo_start.subass

import android.content.Context
import android.view.LayoutInflater
import android.widget.PopupWindow
import com.example.ui_demo_start.databinding.MenuPopLayoutBinding

class menu_popwindow(context: Context?) : PopupWindow() {
    val binding: MenuPopLayoutBinding
    init {
        binding = MenuPopLayoutBinding.inflate(LayoutInflater.from(context))
        contentView = binding.root
        isFocusable = true
        binding.textview.text = "是的"
    }
}