package com.example.ui_demo_start.subass

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.ui_demo_start.R
import com.example.ui_demo_start.databinding.ActivityDialogBinding
import com.example.ui_demo_start.util.inflate
import com.example.ui_demo_start.view.NormalDialog
import com.example.ui_demo_start.view.NormalDialogListenter

class DialogActivity : AppCompatActivity() {
    val binding:ActivityDialogBinding by inflate(ActivityDialogBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        inite()
    }

    fun inite(){
        binding.showDialog.setOnClickListener {

            val norDialog = NormalDialog(this,R.style.NormalDialogStyle)
            norDialog.setOnClickLisener(object :NormalDialogListenter{
                override fun flattv() {

                    Log.e("TAG", "inite: ", )
                    //Toast.makeText(DialogActivity::class.java,"dd",Toast.LENGTH_LONG).show()
                }

            }).show()
            val alertDialog = AlertDialog.Builder(this,R.style.NormalDialogStyle)
            val v = alertDialog.setView(R.layout.dialog_layout_one)
            val view = View.inflate(this,R.layout.dialog_layout_one,null)
            view.findViewById<TextView>(R.id.flat_tv).setOnClickListener {
                Log.e("TAG", "inite: ", )
            }

           // alertDialog.show()
        }
    }
    companion object{
        fun actionStart(context:Context){
            val intent = Intent(context,DialogActivity::class.java)
            context.startActivity(intent)
        }
    }
}