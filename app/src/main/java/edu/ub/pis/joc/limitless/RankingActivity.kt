package edu.ub.pis.joc.limitless


import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton

class RankingActivity : ActivityNoTopBar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        val rankingBackArrow : ImageButton = findViewById(R.id.ranking_back_button)
        rankingBackArrow.setOnClickListener{
            finish()
        }
    }
}
