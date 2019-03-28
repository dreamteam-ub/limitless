package edu.ub.pis.joc.limitless

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView

abstract class FullScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        //* Hides
        hideNav()

    }

    override fun onWindowFocusChanged(hasFocus:Boolean) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)
            hideNav()
    }

    private fun hideNav() {
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun startActivity(intent: Intent?, options: Bundle?) {
        super.startActivity(intent, options)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int, options: Bundle?) {
        super.startActivityForResult(intent, requestCode, options)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    fun customImageToast(r_draw_image : Int, text: String, length : Int, gravity : Int = Gravity.CENTER_VERTICAL,
                    offX : Int = 0, offY : Int = 0) : Toast {

        val layout = layoutInflater.inflate(R.layout.custom_image_toast, findViewById(R.id.custom_image_toast_layout))

        val image = layout.findViewById(R.id.image_toast) as ImageView

        image.setImageResource(r_draw_image)

        val msg = layout.findViewById(R.id.text_toast) as TextView
        msg.text = text

        val toast = Toast(applicationContext)

        toast.setGravity(gravity, offX, offY)
        toast.duration = length
        toast.view = layout
        return toast
    }

    fun customToast(text: String, length : Int, gravity : Int = Gravity.CENTER_VERTICAL,
                    offX : Int = 0, offY : Int = 0) : Toast {

        val layout = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_layout))

        val msg = layout.findViewById(R.id.text_toast) as TextView
        msg.text = text

        val toast = Toast(applicationContext)

        toast.setGravity(gravity, offX, offY)
        toast.duration = length
        toast.view = layout
        return toast
    }

}