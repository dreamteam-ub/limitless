package edu.ub.pis.joc.limitless.engine

import android.graphics.Rect
import android.util.Log
import edu.ub.pis.joc.limitless.model.game.*
import java.util.*
import kotlin.random.Random

class AutoLevelGenerate {
    /*
    Aquesta classe serà l'encarregada de generar el nivell infinit de forma automàtica, tindrà com a suport
    la AI que hem creat
     */
    var time = 1500L
    val timeStage = 300L
    var spawnEnemyFreq = 2 //frecuencia inicial de spàwn de enemigos : 2
    var spawnCoinFreq = 5 //frecuencia inicial de spawn de monedas
    var listOfEnemies =
        arrayListOf(BOMB_CHAR, GHOST_CHAR, EYE_CHAR, DEMON_CHAR, SKULL_CHAR) //blackhole no aparecer //bomb
    val minTimeInGame = 200L //tiempo minimo que deberan estar los personajes en partida
    val minTimeInGameCoins = 150L
    val maxTimeInGameCoins = 250L
    val maxTimeInGame = 250L
    var limitLow = 15
    var limitHigh = 25
    var lastLow = 1
    var lastHigh = 1
    var positiveCoins = 0
    var negativeCoins = 0
    var firstCall = true
    var firstRound = true
    var ai = ArtificialIntelligence()

    /**
    Funció que ens permetrà crear els paràmetres d'un enemic, com el seu tipus(GHOST, BOMB..),
    la seva posició, comportament, temps en el joc, etc.
    *@return : ArrayList<Any>
     */

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

    /**
    Amb aquesta funcio podrem crear facilment els enemics de les stages preeliminars del mode infinit
    que faran que sigui un joc més progressiu i no tant agressiu al començament.
    *@params : String

    *@return : ArrayList<Any>
     */

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

    /**
    Aquesta funció ens permetrà crear els parametres de la Coin (posició, valor, etc)

    *@return : ArrayList<Any>
     */
    fun generateCoins(): ArrayList<Any> {

        val listOfCoinParams = ArrayList<Any>()

        val entity = NUMBER_COIN

        val coords = ai.generatePositionsForBehaviour(entity, 0)

        listOfCoinParams.add(entity)
        listOfCoinParams.add(coords[0])
        listOfCoinParams.add(coords[1])
        listOfCoinParams.add(generateCoinValues())
        listOfCoinParams.add(Random.nextLong(minTimeInGameCoins, maxTimeInGameCoins))
        return listOfCoinParams

    }
    /**
    Funció que ens permetrà generar els limits de cada stage de forma aleatòria, però controlada
    entre uns valors.

    *@return ArrayList<Int>
     */

    fun generateAutoLimits(): ArrayList<Int> {
        if (firstCall) {
            firstCall = false
            //first limits in infinite loop game
            limitLow = 15
            limitHigh = 25
            return arrayListOf(limitLow, limitHigh)
        } else {
            lastLow = limitLow
            lastHigh = limitHigh
            limitLow += Random.nextInt(-5, 5)
            limitHigh = limitLow + 10
            while (limitLow >= limitHigh){
                lastLow += Random.nextInt(-5, 5)
                lastHigh = limitLow + 10
                limitLow = lastLow
                limitHigh = lastHigh
            }
            var lims = arrayListOf(limitLow, limitHigh)
            return lims
        }
    }

    /**
    Aquesta funció ens permetrà controlar el valor que adquireixen les monedes, d'aquesta manera,
    no sortiran valors que no tinguin res a veure i seràn lògics en relació als límits que
    apareixen en aquell stage.

    *@return : Int
     */
    fun generateCoinValues() : Int{
        if (firstRound){    // facilitarem a l'usuari el primer valor per a que no hi hagi errors
            var valCoinFirst = limitLow
            firstRound = false
            return valCoinFirst
        }
        var valCoin = (Random.nextInt(-limitLow / 2,  limitHigh / 3))

        if (valCoin == 0) {valCoin++}

        if(valCoin > 0){
            if(positiveCoins == Math.ceil(spawnCoinFreq/2.0).toInt() ){
                negativeCoins++
                return valCoin*-1
            } else {
                positiveCoins++
                return valCoin
            }
        } else {
            if(negativeCoins == Math.ceil(spawnCoinFreq/2.0).toInt()){
                positiveCoins++
                return valCoin*-1
            } else {
                negativeCoins++
                return valCoin
            }
        }
    }

