package com.example.ui_demo_start.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.WindowInsetsCompat


class QMUINotchConsumeLayout(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs) {
    fun QMUINotchConsumeLayout(paramContext: Context?) {
        QMUINotchConsumeLayout(paramContext, null)
    }

    fun QMUINotchConsumeLayout(paramContext: Context?, paramAttributeSet: AttributeSet?) {
        QMUINotchConsumeLayout(paramContext, paramAttributeSet, 0)
    }

    fun QMUINotchConsumeLayout(
        paramContext: Context?,
        paramAttributeSet: AttributeSet?,
        paramInt: Int
    ) {
/*        super(paramContext, paramAttributeSet, paramInt)
        QMUIWindowInsetHelper.setOnApplyWindowInsetsListener(
            this,
            object : OnApplyWindowInsetsListener {
                fun onApplyWindowInsets(
                    paramAnonymousView: View?,
                    paramAnonymousWindowInsetsCompat: WindowInsetsCompat?
                ): WindowInsetsCompat? {
                    this@QMUINotchConsumeLayout.notifyInsetMaybeChanged()
                    return paramAnonymousWindowInsetsCompat
                }
            },
            true)*/
    }

}