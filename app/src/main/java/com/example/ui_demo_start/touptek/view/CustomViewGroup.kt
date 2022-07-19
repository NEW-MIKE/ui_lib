package com.example.ui_demo_start.touptek.view

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.View.MeasureSpec

class CustomViewGroup : ViewGroup {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //测量子控件
        measureChildren(widthMeasureSpec, heightMeasureSpec)

        //获取当宽/高设为wrap_content时，此模式下的控件宽高
        var height = 0
        var maxWidth = 0
        val count = childCount
        for (i in 0 until count) {
            val child = getChildAt(i)
            val childWidth = child.measuredWidth
            if (childWidth > maxWidth) {
                maxWidth = childWidth
            }
            val childHeight = child.measuredHeight
            height += childHeight
        }

        //在wrap_content模式下，设置控件宽高
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(maxWidth, height)
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(maxWidth, heightSize)
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, height)
        } else {
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var top = 0
        val count = childCount
        for (i in 0 until count) {
            val child = getChildAt(i)
            val childWidth = child.measuredWidth
            val childHeight = child.measuredHeight
            child.layout(0, top, childWidth, top + childHeight)
           // top += 30
        }
    }
}