package edu.ub.pis.joc.limitless.engine

import android.content.Context
import android.util.Log
import edu.ub.pis.joc.limitless.model.Data.screenHeight
import edu.ub.pis.joc.limitless.model.Data.screenWidth
import edu.ub.pis.joc.limitless.model.game.*
import edu.ub.pis.joc.limitless.view.end_game
import edu.ub.pis.joc.limitless.view.gamescreen.Limits
import java.util.ArrayList


class LevelPractice(
    contextApp: Context,
    listOfEnemyCharacters: ArrayList<Enemy>,
    listOfCoins: ArrayList<Coin>
) : Level(contextApp, listOfEnemyCharacters, listOfCoins) {


    @Synchronized override fun buildEnemies(levelWorld: Int, time: Long) {
        //Log.d("TIME", (time).toInt().toString())
        //Log.d("CONTADOR ENEMIGOS", enemyCounter.toString())
        var listOfTmpEnemies = ArrayList<Enemy>()
        var tmp: Enemy
        when (levelWorld) {
            0 -> {
                if (time == 0L) {
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.45).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)

                } else if (time == 150L) {

                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.8).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)

                } else if (time == 300L) {

                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.6).toInt(), (screenHeight * 0.2).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.8).toInt(), (screenHeight * 0.4).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)

                } else if (time == 450L) {

                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.8).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)

                }else if (time == 600L) {

                    end_game = true

                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            1 -> {
                if (time == 0L) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.6).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 100L) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(),1,100)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.3).toInt(),2,100)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.7).toInt(),2,100)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 200L) {
                    listOfEnemyCharacters.clear()
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 1), (screenHeight * 0.7).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.2).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 300L){
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.2).toInt(),2,100)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(),2,100)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.7).toInt(),2,100)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 400L){
                    listOfEnemyCharacters.clear()
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 1), (screenHeight * 0.7).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.2).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 500L){
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            2 -> {
                if (time == 0L) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.1).toInt(),1,100)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.1).toInt(),1,100)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 100L) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.2).toInt(),2,150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 200L) {
                    listOfEnemyCharacters.clear()
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.1).toInt(), 1, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.1).toInt(), 1, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.3).toInt(), 2, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.7).toInt(), 2, 150)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 350L){

                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)

                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.4).toInt(),2,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.6).toInt(),2,150)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 500L){

                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)

                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.1).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.1).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 600L){
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 1), (screenHeight * 0.2).toInt(),0,110)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 1), (screenHeight * 0.8).toInt(),0,110)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.2).toInt(),0,110)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.8).toInt(),0,110)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 700L){
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(),0,200)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(),1,600)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.4).toInt(),2,600)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.6).toInt(),2,600)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 800L){
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(),0,200)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 900L){
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.8).toInt(),0,200)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 1000L) {
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(),0,200)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 1100L){
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(),0,200)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 1200L){
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.8).toInt(),0,200)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 1400L){
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }



            }
            3 -> {
                var tmpEye:Eye
                if (time == 0L) {
                    tmp = createComplexEnemy(EYE_CHAR, 0, (screenHeight * 0.5).toInt(), 0, 150,0)
                    listOfTmpEnemies.add(tmp)
                } else if(time == 25L){
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 150L){
                    listOfEnemyCharacters.clear()
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 1), (screenHeight * 0.5).toInt(), 1, 150,1)
                    listOfTmpEnemies.add(tmp)
                    //end_game=true
                }else if(time == 175L) {
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 275L){
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            4 -> {
                var tmpEye : Eye
                var tmpEye2 : Eye
                if (time == 0L) {
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.5).toInt(), 0, 2, 100,2)
                    listOfTmpEnemies.add(tmp)
                } else if(time == 25L){
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true
                    listOfEnemyCharacters[0] = tmpEye
                } else if(time == 50L){
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 75L) {
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 100L) {

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye

                }else if(time == 150L){
                    listOfEnemyCharacters.clear()
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.5).toInt(), (screenWidth * 2), 3, 100,3)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 175L) {
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true

                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 200L) {
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 225L) {
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 250L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye

                }else if(time == 300L){
                    listOfEnemyCharacters.clear()

                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.2).toInt(), 0, 2, 100,10)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.8).toInt(), 0, 2, 100,11)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 325L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    tmpEye2.drawChild = true
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 350L){
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 375L){
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 400L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 450L){

                    listOfEnemyCharacters.clear()

                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.2).toInt(), (screenWidth * 2), 3, 100,10)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.8).toInt(), (screenWidth * 2), 3, 100,11)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 475L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    tmpEye2.drawChild = true
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 500L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 525L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 550L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 600L){

                    listOfEnemyCharacters.clear()

                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.2).toInt(), 0, 2, 100,12)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.8).toInt(), (screenWidth * 2), 3, 100,13)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 625L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    tmpEye2.drawChild = true
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 650L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 675L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 700L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 750L){

                    listOfEnemyCharacters.clear()

                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.2).toInt(), (screenWidth * 2), 3, 150,14)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.8).toInt(), 0, 2, 150,15)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 775L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    tmpEye2.drawChild = true
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 800L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    listOfEnemyCharacters[1] = tmpEye2


                }else if(time == 825L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 850L){

                    tmpEye = listOfEnemyCharacters[0] as Eye
                    listOfEnemyCharacters[0] = tmpEye

                    tmpEye2 = listOfEnemyCharacters[1] as Eye
                    listOfEnemyCharacters[1] = tmpEye2

                }else if(time == 900L){

                    listOfEnemyCharacters.clear()
                    end_game=true

                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            5 -> {
                var tmpEye : Eye
                if (time == 0L) {
                    tmp = createComplexEnemy(EYE_CHAR, 0, (screenHeight * 0.5).toInt(), 0, 150,4)
                    listOfTmpEnemies.add(tmp)
                } else if(time == 25L){
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true
                    tmpEye.projectileDraw[0] = true
                    tmpEye.projectileRelocate[0] = true
                    listOfEnemyCharacters[0] = tmpEye
                } else if(time == 50L){
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.projectileDraw[0] = true
                    tmpEye.projectileDraw[1] = true
                    tmpEye.projectileRelocate[1] = true
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 75L) {
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.projectileDraw[1] = true
                    tmpEye.projectileDraw[0] = true
                    tmpEye.projectileRelocate[0] = true
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 125L) {
                    listOfEnemyCharacters.clear()

                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.5).toInt(), 0, 2, 150,5)
                    listOfTmpEnemies.add(tmp)
                } else if(time == 150L){
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true
                    tmpEye.projectileDraw[0] = true
                    tmpEye.projectileRelocate[0] = true
                    listOfEnemyCharacters[0] = tmpEye
                } else if(time == 175L){
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.projectileDraw[0] = true
                    tmpEye.projectileDraw[1] = true
                    tmpEye.projectileRelocate[1] = true
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 220L) {
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.projectileDraw[1] = true
                    tmpEye.projectileDraw[2] = true
                    tmpEye.projectileRelocate[2] = true
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time==300L){
                    listOfEnemyCharacters.clear()
                    tmp = createComplexEnemy(EYE_CHAR, 0, (screenHeight * 0.3).toInt(), 0, 150,6)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 1), (screenHeight * 0.7).toInt(), 1, 150,7)
                    listOfTmpEnemies.add(tmp)
                }else if (time == 350L){
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true
                    tmpEye.projectileDraw[0] = true
                    tmpEye.projectileRelocate[0] = true
                    listOfEnemyCharacters[0] = tmpEye
                    tmpEye = listOfEnemyCharacters[1] as Eye
                    tmpEye.drawChild = true
                    tmpEye.projectileDraw[0] = true
                    tmpEye.projectileRelocate[0] = true
                    listOfEnemyCharacters[1] = tmpEye
                }else if (time == 400L){
                    listOfEnemyCharacters.clear()
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.2).toInt(), 0, 2, 150,8)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.8).toInt(), (screenWidth * 2), 3, 150,9)
                    listOfTmpEnemies.add(tmp)
                }else if (time == 450L){
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true
                    tmpEye.projectileDraw[0] = true
                    tmpEye.projectileRelocate[0] = true
                    listOfEnemyCharacters[0] = tmpEye
                    tmpEye = listOfEnemyCharacters[1] as Eye
                    tmpEye.drawChild = true
                    tmpEye.projectileDraw[0] = true
                    tmpEye.projectileRelocate[0] = true
                    listOfEnemyCharacters[1] = tmpEye
                }else if(time == 500L){
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            6 -> {
                if (time == 0L) {
                    tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 8, 300,0)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 300L) {
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            7 -> {
                if (time == 0L) {
                    tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 8, 300,1)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 300L) {
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            8 -> {
                if (time == 0L) {
                    tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 8, 300,2)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 300L) {
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            9 -> {
                if (time == 0L) {
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 0, 300,0)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 1, 300,1)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 2, 300,2)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 3, 300,3)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 4, 300,4)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 5, 300,5)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 6, 300,6)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 7, 300,7)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 8, 300,8)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 9, 300,9)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 300L) {
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            10 -> {
            }
            11 -> {
            }
            12 -> {
            }
        }

        listOfEnemyCharacters.addAll(listOfTmpEnemies)
    }

    @Synchronized override fun buildCoins(levelWorld: Int, time: Long) {
        //Log.d("TIME", (time).toInt().toString())
        //Log.d("CONTADOR MONEDAS", coinCounter.toString())

        var tmpListOfCoins: ArrayList<Coin> = ArrayList()

        when (levelWorld) {
             0 -> {
                if (time  == 50L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                    createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 3,dissapearTimer = 100))
                } else if (time == 200L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), -4,dissapearTimer = 100))
                }else if (time == 350L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.2).toInt(), 5,dissapearTimer = 100))
                }else if (time == 500L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.7).toInt(), -8,dissapearTimer = 100))
                }
                var contador : Int = 0
                while(contador < listOfCoins.size){
                    if(listOfCoins.get(contador).dissapearTimer == 0){
                        listOfCoins.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            1 -> {
                if (time == 0L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 5,dissapearTimer = 120),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(), -6,dissapearTimer = 120))
                } else if (time == 150L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), -4,dissapearTimer = 120),
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.5).toInt(), 6,dissapearTimer = 120))
                } else if (time == 250L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 5,dissapearTimer = 120),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), -6,dissapearTimer = 120),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), -3,dissapearTimer = 120))
                } else if (time == 350L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.2).toInt(),7 ,dissapearTimer = 120),
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.65).toInt(), -4,dissapearTimer = 120))
                }
                var contador : Int = 0
                while(contador < listOfCoins.size){
                    if(listOfCoins.get(contador).dissapearTimer == 0){
                        listOfCoins.removeAt(contador)
                        contador--
                    }
                    contador++
                }

            }
            2 -> {

                if (time == 50L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), -4,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(), 3,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.7).toInt(), 6,dissapearTimer = 150))

                } else if (time == 150L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 2,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), -6,dissapearTimer = 150))

                } else if (time == 250L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), -5,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), 3,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.4).toInt(), -2,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(), 4,dissapearTimer = 150))
                }else if (time == 400L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.2).toInt(), -5,dissapearTimer = 300),
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.8).toInt(), 3,dissapearTimer = 300),
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.2).toInt(), -2,dissapearTimer = 300),
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.8).toInt(), 4,dissapearTimer = 300))
                }else if (time == 750L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.5).toInt(), 5,dissapearTimer = 150))
                }else if (time == 850L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.85).toInt(), 2,dissapearTimer = 150))
                }else if (time == 950L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 6,dissapearTimer = 150))
                }else if (time == 1050L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.25).toInt(), 2,dissapearTimer = 150))
                }else if (time == 1150L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.45).toInt(), -4,dissapearTimer = 150))
                }else if (time == 1250L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.6).toInt(), (screenHeight * 0.8).toInt(), 8,dissapearTimer = 150))
                }else if (time == 1450L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(), 2,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.6).toInt(), (screenHeight * 0.8).toInt(), 2,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.7).toInt(), 2,dissapearTimer = 150))
                }

                var contador : Int = 0
                while(contador < listOfCoins.size){
                    if(listOfCoins.get(contador).dissapearTimer == 0){
                        listOfCoins.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            3 -> {
                if (time == 20L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.4).toInt(), (screenHeight * 0.6).toInt(), 3,dissapearTimer = 100))
                }else if (time == 70L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.4).toInt(), 8,dissapearTimer = 100))
                }else if (time == 200L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 4,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.2).toInt(), 6,dissapearTimer = 100))
                }
                var contador : Int = 0
                while(contador < listOfCoins.size){
                    if(listOfCoins.get(contador).dissapearTimer == 0){
                        listOfCoins.removeAt(contador)
                        contador--
                    }
                    contador++
                }

            }
            4 -> {
                if (time == 0L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 3,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), -6,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.8).toInt(), 4,dissapearTimer = 150))
                }else if (time == 150L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(), 8,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), -9,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.8).toInt(), -3,dissapearTimer = 150))
                }else if (time == 300L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), 6,dissapearTimer = 300),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), -6,dissapearTimer = 300))
                }else if (time == 600L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.2).toInt(), -4,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.8).toInt(), 6,dissapearTimer = 150))
                }else if (time == 750L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), 4,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), -6,dissapearTimer = 150))
                }
                var contador : Int = 0
                while(contador < listOfCoins.size){
                    if(listOfCoins.get(contador).dissapearTimer == 0){
                        listOfCoins.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            5 -> {
                if (time == 20L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.75).toInt(), 3,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 4,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.5).toInt(), 1,dissapearTimer = 100))
                }else if (time == 130L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 7,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.8).toInt(), 8,dissapearTimer = 100))
                }else if (time == 320L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 6,dissapearTimer = 100))
                }else if (time == 430L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 6,dissapearTimer = 100))
                }
                var contador : Int = 0
                while(contador < listOfCoins.size){
                    if(listOfCoins.get(contador).dissapearTimer == 0){
                        listOfCoins.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            6 -> {
            }
            7 -> {
            }
            8 -> {
            }
            9 -> {
            }
            10 -> {
            }
            11 -> {
            }
            12 -> {
            }
        }
        listOfCoins.addAll(tmpListOfCoins)
    }

    override fun createLimits(levelWorld: Int): ArrayList<Int> {

        var listOfLimits: ArrayList<Int> = ArrayList()

        when (levelWorld) {
            0 -> {
                listOfLimits.add(2)
                listOfLimits.add(10)

            }
            1 -> {
                listOfLimits.add(10)
                listOfLimits.add(25)
            }
            2 -> {
                listOfLimits.add(10)
                listOfLimits.add(30)
            }
            3 -> {
                listOfLimits.add(10)
                listOfLimits.add(30)
            }
            4 -> {
                listOfLimits.add(12)
                listOfLimits.add(25)
            }
            5 -> {
                listOfLimits.add(12)
                listOfLimits.add(40)
            }
            6 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)
            }
            7 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)
            }
            8 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)
            }
            9 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)
            }
            10 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)

            }
            11 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)

            }
            12 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)
            }
        }

        limits = Limits(listOfLimits[0],listOfLimits[1])
        return listOfLimits
    }

}
