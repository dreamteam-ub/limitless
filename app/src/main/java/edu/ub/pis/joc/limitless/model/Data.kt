package edu.ub.pis.joc.limitless.model

import edu.ub.pis.joc.limitless.view.ranking.Ranking

class Data private constructor() {
    var user : User? = null
    val ranking : ArrayList<Ranking> = ArrayList<Ranking>()

    companion object {
        private var instance : Data? = null
        fun  getInstance(): Data {
            return when {
                instance != null -> instance!!
                else -> synchronized(this) {
                    if (instance == null) {
                        instance =  Data()
                    }
                    instance!!
                }
            }
        }
    }

}