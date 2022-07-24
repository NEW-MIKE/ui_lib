package com.example.ui_demo_start.touptek.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_demo_start.R

class ListSwipeAdapter2(val datas:ArrayList<String>): RecyclerView.Adapter<ListSwipeAdapter2.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ViewHolder(inflater.inflate(R.layout.item_linear,parent,false))
        return view
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.goToTargetTv.setOnClickListener {
            Log.e("TAG", "onBindViewHolder: gototarget", )
        }

    }

    override fun getItemCount(): Int {
        return datas.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val goToTargetTv:TextView = itemView.findViewById(R.id.tv_item_delete)
        val goToTargetTv1:TextView = itemView.findViewById(R.id.tv_item_delet1e)
        val mhidden:LinearLayout = itemView.findViewById(R.id.ll_hidden)
        val item :LinearLayout = itemView.findViewById(R.id.ll_item)
    }
}
