package edu.ub.pis.joc.limitless.view

import android.content.res.Resources
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import android.view.ViewGroup

// PIXEL 2 REFERENCE
const val XDPI_REFERENCE = 420.0f
const val YDPI_REFERENCE = 420.0f

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
            val dpi = px / density

            view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, ydpi * dpi / YDPI_REFERENCE)
        }

        // convert the DP into pixel

        if (view.layoutParams.height != ViewGroup.LayoutParams.WRAP_CONTENT && view.layoutParams.height != ViewGroup.LayoutParams.MATCH_PARENT) {
            val height = (ydpi * view.layoutParams.height / YDPI_REFERENCE).toInt()
            view.layoutParams.height = height
        }

        if (view.layoutParams.width != ViewGroup.LayoutParams.WRAP_CONTENT && view.layoutParams.width != ViewGroup.LayoutParams.MATCH_PARENT) {
            val width = (xdpi * view.layoutParams.width / XDPI_REFERENCE).toInt()
            view.layoutParams.width = width
        }

        val params = (view.layoutParams as ViewGroup.MarginLayoutParams)

        var top = params.topMargin
        var bottom = params.bottomMargin
        var left = params.leftMargin
        var right = params.rightMargin

        if (top > 0) {
            top = (ydpi * top / YDPI_REFERENCE).toInt()
        }

        if (bottom > 0) {
            bottom = (ydpi * bottom / YDPI_REFERENCE).toInt()
        }

        if (left > 0) {
            left = (xdpi * left / XDPI_REFERENCE).toInt()
        }

        if (right > 0) {
            right = (xdpi * right / XDPI_REFERENCE).toInt()
        }

        (view.layoutParams as ViewGroup.MarginLayoutParams).setMargins(left, top, right, bottom)

    }
}