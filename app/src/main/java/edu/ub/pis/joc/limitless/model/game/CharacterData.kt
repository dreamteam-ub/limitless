package edu.ub.pis.joc.limitless.model.game

import edu.ub.pis.joc.limitless.view.ViewAdjuster

object CharacterData {

    // Dimensiones del demonio
    var demonWidth = (ViewAdjuster.screenWidth * 0.106491).toInt()
    var demonHeight = (ViewAdjuster.screenHeight * 0.073964).toInt()

    //Dimesiones de la Bomba

    var wBomb = arrayOf((ViewAdjuster.screenWidth * 0.087962).toInt(), (ViewAdjuster.screenWidth * 0.00277).toInt(),
        (ViewAdjuster.screenWidth * 0.007407).toInt(), (ViewAdjuster.screenWidth * 0.01481).toInt()
        ,(ViewAdjuster.screenWidth * 0.03055).toInt(), (ViewAdjuster.screenWidth * 0.04629).toInt(),
        (ViewAdjuster.screenWidth * 0.061111).toInt())


    var hBomb = arrayOf((ViewAdjuster.screenHeight * 0.040433).toInt(), (ViewAdjuster.screenHeight * 0.001479).toInt()
        ,(ViewAdjuster.screenHeight * 0.003451).toInt(), (ViewAdjuster.screenHeight * 0.0069033).toInt(),
        (ViewAdjuster.screenHeight * 0.0138).toInt(), (ViewAdjuster.screenHeight * 0.021203).toInt(),
        (ViewAdjuster.screenHeight * 0.028106).toInt())

    // Dimensiones de la moneda

    var wCoin = arrayOf((ViewAdjuster.screenWidth * 0.005555).toInt(), (ViewAdjuster.screenWidth * 0.011111).toInt(),
        (ViewAdjuster.screenWidth * 0.023148).toInt(), (ViewAdjuster.screenWidth * 0.034259).toInt(),
        (ViewAdjuster.screenWidth * 0.046296).toInt(), (ViewAdjuster.screenWidth * 0.057407).toInt(),
        (ViewAdjuster.screenWidth * 0.069444).toInt(),(ViewAdjuster.screenWidth * 0.060185).toInt(),
        (ViewAdjuster.screenWidth * 0.050925).toInt(), (ViewAdjuster.screenWidth * 0.041666).toInt(),
        (ViewAdjuster.screenWidth * 0.025925).toInt(), (ViewAdjuster.screenWidth * 0.0046296).toInt(),
        (ViewAdjuster.screenWidth * 0.065185).toInt())


    var hCoin = arrayOf((ViewAdjuster.screenHeight * 0.002958).toInt(), (ViewAdjuster.screenHeight * 0.0059171).toInt(),
        (ViewAdjuster.screenHeight * 0.012327).toInt(), (ViewAdjuster.screenHeight * 0.018244).toInt(),
        (ViewAdjuster.screenHeight * 0.027120).toInt(), (ViewAdjuster.screenHeight * 0.030571).toInt(),
        (ViewAdjuster.screenHeight * 0.0369822).toInt())


    // Dimesiones del Eye

    var wEye = (ViewAdjuster.screenWidth * 0.162037).toInt()
    var hEye = (ViewAdjuster.screenHeight * 0.041913).toInt()

    // Dimensiones Eye Proyectile

    var wEyeProyectile = arrayOf((ViewAdjuster.screenWidth * 0.032407).toInt(), (ViewAdjuster.screenWidth * 0.055555).toInt(),
        (ViewAdjuster.screenWidth * 0.04537).toInt())

    var hEyeProyectile = arrayOf((ViewAdjuster.screenHeight * 0.029585).toInt(), (ViewAdjuster.screenHeight * 0.017258).toInt(),
        (ViewAdjuster.screenHeight * 0.024654).toInt())


    // Dimensiones del Ghost

    var wGhost = (ViewAdjuster.screenWidth * 0.137962).toInt()
    var hGhost = (ViewAdjuster.screenHeight * 0.071499).toInt()

    // Dimensiones de la Skull

    var wSkull = arrayOf((ViewAdjuster.screenWidth * 0.103703).toInt())
    var hSkull = arrayOf((ViewAdjuster.screenHeight * 0.073964).toInt())

