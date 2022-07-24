package com.example.astroclient.view.ScrollPickerView

import android.view.View

interface IPickerViewOperation {
    fun getSelectedItemOffset(): Int

    fun getVisibleItemNumber(): Int

    fun getLineColor(): Int

    fun updateView(itemView: View?, isSelected: Boolean)
}