package edu.ub.pis.joc.limitless.engine

import edu.ub.pis.joc.limitless.model.game.*
import kotlin.random.Random

class ArtificialIntelligence {
    /*
    Aquesta serà la classe on farem tots els càlculs de la IA
     */


    var allBehavioursList = arrayListOf(AIData.behaviourDemon,AIData.behaviourGhost,AIData.behaviourSkull,
        AIData.behaviourEye)

    var allChildList = arrayListOf(AIData.childEye,AIData.childDemon)

    var calls = 0

    /*
    Aquesta funció serà cridada quan matin al personatge principal. Li passarem per parametre
    l'enemic que ha matat i recalcularem les probabilitats de dit comportament.
    @params : Enemy
     */
    fun updateBestBehaviour(enemy : Enemy){

        when(enemy){
            is Demon -> {
                allBehavioursList.remove(AIData.behaviourDemon)
                calculateProbabilities(AIData.behaviourDemon,enemy.concreteBehaviour)
                allBehavioursList.add(0,AIData.behaviourDemon)
            }
            is Ghost -> {
                allBehavioursList.remove(AIData.behaviourGhost)
                AIData.behaviourGhost=calculateProbabilities(AIData.behaviourGhost,enemy.concreteBehaviour)
                allBehavioursList.add(1,AIData.behaviourGhost)
            }
            is Skull -> {
                allBehavioursList.remove(AIData.behaviourSkull)
                calculateProbabilities(AIData.behaviourSkull,enemy.concreteBehaviour)
                allBehavioursList.add(2,AIData.behaviourSkull)
            }
            is Eye -> {
                allBehavioursList.remove(AIData.behaviourEye)
                calculateProbabilities(AIData.behaviourEye,enemy.concreteBehaviour)
                allBehavioursList.add(3,AIData.behaviourEye)
            }
        }

    }
    /*
    Aquesta funció té la mateixa mecànica que la funcio updateBestBehaviour, pero
    actualitzarà les probabilitats de les armes dels Demon i Eye (projectils i columnes
    de foc)
    @params : Enemy
     */

    fun updateBestChild(enemy : Enemy){

        when(enemy){
            is Demon -> {
                allChildList.remove(AIData.childDemon)
                calculateProbabilities(AIData.childDemon,enemy.childListConditional)
                allChildList.add(0,AIData.childDemon)
            }
            is Eye -> {
                allChildList.remove(AIData.childEye)
                calculateProbabilities(AIData.childEye,enemy.childListConditional)
                allChildList.add(1,AIData.childEye)
            }
        }

    }
    /*
    Aquesta funcio calcularà les probabilitats de cada llista de AIData, hem de tenir en compte, que
    cap probabilitat por superar un cert pes, totes tenen un limit.
    Ens retornarà la llista modificada amb les probabilitats actualitzades
    @params : array<Int>
    @params : Int

    @return : Array<Int>
     */
    fun calculateProbabilities(listProb : Array<Int>, winCondition : Int) : Array<Int>{

        val maxValue = listProb[listProb.size-1]

        var percentageDifference = ((maxValue-listProb[winCondition])*0.3).toInt()

        var divCounter = listProb.size-2

        if (listProb[winCondition] < maxValue) {
            listProb[winCondition] += percentageDifference
            for (i in 0 until listProb.size - 1) {
                if (i != winCondition) {
                    listProb[i] -= (percentageDifference/divCounter)
                    percentageDifference -= (percentageDifference/divCounter)
                    divCounter--
                }
            }
        }

        calls += 1
        return listProb

    }
    /*
    Funció util per obtenir qualsevol llista de probabilitats
    @param : string
    @return : Array<Int>
     */
    fun getList(chr: String): Array<Int> {
        val lista = emptyArray<Int>()
        return when (chr) {
            EYE_CHAR -> AIData.behaviourEye
            DEMON_CHAR -> AIData.behaviourDemon
            SKULL_CHAR -> AIData.behaviourSkull
            GHOST_CHAR -> AIData.behaviourGhost
            DEMON_FIRE_COLUMN -> AIData.childDemon
            EYE_PROJECTILE -> AIData.childEye
            else -> lista
        }
    }
    /*
    Funció que farà un random entre 1 i 100, ens donarà un nombre i escollirà el comportament
    que estigui en el rang del nombre. D'aquesta forma, quan més pes té el comportament,
    més probabilitats té a que el nombre random estigui en el seu rang.

    @params : string
    @return : int
     */
    fun pickABehaviour(str: String): Int {
        val list = getList(str)
        if(list.isEmpty()){
            return 0
        }
        var behaviour = 0
        var accumulateInList = 0
        val probability = Random.nextInt(1, 101)


        for (i in 0 until (list.size - 1)) {
            if(accumulateInList < probability){
                accumulateInList += list[i]
                behaviour = i
            }
        }
        return behaviour
    }

    /*
    Aquesta funció ens permetrà generar posicions adequades per a cada comportament
    @params : string
    @params : int

    @return : arrayList<Int>
     */

