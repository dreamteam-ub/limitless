package edu.ub.pis.joc.limitless.engine

import android.util.Log
import edu.ub.pis.joc.limitless.model.game.*

const val WEIGHT = 4

class ArtificialIntelligence {



    var allLists = arrayListOf<Array<Int>>(AIData.behaviourDemon,AIData.behaviourGhost,AIData.behaviourBomb,AIData.behaviourSkull,
        AIData.behaviourEye,AIData.behaviourBlackHole)


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

            is Bomb -> {
                allLists.remove(AIData.behaviourBomb)
                calculateProbabilities(AIData.behaviourBomb,enemy.concreteBehavior)
                allLists.add(2,AIData.behaviourBomb)

            }
            is Skull -> {
                allLists.remove(AIData.behaviourSkull)
                calculateProbabilities(AIData.behaviourSkull,enemy.concreteBehavior)
                allLists.add(3,AIData.behaviourSkull)

            }
            is Eye -> {
                allLists.remove(AIData.behaviourEye)
                calculateProbabilities(AIData.behaviourEye,enemy.concreteBehavior)
                allLists.add(4,AIData.behaviourEye)

            }
            is BlackHole -> {
                allLists.remove(AIData.behaviourBlackHole)
                calculateProbabilities(AIData.behaviourBlackHole,enemy.concreteBehavior)
                allLists.add(5,AIData.behaviourBlackHole)

            }

        }





    }

    fun calculateProbabilities(listProb : Array<Int>, behaviour : Int) : Array<Int>{
        Log.d("BEFORE CALCULATE",listProb[0].toString())

        if (listProb[behaviour]<40) {
            listProb[behaviour] += WEIGHT
            for (i in 0 until listProb.size) {
                if (i != behaviour) {
                    listProb[i] -= WEIGHT / 4

                }
            }
        }
        Log.d("calculate",listProb[0].toString())

        return listProb

    }




}