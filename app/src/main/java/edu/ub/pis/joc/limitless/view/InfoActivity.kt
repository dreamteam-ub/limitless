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
        ViewAdjuster.adjustView(versionView)

        infoBackArrow = findViewById(R.id.info_back_button)
        infoBackArrow.setOnClickListener {
            finish()
            infoBackArrow.isClickable = false
        }
        ViewAdjuster.adjustView(infoBackArrow)

        ViewAdjuster.adjustView(findViewById(R.id.info_version))
        ViewAdjuster.adjustView(findViewById(R.id.info_developers))
        ViewAdjuster.adjustView(findViewById(R.id.info_music_rights))

        ViewAdjuster.adjustView(findViewById(R.id.developers_details1))
        ViewAdjuster.adjustView(findViewById(R.id.developers_details2))
        ViewAdjuster.adjustView(findViewById(R.id.developers_details3))
        ViewAdjuster.adjustView(findViewById(R.id.developers_details4))

        ViewAdjuster.adjustView(findViewById(R.id.music_rights_details))
    }

    override fun onStart() {
        super.onStart()
        infoBackArrow.isClickable = true
    }
}
