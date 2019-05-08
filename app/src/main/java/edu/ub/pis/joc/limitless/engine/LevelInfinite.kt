package edu.ub.pis.joc.limitless.engine

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.*
import java.util.ArrayList
import kotlin.random.Random

class LevelInfinite(contextApp: Context,
                    listOfEnemyCharacters: ArrayList<Enemy>,
                    listOfCoins: ArrayList<Coin>):
                    Level(contextApp,listOfEnemyCharacters,listOfCoins) {

    var autoLvl = AutoLevelGenerate()
    var coinSpawnInf = false //con esto controlaremos cuando debe haber spawn de monedas, ya que si usamos
    //el tiempo, no será preciso porque la llamada del método de generar monedas se llama despues del de enemigos
    // en el gamEngine
    var limitsChange = false
    var timeCoinSpawn = 50L
    @Synchronized
    override fun buildEnemies(levelWorld: Int, time: Long) {
        var listOfTmpEnemies = ArrayList<Enemy>()
        var tmp: Enemy
        when (levelWorld) {
            -1 -> {

                if (time == 0L) {
                    coinSpawnInf = true
                    //primera oleada de bombas
                    for (i in 0 until autoLvl.spawnEnemyFreq) {
                        //var parameters = autoLvl.generateEnemies()

                        tmp = createEnemy(
                            BOMB_CHAR,
                            Random.nextInt((Data.screenWidth*0.2).toInt(), (Data.screenWidth*0.8).toInt()),
                            Random.nextInt((Data.screenHeight*0.2).toInt(), (Data.screenHeight*0.8).toInt()),
                            0,
                           150
                        )

                        listOfTmpEnemies.add(tmp)
                    }

                }else if (time == 100L) {

                    //segunda oleada fantasmas
                    coinSpawnInf = true

                    for (i in 0 until autoLvl.spawnEnemyFreq) {
                        var parameters = autoLvl.generateEnemies()

                            tmp = createEnemy(
                            GHOST_CHAR,
                            parameters[1].toInt(),
                            parameters[2].toInt(),
                            autoLvl.ai.pickABehaviour(GHOST_CHAR),
                            parameters[3].toInt()
                        )


                        listOfTmpEnemies.add(tmp)

                    }
                }else if (time == 200L) {

                    coinSpawnInf = true
                    // tercera oleada Eyes
                    for (i in 0 until autoLvl.spawnEnemyFreq) {
                        //var parameters = autoLvl.generateComplexEnemy()
                        var tmpEye:Eye
                         tmpEye = createComplexEnemy(
                            EYE_CHAR,
                            autoLvl.ai.generatePositionsForBehaviour(EYE_CHAR)[0],
                             autoLvl.ai.generatePositionsForBehaviour(EYE_CHAR)[1],
                             autoLvl.ai.generatePositionsForBehaviour(EYE_CHAR)[2],
                             (Random.nextInt((autoLvl.minTimeInGame).toInt(), (autoLvl.maxTimeInGame).toInt())),
                            autoLvl.ai.pickABehaviour(EYE_CHAR)
                        ) as Eye
                        listOfTmpEnemies.add(tmpEye)
                        tmpEye.drawChild = true
                        tmpEye.projectileDraw[0] = true
                        tmpEye.projectileRelocate[0] = true

                    }

                }else if (time == 400L) {
                    coinSpawnInf = true
                    // cuarta oleada de Demons
                        for (i in 0 until autoLvl.spawnEnemyFreq) {
                            var parameters = autoLvl.generateComplexEnemy()

                            tmp = createComplexEnemy(
                                DEMON_CHAR,
                                autoLvl.ai.generatePositionsForBehaviour(DEMON_CHAR)[0],
                                autoLvl.ai.generatePositionsForBehaviour(DEMON_CHAR)[1],
                                autoLvl.ai.generatePositionsForBehaviour(DEMON_CHAR)[2],
                                (Random.nextInt((autoLvl.minTimeInGame).toInt(), (autoLvl.maxTimeInGame).toInt())),
                                autoLvl.ai.pickABehaviour(DEMON_CHAR)
                            )

                            listOfTmpEnemies.add(tmp)

                        }

                }else if (time == 600L) {
                    coinSpawnInf = true
                    // quinta y ultima oleada de Skull
                    for (i in 0 until autoLvl.spawnEnemyFreq) {
                        var parameters = autoLvl.generateComplexEnemy()

                        tmp = createComplexEnemy(
                            SKULL_CHAR,
                            parameters[1].toInt(),
                            parameters[2].toInt(),
                            autoLvl.ai.generatePositionsForBehaviour(SKULL_CHAR)[0],
                            parameters[3].toInt(),
                            autoLvl.ai.pickABehaviour(SKULL_CHAR)
                        )

                        listOfTmpEnemies.add(tmp)

                    }

                } else if (time%autoLvl.time == 0L){
                    listOfEnemyCharacters.clear()
                    autoLvl.increaseTime()
                    coinSpawnInf = true
                    for (i in 0 until autoLvl.spawnEnemyFreq) {
                        var parameters = autoLvl.generateRandomTypeEnemy()

                        if (parameters[0].equals(EYE_CHAR) || parameters[0].equals(SKULL_CHAR) || parameters[0].equals(
                                DEMON_CHAR)){

                            when(parameters[0]){

                                EYE_CHAR -> {
                                    var tmpEye : Eye
                                    tmpEye = createComplexEnemy(
                                        parameters[0],
                                        parameters[1].toInt(),
                                        parameters[2].toInt(),
                                        parameters[5].toInt(),
                                        parameters[3].toInt(),
                                        parameters[4].toInt()
                                    ) as Eye

                                    tmpEye.drawChild = true
                                    listOfTmpEnemies.add(tmpEye)
                                    tmpEye.drawChild = true
                                    tmpEye.projectileDraw[0] = true
                                    tmpEye.projectileRelocate[0] = true
                                }

                                DEMON_CHAR -> {
                                    tmp = createComplexEnemy(
                                        parameters[0],
                                        parameters[1].toInt(),
                                        parameters[2].toInt(),
                                        parameters[5].toInt(),
                                        parameters[3].toInt(),
                                        parameters[4].toInt()
                                    )

                                    listOfTmpEnemies.add(tmp)
                                }

                                SKULL_CHAR -> {

                                    tmp = createComplexEnemy(
                                        parameters[0],
                                        parameters[1].toInt(),
                                        parameters[2].toInt(),
                                        parameters[5].toInt(),
                                        parameters[3].toInt(),
                                        parameters[4].toInt()
                                    )

                                    listOfTmpEnemies.add(tmp)

                                }

                            }

                        }else {
                            tmp = createEnemy(
                                parameters[0],
                                parameters[1].toInt(),
                                parameters[2].toInt(),
                                parameters[4].toInt(),
                                parameters[3].toInt()
                            )
                            listOfTmpEnemies.add(tmp)

                        }

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
    @Synchronized
    override fun buildCoins(levelWorld: Int, time: Long) {
        //Log.d("TIME", (time).toInt().toString())
        //Log.d("CONTADOR MONEDAS", coinCounter.toString())
        var tmpListOfCoins: ArrayList<Coin> = ArrayList()
        var coin : Coin
        when (levelWorld) {
            -1 -> {

                if (time!= 0L && coinSpawnInf ) {
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