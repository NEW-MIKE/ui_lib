package com.example.ui_demo_start.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.ui_demo_start.R
import com.example.ui_demo_start.databinding.DialogLayoutOneBinding
import com.example.ui_demo_start.util.inflate
interface NormalDialogListenter{
    fun flattv()
}
class NormalDialog(context: Context) : Dialog(context) {
    val binding:DialogLayoutOneBinding by inflate(DialogLayoutOneBinding::inflate)

    var listenter:NormalDialogListenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_layout_one)
        binding.flatTv.setOnClickListener {
            listenter?.flattv()
        }
    }

    fun setOnClickLisener(listenter: NormalDialogListenter):NormalDialog{
        this.listenter = listenter
        return this
    }
}