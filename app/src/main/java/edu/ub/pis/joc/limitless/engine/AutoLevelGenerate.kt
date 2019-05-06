package edu.ub.pis.joc.limitless.engine

import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.*
import java.util.ArrayList
import kotlin.random.Random

class AutoLevelGenerate {

    var time = 1000L //ponemos que de 1000L en 1000L se genera un nuevo nivel
    var spawnEnemyFreq = 2 //frecuencia inicial de spàwn de enemigos : 2
    var spawnCoinFreq = 5 //frecuencia inicial de spawn de monedas
    var limitLow = 5
    var limitHigh = 10
    var listOfEnemies = arrayListOf(GHOST_CHAR, BOMB_CHAR) //blackhole no aparecer
    var listOfComplexEnemies = arrayListOf(EYE_CHAR, DEMON_CHAR, SKULL_CHAR)
    var minTimeInGame = 200L //tiempo minimo que deberan estar los personajes en partida
    var ai = ArtificialIntelligence()

    /*funcion que generará un enemigo de forma aleatoria pero controlada
    @param 1 : caracter
    @param2 : posicion x
    @param 3 : posicion Y
    @param 4 : comportamiento
    @param 5 : tiempo de desaparicion
    */
    fun generateEnemies() : ArrayList<String>{

        var listOfEnemyParams = ArrayList<String>()

        var randomXlow = Random.nextInt((Data.screenWidth*0.05).toInt(), (Data.screenWidth*0.2).toInt())
        var randomXhigh = Random.nextInt((Data.screenWidth*0.85).toInt(), (Data.screenWidth*0.95).toInt())
        var randX = arrayOf(randomXlow,randomXhigh)

        var randomYlow = Random.nextInt((Data.screenHeight*0.05).toInt(), (Data.screenHeight*0.2).toInt())
        var randomYhigh = Random.nextInt((Data.screenHeight*0.85).toInt(), (Data.screenHeight*0.95).toInt())
        var randY = arrayOf(randomYlow,randomYhigh)



        listOfEnemyParams.add(listOfEnemies[(0 until 2).random()])
        listOfEnemyParams.add(randX[(0 until 2).random()].toString())
        listOfEnemyParams.add(randY[(0 until 2).random()].toString())
        listOfEnemyParams.add(Random.nextInt((minTimeInGame).toInt(), (time).toInt()).toString())
        if (listOfEnemyParams[0]!= BOMB_CHAR) {
            listOfEnemyParams.add(ai.pickABehaviour(listOfEnemyParams[0]).toString())
        }else{
            listOfEnemyParams.add(0.toString())
        }



        return listOfEnemyParams
    }


    fun generateComplexEnemy() : ArrayList<String>{

        var listOfComplexEnemyParams = ArrayList<String>()
        var randomXlow = Random.nextInt((Data.screenWidth*0.05).toInt(), (Data.screenWidth*0.2).toInt())
        var randomXhigh = Random.nextInt((Data.screenWidth*0.85).toInt(), (Data.screenWidth*0.95).toInt())
        var randX = arrayOf(randomXlow,randomXhigh)

        var randomYlow = Random.nextInt((Data.screenHeight*0.05).toInt(), (Data.screenHeight*0.2).toInt())
        var randomYhigh = Random.nextInt((Data.screenHeight*0.85).toInt(), (Data.screenHeight*0.95).toInt())
        var randY = arrayOf(randomYlow,randomYhigh)


        listOfComplexEnemyParams.add(listOfComplexEnemies[(0 until 3).random()])
        listOfComplexEnemyParams.add(randX[(0 until 2).random()].toString())
        listOfComplexEnemyParams.add(randY[(0 until 2).random()].toString())
        listOfComplexEnemyParams.add(Random.nextInt((minTimeInGame).toInt(), (time).toInt()).toString())
        listOfComplexEnemyParams.add(ai.pickABehaviour(listOfComplexEnemyParams[0]).toString())



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
        listOfCoinParams.add(Random.nextInt((minTimeInGame).toInt(), (time).toInt()).toString())
        Log.d("RANDOM X",listOfCoinParams[1])
        Log.d("RANDOM Y",listOfCoinParams[2])
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