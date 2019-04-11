package edu.ub.pis.joc.limitless.model

class Data private constructor() {
    var user : User = User()
    var ranking : ArrayList<Ranking> = ArrayList<Ranking>()

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