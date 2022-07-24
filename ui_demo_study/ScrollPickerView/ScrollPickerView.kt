package com.example.astroclient.view.ScrollPickerView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.astroclient.util.ScreenUtil


class ScrollPickerView(context: Context, @Nullable attrs: AttributeSet?, defStyle: Int) :
    RecyclerView(context, attrs, defStyle) {
    private var mSmoothScrollTask: Runnable? = null
    private var mBgPaint: Paint? = null
    private var mItemHeight = 0
    private var mItemWidth = 0
    private var mInitialY = 0
    private var mFirstLineY = 0
    private var mSecondLineY = 0
    private var mFirstAmend = false

    constructor(context: Context) : this(context, null) {}
    constructor(context: Context, @Nullable attrs: AttributeSet?) : this(context, attrs, 0) {}

    fun doDraw(canvas: Canvas) {
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        doDraw(c)
        if (!mFirstAmend) {
            mFirstAmend = true
            (layoutManager as LinearLayoutManager?)!!.scrollToPositionWithOffset(
                itemSelectedOffset, 0
            )
        }
    }

    override fun onScrolled(dx: Int, dy: Int) {
        super.onScrolled(dx, dy)
        freshItemView()
    }

    private fun initPaint() {
        if (mBgPaint == null) {
            mBgPaint = Paint()
            mBgPaint!!.color = Color.RED
            mBgPaint!!.strokeWidth = ScreenUtil.dpToPx(1f).toFloat()
        }
    }

    private val scrollYDistance: Int
        private get() {
            val layoutManager = this.layoutManager as LinearLayoutManager? ?: return 0
            val position = layoutManager.findFirstVisibleItemPosition()
            val firstVisibleChildView = layoutManager.findViewByPosition(position)
                ?: return 0
            val itemHeight = firstVisibleChildView.height
            return position * itemHeight - firstVisibleChildView.top
        }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        if (e.action == MotionEvent.ACTION_UP) {
            processItemOffset()
        }
        return super.onTouchEvent(e)
    }

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        var widthSpec = widthSpec
        var heightSpec = heightSpec
        widthSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
        heightSpec = MeasureSpec.makeMeasureSpec(Int.MAX_VALUE shr 2, MeasureSpec.AT_MOST)
        super.onMeasure(widthSpec, heightSpec)
        measureSize()
        setMeasuredDimension(mItemWidth, mItemHeight * visibleItemNumber)
    }

    private fun measureSize() {
        if (childCount > 0) {
            if (mItemHeight == 0) {
                mItemHeight = getChildAt(0).measuredHeight
            }
            if (mItemWidth == 0) {
                mItemWidth = getChildAt(0).measuredWidth
            }
            if (mFirstLineY == 0 || mSecondLineY == 0) {
                mFirstLineY = mItemHeight * itemSelectedOffset
                mSecondLineY = mItemHeight * (itemSelectedOffset + 1)
            }
        }
    }

    private fun processItemOffset() {
        mInitialY = scrollYDistance
        postDelayed(mSmoothScrollTask, 30)
    }

    private fun initTask() {
        mSmoothScrollTask = Runnable {
            val newY = scrollYDistance
            if (mInitialY != newY) {
                mInitialY = scrollYDistance
                postDelayed(mSmoothScrollTask, 30)
            } else if (mItemHeight > 0) {
                val offset = mInitialY % mItemHeight //离选中区域中心的偏移量
                if (offset == 0) {
                    return@Runnable
                }
                if (offset >= mItemHeight / 2) { //滚动区域超过了item高度的1/2，调整position的值
                    smoothScrollBy(0, mItemHeight - offset)
                } else if (offset < mItemHeight / 2) {
                    smoothScrollBy(0, -offset)
                }
            }
        }
    }

    private val visibleItemNumber: Int
        private get() {
            val operation: IPickerViewOperation? = adapter as IPickerViewOperation?
            return operation?.getVisibleItemNumber() ?: 3
        }
    private val itemSelectedOffset: Int
        private get() {
            val operation: IPickerViewOperation? = adapter as IPickerViewOperation?
            return operation?.getSelectedItemOffset() ?: 1
        }

    private fun updateView(itemView: View, isSelected: Boolean) {
        val operation: IPickerViewOperation? = adapter as IPickerViewOperation?
        operation?.updateView(itemView, isSelected)
    }

    private fun freshItemView() {
        for (i in 0 until childCount) {
            val itemViewY = (getChildAt(i).top + mItemHeight / 2).toFloat()
            updateView(getChildAt(i), mFirstLineY < itemViewY && itemViewY < mSecondLineY)
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        initPaint()
    }

    init {
        initTask()
    }
}