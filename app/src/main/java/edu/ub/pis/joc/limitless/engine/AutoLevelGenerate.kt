package edu.ub.pis.joc.limitless.engine

import android.util.Log
import edu.ub.pis.joc.limitless.model.game.*
import java.util.ArrayList
import kotlin.random.Random

class AutoLevelGenerate {

    var time = 1100L //ponemos que de 1000L en 1000L se genera un nuevo nivel
    val timeStage = 500L
    var spawnEnemyFreq = 2 //frecuencia inicial de spàwn de enemigos : 2
    var spawnCoinFreq = 5 //frecuencia inicial de spawn de monedas
    var listOfEnemies = arrayListOf(BOMB_CHAR,GHOST_CHAR,EYE_CHAR, DEMON_CHAR, SKULL_CHAR) //blackhole no aparecer //bomb
    var minTimeInGame = 200L //tiempo minimo que deberan estar los personajes en partida
    var maxTimeInGame = 500L
    var limitLow = -20
    var limitHigh = 20
    var firstCall = true
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

    //AMb aquesta funcio podrem crear facilment els enemics de les stages preeliminars del mode infinit
    //que faran que sigui un joc més progressiu i no tant agressiu al començament.

    fun generateEnemiesInPreviousStages(str : String) : ArrayList<Any>{

        var listOfEnemyParamsStage :  ArrayList<Any> = ArrayList()

        val enemyString = str

        val behaviour = ai.pickABehaviour(enemyString)

        val coords = ai.generatePositionsForBehaviour(enemyString,behaviour)

        listOfEnemyParamsStage.add(enemyString)
        listOfEnemyParamsStage.add(coords[0])
        listOfEnemyParamsStage.add(coords[1])
        listOfEnemyParamsStage.add(behaviour)
        listOfEnemyParamsStage.add((Random.nextLong(minTimeInGame,maxTimeInGame)))

        if(enemyString == EYE_CHAR){
            listOfEnemyParamsStage.add(ai.pickABehaviour(EYE_PROJECTILE))
        } else if(enemyString == DEMON_CHAR){
            listOfEnemyParamsStage.add(ai.pickABehaviour(DEMON_FIRE_COLUMN))
        } else if (enemyString == SKULL_CHAR){
            listOfEnemyParamsStage.add(behaviour)
        }

        return listOfEnemyParamsStage

    }

    //hacemos lo mismo con las monedas
    fun generateCoins() : ArrayList<Any>{

        val listOfCoinParams = ArrayList<Any>()

        val entity = NUMBER_COIN

        val coords = ai.generatePositionsForBehaviour(entity,0)

        listOfCoinParams.add(entity)
        listOfCoinParams.add(coords[0])
        listOfCoinParams.add(coords[1])
        listOfCoinParams.add(Random.nextInt(limitLow/5,limitHigh/5))
        listOfCoinParams.add(Random.nextLong(minTimeInGame, maxTimeInGame))
        Log.d("LIMITLOW",limitLow.toString())
        Log.d("LIMITHIGH",limitHigh.toString())

        return listOfCoinParams

    }

    fun generateAutoLimits() : ArrayList<Int>{
        if (firstCall){
            firstCall = false
            limitLow = -20
            limitHigh = 20
            return arrayListOf(limitLow,limitHigh)
        }else{
            limitLow += Random.nextInt(-6,6)
            limitHigh += Random.nextInt(-6,6)
            var lims = arrayListOf(limitLow,limitHigh)
            return lims
        }
    }

    //funcion que hará que a cada time se llame al generate para que nunca acabe la partida
    fun increaseTime(){
        time += timeStage
        spawnEnemyFreq += 1
        if(time>1000 && spawnEnemyFreq<6){
            spawnEnemyFreq += 1
        }
        Log.d("TIME",time.toString())
    }
}