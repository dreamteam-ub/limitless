package edu.ub.pis.joc.limitless.engine

import android.util.Log
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
                calculateProbabilities(AIData.behaviourDemon,enemy.concreteBehavior)
                allLists.add(0,AIData.behaviourDemon)

            }
            is Ghost -> {
                allLists.remove(AIData.behaviourGhost)
                AIData.behaviourGhost=calculateProbabilities(AIData.behaviourGhost,enemy.concreteBehavior)
                allLists.add(1,AIData.behaviourGhost)

            }


            is Skull -> {
                allLists.remove(AIData.behaviourSkull)
                calculateProbabilities(AIData.behaviourSkull,enemy.concreteBehavior)
                allLists.add(2,AIData.behaviourSkull)

            }
            is Eye -> {
                allLists.remove(AIData.behaviourEye)
                calculateProbabilities(AIData.behaviourEye,enemy.concreteBehavior)
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

    fun getList(chr : String) : Array<Int>{
        var lista = emptyArray<Int>()
        when(chr){

            EYE_CHAR -> return AIData.behaviourEye
            DEMON_CHAR -> return AIData.behaviourDemon
            SKULL_CHAR -> return AIData.behaviourSkull
            GHOST_CHAR -> return AIData.behaviourGhost

        }
        return lista
    }

    fun pickABehaviour(str : String) : Int{
        Log.d("STR", str)
        var list = getList(str)
        var long = list.size-1
        var behaviour : Int? = null

        var probability = Random.nextInt(1,101)
        Log.d("PROB", probability.toString())
        var accumulateInList = 0

        for (i in 0 until long){
            if(probability > accumulateInList){
                accumulateInList += list[i]
                Log.d("ACC", accumulateInList.toString())
            }
            if (probability <= accumulateInList){
                behaviour = i
                return behaviour
            }

        }
        Log.d("BEHAVIOUR", behaviour.toString())
        return behaviour!!

    }




}