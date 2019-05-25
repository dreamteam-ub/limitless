package edu.ub.pis.joc.limitless.view

import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.widget.TextView

object  ViewAdjuster {
    val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    val scaledDensity = Resources.getSystem().displayMetrics.scaledDensity

    fun adjustView(view : View) {
        if (view is TextView) {
            val px = view.textSize
            val sp = px / scaledDensity

            view.setTextSize(TypedValue.COMPLEX_UNIT_SP,screenHeight * sp / 2028)
        } else {
            view.layoutParams.width = (screenWidth * view.layoutParams.width) / 1080
            view.layoutParams.height = (screenHeight * view.layoutParams.height) / 2028
        }
    }
}