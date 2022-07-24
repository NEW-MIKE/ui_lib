package com.example.ui_demo_start.touptek.adapter

import android.R
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.animation.LinearInterpolator
import android.widget.LinearLayout
import android.widget.Scroller
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SwipeRecyclerView(context: Context, attrs: AttributeSet?, defStyle: Int) :
    RecyclerView(context, attrs, defStyle) {
    private val maxLength: Int
    private val mTouchSlop: Int
    private var xDown = 0
    private var yDown = 0
    private var xMove = 0
    private var yMove = 0

    /**
     * 当前选中的item索引（这个很重要）
     */
    private var curSelectPosition = 0
    private val mScroller: Scroller
    private var mCurItemLayout: LinearLayout? = null
    private var mLastItemLayout: LinearLayout? = null

    /**
     * 隐藏部分长度
     */
    private var mHiddenWidth = 0

    /**
     * 记录连续移动的长度
     */
    private var mMoveWidth = 0

    /**
     * 是否是第一次touch
     */
    private var isFirst = true
    private val mContext: Context

    /**
     * 删除的监听事件
     */
    private var mRightListener: OnRightClickListener? = null
    fun setRightClickListener(listener: OnRightClickListener?) {
        mRightListener = listener
    }

    constructor(context: Context) : this(context, null) {}
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {}

    override fun onTouchEvent(e: MotionEvent): Boolean {
        val x = e.x.toInt()
        val y = e.y.toInt()
        when (e.action) {
            MotionEvent.ACTION_DOWN -> {
                //记录当前按下的坐标
                xDown = x
                yDown = y
                //计算选中哪个Item
                val firstPosition =
                    (layoutManager as LinearLayoutManager?)!!.findFirstVisibleItemPosition()
                val itemRect = Rect()
                val count = childCount
                var i = 0
                while (i < count) {
                    val child: View = getChildAt(i)
                    if (child.getVisibility() == VISIBLE) {
                        child.getHitRect(itemRect)
                        if (itemRect.contains(x, y)) {
                            curSelectPosition = firstPosition + i
                            break
                        }
                    }
                    i++
                }

                Log.e(TAG, "onTouchEvent:down ", )
                //取到当前选中的Item，赋给mCurItemLayout，以便对其进行左移
                val item: View? = getChildAt(curSelectPosition - firstPosition)
                if (item != null) {
                    //获取当前选中的Item
                    val viewHolder: ListSwipeAdapter2.ViewHolder =
                        getChildViewHolder(item) as ListSwipeAdapter2.ViewHolder
                    mCurItemLayout = viewHolder.item
                    //找到具体元素（这与实际业务相关了~~）
                    viewHolder.goToTargetTv.setOnClickListener {
                        if (mRightListener != null) {
                            //删除
                            mRightListener!!.onRightClick(curSelectPosition, "")
                        }
                        Log.e(TAG, "onTouchEvent:goToTargetTv ", )
                    }
                    viewHolder.goToTargetTv1.setOnClickListener {
                        if (mRightListener != null) {
                            //删除
                            mRightListener!!.onRightClick(curSelectPosition, "")
                        }
                        Log.e(TAG, "onTouchEvent:goToTargetTv1 ", )
                    }

                    //这里将删除按钮的宽度设为可以移动的距离
                    mHiddenWidth = viewHolder.mhidden.width
                }
            }
            MotionEvent.ACTION_MOVE -> {
                xMove = x
                yMove = y
                val dx = xMove - xDown //为负时：手指向左滑动；为正时：手指向右滑动。这与Android的屏幕坐标定义有关
                val dy = yMove - yDown //

                Log.e(TAG, "onTouchEvent:ACTION_MOVE1 ", )
                //左滑
                if (dx < 0 && Math.abs(dx) > mTouchSlop && Math.abs(dy) < mTouchSlop) {
                    var newScrollX = Math.abs(dx)
                    if (mMoveWidth >= mHiddenWidth) { //超过了，不能再移动了
                        newScrollX = 0
                    } else if (mMoveWidth + newScrollX > mHiddenWidth) { //这次要超了，
                        newScrollX = mHiddenWidth - mMoveWidth
                    }

                    Log.e(TAG, "onTouchEvent:ACTION_MOVE2 ", )
                    //左滑，每次滑动手指移动的距离
                    scrollLeft(mCurItemLayout!!, newScrollX)
                    //对移动的距离叠加
                    mMoveWidth = mMoveWidth + newScrollX
                } else if (dx > 0) { //右滑
                    //执行右滑，这里没有做跟随，瞬间恢复
                    scrollRight(mCurItemLayout!!, 0 - mMoveWidth)
                    mMoveWidth = 0
                }
            }
            MotionEvent.ACTION_UP -> {
                val scrollX = mCurItemLayout!!.scrollX
                if (mHiddenWidth > mMoveWidth) {
                    val toX = mHiddenWidth - mMoveWidth
                    mMoveWidth = if (scrollX > mHiddenWidth / 2) { //超过一半长度时松开，则自动滑到左侧
                        scrollLeft(mCurItemLayout!!, toX)
                        mHiddenWidth
                    } else { //不到一半时松开，则恢复原状
                        scrollRight(mCurItemLayout!!, 0 - mMoveWidth)
                        0
                    }
                }
                mLastItemLayout = mCurItemLayout
            }
        }
        return super.onTouchEvent(e)
    }

    override fun computeScroll() {
        if (mScroller.computeScrollOffset()) {
            mCurItemLayout!!.scrollBy(mScroller.currX, 0)
            invalidate()
        }
    }

    /**
     * 向左滑动
     */
    private fun scrollLeft(item: View, scorllX: Int) {
        item.scrollBy(scorllX, 0)
    }

    /**
     * 向右滑动
     */
    private fun scrollRight(item: View, scorllX: Int) {
        item.scrollBy(scorllX, 0)
    }

    interface OnRightClickListener {
        fun onRightClick(position: Int, id: String?)
    }

    companion object {
        private const val TAG = "RecycleView"
    }

    init {
        mContext = context
        //滑动到最小距离
        mTouchSlop = ViewConfiguration.get(context).scaledTouchSlop
        //滑动的最大距离
        maxLength = ((180 * context.getResources().getDisplayMetrics().density + 0.5f).toInt())
        //初始化Scroller
        mScroller = Scroller(context, LinearInterpolator(context, null))
    }
}