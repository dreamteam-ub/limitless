package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.net.Uri
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

        val dev1 : TextView = findViewById(R.id.developers_details1)
        ViewAdjuster.adjustView(dev1)

        dev1.setOnClickListener {
            val github = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.detail_github_developer1)))
            startActivity(github)
        }

        val dev2 : TextView = findViewById(R.id.developers_details2)
        ViewAdjuster.adjustView(dev2)

        dev2.setOnClickListener {
            val github = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.detail_github_developer2)))
            startActivity(github)
        }

        val dev3 : TextView = findViewById(R.id.developers_details3)
        ViewAdjuster.adjustView(dev3)

        dev3.setOnClickListener {
            val github = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.detail_github_developer3)))
            startActivity(github)
        }

        val dev4 : TextView = findViewById(R.id.developers_details4)
        ViewAdjuster.adjustView(dev4)

        dev4.setOnClickListener {
            val github = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.detail_github_developer4)))
            startActivity(github)
        }

        ViewAdjuster.adjustView(findViewById(R.id.music_rights_details))
    }

    override fun onStart() {
        super.onStart()
        infoBackArrow.isClickable = true
    }
}