    fun generatePositionsForBehaviour(str: String, behaviour: Int): ArrayList<Int> {

        when (str) {
            BOMB_CHAR->{
                val x = AIData.spawnCoinAndBombsX[Random.nextInt(0,AIData.spawnCoinAndBombsX.size)]
                val y = AIData.spawnCoinAndBombsY[Random.nextInt(0,AIData.spawnCoinAndBombsY.size)]
                return arrayListOf(x,y)
            }
            NUMBER_COIN->{
                val x = AIData.spawnCoinAndBombsX[Random.nextInt(0,AIData.spawnCoinAndBombsX.size)]
                val y = AIData.spawnCoinAndBombsY[Random.nextInt(0,AIData.spawnCoinAndBombsY.size)]
                return arrayListOf(x,y)
            }
            GHOST_CHAR -> {
                when(behaviour){
                    0->{
                        val left = AIData.leftSpawns[Random.nextInt(0,AIData.leftSpawns.size)]
                        val right = AIData.rightSpawns[Random.nextInt(0,AIData.rightSpawns.size)]
                        return if (Random.nextInt(0,2)==0) arrayListOf(left[0],left[1]) else arrayListOf(right[0],right[1])
                    }
                    1->{
                        val top = AIData.topSpawns[Random.nextInt(0,AIData.topSpawns.size)]
                        val bottom = AIData.bottomSpawns[Random.nextInt(0,AIData.bottomSpawns.size)]
                        return if (Random.nextInt(0,2)==0) arrayListOf(top[0],top[1]) else arrayListOf(bottom[0],bottom[1])

                    }
                    2->{
                        val left = AIData.leftSpawns[Random.nextInt(0,AIData.leftSpawns.size)]
                        val right = AIData.rightSpawns[Random.nextInt(0,AIData.rightSpawns.size)]
                        return if (Random.nextInt(0,2)==0) arrayListOf(left[0],left[1]) else arrayListOf(right[0],right[1])

                    }
                    3->{
                        val left = AIData.leftSpawns[Random.nextInt(0,AIData.leftSpawns.size)]
                        return arrayListOf(left[0],left[1])
                    }
                    4->{
                        val right = AIData.rightSpawns[Random.nextInt(0,AIData.rightSpawns.size)]
                        return arrayListOf(right[0],right[1])
                    }
                }
            }

            DEMON_CHAR -> {
                when(behaviour){
                    0->{
                        val left = AIData.leftSpawns[Random.nextInt(0,AIData.leftSpawns.size)]
                        return arrayListOf(left[0],left[1])
                    }
                    1->{
                        val right = AIData.rightSpawns[Random.nextInt(0,AIData.rightSpawns.size)]
                        return arrayListOf(right[0],right[1])
                    }
                    2->{
                        val top = AIData.topSpawns[Random.nextInt(0,AIData.topSpawns.size)]
                        return arrayListOf(top[0],top[1])
                    }
                    3->{
                        val bottom = AIData.bottomSpawns[Random.nextInt(0,AIData.bottomSpawns.size)]
                        return arrayListOf(bottom[0],bottom[1])
                    }
                    4->{
                        val topRight = AIData.topRightSpawns[Random.nextInt(0,AIData.topRightSpawns.size)]
                        return arrayListOf(topRight[0],topRight[1])
                    }
                    5->{
                        val bottomRight = AIData.bottomRightSpawns[Random.nextInt(0,AIData.bottomRightSpawns.size)]
                        return arrayListOf(bottomRight[0],bottomRight[1])
                    }
                    6->{
                        val bottomLeft = AIData.bottomLeftSpawns[Random.nextInt(0,AIData.bottomLeftSpawns.size)]
                        return arrayListOf(bottomLeft[0],bottomLeft[1])
                    }
                    7->{
                        val topLeft = AIData.topLeftSpawns[Random.nextInt(0,AIData.topLeftSpawns.size)]
                        return arrayListOf(topLeft[0],topLeft[1])
                    }
                    8->{
                        val left = AIData.leftSpawns[Random.nextInt(0,AIData.leftSpawns.size)]
                        val right = AIData.rightSpawns[Random.nextInt(0,AIData.rightSpawns.size)]
                        return if (Random.nextInt(0,2)==0) arrayListOf(left[0],left[1]) else arrayListOf(right[0],right[1])
                    }
                }
            }

            EYE_CHAR -> {
                when(behaviour){
                    0->{
                        val left = AIData.leftSpawns[Random.nextInt(0,AIData.leftSpawns.size)]
                        return arrayListOf(left[0],left[1])
                    }
                    1->{
                        val right = AIData.rightSpawns[Random.nextInt(0,AIData.rightSpawns.size)]
                        return arrayListOf(right[0],right[1])
                    }
                    2->{
                        val top = AIData.topSpawns[Random.nextInt(0,AIData.topSpawns.size)]
                        return arrayListOf(top[0],top[1])
                    }
                    3->{
                        val bottom = AIData.bottomSpawns[Random.nextInt(0,AIData.bottomSpawns.size)]
                        return arrayListOf(bottom[0],bottom[1])
                    }
                    4->{
                        val topRight = AIData.topRightSpawns[Random.nextInt(0,AIData.topRightSpawns.size)]
                        return arrayListOf(topRight[0],topRight[1])
                    }
                    5->{
                        val bottomRight = AIData.bottomRightSpawns[Random.nextInt(0,AIData.bottomRightSpawns.size)]
                        return arrayListOf(bottomRight[0],bottomRight[1])
                    }
                    6->{
                        val bottomLeft = AIData.bottomLeftSpawns[Random.nextInt(0,AIData.bottomLeftSpawns.size)]
                        return arrayListOf(bottomLeft[0],bottomLeft[1])
                    }
                    7->{
                        val topLeft = AIData.topLeftSpawns[Random.nextInt(0,AIData.topLeftSpawns.size)]
                        return arrayListOf(topLeft[0],topLeft[1])
                    }
                }
            }
            SKULL_CHAR ->{
                arrayListOf(0,0)
            }
        }
        return arrayListOf(0,0)
    }

}




