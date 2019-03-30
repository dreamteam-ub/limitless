package edu.ub.pis.joc.limitless.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Ranking
import edu.ub.pis.joc.limitless.model.User
import edu.ub.pis.joc.limitless.view.ranking.RankingRecyclerAdapter

const val LIMIT : Long = 10

class RankingActivity : FullScreenActivity() {

    private val TAG = "RankingActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        val recyclerView : RecyclerView = findViewById(R.id.ranking_recicler)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val rankings = ArrayList<Ranking>()
        val adapter = RankingRecyclerAdapter(rankings)
        recyclerView.adapter = adapter

        FirebaseFirestore.getInstance().collection(USERS).whereGreaterThan(SURVIVED, 0).limit(LIMIT).orderBy(
            SURVIVED,
            Query.Direction.DESCENDING
        ).get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                if (!task.result!!.isEmpty) {
                    for ((i, u) in task.result!!.withIndex()) {
                        val user = u.toObject(User::class.java)
                        rankings.add(
                            Ranking(
                                (i + 1).toString(), user.userName!!,
                                getString(R.string.survived_rank) + ": " + numberToMMSS(user.survived!!)
                            )
                        )
                    }
                    adapter.notifyDataSetChanged()
                } else {
                    customToast(
                        getString(R.string.no_ranking),
                        Toast.LENGTH_SHORT, Gravity.CENTER_VERTICAL or
                                Gravity.FILL_HORIZONTAL
                    ).show()
                }
            }
        }

        val rankingBackArrow: ImageButton = findViewById(R.id.ranking_back_button)
        rankingBackArrow.setOnClickListener {
            finish()
        }
    }

    private fun numberToMMSS(num: Long): String {
        return String.format("%02d:%02d", num / 60, num % 60)
    }
}
