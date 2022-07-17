package com.example.ui_demo_start.touptek.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_demo_start.R

class ListSwipeAdapter(val datas:ArrayList<String>): RecyclerView.Adapter<ListSwipeAdapter.NormalHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NormalHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = NormalHolder(inflater.inflate(R.layout.screen_add_goto_item_layout,parent,false))
        return view
    }

    override fun onBindViewHolder(holder: NormalHolder, position: Int) {
        holder.goToTargetTv.setOnClickListener {

        }

        holder.addToFavoriteTv.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }


    inner class NormalHolder(itemView: View): RecyclerView.ViewHolder(itemView),Extension  {
        val goToTargetTv:TextView = itemView.findViewById(R.id.go_to_target)

        val addToFavoriteTv:TextView = itemView.findViewById(R.id.add_to_favorite_tv)

        val cl_control: ConstraintLayout = itemView.findViewById(R.id.cl_control)

        val startIV : ImageView = itemView.findViewById((R.id.star_iv))

        val chartView:ImageView = itemView.findViewById(R.id.chart_view)

        val swipLL:LinearLayout = itemView.findViewById(R.id.swipLL)
        override fun getActionWidth(): Float {
            return goToTargetTv.width.toFloat()
        }
    }
}
