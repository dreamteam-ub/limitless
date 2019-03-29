package edu.ub.pis.joc.limitless.presenter




class Presenter {


    companion object {
        val instance : Presenter by lazy(LazyThreadSafetyMode.PUBLICATION){ Presenter()}

    }
    fun getInstance(): Presenter {
        return instance
    }


}