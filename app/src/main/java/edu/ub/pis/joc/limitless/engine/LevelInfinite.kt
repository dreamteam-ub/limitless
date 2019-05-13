package edu.ub.pis.joc.limitless.engine

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import edu.ub.pis.joc.limitless.model.game.*
import edu.ub.pis.joc.limitless.view.end_game
import edu.ub.pis.joc.limitless.view.gamescreen.Limits
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

    var infiniteStage = 0
    init {
        limits = Limits(autoLvl.limitLow,autoLvl.limitHigh, contextApp)
    }
    @Synchronized
    override fun buildEnemies(levelWorld: Int, time: Long) {
        var listOfTmpEnemies = ArrayList<Enemy>()
        when (levelWorld) {
            -1 -> {

                if (time == 0L) {   //primera stage de bombes per començar
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    var parameters : ArrayList<Any>
                    for (i in 0 until autoLvl.spawnEnemyFreq){
                        parameters = autoLvl.generateEnemiesInPreviousStages(BOMB_CHAR)
                        listOfTmpEnemies.add(createEnemy(
                            parameters[0].toString(),
                            parameters[1].toString().toInt(),
                            parameters[2].toString().toInt(),
                            parameters[3].toString().toInt(),
                            parameters[4].toString().toInt()
                        ))
                        listOfTmpEnemies[i].appearTime = Random.nextLong(0L, 150L)
                    }

                }else if (time == 200L) { //segona stage ghosts
                    infiniteStage = 1
                    newStage = true
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    var parameters : ArrayList<Any>
                    for (i in 0 until autoLvl.spawnEnemyFreq){
                        parameters = autoLvl.generateEnemiesInPreviousStages(GHOST_CHAR)
                        listOfTmpEnemies.add(createEnemy(
                            parameters[0].toString(),
                            parameters[1].toString().toInt(),
                            parameters[2].toString().toInt(),
                            parameters[3].toString().toInt(),
                            parameters[4].toString().toInt()
                        ))
                        listOfTmpEnemies[i].appearTime = Random.nextLong(200L, 350L)

                    }

                    //HARDCODEAR MAXIMO Y MINIMO PUNTUACION
                }else if (time == 400L) {   // Tercera stage eyes
                    infiniteStage = 2
                    newStage = true
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    var parameters : ArrayList<Any>
                    for (i in 0 until autoLvl.spawnEnemyFreq){
                        parameters = autoLvl.generateEnemiesInPreviousStages(EYE_CHAR)
                        var eye : Eye = (createComplexEnemy(
                            parameters[0].toString(),
                            parameters[1].toString().toInt(),
                            parameters[2].toString().toInt(),
                            parameters[3].toString().toInt(),
                            parameters[4].toString().toInt(),
                            parameters[5].toString().toInt()
                        )) as Eye
                        eye.drawChild = true
                        listOfTmpEnemies.add(eye)
                        listOfTmpEnemies[i].appearTime = Random.nextLong(400L, 550L)

                    }
                    //HARDCODEAR MAXIMO Y MINIMO PUNTUACION
                }else if (time == 600L) {   // quarta stage demons
                    infiniteStage = 3
                    newStage = true
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    var parameters : ArrayList<Any>
                    for (i in 0 until autoLvl.spawnEnemyFreq) {
                        parameters = autoLvl.generateEnemiesInPreviousStages(DEMON_CHAR)
                        listOfTmpEnemies.add(
                            createComplexEnemy(
                                parameters[0].toString(),
                                parameters[1].toString().toInt(),
                                parameters[2].toString().toInt(),
                                parameters[3].toString().toInt(),
                                parameters[4].toString().toInt(),
                                parameters[5].toString().toInt()
                            )
                        )
                        listOfTmpEnemies[i].appearTime = Random.nextLong(600L, 750L)

                    }
                    //HARDCODEAR MAXIMO Y MINIMO PUNTUACION
                }else if (time == 800L) { //cinquena stage skulls
                    infiniteStage = 4
                    newStage = true
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    var parameters : ArrayList<Any>
                    for (i in 0 until autoLvl.spawnEnemyFreq) {
                        parameters = autoLvl.generateEnemiesInPreviousStages(SKULL_CHAR)
                        listOfTmpEnemies.add(
                            createComplexEnemy(
                                parameters[0].toString(),
                                parameters[1].toString().toInt(),
                                parameters[2].toString().toInt(),
                                parameters[3].toString().toInt(),
                                parameters[4].toString().toInt(),
                                parameters[5].toString().toInt()
                            )
                        )
                        listOfTmpEnemies[i].appearTime = Random.nextLong(800L, 950L)

                    }
                    //HARDCODEAR MAXIMO Y MINIMO PUNTUACION
                } else if (time%autoLvl.time == 0L){
                    infiniteMode = true
                    listOfEnemyCharacters.clear()
                    autoLvl.increaseTime()
                    newStage = true
                    coinSpawnInf = true
                    var parameters : ArrayList<Any>
                    for (i in 0 until autoLvl.spawnEnemyFreq) {
                        parameters = autoLvl.generateEnemy()
                        if(parameters.size == 5){
                            listOfTmpEnemies.add(createEnemy(
                                parameters[0].toString(),
                                parameters[1].toString().toInt(),
                                parameters[2].toString().toInt(),
                                parameters[3].toString().toInt(),
                                parameters[4].toString().toInt()
                            ))
                        } else if(parameters[0].toString()== EYE_CHAR) {
                            var eye : Eye = (createComplexEnemy(
                                parameters[0].toString(),
                                parameters[1].toString().toInt(),
                                parameters[2].toString().toInt(),
                                parameters[3].toString().toInt(),
                                parameters[4].toString().toInt(),
                                parameters[5].toString().toInt()
                            )) as Eye
                            eye.drawChild = true
                        }else{
                            listOfTmpEnemies.add(createComplexEnemy(
                                parameters[0].toString(),
                                parameters[1].toString().toInt(),
                                parameters[2].toString().toInt(),
                                parameters[3].toString().toInt(),
                                parameters[4].toString().toInt(),
                                parameters[5].toString().toInt()
                            ))
                        }
                        listOfTmpEnemies[i].appearTime = Random.nextLong(time, autoLvl.time-100L)

                    }
                    //HARDCODEAR MAXIMO Y MINIMO PUNTUACION
                }


                var contador = 0
                while (contador < listOfEnemyCharacters.size) {
                    if (listOfEnemyCharacters.get(contador).dissapearTimer == 0) {
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    listOfTmpEnemies.clear()
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
                if (!infiniteMode && coinSpawnInf){
                    listOfCoins.clear()
                    for (j in 0 until autoLvl.spawnCoinFreq) {
                        var parameters = autoLvl.generateCoins()

                        coin = createCoin(
                            parameters[0].toString(),
                            parameters[1].toString().toInt(),
                            parameters[2].toString().toInt(),
                            Random.nextInt(createLimits(-1)[0],createLimits(-1)[1]),
                            Typeface.createFromAsset(contextApp.assets, FONT_CRIME_SIX),
                            parameters[4].toString().toInt()
                        )

                        //Log.d("COINS CREATED", parameters[3].toString())
                        tmpListOfCoins.add(coin)
                        if (time<1000) {
                            tmpListOfCoins[j].appearTime = Random.nextLong(time, time + 200L)
                        }

                    }
                    coinSpawnInf = false

                }

                else if (time!= 0L && coinSpawnInf && infiniteMode) {
                    listOfCoins.clear()
                    for (j in 0 until autoLvl.spawnCoinFreq) {
                        var parameters = autoLvl.generateCoins()

                        coin = createCoin(
                            parameters[0].toString(),
                            parameters[1].toString().toInt(),
                            parameters[2].toString().toInt(),
                            parameters[3].toString().toInt(),
                            Typeface.createFromAsset(contextApp.assets, FONT_CRIME_SIX),
                            parameters[4].toString().toInt()
                        )
                        //Log.d("COINS CREATED", parameters[3].toString())
                        tmpListOfCoins.add(coin)
                        tmpListOfCoins[j].appearTime = Random.nextLong(time, autoLvl.time-100)


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
        var limit = ArrayList<Int>()

        if (!infiniteMode){
            when(infiniteStage){
                0 -> {
                    limits.min = 15
                    limits.max = 50
                    autoLvl.limitLow=15
                    autoLvl.limitHigh=50
                    limit.add(limits.min)
                    limit.add(limits.max)
                }
                1 -> {
                    limits.min = 20
                    limits.max = 65
                    autoLvl.limitLow=20
                    autoLvl.limitHigh=65
                    limit.add(limits.min)
                    limit.add(limits.max)
                }
                2 -> {
                    limits.min = 10
                    limits.max = 36
                    autoLvl.limitLow=10
                    autoLvl.limitHigh=36
                    limit.add(limits.min)
                    limit.add(limits.max)
                }
                3 -> {
                    limits.min = 50
                    limits.max = 90
                    autoLvl.limitLow=50
                    autoLvl.limitHigh=90
                    limit.add(limits.min)
                    limit.add(limits.max)
                }
                4 -> {
                    limits.min = 45
                    limits.max = 90
                    autoLvl.limitLow=45
                    autoLvl.limitHigh=90
                    limit.add(limits.min)
                    limit.add(limits.max)
                }
            }
        }
        else{
            var lims = (autoLvl.generateAutoLimits())
            limits.min = lims[0]
            limits.max = lims[1]
            Log.d("limits", lims[0].toString())
            Log.d("limits2", lims[1].toString())

            return lims
        }
        Log.d("INFstage", infiniteStage.toString())
        return limit
    }
}