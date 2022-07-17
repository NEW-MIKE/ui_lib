package com.example.ui_demo_start.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.ui_demo_start.R

class MountCtrlView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    var paint = Paint()
    init {
/*        val typedArray = context!!.obtainStyledAttributes(attrs!!, R.styleable.MyViewStyle)
        if (typedArray!=null){

        }*/
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //paint.color = 0
        canvas!!.drawCircle(50f,50f,50f,paint)
    }

}