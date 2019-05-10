package edu.ub.pis.joc.limitless.engine

import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.*
import java.util.ArrayList
import kotlin.random.Random
import kotlin.random.nextInt

class AutoLevelGenerate {

    var time = 1000L //ponemos que de 1000L en 1000L se genera un nuevo nivel
    var spawnEnemyFreq = 2 //frecuencia inicial de spàwn de enemigos : 2
    var spawnCoinFreq = 5 //frecuencia inicial de spawn de monedas
    var limitLow = -10
    var limitHigh = 10
    var listOfEnemies = arrayListOf(BOMB_CHAR,GHOST_CHAR,EYE_CHAR, DEMON_CHAR, SKULL_CHAR) //blackhole no aparecer //bomb
    var minTimeInGame = 200L //tiempo minimo que deberan estar los personajes en partida
    var maxTimeInGame = 500L
    var ai = ArtificialIntelligence()


    fun generateEnemy() : ArrayList<Any>{

        var listOfEnemyParams :  ArrayList<Any> = ArrayList()

        val enemyString = listOfEnemies[(0 until listOfEnemies.size).random()]

        val behaviour = ai.pickABehaviour(enemyString)

        val coords = ai.generatePositionsForBehaviour(enemyString,behaviour)

        listOfEnemyParams.add(enemyString)
        listOfEnemyParams.add(coords[0])
        listOfEnemyParams.add(coords[1])
        listOfEnemyParams.add(behaviour)
        listOfEnemyParams.add((Random.nextLong(minTimeInGame,maxTimeInGame)))

        if(enemyString == EYE_CHAR){
            listOfEnemyParams.add(ai.pickABehaviour(EYE_PROJECTILE))
        } else if(enemyString == DEMON_CHAR){
            listOfEnemyParams.add(ai.pickABehaviour(DEMON_FIRE_COLUMN))
        } else if (enemyString == SKULL_CHAR){
            listOfEnemyParams.add(behaviour)
        }

        return listOfEnemyParams
    }

    //hacemos lo mismo con las monedas
    fun generateCoins() : ArrayList<Any>{

        val listOfCoinParams = ArrayList<Any>()

        val entity = NUMBER_COIN

        val coords = ai.generatePositionsForBehaviour(entity,0)

        listOfCoinParams.add(entity)
        listOfCoinParams.add(coords[0])
        listOfCoinParams.add(coords[1])
        listOfCoinParams.add(Random.nextInt(limitLow,limitHigh))
        listOfCoinParams.add(Random.nextLong(minTimeInGame, maxTimeInGame))

        return listOfCoinParams

    }

    //funcion que hará que a cada time se llame al generate para que nunca acabe la partida
    fun increaseTime(){
        time += time
        spawnEnemyFreq += 1
    }
}