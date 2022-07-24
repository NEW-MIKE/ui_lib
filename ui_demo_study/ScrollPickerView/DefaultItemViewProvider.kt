package com.example.astroclient.view.ScrollPickerView

import android.graphics.Color
import android.view.View
import android.widget.EditText
import com.example.astroclient.view.ScrollPickerView.IViewProvider
import com.example.astroclient.R
import android.widget.TextView
import com.example.astroclient.util.ScreenUtil

class DefaultItemViewProvider : IViewProvider<String?> {
    override fun resLayout(): Int {
        return R.layout.scroll_picker_default_item_layout
    }

    override fun onBindView(view: View, text: String?) {
        val tv = view.findViewById<EditText>(R.id.tv_content)
        tv.setText(text)
        view.tag = text
        tv.textSize = ScreenUtil.spToPx(8f).toFloat()
        tv.setOnClickListener {
            tv.isFocusable = true
        }
    }

    override fun updateView(itemView: View, isSelected: Boolean) {
        val tv = itemView.findViewById<TextView>(R.id.tv_content)
        val textSize = (if (isSelected) 8 else 6)
        tv.textSize = ScreenUtil.spToPx(textSize.toFloat()).toFloat()
        tv.setTextColor(Color.parseColor(if (isSelected) "#0E8211" else "#FFFFFF"))
    }
}