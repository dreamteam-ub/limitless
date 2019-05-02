package edu.ub.pis.joc.limitless.engine

import android.content.Context
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.BOMB_CHAR
import edu.ub.pis.joc.limitless.model.game.Coin
import edu.ub.pis.joc.limitless.model.game.Enemy
import java.util.ArrayList

class LevelInfinite(contextApp: Context,
                    listOfEnemyCharacters: ArrayList<Enemy>,
                    listOfCoins: ArrayList<Coin>):
                    Level(contextApp,listOfEnemyCharacters,listOfCoins) {
    override fun buildEnemies(levelWorld: Int, time: Long) {
        var listOfTmpEnemies = ArrayList<Enemy>()
        var tmp: Enemy
        when (levelWorld) {
            -1 -> {
                endOfLevel = false
                if (time == 0L) {
                    tmp = createEnemy(
                        BOMB_CHAR,
                        (Data.screenWidth * 0.2).toInt(),
                        (Data.screenHeight * 0.5).toInt(),
                        0,
                        150
                    )
                    listOfTmpEnemies.add(tmp)
                }
                var contador: Int = 0
                while (contador < listOfEnemyCharacters.size) {
                    if (listOfEnemyCharacters.get(contador).dissapearTimer == 0) {
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }

        }
        listOfEnemyCharacters.addAll(listOfTmpEnemies)
    }

    override fun buildCoins(levelWorld: Int, time: Long) {

        //Log.d("TIME", (time).toInt().toString())
        //Log.d("CONTADOR MONEDAS", coinCounter.toString())

        var tmpListOfCoins: ArrayList<Coin> = ArrayList()

        when (levelWorld) {
            -1 -> {
                if (time == 50L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin(
                            "Coin",
                            (Data.screenWidth * 0.3).toInt(),
                            (Data.screenHeight * 0.3).toInt(),
                            3,
                            dissapearTimer = 100
                        )
                    )
                } else if (time == 300L) {
                    tmpListOfCoins = arrayListOf(
                        createCoin(
                            "Coin",
                            (Data.screenWidth * 0.7).toInt(),
                            (Data.screenHeight * 0.7).toInt(),
                            4,
                            dissapearTimer = 100
                        )
                    )
                }
                var contador: Int = 0
                while (contador < listOfCoins.size) {
                    if (listOfCoins.get(contador).dissapearTimer == 0) {
                        listOfCoins.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
        }
        listOfCoins.addAll(tmpListOfCoins)
    }

    override fun createLimits(levelWorld: Int): ArrayList<Int> {

        var listOfLimits: ArrayList<Int> = ArrayList()

        when (levelWorld) {
            -1 -> {
                listOfLimits.add(2)
                listOfLimits.add(10)
            }


        }
        return listOfLimits
    }
}