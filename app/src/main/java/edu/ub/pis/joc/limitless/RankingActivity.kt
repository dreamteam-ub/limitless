package edu.ub.pis.joc.limitless


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageButton
import android.widget.LinearLayout

class RankingActivity : FullScreenActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        val recyclerView = findViewById(R.id.ranking_recicler) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val rankings = ArrayList<RankingRecicler>()
        rankings.add(RankingRecicler("1. Aaron","Survived: 4:53"))
        rankings.add(RankingRecicler("2. Arnau","Survived: 4:12"))
        rankings.add(RankingRecicler("3. Pau","Survived: 3:48"))
        rankings.add(RankingRecicler("4. Manu","Survived: 0:03"))
        rankings.add(RankingRecicler("5. Cepeda","Survived: Calvicie"))

        val adapter = RankingReciclerAdapter(rankings)
        recyclerView.adapter = adapter

        val rankingBackArrow : ImageButton = findViewById(R.id.ranking_back_button)
        rankingBackArrow.setOnClickListener{
            finish()
        }
    }
}
