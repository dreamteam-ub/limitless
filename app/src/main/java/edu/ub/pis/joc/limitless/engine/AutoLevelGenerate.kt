package edu.ub.pis.joc.limitless.engine

import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.*
import java.util.ArrayList
import kotlin.random.Random

class AutoLevelGenerate {

    var time = 300L //ponemos que de 200L en 200L se genera un nuevo nivel
    var spawnEnemyFreq = 2
    var spawnCoinFreq = 5
    var listOfEnemies = arrayListOf(GHOST_CHAR, BOMB_CHAR) //blackhole
    var listOfComplexEnemies = arrayListOf(EYE_CHAR, DEMON_CHAR, SKULL_CHAR)
    var minTimeInGame = 200L //tiempo minimo que deberan estar los personajes en partida
    //lista de enemigos donde estan todos los nombres


    /*funcion que generará un enemigo de forma aleatoria pero controlada
    @param 1 : caracter
    @param2 : posicion x
    @param 3 : posicion Y
    @param 4 : comportamiento
    @param 5 : tiempo de desaparicion
    */
    fun generateEnemies() : ArrayList<String>{

        var listOfEnemyParams = ArrayList<String>()

        listOfEnemyParams.add(listOfEnemies[(0 until 2).random()])
        listOfEnemyParams.add(Random.nextInt((Data.screenWidth*0.2).toInt(), (Data.screenWidth*0.9).toInt()).toString())
        listOfEnemyParams.add(Random.nextInt((Data.screenHeight*0.2).toInt(), (Data.screenHeight*0.9).toInt()).toString())




        return listOfEnemyParams
    }


    fun generateComplexEnemy() : ArrayList<String>{

        var listOfComplexEnemyParams = ArrayList<String>()

        listOfComplexEnemyParams.add(listOfComplexEnemies[(0 until 3).random()])
        listOfComplexEnemyParams.add(Random.nextInt((Data.screenWidth*0.2).toInt(),(Data.screenWidth*0.85).toInt()).toString())
        listOfComplexEnemyParams.add(Random.nextInt((Data.screenHeight*0.2).toInt(), (Data.screenHeight*0.85).toInt()).toString())


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

        return listOfCoinParams

    }

    fun generateLimits() : ArrayList<Int>{

        var listOfLimits = ArrayList<Int>()

        listOfLimits.add(1)
        listOfLimits.add(12)
        

        return listOfLimits

    }




    //funcion que hará que a cada time se llame al generate para que nunca acabe la partida
    fun increaseTime(){
        time += time
        spawnEnemyFreq += 1

    }
}