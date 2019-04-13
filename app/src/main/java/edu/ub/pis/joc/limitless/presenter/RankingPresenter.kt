package edu.ub.pis.joc.limitless.presenter

import edu.ub.pis.joc.limitless.view.ranking.model.Data
import edu.ub.pis.joc.limitless.view.ranking.model.Ranking
import edu.ub.pis.joc.limitless.view.ranking.model.User

class RankingPresenter(var view : View) {

    fun updateUser(user: User) {
        Data.user = user
        view.updateUserInfo(user)
    }

    fun updateRanking(ranks: ArrayList<Ranking>) {
        Data.ranking = ranks
        view.updateRankInfo(ranks)
    }

    interface View {
        fun updateUserInfo(user: User)
        fun updateRankInfo(ranks: ArrayList<Ranking>)
    }
}