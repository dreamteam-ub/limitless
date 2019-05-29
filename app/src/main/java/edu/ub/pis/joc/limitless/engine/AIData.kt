package edu.ub.pis.joc.limitless.engine

import edu.ub.pis.joc.limitless.view.ViewAdjuster

object AIData {

    /*
    Aquesta classe (object) l'utilitzarem per a guardar la manera de jugar que te el jugador.
    Cada enemic te diversos comportaments, cada cop que el mati un enemic amb un comportament
    concret, aquestes dades s'actualitzaran i donaran més pes al comportament d'aquell enemic X.
    D'aquesta manera, si li donem un pes doncs tindrà més probabilitats a que els enemics adquireixin
    aquell comportament i d'aquesta forma fer el joc més competitiu.
    Aquestes dades es reestableixen quan l'usuari surt del joc.
     */

    //la llista de probabilitats de cada enemic consisteix en el numero de comportaments/childLists que tenen
    // i l'últim index representa el valor límit que pot adquirir cada index de probabilitat
    var behaviourDemon = arrayOf(11,11,11,11,11,11,11,11,12,40)
    var behaviourGhost = arrayOf(20,20,20,20,20,40)
    var behaviourSkull = arrayOf(10,10,10,10,10,10,10,10,10,10,30)
    var behaviourEye = arrayOf(12,12,12,12,13,13,13,13,30)

    var childDemon = arrayOf(25,25,25,25,40)
    var childEye = arrayOf(6,6,6,7,6,6,6,7,6,6,6,7,6,6,6,7,20)

    /*
    Aquestes llistes són els spawns possibles dels enemics, que posen pautes per a que apareixin
    tots correctament en pantalla
     */

    val leftSpawns : Array<Array<Int>> = arrayOf(
        arrayOf(0,(ViewAdjuster.screenHeight*0.2).toInt()),
        arrayOf(0,(ViewAdjuster.screenHeight*0.4).toInt()),
        arrayOf(0,(ViewAdjuster.screenHeight*0.6).toInt()),
        arrayOf(0,(ViewAdjuster.screenHeight*0.8).toInt())
    )

    val rightSpawns : Array<Array<Int>> = arrayOf(
        arrayOf(ViewAdjuster.screenWidth,(ViewAdjuster.screenHeight*0.2).toInt()),
        arrayOf(ViewAdjuster.screenWidth,(ViewAdjuster.screenHeight*0.4).toInt()),
        arrayOf(ViewAdjuster.screenWidth,(ViewAdjuster.screenHeight*0.6).toInt()),
        arrayOf(ViewAdjuster.screenWidth,(ViewAdjuster.screenHeight*0.8).toInt())
    )

    val topSpawns : Array<Array<Int>> = arrayOf(
        arrayOf((ViewAdjuster.screenWidth*0.3).toInt(),0),
        arrayOf((ViewAdjuster.screenWidth*0.5).toInt(),0),
        arrayOf((ViewAdjuster.screenWidth*0.7).toInt(),0)
    )

    val bottomSpawns : Array<Array<Int>> = arrayOf(
        arrayOf((ViewAdjuster.screenWidth*0.3).toInt(),ViewAdjuster.screenHeight),
        arrayOf((ViewAdjuster.screenWidth*0.5).toInt(),ViewAdjuster.screenHeight),
        arrayOf((ViewAdjuster.screenWidth*0.7).toInt(),ViewAdjuster.screenHeight)
    )

    val bottomLeftSpawns : Array<Array<Int>> = arrayOf(
        arrayOf((ViewAdjuster.screenWidth*0.2).toInt(),ViewAdjuster.screenHeight),
        arrayOf((ViewAdjuster.screenWidth*0.3).toInt(),ViewAdjuster.screenHeight)
    )

    val bottomRightSpawns : Array<Array<Int>> = arrayOf(
        arrayOf((ViewAdjuster.screenWidth*0.7).toInt(),ViewAdjuster.screenHeight),
        arrayOf((ViewAdjuster.screenWidth*0.8).toInt(),ViewAdjuster.screenHeight)
    )

    val topLeftSpawns : Array<Array<Int>> = arrayOf(
        arrayOf((ViewAdjuster.screenWidth*0.2).toInt(),0),
        arrayOf((ViewAdjuster.screenWidth*0.3).toInt(),0)
    )

    val topRightSpawns : Array<Array<Int>> = arrayOf(
        arrayOf((ViewAdjuster.screenWidth*0.7).toInt(),0),
        arrayOf((ViewAdjuster.screenWidth*0.8).toInt(),0)
    )

    val spawnCoinAndBombsX : Array<Int> = arrayOf(
        (ViewAdjuster.screenWidth*0.2).toInt(),
        (ViewAdjuster.screenWidth*0.3).toInt(),
        (ViewAdjuster.screenWidth*0.4).toInt(),
        (ViewAdjuster.screenWidth*0.5).toInt(),
        (ViewAdjuster.screenWidth*0.6).toInt(),
        (ViewAdjuster.screenWidth*0.7).toInt(),
        (ViewAdjuster.screenWidth*0.8).toInt()
    )

    val spawnCoinAndBombsY : Array<Int> = arrayOf(
        (ViewAdjuster.screenHeight*0.2).toInt(),
        (ViewAdjuster.screenHeight*0.3).toInt(),
        (ViewAdjuster.screenHeight*0.4).toInt(),
        (ViewAdjuster.screenHeight*0.5).toInt(),
        (ViewAdjuster.screenHeight*0.6).toInt(),
        (ViewAdjuster.screenHeight*0.7).toInt(),
        (ViewAdjuster.screenHeight*0.8).toInt()
    )

}