package com.example.ui_demo_start.touptek.view

import android.graphics.RectF
import com.example.ui_demo_start.touptek.view.VolumeView
import android.view.View.MeasureSpec
import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class VolumeView : View {
    private val mPaint = Paint()
    private val mBackgroundColor = 0x60000000
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
            setMeasuredDimension(DEFAULT_DIMENSION, DEFAULT_DIMENSION)
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(DEFAULT_DIMENSION, heightSize)
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, DEFAULT_DIMENSION)
        } else {
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        canvas.translate(mCenterX.toFloat(), mCenterY.toFloat())
        mPaint.color = mBackgroundColor
        mPaint.style = Paint.Style.FILL
        canvas.drawCircle(0f, 0f, mRadius.toFloat(), mPaint)
        mPaint.style = Paint.Style.STROKE
        mPaint.color = mVolumeBgColor
        mPaint.strokeWidth = mBorderWidth.toFloat()

        //画音量背景
        canvas.drawCircle(0f, 0f, mVolumeRadius.toFloat(), mPaint)
        mPaint.color = mVolumeColor
        //画音量
        if (mIsVolumeUp) {
            val num = if (mVolumeNum - 1 > 0) mVolumeNum - 1 else 0
            canvas.drawArc(
                mVolumeRect!!,
                -90f,
                (mUniteDegree * num + mAnimatedDegree).toFloat(),
                false,
                mPaint
            )
        } else {
            val num = mVolumeNum + 1
            canvas.drawArc(
                mVolumeRect!!,
                -90f,
                (mUniteDegree * num - mAnimatedDegree).toFloat(),
                false,
                mPaint
            )
        }
        canvas.restore()
    }

    /**
     * 控制音量增加减少时的动画效果
     */
    private fun startAnim() {
        val valueAnimator = ValueAnimator.ofInt(0, mUniteDegree)
        valueAnimator.duration = 300
        valueAnimator.addUpdateListener { animation ->
            mAnimatedDegree = animation.animatedValue as Int
            invalidate()
        }
        valueAnimator.start()
    }

    private var mIsVolumeUp = true

    /**
     * 加音量
     */
    fun volumeUp() {
        mIsVolumeUp = true
        if (mVolumeNum < mMaxVolume) {
            mVolumeNum++
            startAnim()
        }
    }

    /**
     * 减音量
     */
    fun volumeDown() {
        mIsVolumeUp = false
        if (mVolumeNum > 0) {
            mVolumeNum--
            startAnim()
        }
    }

    companion object {
        private var DEFAULT_DIMENSION = 0
    }
}