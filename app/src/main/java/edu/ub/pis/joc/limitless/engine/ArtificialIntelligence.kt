package edu.ub.pis.joc.limitless.engine

import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.*
import kotlin.random.Random


class ArtificialIntelligence {



    var allLists = arrayListOf<Array<Int>>(AIData.behaviourDemon,AIData.behaviourGhost,AIData.behaviourSkull,
        AIData.behaviourEye)

    var calls = 0

    // in complex enemies we will take its childList and in simple enemies we will take its behaviour
    fun updateBestBehaviour(enemy : Enemy){

        when(enemy){

            is Demon -> {
                allLists.remove(AIData.behaviourDemon)
                calculateProbabilities(AIData.behaviourDemon,enemy.concreteBehaviour)
                allLists.add(0,AIData.behaviourDemon)

            }
            is Ghost -> {
                allLists.remove(AIData.behaviourGhost)
                AIData.behaviourGhost=calculateProbabilities(AIData.behaviourGhost,enemy.concreteBehaviour)
                allLists.add(1,AIData.behaviourGhost)

            }


            is Skull -> {
                allLists.remove(AIData.behaviourSkull)
                calculateProbabilities(AIData.behaviourSkull,enemy.concreteBehaviour)
                allLists.add(2,AIData.behaviourSkull)

            }
            is Eye -> {
                allLists.remove(AIData.behaviourEye)
                calculateProbabilities(AIData.behaviourEye,enemy.concreteBehaviour)
                allLists.add(3,AIData.behaviourEye)

            }


        }





    }
    fun calculateProbabilities(listProb : Array<Int>, behaviour : Int) : Array<Int>{

        Log.d("BEFORE CALCULATE",listProb[behaviour].toString())
            if (listProb[behaviour] < listProb[listProb.size-1]) {
                Log.d("calculate min 1",listProb[listProb.size-1].toString())
                listProb[behaviour] += listProb.size - 1
                for (i in 0 until listProb.size - 1) {
                    if (i != behaviour) {
                        listProb[i] -= (listProb.size - 1 / listProb.size - 1)

                    }
                }
            }

        Log.d("calculate",listProb[behaviour].toString())
        calls += 1
        return listProb

    }

    fun getBehaviour(chr: String): Int { //ONLY FOR COMPLEX ENEMIES
        when (chr) {
            EYE_CHAR -> {
                return AIData.bEye
            }
            DEMON_CHAR -> {
                return AIData.bDemon
            }
            SKULL_CHAR -> {
                return AIData.bSkull
            }
        }
        return 0
    }

    fun getList(chr: String): Array<Int> {
        var lista = emptyArray<Int>()
        when (chr) {

            EYE_CHAR -> return AIData.behaviourEye
            DEMON_CHAR -> return AIData.behaviourDemon
            SKULL_CHAR -> return AIData.behaviourSkull
            GHOST_CHAR -> return AIData.behaviourGhost

        }
        return lista
    }

    fun pickABehaviour(str: String): Int {
        Log.d("STR", str)
        var list = getList(str)
        var long = list.size - 1
        var behaviour = 0

        var probability = Random.nextInt(1, 101)
        Log.d("PROB", probability.toString())
        var accumulateInList = 0

        for (i in 0 until long) {
            if (probability > accumulateInList) {
                accumulateInList += list[i]
                Log.d("ACC", accumulateInList.toString())
            }
            if (probability <= accumulateInList) {
                behaviour = i
                return behaviour
            }

        }
        Log.d("BEHAVIOUR", behaviour.toString())
        return behaviour

    }

