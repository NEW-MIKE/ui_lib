package com.example.ui_demo_start.touptek

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.ui_demo_start.R
import com.example.ui_demo_start.databinding.ActivityLibraryBinding
import com.example.ui_demo_start.touptek.adapter.ItemTouchHelperExtension
import com.example.ui_demo_start.touptek.adapter.ListSwipeAdapter
import com.example.ui_demo_start.touptek.adapter.ListSwipeAdapter2
import com.example.ui_demo_start.touptek.adapter.ListSwipeTouchHelperCallBack
import com.example.ui_demo_start.util.inflate

class LibraryActivity  : BaseActivity() {
    val binding : ActivityLibraryBinding by inflate(ActivityLibraryBinding::inflate)
    val datas  = ArrayList<String>()
    private lateinit var mItemTouchHelper : ItemTouchHelperExtension

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        init()
    }

    fun init(){
        datas.add("12")
        datas.add("12")
        datas.add("12")
        datas.add("12")
        val mlayoutManager = LinearLayoutManager(this)
        mlayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.ListSwipeRv.apply {
            layoutManager = mlayoutManager
            addItemDecoration(DividerItemDecoration(this@LibraryActivity,DividerItemDecoration.VERTICAL))
            val madapter = ListSwipeAdapter(datas)
            adapter = madapter
            mItemTouchHelper = ItemTouchHelperExtension(ListSwipeTouchHelperCallBack(datas, madapter))
            mItemTouchHelper.attachToRecyclerView(this)
        }
    }
    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context,LibraryActivity::class.java)
            context.startActivity(intent)
        }
    }
}