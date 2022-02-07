package com.markas.games.core.utils

import android.content.Context
import android.util.AttributeSet

class CustomGrid : androidx.appcompat.widget.AppCompatImageView {
    constructor(context: Context?) : super(context!!)
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context!!,
        attrs,
        defStyle
    )

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val gridwidth = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec)
        setMeasuredDimension(gridwidth, gridwidth)
    }

    override fun onSizeChanged(width: Int, height: Int, oldwidth: Int, oldheight: Int) {
        super.onSizeChanged(width, width, oldwidth, oldheight)
    }
}