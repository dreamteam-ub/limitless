package edu.ub.pis.joc.limitless.view.ranking

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import edu.ub.pis.joc.limitless.R

class RankingReciclerAdapter (val llista : ArrayList<RankingRecicler>) : RecyclerView.Adapter<RankingReciclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.ranking_list, p0, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return llista.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val user : RankingRecicler = llista[p1]
        p0.textViewName.text = user.name
        p0.textViewAdress.text = user.address

    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        val textViewName = itemView.findViewById(R.id.ranking_recicle_list) as TextView
        val textViewAdress = itemView.findViewById(R.id.ranking_recicle_address) as TextView
    }

}