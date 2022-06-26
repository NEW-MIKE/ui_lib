package com.example.ui_demo_start.view.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class AutoRunTotalProgressView(paramContext: Context, paramAttributeSet: AttributeSet):View(paramContext,paramAttributeSet) {
    private val COLOR_GRAY = Color.parseColor("#BBBBBB")
    private val COLOR_GREEN = Color.parseColor("#259B24")
    private val DEFALT_PROGRESS_BAR_WIDTH_PERCENT = 0.1f
    private val centerBgColor = 0
    private val mPaint: Paint? = null
    private var progress = 0.0f
    private val progressBarPercent = 0f

    init {
/*        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AutoRunTotalProgressView);
        this.centerBgColor = paramContext.getColor(R.styleable.AutoRunTotalProgressView_center_background_color, Color.parseColor("#FFFFFF"));
        this.progressBarPercent = paramContext.getFloat(R.styleable.AutoRunTotalProgressView_progress_bar_width_percent, 0.1F);
        paramContext.recycle();
        this.mPaint = new Paint(1);*/
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