    // Dimensiones del Skull Laser
    var wSkullLaser = (ViewAdjuster.screenWidth * 0.103703).toInt()
    var hSkullLaser = (ViewAdjuster.screenHeight * 0.26923).toInt()

    // Dimensiones de la columna de fuego

    var wDemonFire = arrayOf((ViewAdjuster.screenWidth * 0.037037).toInt(), (ViewAdjuster.screenWidth * 0.039814).toInt(),
        (ViewAdjuster.screenWidth * 0.05).toInt(),(ViewAdjuster.screenWidth * 0.060185).toInt(),
        (ViewAdjuster.screenWidth * 0.07037).toInt(), (ViewAdjuster.screenWidth * 0.079629).toInt(),
        (ViewAdjuster.screenWidth * 0.087962).toInt(), (ViewAdjuster.screenWidth * 0.09351).toInt(),
        (ViewAdjuster.screenWidth * 0.096296).toInt(), (ViewAdjuster.screenWidth * 0.097222).toInt(),
        (ViewAdjuster.screenWidth * 0.096296).toInt(), (ViewAdjuster.screenWidth * 0.095370).toInt(),
        (ViewAdjuster.screenWidth * 0.081481).toInt(),(ViewAdjuster.screenWidth * 0.069444).toInt(),
        (ViewAdjuster.screenWidth * 0.057407).toInt(),(ViewAdjuster.screenWidth * 0.043518).toInt(),
        (ViewAdjuster.screenWidth * 0.036111).toInt(), (ViewAdjuster.screenWidth * 0.032407).toInt(),
        (ViewAdjuster.screenWidth * 0.034259).toInt(),  (ViewAdjuster.screenWidth * 0.049074).toInt(),
        (ViewAdjuster.screenWidth * 0.071296).toInt(), (ViewAdjuster.screenWidth * 0.077777).toInt(),
        (ViewAdjuster.screenWidth * 0.093518).toInt(), (ViewAdjuster.screenWidth * 0.097222).toInt(),
        (ViewAdjuster.screenWidth * 0.094444).toInt(), (ViewAdjuster.screenWidth * 0.088888).toInt(),
        (ViewAdjuster.screenWidth * 0.080555).toInt(), (ViewAdjuster.screenWidth * 0.057407).toInt())

    var hDemonFire = arrayOf((ViewAdjuster.screenHeight * 0.051775).toInt(), (ViewAdjuster.screenHeight * 0.05177).toInt(),
        (ViewAdjuster.screenHeight * 0.050295).toInt(), (ViewAdjuster.screenHeight * 0.04684).toInt(),
        (ViewAdjuster.screenHeight * 0.042406).toInt(), (ViewAdjuster.screenHeight * 0.037475).toInt(),
        (ViewAdjuster.screenHeight * 0.032544).toInt(), (ViewAdjuster.screenHeight * 0.026134).toInt(),
        (ViewAdjuster.screenHeight * 0.018244).toInt(), (ViewAdjuster.screenHeight * 0.015285).toInt(),
        (ViewAdjuster.screenHeight * 0.020216).toInt(), (ViewAdjuster.screenHeight * 0.025147).toInt(),
        (ViewAdjuster.screenHeight * 0.036489).toInt(),(ViewAdjuster.screenHeight * 0.042899).toInt(),
        (ViewAdjuster.screenHeight * 0.04733).toInt(),(ViewAdjuster.screenHeight * 0.051282).toInt(),
        (ViewAdjuster.screenHeight * 0.049802).toInt(), (ViewAdjuster.screenHeight * 0.03796).toInt(),
        (ViewAdjuster.screenHeight * 0.036571).toInt(), (ViewAdjuster.screenHeight * 0.024664).toInt(),
        (ViewAdjuster.screenHeight * 0.01775).toInt(), (ViewAdjuster.screenHeight * 0.015285).toInt(),
        (ViewAdjuster.screenHeight * 0.01923).toInt(), (ViewAdjuster.screenHeight * 0.023175).toInt(),
        (ViewAdjuster.screenHeight * 0.030571).toInt(), (ViewAdjuster.screenHeight * 0.03698).toInt())


}