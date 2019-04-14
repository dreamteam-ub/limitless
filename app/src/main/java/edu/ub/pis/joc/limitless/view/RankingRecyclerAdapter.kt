package edu.ub.pis.joc.limitless.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Ranking

class RankingRecyclerAdapter(private val llista: ArrayList<Ranking>) :
    RecyclerView.Adapter<RankingRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.ranking_list, p0, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return llista.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val user: Ranking = llista[p1]
        p0.posRank.text = user.position
        p0.tvName.text = user.name
        p0.tvSurvived.text = user.survived
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val posRank = itemView.findViewById(R.id.ranking_position) as TextView
        val tvName = itemView.findViewById(R.id.ranking_user) as TextView
        val tvSurvived = itemView.findViewById(R.id.ranking_time) as TextView
    }

}