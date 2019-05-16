package edu.ub.pis.joc.limitless.engine

import android.graphics.Rect
import android.util.Log
import edu.ub.pis.joc.limitless.model.game.*
import java.util.ArrayList
import kotlin.random.Random

class AutoLevelGenerate {

    var time = 1500L //ponemos que de 1000L en 1000L se genera un nuevo nivel
    val timeStage = 300L
    var spawnEnemyFreq = 2 //frecuencia inicial de spàwn de enemigos : 2
    var spawnCoinFreq = 5 //frecuencia inicial de spawn de monedas
    var listOfEnemies =
        arrayListOf(BOMB_CHAR, GHOST_CHAR, EYE_CHAR, DEMON_CHAR, SKULL_CHAR) //blackhole no aparecer //bomb
    var minTimeInGame = 200L //tiempo minimo que deberan estar los personajes en partida
    var maxTimeInGame = 500L
    var limitLow = -10
    var limitHigh = 20
    var lastLow = 1
    var firstCall = true
    var ai = ArtificialIntelligence()


    fun generateEnemy(): ArrayList<Any> {

        var listOfEnemyParams: ArrayList<Any> = ArrayList()

        val enemyString = listOfEnemies[(0 until listOfEnemies.size).random()]

        val behaviour = ai.pickABehaviour(enemyString)

        val coords = ai.generatePositionsForBehaviour(enemyString, behaviour)

        listOfEnemyParams.add(enemyString)
        listOfEnemyParams.add(coords[0])
        listOfEnemyParams.add(coords[1])
        listOfEnemyParams.add(behaviour)
        listOfEnemyParams.add((Random.nextLong(minTimeInGame, maxTimeInGame)))

        if (enemyString == EYE_CHAR) {
            listOfEnemyParams.add(ai.pickABehaviour(EYE_PROJECTILE))
        } else if (enemyString == DEMON_CHAR) {
            listOfEnemyParams.add(ai.pickABehaviour(DEMON_FIRE_COLUMN))
        } else if (enemyString == SKULL_CHAR) {
            listOfEnemyParams.add(behaviour)
        }

        return listOfEnemyParams
    }

    //AMb aquesta funcio podrem crear facilment els enemics de les stages preeliminars del mode infinit
    //que faran que sigui un joc més progressiu i no tant agressiu al començament.

    fun generateEnemiesInPreviousStages(str: String): ArrayList<Any> {

        var listOfEnemyParamsStage: ArrayList<Any> = ArrayList()

        val enemyString = str

        val behaviour = ai.pickABehaviour(enemyString)

        val coords = ai.generatePositionsForBehaviour(enemyString, behaviour)

        listOfEnemyParamsStage.add(enemyString)
        listOfEnemyParamsStage.add(coords[0])
        listOfEnemyParamsStage.add(coords[1])
        listOfEnemyParamsStage.add(behaviour)
        listOfEnemyParamsStage.add((Random.nextLong(minTimeInGame, maxTimeInGame)))

        if (enemyString == EYE_CHAR) {
            listOfEnemyParamsStage.add(ai.pickABehaviour(EYE_PROJECTILE))
        } else if (enemyString == DEMON_CHAR) {
            listOfEnemyParamsStage.add(ai.pickABehaviour(DEMON_FIRE_COLUMN))
        } else if (enemyString == SKULL_CHAR) {
            listOfEnemyParamsStage.add(behaviour)
        }

        return listOfEnemyParamsStage

    }

    //hacemos lo mismo con las monedas
    fun generateCoins(): ArrayList<Any> {

        val listOfCoinParams = ArrayList<Any>()

        val entity = NUMBER_COIN

        val coords = ai.generatePositionsForBehaviour(entity, 0)

        listOfCoinParams.add(entity)
        listOfCoinParams.add(coords[0])
        listOfCoinParams.add(coords[1])
        listOfCoinParams.add(generateCoinValues(lastLow,limitLow))
        listOfCoinParams.add(Random.nextLong(minTimeInGame, maxTimeInGame))
        Log.d("LIMITLOW", limitLow.toString())
        Log.d("LIMITHIGH", limitHigh.toString())

        return listOfCoinParams

    }

    fun generateAutoLimits(): ArrayList<Int> {
        if (firstCall) {
            firstCall = false
            //first limits in infinite loop game
            limitLow = -10
            limitHigh = 20
            return arrayListOf(limitLow, limitHigh)
        } else {
            lastLow = limitLow
            limitLow += Random.nextInt(-6, 6)
            limitHigh += Random.nextInt(-6, 6)
            var lims = arrayListOf(limitLow, limitHigh)
            return lims
        }
    }

    fun generateCoinValues(lastLow : Int, low : Int) : Int{
        var valCoin = 0
        if (lastLow > low){
            //mas monedas negativas
            valCoin = (Random.nextInt(-limitLow / 3,  2))

        }
        else if (lastLow <= low){
            //mas monedas positivas
            valCoin = (Random.nextInt((-limitLow+limitHigh/10) / 3, limitHigh / 3))

        }
        return valCoin
    }

    //funcion que hará que a cada time se llame al generate para que nunca acabe la partida
    fun increaseTime() {
        time += timeStage
        spawnEnemyFreq += 1
        if (time > 1000 && spawnEnemyFreq < 6) {
            spawnEnemyFreq += 1
        }
        Log.d("TIME", time.toString())
    }


    fun reallocateCoin(listCoin: ArrayList<Coin>, coin: Coin): Boolean {
        var same = false
        if (listCoin.size <= 1) {
            return same
        }

        for (i in 0 until listCoin.size) {
            var tmpcoin = listCoin[i]
            if (Rect.intersects(coin.rect, tmpcoin.rect)) {
                listCoin.remove(coin)
                Log.d("REALTRUE", i.toString())
                same = true
            } else if (coin.x == tmpcoin.x && coin.y == tmpcoin.y) {
                listCoin.remove(coin)
                Log.d("REALTRUE2", i.toString())
                same = true
            }
        }
        return same
    }

    fun reallocateBombs(listBomb: ArrayList<Enemy>, enemy: Enemy): Boolean {
        var same = false
        if (enemy is Bomb) {
            if (listBomb.size <= 1) {
                return same
            }
            for (i in 0 until listBomb.size) {
                var tmpBomb = listBomb[i]
                if (Rect.intersects(enemy.rect, tmpBomb.rect)) {
                    listBomb.remove(enemy)
                    Log.d("REALTRUEBOMB", i.toString())
                    same = true

                } else if (enemy.x == tmpBomb.x && enemy.y == tmpBomb.y) {
                    listBomb.remove(enemy)
                    Log.d("REALTRUEBOMB2", i.toString())
                    same = true
                }
            }
        }
        return same
    }

    fun reallocCoinsAndBombs(coin: Coin , listOfEnemy: ArrayList<Enemy>, listCoin: ArrayList<Coin>) : Boolean {
        var same = false
        for(i in 0 until listOfEnemy.size){
            if (listOfEnemy[i] is Bomb){
                var tmpBomb = listOfEnemy[i]
                if (Rect.intersects(coin.rect, tmpBomb.rect)) {
                    listCoin.remove(coin)
                    Log.d("REALTRUEBOMBCOIN", i.toString())
                    same = true

                } else if (coin.x == tmpBomb.x && coin.y == tmpBomb.y) {
                    listCoin.remove(coin)
                    Log.d("REALTRUEBOMBCOIN2", i.toString())
                    same = true
                }

            }
        }
        return same

    }
}