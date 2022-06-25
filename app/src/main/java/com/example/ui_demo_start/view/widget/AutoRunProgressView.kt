package com.example.ui_demo_start.view.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class AutoRunProgressView(paramContext: Context,  paramAttributeSet: AttributeSet):View(paramContext,paramAttributeSet) {
    private var mPaint: Paint? = null
    private var progress = 0.0f

    init {
        mPaint = Paint()
        mPaint!!.color = Color.parseColor("#259B24")
        mPaint!!.setStyle(Paint.Style.FILL)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val i = width
        val j = height
        canvas!!.drawRect(0.0f, 0.0f, progress * i, j.toFloat(), mPaint!!)
    }
    fun setProgress(paramFloat: Float) {
        progress = paramFloat
        invalidate()
    }
}