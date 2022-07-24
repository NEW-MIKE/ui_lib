package com.example.ui_demo_start.touptek.qqdelete;

import android.graphics.Canvas;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ui_demo_start.touptek.qqdelete.library.ItemTouchHelperExtension;

import java.util.ArrayList;

/**
 * 使用ItemTouchHelper的实现代码
 */
/*public class QQDeleteTouchHelperCallBack extends ItemTouchHelper.Callback {
    private ArrayList<String> mDatas;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;

    public QQDeleteTouchHelperCallBack(ArrayList<String> datas, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        mDatas = datas;
        mAdapter = adapter;
    }


    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = 0;
        int swipeFlags = ItemTouchHelper.LEFT;
        int flags = makeMovementFlags(dragFlags, swipeFlags);
        return flags;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
    }

    *//**
     * 方法一：使用getDefaultUIUtil()实现
     *//*
*//*
    @Override
    public void onChildDraw(Canvas c,RecyclerView recyclerView,RecyclerView.ViewHolder viewHolder,float dX,float dY, int actionState, boolean isCurrentlyActive) {
//        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        getDefaultUIUtil().onDraw(c,recyclerView,((QQDeleteAdapter.NormalHolder)viewHolder).mItemText,dX,dY,actionState,isCurrentlyActive);
    }

    @Override
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
//        super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        getDefaultUIUtil().onDrawOver(c, recyclerView, ((QQDeleteAdapter.NormalHolder)viewHolder).mItemText, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public void clearView(RecyclerView recyclerView, ViewHolder viewHolder) {
//        super.clearView(recyclerView, viewHolder);
        getDefaultUIUtil().clearView(((QQDeleteAdapter.NormalHolder)viewHolder).mItemText);
    }

    @Override
    public void onSelectedChanged(ViewHolder viewHolder, int actionState) {
//        super.onSelectedChanged(viewHolder, actionState);
        getDefaultUIUtil().onSelected(((QQDeleteAdapter.NormalHolder)viewHolder).mItemText);
    }*//*

    *//**
     * 方法二：自定义translate对象
     *//*
    private int mMaxWidth = 500;
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
//        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            Log.d("qijian", "dx:" + dX);
            if (dX < -mMaxWidth) {
                dX = -mMaxWidth;
            }
            ((QQDeleteAdapter.NormalHolder)viewHolder).mItemText.setTranslationX((int) dX);
        }
    }
}*/



/**
 * 使用ItemTouchHelperExtension的实现代码
 */
public class QQDeleteTouchHelperCallBack extends ItemTouchHelperExtension.Callback {
    private ArrayList<String> mDatas;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;

    public QQDeleteTouchHelperCallBack(ArrayList<String> datas, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        mDatas = datas;
        mAdapter = adapter;
    }


    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = 0;
        int swipeFlags = ItemTouchHelper.LEFT;
        int flags = makeMovementFlags(dragFlags, swipeFlags);
        return flags;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
//        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            ((QQDeleteAdapter.NormalHolder)viewHolder).mItemText.setTranslationX((int) dX);
        }
    }
}

