package com.example.ui_demo_start.view

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.ScrollView
import android.widget.Scroller
import com.example.ui_demo_start.R


class ColorPicker(paramContext: Context, paramAttributeSet: AttributeSet?) :
  ScrollView(paramContext, paramAttributeSet) {
  var mchildCount = 7
  private val childHeight: Float
  private val dividerHeight: Float
  private var lastPoint = 0f
  private var mHandler: Handler? = null
  private val mScroller: Scroller
  private val parentHeight: Float

  internal constructor(paramContext: Context) : this(paramContext, null) {}

  private fun calcCenterItem(): Int {
    var d1 = scrollY / (childHeight + dividerHeight) + 0.5
    var d2 = d1
    if (d1 < 0.0) d2 = 0.0
    val i = mchildCount
    d1 = d2
    if (d2 >= i) d1 = (i - 1).toDouble()
    return d1.toInt()
  }

  private fun dragBack(paramInt: Int) {
    var paramInt = paramInt
    var f1 = parentHeight
    val f2 = childHeight
    f1 = -(f1 - f2) / 2.0f
    val f3 = dividerHeight
    paramInt = (f1 + f2 + f3 + paramInt * (f2 + f3)).toInt()
    mScroller.startScroll(0, scrollY, 0, paramInt - scrollY)
  }

  override fun computeScroll() {
    if (mScroller.computeScrollOffset()) scrollTo(mScroller.currX, mScroller.currY)
    invalidate()
    super.computeScroll()
  }

  override fun onInterceptTouchEvent(paramMotionEvent: MotionEvent): Boolean {
    if (paramMotionEvent.action == 0) lastPoint = paramMotionEvent.rawY
    return if (paramMotionEvent.action == 2) true else super.onInterceptTouchEvent(paramMotionEvent)
  }

  override fun onTouchEvent(paramMotionEvent: MotionEvent): Boolean {
    var paramMotionEvent: MotionEvent? = paramMotionEvent
    var i = paramMotionEvent!!.action
    if (i != 0) {
      if (i != 1) {
        if (i == 2) {
          scrollBy(0, (lastPoint - paramMotionEvent.rawY).toInt())
          lastPoint = paramMotionEvent.rawY
          invalidate()
        }
      } else {
        i = calcCenterItem()
        dragBack(i)
        if (mHandler != null) mHandler!!.sendEmptyMessage(i)
        invalidate()
      }
    } else lastPoint = paramMotionEvent.rawY
    return true
  }

  fun scrollTo(paramInt: Int): Boolean {
    if (paramInt >= 0 && paramInt < mchildCount) {
      dragBack(paramInt)
      return true
    }
    return false
  }

  fun setHandler(paramHandler: Handler?) {
    mHandler = paramHandler
  }

  init {
    LayoutInflater.from(paramContext).inflate(R.layout.lyt_colorpicker, this, true)

    childHeight = paramContext.resources.getDimensionPixelSize(R.dimen.popWindow_titleHeight).toFloat()
    mScroller = Scroller(paramContext)
    parentHeight = paramContext.getResources().getDimensionPixelSize(R.dimen.switch_height).toFloat()
    dividerHeight = paramContext.getResources().getDimensionPixelSize(R.dimen.icon_gap).toFloat()
    isVerticalScrollBarEnabled = false
    overScrollMode = 0
  }
}