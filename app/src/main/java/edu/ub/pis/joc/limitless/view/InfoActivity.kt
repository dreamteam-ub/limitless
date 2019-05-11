package edu.ub.pis.joc.limitless.view

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import edu.ub.pis.joc.limitless.BuildConfig
import edu.ub.pis.joc.limitless.R

class InfoActivity : FullScreenActivity() {

    private val TAG = "InfoActivity"

    private lateinit var infoBackArrow: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val versionView: TextView = findViewById(R.id.version_details)
        versionView.text = BuildConfig.VERSION_NAME

        infoBackArrow = findViewById(R.id.info_back_button)
        infoBackArrow.setOnClickListener {
            finish()
            infoBackArrow.isClickable = false
        }
    }

    override fun onStart() {
        super.onStart()
        infoBackArrow.isClickable = true
    }
}
