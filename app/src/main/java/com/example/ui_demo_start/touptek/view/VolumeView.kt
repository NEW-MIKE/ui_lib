package com.example.ui_demo_start.touptek.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class VolumeView : View {
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
            setMeasuredDimension(DEFAULT_DIMENSION, DEFAULT_DIMENSION)
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(DEFAULT_DIMENSION, heightSize)
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
       // doneMode(canvas)
        //idleMode(canvas)
        doingMode(canvas)
        //画音量
        /* if (mIsVolumeUp) {
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
         }*/
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

    fun setMode(mode:Int){
        mMode = mode
    }

    fun idleMode(canvas: Canvas){
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 2.0F
        mPaint.color = Color.BLACK
        canvas.translate(mCenterX.toFloat(), mCenterY.toFloat())
        canvas.drawCircle(0f, 0f, mRadius.toFloat()-80, mPaint)
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 40.0F
        canvas.drawCircle(0f, 0f, mRadius.toFloat()-140, mPaint)
    }

    fun doneMode(canvas: Canvas){
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
        mPaint.style = Paint.Style.FILL
        //mPaint.strokeWidth = 20.0F
        mPaint.color = Color.RED
        canvas.translate(mCenterX.toFloat(), mCenterY.toFloat())
        canvas.drawCircle(0f, 0f, mRadius.toFloat(), mPaint)
        mPaint.color = Color.BLACK
        mPaint.style = Paint.Style.FILL
        canvas.drawCircle(0f, 0f, mRadius.toFloat()-80, mPaint)
        rect_width = mRadius / Math.sqrt(2.0) - 100
        rect.top = (-rect_width).toInt()
        rect.left = (-rect_width).toInt()
        rect.bottom = (rect_width).toInt()
        rect.right = (rect_width).toInt()
        mPaint.color = Color.RED
        canvas.drawRect(rect, mPaint)
    }
    fun doingMode(canvas: Canvas){
        canvas.save()
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)

        mPaint.style = Paint.Style.STROKE
       // mPaint.strokeWidth = 20.0F
        mPaint.color = Color.BLACK
        canvas.translate(mCenterX.toFloat(), mCenterY.toFloat())
       // canvas.drawCircle(0f, 0f, mRadius.toFloat(), mPaint)
        mPaint.style = Paint.Style.FILL
        canvas.drawCircle(0f, 0f, mRadius.toFloat()-80, mPaint)
        mPaint.color = mBackgroundColor
        mPaint.style = Paint.Style.FILL_AND_STROKE
        //canvas.drawCircle(0f, 0f, mRadius.toFloat() - 80, mPaint)
        rect_width = mRadius / Math.sqrt(2.0) - 120
        rect.top = (-rect_width).toInt()
        rect.left = (-rect_width).toInt()
        rect.bottom = (rect_width).toInt()
        rect.right = (rect_width).toInt()
        mPaint.color = Color.RED
        canvas.drawRect(rect, mPaint)
        mPaint.style = Paint.Style.STROKE
        mPaint.color = mVolumeBgColor
        mPaint.strokeWidth = 40f

        mPaint.color = Color.YELLOW
        canvas.drawArc(
            mVolumeRect!!,
            -90f,
            (mUniteDegree * 4 + mAnimatedDegree).toFloat(),
            false,
            mPaint
        )
        canvas.restore()
    }
    companion object {
        private var DEFAULT_DIMENSION = 0
    }
}