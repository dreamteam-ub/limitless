package edu.ub.pis.joc.limitless.view

import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import android.view.ViewGroup

// PIXEL 2 REFERENCE
const val HEIGHT_REFERENCE = 2028
const val WIDTH_REFERENCE = 1080

object ViewAdjuster {

    val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    val xdpi = Resources.getSystem().displayMetrics.xdpi
    val ydpi = Resources.getSystem().displayMetrics.ydpi

    val scaledDensity = Resources.getSystem().displayMetrics.scaledDensity
    val density = Resources.getSystem().displayMetrics.density

    fun adjustView(view: View) {
        if (view is TextView) {
            val px = view.textSize
            val dpi = screenHeight * px / HEIGHT_REFERENCE / density

            view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, dpi)
        }

        // convert the DP into pixel

        if (view.layoutParams.height != ViewGroup.LayoutParams.WRAP_CONTENT && view.layoutParams.height != ViewGroup.LayoutParams.MATCH_PARENT) {
            val height = (screenHeight * view.layoutParams.height / HEIGHT_REFERENCE).toInt()
            view.layoutParams.height = height
        }

        if (view.layoutParams.width != ViewGroup.LayoutParams.WRAP_CONTENT && view.layoutParams.width != ViewGroup.LayoutParams.MATCH_PARENT) {
            val width = (screenWidth * view.layoutParams.width / WIDTH_REFERENCE).toInt()
            view.layoutParams.width = width
        }

        val params = (view.layoutParams as ViewGroup.MarginLayoutParams)

        var top = params.topMargin
        var bottom = params.bottomMargin
        var left = params.leftMargin
        var right = params.rightMargin

        if (top > 0) {
            top = (screenHeight * top / HEIGHT_REFERENCE).toInt()
        }

        if (bottom > 0) {
            bottom = (screenHeight * bottom / HEIGHT_REFERENCE).toInt()
        }

        if (left > 0) {
            left = (screenWidth * left / WIDTH_REFERENCE).toInt()
        }

        if (right > 0) {
            right = (screenWidth * right / WIDTH_REFERENCE).toInt()
        }

        (view.layoutParams as ViewGroup.MarginLayoutParams).setMargins(left, top, right, bottom)

    }
}