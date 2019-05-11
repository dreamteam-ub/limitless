package edu.ub.pis.joc.limitless.engine

import edu.ub.pis.joc.limitless.model.Data
import kotlin.random.Random

object AIData {

    //la llista de probabilitats de cada enemic consisteix en el numero de comportaments/childLists que tenen
    // i l'últim index representa el valor límit que pot adquirir cada index de probabilitat
    var behaviourDemon = arrayOf(11,11,11,11,11,11,11,11,12,40)
    var behaviourGhost = arrayOf(20,20,20,20,20,40)
    var behaviourSkull = arrayOf(10,10,10,10,10,10,10,10,10,10,30)
    var behaviourEye = arrayOf(12,12,12,12,13,13,13,13,30)

    var childDemon = arrayOf(25,25,25,25,40)
    var childEye = arrayOf(6,6,6,7,6,6,6,7,6,6,6,7,6,6,6,7,20)

    val leftSpawns : Array<Array<Int>> = arrayOf(
        arrayOf(0,(Data.screenHeight*0.2).toInt()),
        arrayOf(0,(Data.screenHeight*0.4).toInt()),
        arrayOf(0,(Data.screenHeight*0.6).toInt()),
        arrayOf(0,(Data.screenHeight*0.8).toInt())
    )

    val rightSpawns : Array<Array<Int>> = arrayOf(
        arrayOf(Data.screenWidth,(Data.screenHeight*0.2).toInt()),
        arrayOf(Data.screenWidth,(Data.screenHeight*0.4).toInt()),
        arrayOf(Data.screenWidth,(Data.screenHeight*0.6).toInt()),
        arrayOf(Data.screenWidth,(Data.screenHeight*0.8).toInt())
    )

    val topSpawns : Array<Array<Int>> = arrayOf(
        arrayOf((Data.screenWidth*0.3).toInt(),0),
        arrayOf((Data.screenWidth*0.5).toInt(),0),
        arrayOf((Data.screenWidth*0.7).toInt(),0)
    )

    val bottomSpawns : Array<Array<Int>> = arrayOf(
        arrayOf((Data.screenWidth*0.3).toInt(),Data.screenHeight),
        arrayOf((Data.screenWidth*0.5).toInt(),Data.screenHeight),
        arrayOf((Data.screenWidth*0.7).toInt(),Data.screenHeight)
    )

    val bottomLeftSpawns : Array<Array<Int>> = arrayOf(
        arrayOf((Data.screenWidth*0.2).toInt(),Data.screenHeight),
        arrayOf((Data.screenWidth*0.3).toInt(),Data.screenHeight)
    )

    val bottomRightSpawns : Array<Array<Int>> = arrayOf(
        arrayOf((Data.screenWidth*0.7).toInt(),Data.screenHeight),
        arrayOf((Data.screenWidth*0.8).toInt(),Data.screenHeight)
    )

    val topLeftSpawns : Array<Array<Int>> = arrayOf(
        arrayOf((Data.screenWidth*0.2).toInt(),0),
        arrayOf((Data.screenWidth*0.3).toInt(),0)
    )

    val topRightSpawns : Array<Array<Int>> = arrayOf(
        arrayOf((Data.screenWidth*0.7).toInt(),0),
        arrayOf((Data.screenWidth*0.8).toInt(),0)
    )

    val spawnCoinAndBombsX : Array<Int> = arrayOf(
        (Data.screenWidth*0.2).toInt(),
        (Data.screenWidth*0.3).toInt(),
        (Data.screenWidth*0.4).toInt(),
        (Data.screenWidth*0.5).toInt(),
        (Data.screenWidth*0.6).toInt(),
        (Data.screenWidth*0.7).toInt(),
        (Data.screenWidth*0.8).toInt()
    )

    val spawnCoinAndBombsY : Array<Int> = arrayOf(
        (Data.screenHeight*0.2).toInt(),
        (Data.screenHeight*0.3).toInt(),
        (Data.screenHeight*0.4).toInt(),
        (Data.screenHeight*0.5).toInt(),
        (Data.screenHeight*0.6).toInt(),
        (Data.screenHeight*0.7).toInt(),
        (Data.screenHeight*0.8).toInt()
    )

}