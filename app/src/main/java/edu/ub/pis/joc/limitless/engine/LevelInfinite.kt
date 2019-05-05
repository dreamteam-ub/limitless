package edu.ub.pis.joc.limitless.engine

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.*
import edu.ub.pis.joc.limitless.view.FullScreenActivity
import java.util.ArrayList

class LevelInfinite(contextApp: Context,
                    listOfEnemyCharacters: ArrayList<Enemy>,
                    listOfCoins: ArrayList<Coin>):
                    Level(contextApp,listOfEnemyCharacters,listOfCoins) {

    var autoLvl = AutoLevelGenerate()
    var coinSpawnInf = false //con esto controlaremos cuando debe haber spawn de monedas, ya que si usamos
    //el tiempo, no será preciso porque la llamada del método de generar monedas se llama despues del de enemigos
    // en el gamEngine

    override fun buildEnemies(levelWorld: Int, time: Long) {
        var listOfTmpEnemies = ArrayList<Enemy>()
        var tmp: Enemy
        when (levelWorld) {
            -1 -> {
                endOfLevel = false

                if (time == 0L) {

                    for (i in 0 until autoLvl.spawnEnemyFreq) {
                        var parameters = autoLvl.generateRandomTypeEnemy()

                        if (parameters[0].equals(EYE_CHAR) || parameters[0].equals(SKULL_CHAR) || parameters[0].equals(
                                DEMON_CHAR)){

                            tmp = createComplexEnemy(
                                parameters[0],
                                parameters[1].toInt(),
                                parameters[2].toInt(),
                                0,
                                150,
                                0
                            )


                        }else {
                            tmp = createEnemy(
                                parameters[0],
                                parameters[1].toInt(),
                                parameters[2].toInt(),
                                0,
                                150
                            )
                        }

                        listOfTmpEnemies.add(tmp)
                    }


                } else if (time!= 0L && time%autoLvl.time == 0L){
                    listOfEnemyCharacters.clear()
                    autoLvl.increaseTime()
                    coinSpawnInf = true
                    for (i in 0 until autoLvl.spawnEnemyFreq) {
                        var parameters = autoLvl.generateRandomTypeEnemy()

                        if (parameters[0].equals(EYE_CHAR) || parameters[0].equals(SKULL_CHAR) || parameters[0].equals(
                                DEMON_CHAR)){

                            tmp = createComplexEnemy(
                                parameters[0],
                                parameters[1].toInt(),
                                parameters[2].toInt(),
                                0,
                                150,
                                0
                            )


                        }else {
                            tmp = createEnemy(
                                parameters[0],
                                parameters[1].toInt(),
                                parameters[2].toInt(),
                                0,
                                150
                            )
                        }

                        listOfTmpEnemies.add(tmp)
                    }

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
        var coin : Coin
        when (levelWorld) {
            -1 -> {

                if (time == 0L) {
                    for (j in 0 until autoLvl.spawnCoinFreq) {
                        var parameters = autoLvl.generateCoins()

                        coin = createCoin(
                                parameters[0],
                                parameters[1].toInt(),
                                parameters[2].toInt(),
                                parameters[3].toInt(),
                                Typeface.createFromAsset(contextApp.assets, FONT_CRIME_SIX),
                                parameters[4].toInt()
                            )

                        tmpListOfCoins.add(coin)

                    }
                }
                else if (time!= 0L && coinSpawnInf ) {
                    listOfCoins.clear()
                    for (j in 0 until autoLvl.spawnCoinFreq) {
                        var parameters = autoLvl.generateCoins()

                        coin = createCoin(
                            parameters[0],
                            parameters[1].toInt(),
                            parameters[2].toInt(),
                            parameters[3].toInt(),
                            Typeface.createFromAsset(contextApp.assets, FONT_CRIME_SIX),
                            parameters[4].toInt()
                        )
                        Log.d("COINS CREATED", parameters[3])
                        tmpListOfCoins.add(coin)
                    }
                    coinSpawnInf = false

                }

                var contador: Int = 0
                while (contador < listOfCoins.size) {
                    if (listOfCoins[contador].dissapearTimer == 0) {
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

                listOfLimits.add(autoLvl.generateLimits()[0])
                listOfLimits.add(autoLvl.generateLimits()[1])

            }


        }
        return listOfLimits
    }
}