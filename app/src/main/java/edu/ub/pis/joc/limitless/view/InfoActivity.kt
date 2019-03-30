package edu.ub.pis.joc.limitless.view

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import edu.ub.pis.joc.limitless.BuildConfig
import edu.ub.pis.joc.limitless.R

class InfoActivity : FullScreenActivity() {

    private val TAG = "InfoActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val versionView: TextView = findViewById(R.id.version_details)
        versionView.text = BuildConfig.VERSION_NAME

        val infoBackArrow: ImageButton = findViewById(R.id.info_back_button)
        infoBackArrow.setOnClickListener {
            finish()
        }
    }
}
