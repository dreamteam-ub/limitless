package edu.ub.pis.joc.limitless.engine

import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.*
import java.util.ArrayList
import kotlin.random.Random

class AutoLevelGenerate {

    var time = 1500L //ponemos que de 1000L en 1000L se genera un nuevo nivel
    var spawnEnemyFreq = 2 //frecuencia inicial de spàwn de enemigos : 2
    var spawnCoinFreq = 5 //frecuencia inicial de spawn de monedas
    var limitLow = 5
    var limitHigh = 10
    var listOfEnemies = arrayListOf(GHOST_CHAR) //blackhole no aparecer //bomb
    var listOfComplexEnemies = arrayListOf(EYE_CHAR, DEMON_CHAR)
    var minTimeInGame = 200L //tiempo minimo que deberan estar los personajes en partida
    var maxTimeInGame = 500L
    var ai = ArtificialIntelligence()


    fun generateEnemies() : ArrayList<String>{

        var listOfEnemyParams = ArrayList<String>()




        listOfEnemyParams.add(listOfEnemies[(0 until 1).random()])

        listOfEnemyParams.add(ai.generatePositionsForBehaviour(listOfEnemyParams[0])[0].toString())
        listOfEnemyParams.add(ai.generatePositionsForBehaviour(listOfEnemyParams[0])[1].toString())
        listOfEnemyParams.add(Random.nextInt((minTimeInGame).toInt(), (maxTimeInGame).toInt()).toString())
        listOfEnemyParams.add(ai.generatePositionsForBehaviour(listOfEnemyParams[0])[2].toString())




        return listOfEnemyParams
    }


    fun generateComplexEnemy() : ArrayList<String>{

        var listOfComplexEnemyParams = ArrayList<String>()

        listOfComplexEnemyParams.add(listOfComplexEnemies[(0 until 2).random()])
        listOfComplexEnemyParams.add(ai.generatePositionsForBehaviour(listOfComplexEnemyParams[0])[0].toString())
        listOfComplexEnemyParams.add(ai.generatePositionsForBehaviour(listOfComplexEnemyParams[0])[1].toString())
        listOfComplexEnemyParams.add(Random.nextInt((minTimeInGame).toInt(), (maxTimeInGame).toInt()).toString())
        listOfComplexEnemyParams.add(ai.pickABehaviour(listOfComplexEnemyParams[0]).toString())
        listOfComplexEnemyParams.add(ai.generatePositionsForBehaviour(listOfComplexEnemyParams[0])[2].toString())




        return listOfComplexEnemyParams

    }

    fun generateRandomTypeEnemy() : ArrayList<String>{

        var listParams = ArrayList<String>()

        var number = Random.nextInt(0,2)
        when(number){

            0 -> {
                listParams = generateEnemies()
            }

            1 -> {
                listParams = generateComplexEnemy()
            }
        }
        return listParams
    }

    //hacemos lo mismo con las monedas
    fun generateCoins() : ArrayList<String>{

        var listOfCoinParams = ArrayList<String>()

        listOfCoinParams.add(NUMBER_COIN)
        listOfCoinParams.add(Random.nextInt((Data.screenWidth*0.19).toInt(),(Data.screenWidth*0.81).toInt()).toString())
        listOfCoinParams.add(Random.nextInt((Data.screenHeight*0.19).toInt(),(Data.screenHeight*0.81).toInt()).toString())
        listOfCoinParams.add(Random.nextInt(-generateLimits()[0],generateLimits()[1]).toString())
        listOfCoinParams.add(Random.nextInt((minTimeInGame).toInt(), (maxTimeInGame).toInt()).toString())

        Log.d("VALUE",listOfCoinParams[3])

        return listOfCoinParams

    }

    fun generateLimits() : ArrayList<Int>{

        var listOfLimits = ArrayList<Int>()

        listOfLimits.add(limitLow)
        listOfLimits.add(limitHigh)
        

        return listOfLimits

    }

    fun modifyLimits(){
        var valueToModifyLow = 6
        var valueToModifyHigh = 6


    }



    //funcion que hará que a cada time se llame al generate para que nunca acabe la partida
    fun increaseTime(){
        time += time
        spawnEnemyFreq += 1

    }
}