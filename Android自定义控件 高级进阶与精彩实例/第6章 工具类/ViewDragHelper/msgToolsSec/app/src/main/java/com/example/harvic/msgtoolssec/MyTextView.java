package com.example.harvic.msgtoolssec;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

public class MyTextView extends TextView {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        Log.d("qijian","MyTextView onTouchEvent   event:"+event.getAction());
        //如果加上不允许父控件拦截的话，在DragLayout的onInterceptTouchEvent中的拦截效果将失败。
//        ViewParent parentView = getParent();
//        parentView.requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(event);
//        return true;
    }
}
