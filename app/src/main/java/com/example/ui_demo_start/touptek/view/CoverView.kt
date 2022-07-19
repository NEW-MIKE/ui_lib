package com.example.ui_demo_start.touptek.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CoverView : View {
    private val mPaint = Paint()
    private val mBackgroundColor = Color.BLACK
    private var mBorderWidth = 0
    private val mVolumeBgColor = -0x80000000
    private var mRadius = 0
    private var mCenterX = 0
    private var mCenterY = 0
    private var mVolumeRadius = 0
    private var mVolumeRect: RectF? = null
    private val mVolumeColor = Color.WHITE
    private var mVolumeNum = 0
    private val mMaxVolume = 10
    private val mUniteDegree = 360 / mMaxVolume
    private var mAnimatedDegree = 0

    private var mMode = 0

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    private fun init(context: Context) {
        DEFAULT_DIMENSION = dipToPx(context, 150)
        mBorderWidth = dipToPx(context, 8)
    }

    fun dipToPx(context: Context, dip: Int): Int {
        val px = context.resources.displayMetrics.density
        return (dip * px + 0.5f).toInt()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mRadius = Math.min(w, h) / 2
        mVolumeRadius = mRadius - mBorderWidth
        mCenterX = w / 2
        mCenterY = h / 2
       mVolumeRect = RectF(
            (-mVolumeRadius).toFloat(),
            (-mVolumeRadius).toFloat(),
            mVolumeRadius.toFloat(),
            mVolumeRadius.toFloat()
        )
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            //setMeasuredDimension(DEFAULT_DIMENSION, DEFAULT_DIMENSION)
            setMeasuredDimension(widthSize, heightSize)
        } else if (widthMode == MeasureSpec.AT_MOST) {
           // setMeasuredDimension(DEFAULT_DIMENSION, heightSize)
            setMeasuredDimension(widthSize, heightSize)
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, DEFAULT_DIMENSION)
        } else {
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
        }
    }

    val rect = Rect(0, 0, mRadius, mRadius)
    var rect_width = 0.0
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        doneMode(canvas)
    }

    fun doneMode(canvas: Canvas){
        mPaint.style = Paint.Style.FILL
        mPaint.color = Color.BLACK
        mPaint.alpha = 160
        canvas.translate(mCenterX.toFloat(), mCenterY.toFloat())
        mVolumeRect!!.top = -mCenterY.toFloat()
        mVolumeRect!!.left  = -mRadius.toFloat()*2
        mVolumeRect!!.right  = mRadius.toFloat()*2
        mVolumeRect!!.bottom  = mCenterY.toFloat()
        canvas.drawRect(mVolumeRect!!, mPaint)
    }

    companion object {
        private var DEFAULT_DIMENSION = 0
    }
}