package com.example.ui_demo_start.touptek.adapter

import android.graphics.Canvas
import android.util.Log
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class ListSwipeTouchHelperCallBack(val datas:ArrayList<String>,
                                   adapter: ListSwipeAdapter) : ItemTouchHelperExtension.Callback() {
/*    class ListSwipeTouchHelperCallBack(val datas:ArrayList<String>,
                                       adapter: ListSwipeAdapter) : ItemTouchHelper.Callback() {*/
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlag = 0
        val swipeFlags =  ItemTouchHelper.LEFT
        val flags = makeMovementFlags(dragFlag,swipeFlags)
        return flags
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        //super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE){

            (viewHolder as ListSwipeAdapter.NormalHolder).swipLL.translationX = dX
            //viewHolder.cl_control.translationX = dX
            //viewHolder.swipLL.translationX = dX
            if (dX == 0f)viewHolder.clickable = false
            else viewHolder.clickable = true
            Log.e("TAG", "onChildDraw: "+dX, )
        }
    }
}