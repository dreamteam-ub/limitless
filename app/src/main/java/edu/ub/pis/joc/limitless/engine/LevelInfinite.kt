package edu.ub.pis.joc.limitless.engine

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.*
import java.lang.Math.abs
import java.sql.DataTruncation
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
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    //HARDCODEAR
                    //HARDCODEAR MAXIMO Y MINIMO PUNTUACION
                }else if (time == 100L) {
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    //HARDCODEAR
                    //HARDCODEAR MAXIMO Y MINIMO PUNTUACION
                }else if (time == 200L) {
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    //HARDCODEAR
                    //HARDCODEAR MAXIMO Y MINIMO PUNTUACION
                }else if (time == 400L) {
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    //HARDCODEAR
                    //HARDCODEAR MAXIMO Y MINIMO PUNTUACION
                }else if (time == 600L) {
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    //HARDCODEAR ENEMIGOS
                    //HARDCODEAR MAXIMO Y MINIMO PUNTUACION
                } else if (time%autoLvl.time == 0L){
                    listOfEnemyCharacters.clear()
                    autoLvl.increaseTime()
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
                if (time!= 0L && coinSpawnInf ) {
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
        return arrayListOf(0,100)
    }
}