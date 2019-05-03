package edu.ub.pis.joc.limitless.engine

import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.*
import java.util.ArrayList
import kotlin.random.Random

class AutoLevelGenerate {

    var time = 300L //ponemos que de 300L en 300L se genera un nuevo nivel
    var listOfEnemies = arrayListOf(SKULL_CHAR, GHOST_CHAR, DEMON_CHAR, BOMB_CHAR, EYE_CHAR, BLACKHOLE_CHAR)
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

        listOfEnemyParams.add(listOfEnemies[(0 until 5).random()])
        //faltan parametros uwu





        return listOfEnemyParams
    }

    //hacemos lo mismo con las monedas
    fun generateCoins() : ArrayList<String>{

        var listOfCoinParams = ArrayList<String>()

        listOfCoinParams.add(NUMBER_COIN)
        listOfCoinParams.add(Random.nextInt(Data.screenWidth/3).toString())
        listOfCoinParams.add(Random.nextInt(Data.screenHeight/3).toString())
        listOfCoinParams.add(Random.nextInt(-generateLimits()[0],generateLimits()[1]).toString())
        //falta dissapeartime


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
    }
}