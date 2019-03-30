package edu.ub.pis.joc.limitless.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageButton
import android.widget.LinearLayout
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Ranking
import edu.ub.pis.joc.limitless.view.ranking.RankingRecyclerAdapter

class RankingActivity : FullScreenActivity() {

    private val TAG = "RankingActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        val recyclerView = findViewById<RecyclerView>(R.id.ranking_recicler)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val rankings = ArrayList<Ranking>()
        rankings.add(Ranking("1. Aaron", "Survived: 4:53"))
        rankings.add(Ranking("2. Arnau", "Survived: 4:12"))
        rankings.add(Ranking("3. Pau", "Survived: 3:48"))
        rankings.add(Ranking("4. Manu", "Survived: 0:03"))
        rankings.add(Ranking("5. Cepeda", "Survived: Calvicie"))

        val adapter = RankingRecyclerAdapter(rankings)
        recyclerView.adapter = adapter

        val rankingBackArrow : ImageButton = findViewById(R.id.ranking_back_button)
        rankingBackArrow.setOnClickListener{
            finish()
        }
    }
}
