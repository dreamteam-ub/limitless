package edu.ub.pis.joc.limitless.engine

object AIData {

    var behaviourProbabilities = arrayOf(20,20,20,20,20)

    //la llista de probabilitats de cada enemic consisteix en el numero de comportaments/childLists que tenen
    // i l'últim index representa el valor límit que pot adquirir cada index de probabilitat
    var behaviourDemon = arrayOf(25,25,25,25,40)
    var behaviourGhost = arrayOf(33,33,34,50)
    var behaviourSkull = behaviourProbabilities
    var behaviourEye = arrayOf(25,25,25,25,40)

    var bDemon = 8
    var bEye = 8
    var bSkull = 0


}