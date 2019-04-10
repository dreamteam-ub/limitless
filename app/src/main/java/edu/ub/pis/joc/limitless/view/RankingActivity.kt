package edu.ub.pis.joc.limitless.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.Query
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.view.ranking.Ranking
import edu.ub.pis.joc.limitless.model.User
import edu.ub.pis.joc.limitless.view.ranking.RankingRecyclerAdapter

const val LIMIT: Long = 10

class RankingActivity : FullScreenActivity() {

    private val TAG = "RankingActivity"

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    private lateinit var rankListener: ListenerRegistration
    private var userListener: ListenerRegistration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val yourStatsNoTop: LinearLayout = findViewById(R.id.your_rank_ly)
        yourStatsNoTop.visibility = View.GONE

        val yourUserName: TextView = findViewById(R.id.your_user)
        val yourUserTime: TextView = findViewById(R.id.your_time)

        val recyclerView: RecyclerView = findViewById(R.id.ranking_recicler)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val adapter = RankingRecyclerAdapter(Data.getInstance().ranking)

        // SYNC DB START


        val rank = db.collection(USERS).whereGreaterThan(SURVIVED, 0).limit(LIMIT).orderBy(
            SURVIVED,
            Query.Direction.DESCENDING
        )
        rankListener = rank.addSnapshotListener { docSnapshot, exception ->
            if (exception != null) {
                Log.w(TAG, "Listen failed.", exception)
            }
            if (docSnapshot != null && !docSnapshot.isEmpty) {
                Log.d(TAG, "Current data: " + docSnapshot.documents)
                Data.getInstance().ranking.clear()
                var posIam = -1
                for ((i, u) in docSnapshot.documents.withIndex()) {
                    val user = u.toObject(User::class.java)
                    if (u.id == mAuth.currentUser!!.uid) {
                        posIam = i
                    }

                    Data.getInstance().ranking.add(
                        Ranking(
                            (i + 1).toString(), user!!.userName!!,
                            getString(R.string.survived_rank) + ": " + numberToMMSS(user.survived!!)
                        )
                    )

                }
                if (posIam == -1) {
                    yourStatsNoTop.visibility = View.VISIBLE

                    userListener =
                            db.collection(USERS).document(mAuth.currentUser!!.uid).addSnapshotListener { docSnapshot, exception ->
                                if (exception != null) {
                                    Log.w(TAG, "Listen failed.", exception)
                                }
                                if (docSnapshot != null && docSnapshot.exists()) {
                                    Data.getInstance().user = docSnapshot.toObject(User::class.java)!!
                                    yourUserName.text = Data.getInstance().user!!.userName
                                    if (Data.getInstance().user!!.survived!! == 0L) {
                                        yourUserTime.text = getString(R.string.no_records)
                                    } else {
                                        yourUserTime.text = numberToMMSS(Data.getInstance().user!!.survived!!)
                                    }

                                }
                            }

                } else {
                    yourStatsNoTop.visibility = View.GONE
                    if (userListener != null) {
                        userListener!!.remove()
                    }

                }
                adapter.notifyDataSetChanged()
            } else {
                Log.d(TAG, "Current data: null")
            }
        }
        // SYNC DB END

        val rankingBackArrow: ImageButton = findViewById(R.id.ranking_back_button)
        rankingBackArrow.setOnClickListener {
            finish()
        }

        recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        rankListener.remove() // IMPORTANTE
        if (userListener != null) {
            userListener!!.remove() // IMPORTANTE
        }
    }

    private fun numberToMMSS(num: Long): String {
        return String.format("%02d:%02d", num / 60, num % 60)
    }
}
