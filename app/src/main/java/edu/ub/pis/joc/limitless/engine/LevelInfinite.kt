package edu.ub.pis.joc.limitless.engine

import android.content.Context
import edu.ub.pis.joc.limitless.model.game.Coin
import edu.ub.pis.joc.limitless.model.game.Enemy
import java.util.ArrayList

class LevelInfinite(contextApp: Context,
                    listOfEnemyCharacters: ArrayList<Enemy>,
                    listOfCoins: ArrayList<Coin>):
                    Level(contextApp,listOfEnemyCharacters,listOfCoins) {
    override fun buildEnemies(levelWorld: Int, time: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun buildCoins(levelWorld: Int, time: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createLimits(levelWorld: Int): ArrayList<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}