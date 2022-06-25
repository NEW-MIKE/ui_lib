package com.example.ui_demo_start.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.WindowInsetsCompat


class QMUINotchConsumeLayout(
    paramContext: Context,
    paramAttributeSet: AttributeSet?,
    paramInt: Int
) : FrameLayout(paramContext, paramAttributeSet, paramInt) {

    constructor(paramContext: Context) : this(paramContext, null)

    constructor(paramContext: Context, paramAttributeSet: AttributeSet?) : this(
        paramContext,
        paramAttributeSet,
        0
    )

    init {
/*        QMUIWindowInsetHelper.setOnApplyWindowInsetsListener(
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
            true
        )*/
    }


}