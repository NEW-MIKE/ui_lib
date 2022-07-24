package com.example.astroclient.view.ScrollPickerView

import android.view.View
import androidx.annotation.LayoutRes

interface IViewProvider<T> {
    @LayoutRes
    fun resLayout(): Int
    fun onBindView(view: View, itemData: T?)
    fun updateView(itemView: View, isSelected: Boolean)
}