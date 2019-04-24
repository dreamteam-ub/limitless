package edu.ub.pis.joc.limitless.model.game

import android.content.res.Resources
import android.util.Log
import java.util.ArrayList

class LevelGenerator() {

    var xPixels = Resources.getSystem().displayMetrics.widthPixels
    var yPixels = Resources.getSystem().displayMetrics.heightPixels
    var contadorEnemies : Int = 0
    var contadorEnemyPositons : Int = 0
    var listOfEnemies = ArrayList<String>()
    var listOfEnemyPositions = ArrayList<Array<Int>>()
    var enemyChange = false


    fun generarEnemics(nivell: Int, tempsActualMilis: Long) : ArrayList<String>{

        var newListOfEnemies = ArrayList<String>()

        when(nivell){
            0->{
                Log.d("CALVO",tempsActualMilis.toString())
                Log.d("CONTADOR",contadorEnemies.toString())
                if(tempsActualMilis == 0L && contadorEnemies == 0){
                    newListOfEnemies.clear()
                    newListOfEnemies.add("Demon")
                    contadorEnemies = 1
                    Log.d("Lista1",newListOfEnemies[0])
                    enemyChange = true
                    return newListOfEnemies
                } else if (tempsActualMilis > 3000L && contadorEnemies == 1){
                    newListOfEnemies.clear()
                    newListOfEnemies.add("Skull")
                    newListOfEnemies.add("SkullLaser")
                    contadorEnemies = 2
                    enemyChange = true
                    Log.d("Lista1",newListOfEnemies[0])
                    return newListOfEnemies
                } else if (tempsActualMilis > 7000L && contadorEnemies ==2){
                    newListOfEnemies.clear()
                    newListOfEnemies.add("Demon")
                    contadorEnemies = 3
                    enemyChange = true
                    Log.d("Lista1",newListOfEnemies[0])
                    return newListOfEnemies
                }
            }
            1->{
                newListOfEnemies.add("Skull")
                newListOfEnemies.add("SkullLaser")
            }
            2->{
                newListOfEnemies.add("Demon")
            }
            3->{
                newListOfEnemies.add("Eye")
            }
            4->{
                newListOfEnemies.add("Demon")
            }
            5->{
                newListOfEnemies.add("Skull")
            }
            6->{
                newListOfEnemies.add("Demon")
            }
            7->{
                newListOfEnemies.add("Skull")
            }
            8->{
                newListOfEnemies.add("Demon")
            }
            9->{
                newListOfEnemies.add("Skull")
            }
            10->{
                newListOfEnemies.add("Demon")
            }
            11->{
                newListOfEnemies.add("Skull")
            }
            12->{
                newListOfEnemies.add("Skull")
            }

        }
        if(listOfEnemies!=newListOfEnemies) {
            enemyChange = true
            return newListOfEnemies
        } else {
            enemyChange = false
            return listOfEnemies
        }
    }

    fun generarPosicionsEnemics(nivell: Int, tempsActualMilis: Long) : ArrayList<Array<Int>>{

        var newListOfEnemyPositions = ArrayList<Array<Int>>()

        when(nivell){
            0->{
                if(tempsActualMilis == 0L && contadorEnemyPositons==0){
                    newListOfEnemyPositions.add(arrayOf((xPixels*0.3).toInt(),(yPixels*0.3).toInt()))
                    contadorEnemyPositons=1
                    return newListOfEnemyPositions
                } else if (tempsActualMilis > 3000L && contadorEnemyPositons==1){
                    newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.05).toInt()))
                    newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.05).toInt()))
                    contadorEnemyPositons=2
                    return newListOfEnemyPositions
                } else if (tempsActualMilis > 7000L && contadorEnemyPositons==2){
                    newListOfEnemyPositions.add(arrayOf((xPixels*0.3).toInt(),(yPixels*0.3).toInt()))
                    contadorEnemyPositons=3
                    return newListOfEnemyPositions
                }
            }
            1->{
                newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.05).toInt()))
                newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.05).toInt()))
            }
            2->{
                newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.2).toInt()))
            }
            3->{
                newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.2).toInt()))
            }
            4->{
                newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.2).toInt()))
            }
            5->{
                newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.2).toInt()))
            }
            6->{
                newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.2).toInt()))
            }
            7->{
                newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.2).toInt()))
            }
            8->{
                newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.2).toInt()))
            }
            9->{
                newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.2).toInt()))
            }
            10->{
                newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.2).toInt()))
            }
            11->{
                newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.2).toInt()))
            }
            12->{
                newListOfEnemyPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.2).toInt()))
            }
        }
        if(listOfEnemyPositions!=newListOfEnemyPositions) {
            return newListOfEnemyPositions
        } else {
            return listOfEnemyPositions
        }
    }

    fun generarMonedes(nivell: Int, tempsActualMilis: Long) : ArrayList<String>{
        var listOfNumbers = ArrayList<String>()
        var contador : Int = 0

        when(nivell) {
            0 -> {
                if(tempsActualMilis == 0L){
                    listOfNumbers.clear()
                    listOfNumbers.add("NumberCharacter")
                    listOfNumbers.add("NumberCharacter")
                    contador++
                    return listOfNumbers
                }
            }
            1 -> {

            }
            2 -> {

            }
            3 -> {

            }
            4 -> {

            }
            5 -> {

            }
            6 -> {

            }
            7 -> {

            }
            8 -> {

            }
            9-> {

            }
            10 -> {

            }
            11 -> {
            }

        }
        return listOfNumbers
    }

    fun generarPosicionsMonedes(nivell: Int, tempsActualMilis: Long) : ArrayList<Array<Int>>{
        var listOfPositions = ArrayList<Array<Int>>()
        var contador : Int = 0
        when(nivell){
            0->{
                if(tempsActualMilis == 0L) {
                    listOfPositions.clear()
                    listOfPositions.add(arrayOf((xPixels * 0.5).toInt(), (yPixels * 0.2).toInt()))
                    listOfPositions.add(arrayOf((xPixels * 0.3).toInt(), (yPixels * 0.3).toInt()))
                    contador++
                    return listOfPositions
                }
            }
            1->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            2->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            3->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            4->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            5->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            6->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            7->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            8->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            9->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            10->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            11->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }

        }
        return listOfPositions
    }

    fun generarValorMonedes(nivell: Int, tempsActualMilis: Long) : ArrayList<Int>{
        var listOfNumberValues = ArrayList<Int>()
        var contador : Int = 0
        when(nivell) {
            0 -> {
                if(tempsActualMilis == 0L){
                    listOfNumberValues.clear()
                    listOfNumberValues.add(10)
                    listOfNumberValues.add(20)
                    contador++
                    return listOfNumberValues
                }
            }
            1 -> {

            }
            2 -> {

            }
            3 -> {

            }
            4 -> {

            }
            5 -> {

            }
            6 -> {

            }
            7 -> {

            }
            8 -> {

            }
            9-> {

            }
            10 -> {

            }
            11 -> {
            }

        }
        return listOfNumberValues
    }
}