    /*
    Funció que es cridarà per a que no acabi la partida i no parin de generar-se enemics i monedes.
    Cada cop incrementa el time un cert valor per a que només s'afegeixin enemics i monedes noves a
    partir de cada 300L
     */
    fun increaseTime() {
            time += timeStage
            if (spawnEnemyFreq < 7) {
                spawnEnemyFreq += 1
            }
    }

    /**
    Funcio que farà que no apareixin monedes una sobre de l'altre, se'ns indicarà si
    estan en la mateixa posició o no
    *@params : ArrayList<Coin>
    *@params : Coin

    *@return : Boolean
     */
    fun reallocateCoin(listCoin: ArrayList<Coin>, coin: Coin): Boolean {
        var same = false
        if (listCoin.size <= 1) {
            return same
        }

        for (i in 0 until listCoin.size) {
            var tmpcoin = listCoin[i]
            if (coin.rect.intersects(tmpcoin.rect.left,tmpcoin.rect.top,tmpcoin.rect.right,tmpcoin.rect.bottom)
                || tmpcoin.rect.intersects(coin.rect.left,coin.rect.top,coin.rect.right,coin.rect.bottom)) {
                Log.d("INTERSECTCOIN","coin")
                listCoin.remove(coin)
                same = true
            } else if (coin.x == tmpcoin.x && coin.y == tmpcoin.y) {
                listCoin.remove(coin)
                same = true
            }
        }
        return same
    }
    /**
    Funcio que farà que no apareixin bombes una sobre de l'altre, se'ns indicarà si
    estan en la mateixa posició o no
    *@params : ArrayList<Enemy>
    *@params : Bomb

    *@return : Boolean
     */
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
    /**
    Funcio que farà que no apareixin bombes sombre monedes, se'ns indicarà si
    estan en la mateixa posició o no
    *@params : ArrayList<Enemy>
    *@params : Coin
    *@params : ArrayList<Coin>

    *@return : Boolean
     */
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

    fun reallocSkulls(skull : Skull, listOfEnemy: ArrayList<Enemy>) : Boolean{
        var same = false
        for (i in 0 until listOfEnemy.size){
            if (listOfEnemy[i] is Skull){

                if (skull.concreteBehaviour == 1 && listOfEnemy[i].concreteBehaviour == 7
                    || skull.concreteBehaviour == 7 && listOfEnemy[i].concreteBehaviour == 1){
                    listOfEnemy.remove(skull)
                    same = true
                }else if (skull.concreteBehaviour == 2 && listOfEnemy[i].concreteBehaviour == 6
                    || skull.concreteBehaviour == 6 && listOfEnemy[i].concreteBehaviour == 2){
                    listOfEnemy.remove(skull)
                    same = true
                }else if (skull.concreteBehaviour == 3 && listOfEnemy[i].concreteBehaviour == 10
                    || skull.concreteBehaviour == 10 && listOfEnemy[i].concreteBehaviour == 3){
                    listOfEnemy.remove(skull)
                    same = true
                }else if (skull.concreteBehaviour == 4 && listOfEnemy[i].concreteBehaviour == 9
                    || skull.concreteBehaviour == 9 && listOfEnemy[i].concreteBehaviour == 4){
                    listOfEnemy.remove(skull)
                    same = true
                }else if (skull.concreteBehaviour == 8 && listOfEnemy[i].concreteBehaviour == 5
                    || skull.concreteBehaviour == 5 && listOfEnemy[i].concreteBehaviour == 8){
                    listOfEnemy.remove(skull)
                    same = true
                }else if (skull.concreteBehaviour == listOfEnemy[i].concreteBehaviour){
                    listOfEnemy.remove(skull)
                    same = true
                }

            }
        }
        return same
    }
}