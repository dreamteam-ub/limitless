package edu.ub.pis.joc.limitless.view

import android.content.res.Resources
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import android.view.ViewGroup

// PIXEL 2 REFERENCE
const val HEIGHT_REFERENCE = 1794
const val WIDTH_REFERENCE = 1080

object ViewAdjuster {

    val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    val scaledDensity = Resources.getSystem().displayMetrics.scaledDensity
    val density = Resources.getSystem().displayMetrics.density

    fun adjustView(view: View) {
        if (view is TextView) {
            val px = view.textSize
            val sp = px / scaledDensity

            view.setTextSize(TypedValue.COMPLEX_UNIT_SP, screenHeight * sp / HEIGHT_REFERENCE)
        }

        // convert the DP into pixel

        if(view.layoutParams.height != ViewGroup.LayoutParams.WRAP_CONTENT && view.layoutParams.height != ViewGroup.LayoutParams.MATCH_PARENT) {
            val height = (((screenHeight * view.layoutParams.height / density) / HEIGHT_REFERENCE) * density).toInt()
            view.layoutParams.height = height
        }

        if(view.layoutParams.width != ViewGroup.LayoutParams.WRAP_CONTENT && view.layoutParams.width != ViewGroup.LayoutParams.MATCH_PARENT) {
            val width = (((screenWidth * view.layoutParams.width / density) / WIDTH_REFERENCE) * density).toInt()
            view.layoutParams.width = width
        }

        val params = (view.layoutParams as ViewGroup.MarginLayoutParams)

        var top = params.topMargin
        var bottom = params.bottomMargin
        var left = params.leftMargin
        var right = params.rightMargin

        if (top > 0) {
            top = (((screenHeight * top / density) / HEIGHT_REFERENCE) * density).toInt()
        }

        if (bottom > 0) {
            bottom = (((screenHeight * bottom / density) / HEIGHT_REFERENCE) * density).toInt()
        }

        if (left > 0) {
            left = (((screenWidth * left / density) / HEIGHT_REFERENCE) * density).toInt()
        }

        if (right > 0) {
            right = (((screenWidth * right / density) / HEIGHT_REFERENCE) * density).toInt()
        }

        (view.layoutParams as ViewGroup.MarginLayoutParams).setMargins(left, top, right, bottom)

    }
}