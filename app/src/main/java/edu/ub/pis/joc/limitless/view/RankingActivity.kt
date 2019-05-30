package edu.ub.pis.joc.limitless.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.Query
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.Data.numberToMMSS
import edu.ub.pis.joc.limitless.model.Ranking
import edu.ub.pis.joc.limitless.model.SURVIVED
import edu.ub.pis.joc.limitless.model.User
import edu.ub.pis.joc.limitless.presenter.RankingPresenter

const val LIMIT: Long = 10

class RankingActivity : FullScreenActivity(), RankingPresenter.View {

    private val TAG = "RankingActivity"

    private lateinit var presenter : RankingPresenter

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    private lateinit var rankListener: ListenerRegistration
    private lateinit var userListener: ListenerRegistration

    private lateinit var userName: TextView
    private lateinit var userTime: TextView

    private lateinit var recyclerView: RecyclerView

    private lateinit var rankingBackArrow: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        ViewAdjuster.adjustViewLayoutPadding(findViewById(R.id.root))

        presenter = RankingPresenter(this)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        userName = findViewById(R.id.my_user_name)
        userTime = findViewById(R.id.my_time)

        // SYNC DB START
        userListener =
            db.collection(USERS).document(mAuth.currentUser!!.uid).addSnapshotListener { docSnapshot, exception ->
                if (exception != null) {
                    Log.w(TAG, "Listen failed.", exception)
                }
                if (docSnapshot != null && docSnapshot.exists()) {
                    presenter.updateUser(docSnapshot.toObject(User::class.java)!!)
                }
            }

        recyclerView = findViewById(R.id.ranking_recicler)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerView.adapter = RankingRecyclerAdapter(Data.ranking)

        // RANK
        val rank = db.collection(USERS).whereGreaterThan(SURVIVED, 0).limit(LIMIT).orderBy(
            SURVIVED,
            Query.Direction.DESCENDING
        )
        rankListener = rank.addSnapshotListener { docSnapshot, exception ->
            if (exception != null) {
            }
            if (docSnapshot != null && !docSnapshot.isEmpty) {
                val ranking : ArrayList<Ranking> = ArrayList()
                for ((i, u) in docSnapshot.documents.withIndex()) {
                    val user = u.toObject(User::class.java)
                    ranking.add(
                        Ranking(
                            (i + 1).toString(), user!!.userName!!,
                            getString(R.string.survived_rank) + ": " + numberToMMSS(user.survived!!)
                        )
                    )
                }
                presenter.updateRanking(ranking)
            } else {
            }
        }
        // SYNC DB END

        rankingBackArrow = findViewById(R.id.ranking_back_button)
        rankingBackArrow.setOnClickListener {
            finish()
            rankingBackArrow.isClickable = false
        }

        ViewAdjuster.adjustView(rankingBackArrow)

        ViewAdjuster.adjustView(findViewById(R.id.infinity_title))
        ViewAdjuster.adjustView(findViewById(R.id.ranking_lines))
        ViewAdjuster.adjustView(findViewById(R.id.ranking_lines2))
        ViewAdjuster.adjustView(findViewById(R.id.my_user_name))
        ViewAdjuster.adjustView(findViewById(R.id.my_time))
    }

    override fun onDestroy() {
        super.onDestroy()
        rankListener.remove() // IMPORTANTE
        userListener.remove() // IMPORTANTE
    }

    override fun updateUserInfo(user: User) {
        userName.text = user.userName
        val surv = user.survived!!
        if (surv == 0L) {
            userTime.text = getString(R.string.no_records)
        } else  {
            userTime.text = numberToMMSS(surv)
        }
    }

    override fun updateRankInfo(ranks: ArrayList<Ranking>) {
        recyclerView.adapter = RankingRecyclerAdapter(ranks)
    }

    override fun onStart() {
        super.onStart()
        rankingBackArrow.isClickable = true
    }
}