    fun generatePositionsForBehaviour(str: String): ArrayList<Int> {
        var arrayCord = ArrayList<Int>()
        var behaviourSimple = pickABehaviour(str)
        var numBehaviourComplex = getBehaviour(str)

        when (str) {
            GHOST_CHAR -> {
                if (behaviourSimple == 0) {
                    var randomXlow = Random.nextInt((Data.screenWidth * 0.05).toInt(), (Data.screenWidth * 0.2).toInt())
                    var randomXhigh = Random.nextInt((Data.screenHeight * 0.85).toInt(), (Data.screenHeight * 0.95).toInt())
                    var randX = arrayOf(randomXlow, randomXhigh)
                    arrayCord.add(randX[(0 until 2).random()])

                    var randomYlow = Random.nextInt((Data.screenHeight * 0.05).toInt(), (Data.screenHeight * 0.2).toInt())
                    var randomYhigh = Random.nextInt((Data.screenHeight * 0.85).toInt(), (Data.screenHeight * 0.95).toInt())
                    var randY = arrayOf(randomYlow, randomYhigh)
                    arrayCord.add(randY[(0 until 2).random()])
                    arrayCord.add(behaviourSimple) //añadimos el behaviour directamente desde esta lista

                } else if (behaviourSimple == 1 || behaviourSimple == 2) {
                    var randomXlow = Random.nextInt((Data.screenWidth * 0.05).toInt(), (Data.screenWidth * 0.2).toInt())
                    var randomXhigh = Random.nextInt((Data.screenHeight * 0.85).toInt(), (Data.screenHeight * 0.95).toInt())
                    var randX = arrayOf(randomXlow, randomXhigh)
                    arrayCord.add(randX[(0 until 2).random()])

                    var randomY = Random.nextInt((Data.screenHeight * 0.2).toInt(), (Data.screenHeight * 0.81).toInt())
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourSimple)

                }
            }
            DEMON_CHAR -> {
                var behaviourComplex = Random.nextInt(0,numBehaviourComplex)

                if (behaviourComplex == 0){
                    var randomX = Random.nextInt((Data.screenWidth * 0.05).toInt(), (Data.screenWidth * 0.2).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.2).toInt(), (Data.screenHeight * 0.8).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }else if(behaviourComplex == 1){
                    var randomX = Random.nextInt((Data.screenWidth * 0.8).toInt(), (Data.screenWidth * 0.95).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.2).toInt(), (Data.screenHeight * 0.8).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }else if(behaviourComplex == 2){
                    var randomX = Random.nextInt((Data.screenWidth * 0.20).toInt(), (Data.screenWidth * 0.8).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.05).toInt(), (Data.screenHeight * 0.2).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }else if (behaviourComplex == 3){
                    var randomX = Random.nextInt((Data.screenWidth * 0.20).toInt(), (Data.screenWidth * 0.8).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.8).toInt(), (Data.screenHeight * 0.95).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }else if (behaviourComplex == 4){
                    var randomX = Random.nextInt((Data.screenWidth * 0.2).toInt(), (Data.screenWidth * 0.8).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.2).toInt(), (Data.screenHeight * 0.8).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }else if (behaviourComplex == 5){
                    var randomX = Random.nextInt((Data.screenWidth * 0.8).toInt(), (Data.screenWidth * 0.95).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.8).toInt(), (Data.screenHeight * 0.95).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)

                }else if(behaviourComplex == 6){
                    var randomX = Random.nextInt((Data.screenWidth * 0.05).toInt(), (Data.screenWidth * 0.2).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.8).toInt(), (Data.screenHeight * 0.95).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }else if (behaviourComplex == 7){
                    var randomX = Random.nextInt((Data.screenWidth * 0.05).toInt(), (Data.screenWidth * 0.2).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.2).toInt(), (Data.screenHeight * 0.8).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }

            }
            EYE_CHAR -> {
                var behaviourComplex = Random.nextInt(0,numBehaviourComplex)

                if (behaviourComplex == 0){
                    var randomX = Random.nextInt((Data.screenWidth * 0.05).toInt(), (Data.screenWidth * 0.2).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.2).toInt(), (Data.screenHeight * 0.8).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }else if(behaviourComplex == 1){
                    var randomX = Random.nextInt((Data.screenWidth * 0.8).toInt(), (Data.screenWidth * 0.95).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.2).toInt(), (Data.screenHeight * 0.8).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }else if(behaviourComplex == 2){
                    var randomX = Random.nextInt((Data.screenWidth * 0.20).toInt(), (Data.screenWidth * 0.8).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.05).toInt(), (Data.screenHeight * 0.2).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }else if (behaviourComplex == 3){
                    var randomX = Random.nextInt((Data.screenWidth * 0.20).toInt(), (Data.screenWidth * 0.8).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.8).toInt(), (Data.screenHeight * 0.95).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }else if (behaviourComplex == 4){
                    var randomX = Random.nextInt((Data.screenWidth * 0.2).toInt(), (Data.screenWidth * 0.8).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.2).toInt(), (Data.screenHeight * 0.8).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }else if (behaviourComplex == 5){
                    var randomX = Random.nextInt((Data.screenWidth * 0.8).toInt(), (Data.screenWidth * 0.95).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.8).toInt(), (Data.screenHeight * 0.95).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }else if(behaviourComplex == 6){
                    var randomX = Random.nextInt((Data.screenWidth * 0.05).toInt(), (Data.screenWidth * 0.2).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.8).toInt(), (Data.screenHeight * 0.95).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }else if (behaviourComplex == 7){
                    var randomX = Random.nextInt((Data.screenWidth * 0.05).toInt(), (Data.screenWidth * 0.2).toInt())
                    var randomY = Random.nextInt((Data.screenHeight * 0.2).toInt(), (Data.screenHeight * 0.8).toInt())
                    arrayCord.add(randomX)
                    arrayCord.add(randomY)
                    arrayCord.add(behaviourComplex)
                }

            }

            SKULL_CHAR -> {

                var behaviourComplex = Random.nextInt(0,numBehaviourComplex)

                arrayCord.add(behaviourComplex)


            }

        }

        return arrayCord
    }



}




