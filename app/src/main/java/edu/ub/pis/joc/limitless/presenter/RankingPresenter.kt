package edu.ub.pis.joc.limitless.presenter

import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.Ranking
import edu.ub.pis.joc.limitless.model.User

class RankingPresenter(var view : View) {

    fun updateUser(user: User) {
        Data.getInstance().user = user
        view.updateUserInfo(user)
    }

    fun updateRanking(ranks: ArrayList<Ranking>) {
        Data.getInstance().ranking = ranks
        view.updateRankInfo(ranks)
    }

    interface View {
        fun updateUserInfo(user: User)
        fun updateRankInfo(ranks: ArrayList<Ranking>)
    }
}