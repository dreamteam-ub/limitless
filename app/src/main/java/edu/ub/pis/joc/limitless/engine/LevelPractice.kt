package edu.ub.pis.joc.limitless.engine

import android.content.res.AssetManager
import edu.ub.pis.joc.limitless.model.game.*
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenHeight
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenWidth
import edu.ub.pis.joc.limitless.view.end_game
import edu.ub.pis.joc.limitless.view.gamescreen.Limits
import java.util.*


class LevelPractice(
    assets : AssetManager,
    listOfEnemyCharacters: ArrayList<Enemy>,
    listOfCoins: ArrayList<Coin>,
    currentLevelWorld : Int
) : Level(assets, listOfEnemyCharacters, listOfCoins) {

    var auxEnemies : ArrayList<Enemy> = ArrayList()

    init {
        var tmp: Enemy

        when(currentLevelWorld){
            1->{

            }
            2->{

            }
            3->{

            }
            4->{

            }
            5->{

            }
            6->{
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.1).toInt(), (screenHeight * 0.3).toInt(), 8, 350,0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.1).toInt(), (screenHeight * 0.7).toInt(), 8, 300,0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.1).toInt(), screenHeight, 5, 150,0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.8).toInt(), screenHeight, 6, 150,0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.2).toInt(), screenHeight, 3, 150,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.8).toInt(), screenHeight, 3, 150,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.2).toInt(), 0, 2, 150,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.8).toInt(), 0, 2, 150,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.2).toInt(), 0, 100,3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.5).toInt(), 0, 100,3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.8).toInt(), 0, 100,3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.8).toInt(), 0, 100,3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 1.1).toInt(), 0, 100,3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 1.4).toInt(), 0, 100,3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.2).toInt(), 8, 300,0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, screenWidth, (screenWidth * 0.2).toInt(), 8, 300,0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, screenWidth, (screenWidth * 0.8).toInt(), 8, 300,0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.8).toInt(), 8, 300,0)
                auxEnemies.add(tmp)
            }
            7->{
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.5).toInt(), 0, 2, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.2).toInt(), 0, 2, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.7).toInt(), 0, 2, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.5).toInt(), 0, 2, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.2).toInt(), 0, 2, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.5).toInt(), 0, 2, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.2).toInt(), 0, 2, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.7).toInt(), 0, 2, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.5).toInt(), 0, 2, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.2).toInt(), 0, 2, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.7).toInt(), 0, 2, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.5).toInt(), 0, 3, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 1), 3, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 1), 3, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 1), 3, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 1), 3, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 1), 3, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 1), 3, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 1), 3, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 1), 3, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 1), 3, 100,1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 1), 3, 100,1)
                auxEnemies.add(tmp)
            }
            8-> {
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.3).toInt(), 0, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 1.3).toInt(), 0, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1).toInt(), (screenWidth * 0.3).toInt(), 1, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1).toInt(), (screenWidth * 1.3).toInt(), 1, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.2).toInt(), 0, 2, 100, 1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.7).toInt(), 0, 2, 100, 1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 1), 3, 100, 1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 1), 3, 100, 1)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.2).toInt(), 0, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.5).toInt(), 0, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.8).toInt(), 0, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.8).toInt(), 0, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 1.1).toInt(), 0, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 1.4).toInt(), 0, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.2).toInt(), 0, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.5).toInt(), 0, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.8).toInt(), 0, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.8).toInt(), 0, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 1.1).toInt(), 0, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 1.4).toInt(), 0, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), (screenWidth * 0.8).toInt(), 1, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), (screenWidth * 1.1).toInt(), 1, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), (screenWidth * 1.4).toInt(), 1, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), (screenWidth * 0.2).toInt(), 1, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), (screenWidth * 0.5).toInt(), 1, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), (screenWidth * 0.8).toInt(), 1, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), (screenWidth * 0.8).toInt(), 1, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), (screenWidth * 1.1).toInt(), 1, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), (screenWidth * 1.4).toInt(), 1, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), (screenWidth * 0.2).toInt(), 1, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), (screenWidth * 0.5).toInt(), 1, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), (screenWidth * 0.8).toInt(), 1, 100, 3)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), (screenWidth * 0.2).toInt(), 8, 300, 0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.8).toInt(), 8, 300, 0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), (screenWidth * 0.8).toInt(), 8, 300, 0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, (screenWidth * 0.2).toInt(), 8, 300, 0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, 0, 0, 7, 100, 0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 1), 0, 7, 100, 0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.5).toInt(), 0, 7, 100, 0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.1).toInt(), (screenHeight * 1), 6, 100, 0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 1), 6, 100, 0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.6).toInt(), (screenHeight * 1), 5, 100, 0)
                auxEnemies.add(tmp)
                tmp = createComplexEnemy(DEMON_CHAR, (screenWidth * 0.8).toInt(), (screenHeight * 1), 5, 100, 0)
                auxEnemies.add(tmp)
            }
            9->{

            }
            10->{

            }
            11->{

            }
        }
    }


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
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == -1){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            1 -> {
                if (time == 0L) {
                    tmp = createEnemy(GHOST_CHAR, 0, (screenHeight * 0.6).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 100L) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), 0,1,100)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, 0, (screenHeight * 0.3).toInt(),2,100)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, 0, (screenHeight * 0.7).toInt(),2,100)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 200L) {

                    tmp=createEnemy(GHOST_CHAR, screenWidth , (screenHeight * 0.7).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, 0 , (screenHeight * 0.2).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 300L){
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), 0,2,100)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, 0, (screenHeight * 0.5).toInt(),2,100)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, 0, (screenHeight * 0.7).toInt(),2,100)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 400L){

                    tmp=createEnemy(GHOST_CHAR, screenWidth, (screenHeight * 0.7).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, 0, (screenHeight * 0.2).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 500L){
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == -1){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            2 -> {
                if (time == 0L) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), 0,1,100)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.7).toInt(), 0,1,100)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 150L) {

                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), 0,1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, 0, (screenHeight * 0.2).toInt(),2,150)
                    listOfTmpEnemies.add(tmp)

                } else if (time == 300L) {

                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), 0, 1, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.7).toInt(),0, 1, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, 0, (screenHeight * 0.3).toInt(), 2, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, 0, (screenHeight * 0.7).toInt(), 2, 150)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 475L){

                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)

                    tmp = createEnemy(GHOST_CHAR, 0, (screenHeight * 0.4).toInt(),2,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, 0, (screenHeight * 0.6).toInt(),2,150)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 625L){

                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)

                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.7).toInt(), 0,1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), 0,1,150)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 775L){
                    tmp=createEnemy(GHOST_CHAR, screenWidth, (screenHeight * 0.2).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, screenWidth , screenHeight,0,100)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, 0, (screenHeight * 0.2).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, 0, screenHeight,0,100)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 800L){
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), 0,1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, 0, (screenHeight * 0.4).toInt(),2,150)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, 0, (screenHeight * 0.6).toInt(),2,150)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 950L){
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(),0,200)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 1150L){
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.8).toInt(),0,200)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 1350L) {
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(),0,200)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 1550L){
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(),0,200)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 1750L){
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.8).toInt(),0,200)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 1950L){
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == -1){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            3 -> {
                var tmpEye:Eye
                var tmpEye2:Eye
                if (time == 0L) {
                    tmp = createComplexEnemy(EYE_CHAR, 0, (screenHeight * 0.5).toInt(), 0, 20,0)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 150L){
                    listOfEnemyCharacters.clear()
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 1), (screenHeight * 0.5).toInt(), 1, 20,1)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 300L){
                    tmp = createComplexEnemy(EYE_CHAR, 0, (screenHeight * 0.3).toInt(), 0, 100,16)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 1), (screenHeight * 0.7).toInt(), 1, 100,17)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 450L){

                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 1), (screenHeight * 0.3).toInt(), 1, 100,16)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 1), (screenHeight * 0.7).toInt(), 1, 100,17)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 600L){

                    tmp = createComplexEnemy(EYE_CHAR, 0 , (screenHeight * 0.3).toInt(), 0, 100,16)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, 0 , (screenHeight * 0.7).toInt(), 0, 100,17)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 750L){

                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 1), (screenHeight * 0.5).toInt(), 1, 100,2)
                    listOfTmpEnemies.add(tmp)


                }else if(time == 825L){
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == -1){
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
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.5).toInt(), 0, 2, 20,2)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 150L){
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.5).toInt(), (screenWidth * 2), 3, 20,3)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 300L){
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.2).toInt(), 0, 2, 20,10)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.8).toInt(), 0, 2, 20,11)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 450L){

                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.2).toInt(), (screenWidth * 2), 3, 20,10)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.8).toInt(), (screenWidth * 2), 3, 20,11)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 600L){
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.2).toInt(), 0, 2, 20,12)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.8).toInt(), (screenWidth * 2), 3, 20,13)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 750L){
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.2).toInt(), (screenWidth * 2), 3, 20,14)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.8).toInt(), 0, 2, 20,15)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 900L){
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == -1){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            5 -> {
                var tmpEye : Eye
                if (time == 0L) {
                    tmp = createComplexEnemy(EYE_CHAR, 0, (screenHeight * 0.5).toInt(), 0, 20,4)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 100L) {
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.5).toInt(), 0, 2, 20,5)
                    listOfTmpEnemies.add(tmp)
                }else if(time==250L){
                    tmp = createComplexEnemy(EYE_CHAR, 0, (screenHeight * 0.3).toInt(), 0, 50,6)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 1), (screenHeight * 0.7).toInt(), 1, 50,7)
                    listOfTmpEnemies.add(tmp)
                }else if (time == 400L){
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.2).toInt(), 0, 2, 20,8)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.8).toInt(), (screenHeight * 1) , 3, 20,9)
                    listOfTmpEnemies.add(tmp)
                }else if (time == 550L){
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 1), 3, 20,10)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.8).toInt(), 0, 2, 20,11)
                    listOfTmpEnemies.add(tmp)
                }else if (time == 700L){
                    tmp = createComplexEnemy(EYE_CHAR, 0, (screenHeight * 0.3).toInt(), 0, 20,1)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.8).toInt(), (screenHeight * 0.7).toInt(), 1, 20,1)
                    listOfTmpEnemies.add(tmp)
                }else if (time == 850L){
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.8).toInt(), (screenHeight * 0.3).toInt(), 1, 20,8)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(EYE_CHAR, 0, (screenHeight * 0.7).toInt(), 0, 20,9)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 1000L){
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == -1){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            6 -> {
                if (time == 0L) {
                    listOfTmpEnemies.add(auxEnemies[0])
                    listOfTmpEnemies.add(auxEnemies[1])
                }else if(time == 350L) {

                    listOfTmpEnemies.add(auxEnemies[2])
                    listOfTmpEnemies.add(auxEnemies[3])

                }else if(time == 500L) {

                    listOfTmpEnemies.add(auxEnemies[4])
                    listOfTmpEnemies.add(auxEnemies[5])

                }else if(time == 650L) {

                    listOfTmpEnemies.add(auxEnemies[6])
                    listOfTmpEnemies.add(auxEnemies[7])

                }else if(time == 800L) {

                    listOfTmpEnemies.add(auxEnemies[8])
                    listOfTmpEnemies.add(auxEnemies[9])
                    listOfTmpEnemies.add(auxEnemies[10])

                }else if(time == 900L) {

                    listOfTmpEnemies.add(auxEnemies[11])
                    listOfTmpEnemies.add(auxEnemies[12])
                    listOfTmpEnemies.add(auxEnemies[13])

                }else if(time == 1000L) {

                    listOfTmpEnemies.add(auxEnemies[14])
                    listOfTmpEnemies.add(auxEnemies[15])
                    listOfTmpEnemies.add(auxEnemies[16])
                    listOfTmpEnemies.add(auxEnemies[17])

                }else if(time == 1350L) {
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == -1){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            7 -> {
                if (time == 0L) {
                    listOfTmpEnemies.add(auxEnemies[0])
                }else if(time == 50L) {
                    listOfTmpEnemies.add(auxEnemies[1])
                }else if(time == 100L) {
                    listOfTmpEnemies.add(auxEnemies[2])
                }else if(time == 150L) {
                    listOfTmpEnemies.add(auxEnemies[3])
                }else if(time == 200L) {
                    listOfTmpEnemies.add(auxEnemies[4])
                }else if(time == 250L) {
                    listOfTmpEnemies.add(auxEnemies[5])
                }else if(time == 300L) {
                    listOfTmpEnemies.add(auxEnemies[6])
                    listOfTmpEnemies.add(auxEnemies[7])
                }else if(time == 350L) {
                    listOfTmpEnemies.add(auxEnemies[8])
                }else if(time == 400L) {
                    listOfTmpEnemies.add(auxEnemies[9])
                    listOfTmpEnemies.add(auxEnemies[10])
                }else if(time == 450L) {
                    listOfTmpEnemies.add(auxEnemies[11])
                }else if(time == 500L) {
                    listOfTmpEnemies.add(auxEnemies[12])
                }else if(time == 550L) {
                    listOfTmpEnemies.add(auxEnemies[13])
                }else if(time == 600L) {
                    listOfTmpEnemies.add(auxEnemies[14])
                }else if(time == 650L) {
                    listOfTmpEnemies.add(auxEnemies[15])
                }else if(time == 700L) {
                    listOfTmpEnemies.add(auxEnemies[16])
                }else if(time == 750L) {
                    listOfTmpEnemies.add(auxEnemies[17])
                    listOfTmpEnemies.add(auxEnemies[18])
                }else if(time == 850L) {
                    listOfTmpEnemies.add(auxEnemies[19])
                }else if(time == 900L) {
                    listOfTmpEnemies.add(auxEnemies[20])
                    listOfTmpEnemies.add(auxEnemies[21])
                }else if(time == 1000L) {
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == -1){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            8 -> {
                if (time == 0L) {
                    listOfTmpEnemies.add(auxEnemies[0])
                    listOfTmpEnemies.add(auxEnemies[1])
                }else if (time == 100L) {
                    listOfTmpEnemies.add(auxEnemies[2])
                    listOfTmpEnemies.add(auxEnemies[3])
                }else if (time == 200L) {
                    listOfTmpEnemies.add(auxEnemies[4])
                    listOfTmpEnemies.add(auxEnemies[5])
                }else if (time == 300L) {
                    listOfTmpEnemies.add(auxEnemies[6])
                    listOfTmpEnemies.add(auxEnemies[7])
                }else if(time == 400L) {
                    listOfTmpEnemies.add(auxEnemies[8])
                    listOfTmpEnemies.add(auxEnemies[9])
                    listOfTmpEnemies.add(auxEnemies[10])
                }else if(time == 450L) {
                    listOfTmpEnemies.add(auxEnemies[11])
                    listOfTmpEnemies.add(auxEnemies[12])
                    listOfTmpEnemies.add(auxEnemies[13])
                }else if(time == 500L) {
                    listOfTmpEnemies.add(auxEnemies[14])
                    listOfTmpEnemies.add(auxEnemies[15])
                    listOfTmpEnemies.add(auxEnemies[16])
                }else if(time == 550L) {
                    listOfTmpEnemies.add(auxEnemies[17])
                    listOfTmpEnemies.add(auxEnemies[18])
                    listOfTmpEnemies.add(auxEnemies[19])
                }else if(time == 650L) {
                    listOfTmpEnemies.add(auxEnemies[20])
                    listOfTmpEnemies.add(auxEnemies[21])
                    listOfTmpEnemies.add(auxEnemies[22])
                }else if(time == 700L) {
                    listOfTmpEnemies.add(auxEnemies[23])
                    listOfTmpEnemies.add(auxEnemies[24])
                    listOfTmpEnemies.add(auxEnemies[25])
                }else if(time == 750L) {
                    listOfTmpEnemies.add(auxEnemies[26])
                    listOfTmpEnemies.add(auxEnemies[27])
                    listOfTmpEnemies.add(auxEnemies[28])
                }else if(time == 800L) {
                    listOfTmpEnemies.add(auxEnemies[29])
                    listOfTmpEnemies.add(auxEnemies[30])
                    listOfTmpEnemies.add(auxEnemies[31])
                }else if(time == 900L) {
                    listOfTmpEnemies.add(auxEnemies[32])
                    listOfTmpEnemies.add(auxEnemies[33])
                    listOfTmpEnemies.add(auxEnemies[34])
                    listOfTmpEnemies.add(auxEnemies[35])
                }else if(time == 1200L) {
                    listOfTmpEnemies.add(auxEnemies[36])
                    listOfTmpEnemies.add(auxEnemies[37])
                    listOfTmpEnemies.add(auxEnemies[38])
                }else if(time == 1350L) {
                    listOfTmpEnemies.add(auxEnemies[39])
                    listOfTmpEnemies.add(auxEnemies[40])
                    listOfTmpEnemies.add(auxEnemies[41])
                    listOfTmpEnemies.add(auxEnemies[42])
                }else if(time == 1500L) {
                    listOfEnemyCharacters.clear()
                    end_game=true
                }

                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == -1){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            9 -> {
                if (time == 50L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 0, 150,0)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 1, 150,1)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 250L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 2, 150,2)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 4, 150,4)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 450L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 3, 150,3)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 5, 150,5)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 650L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 8, 150,8)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 0, 150,0)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 850L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 2, 150,2)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 4, 150,4)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 8, 150,8)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 1050L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 9, 150,9)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 7, 150,7)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 1, 150,1)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 1150L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 0, 150,0)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 2, 150,2)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 4, 150,4)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 5, 150,5)
                    listOfTmpEnemies.add(tmp)


                }else if(time == 1350L) {

                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == -1){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            10 -> {
                if (time == 0L) {
                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 0, 150, 0)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 100L){
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 2, 150,2)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 200L){
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 7, 150,7)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 300L){
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 9, 150,9)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 400L){
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 4, 150,4)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 500L){
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 8, 150,8)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 600L){
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 5, 150,5)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 700L){
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 0, 150,0)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 800L){
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 2, 150,2)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 4, 150,4)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 1000L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 9, 200,9)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 8, 200,8)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 7, 200,8)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 1200L) {
                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 6, 200,7)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0 , 0, 5, 200,4)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 1400L) {

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

                }else if(time == 1700L) {
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == -1){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }

            11 -> {
                if (time == 0L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 2, 400, 2)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 50L){

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 3, 100, 3)
                    listOfTmpEnemies.add(tmp)


                }else if(time == 150L){

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 5, 100, 5)
                    listOfTmpEnemies.add(tmp)


                }else if(time == 250L){

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 7, 100, 7)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 6, 100, 6)
                    listOfTmpEnemies.add(tmp)


                }else if(time == 350L){

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 6, 100, 6)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 5, 100, 5)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 4, 100, 4)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 450L){

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 7, 550, 7)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 500L){

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 6, 100, 6)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 1, 100, 1)
                    listOfTmpEnemies.add(tmp)


                }else if(time == 600L){

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 3, 200, 3)
                    listOfTmpEnemies.add(tmp)


                }else if(time == 700L){


                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 9, 100, 9)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 800L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 0, 100, 0)
                    listOfTmpEnemies.add(tmp)


                }else if(time == 900L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 6, 100, 6)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 5, 100, 5)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 9, 100, 9)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 1000L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 1, 600, 1)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 1050L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 0, 100, 0)
                    listOfTmpEnemies.add(tmp)


                }else if(time == 1150L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 9, 100, 9)
                    listOfTmpEnemies.add(tmp)

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 4, 100, 4)
                    listOfTmpEnemies.add(tmp)


                }else if(time == 1250L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 3, 200, 3)
                    listOfTmpEnemies.add(tmp)


                }else if(time == 1350L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 0, 100, 0)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 1500L) {

                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 0, 100, 0)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 2, 100, 2)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 3, 100, 3)
                    listOfTmpEnemies.add(tmp)
                    tmp = createComplexEnemy(SKULL_CHAR, 0, 0, 4, 100, 5)
                    listOfTmpEnemies.add(tmp)


                }else if(time == 1600L) {
                    listOfEnemyCharacters.clear()
                    end_game=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == -1){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }

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
                    createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 3,dissapearTimer = 150))
                } else if (time == 200L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), -4,dissapearTimer = 150))
                }else if (time == 350L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.2).toInt(), 5,dissapearTimer = 150))
                }else if (time == 500L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.7).toInt(), -8,dissapearTimer = 150))
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
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 5,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(), -6,dissapearTimer = 150))
                } else if (time == 150L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), -4,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.5).toInt(), 6,dissapearTimer = 150))
                } else if (time == 250L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 5,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), -6,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), -3,dissapearTimer = 150))
                } else if (time == 350L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.2).toInt(),7 ,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.65).toInt(), -4,dissapearTimer = 150))
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
                        createCoin("Coin", (screenWidth * 0.4).toInt(), (screenHeight * 0.6).toInt(), 3,dissapearTimer = 150))
                }else if (time == 70L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.4).toInt(), 8,dissapearTimer = 150))
                }else if (time == 200L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 4,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.2).toInt(), 6,dissapearTimer = 150))
                }else if (time == 350L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 5,dissapearTimer = 150))
                }else if (time == 500L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.75).toInt(), (screenHeight * 0.5).toInt(), 2,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), -1,dissapearTimer = 150))
                }else if (time == 650L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 4,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.2).toInt(), -6,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.6).toInt(), (screenHeight * 0.5).toInt(), 8,dissapearTimer = 150))
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
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.75).toInt(), 3,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), -5,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.5).toInt(), 1,dissapearTimer = 200))
                }else if (time == 130L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 7,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.8).toInt(), -8,dissapearTimer = 200))
                }else if (time == 320L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 5,dissapearTimer = 200))
                }else if (time == 430L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.45).toInt(), (screenHeight * 0.4).toInt(), 6,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.65).toInt(), (screenHeight * 0.6).toInt(), 4,dissapearTimer = 200))

                }else if (time == 530L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), -4,dissapearTimer = 200))

                }else if (time == 640L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 8,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.7).toInt(), -9,dissapearTimer = 200))

                }else if (time == 750L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 2,dissapearTimer = 200))

                }else if (time == 900L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), -5,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), -6,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), -4,dissapearTimer = 200))

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
                if (time == 50L) {

                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), -6,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.7).toInt(), 5,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(), 9,dissapearTimer = 200))

                }else if(time == 350L) {

                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.25).toInt(), 4,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.65).toInt(), -15,dissapearTimer = 200))


                }else if(time == 500L) {

                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), -6,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.7).toInt(), 4,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(), 7,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), -9,dissapearTimer = 200))

                }else if(time == 800L) {

                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.35).toInt(), 10,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.35).toInt(), -5,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.75).toInt(), -5,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.75).toInt(), 20,dissapearTimer = 200))

                }else if(time == 900L) {

                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(), 6,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.4).toInt(), -5,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(), 2,dissapearTimer = 200))

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
            7 -> {
                if (time == 50L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 10, dissapearTimer = 150))

                } else if (time == 100L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.7).toInt(), -6,dissapearTimer = 150))

                } else if (time == 150L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), 4,dissapearTimer = 150))

                }else if (time == 200L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(), 2,dissapearTimer = 150))

                }else if (time == 250L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.75).toInt(), 10,dissapearTimer = 150))

                }else if (time == 300L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), -5,dissapearTimer = 150))

                }else if (time == 350L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), 9,dissapearTimer = 150))

                }else if (time == 400L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.7).toInt(), -12,dissapearTimer = 150))

                }else if (time == 450L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.3).toInt(), 4,dissapearTimer = 150))

                }else if (time == 500L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 5,dissapearTimer = 150))

                }else if (time == 550L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(), -4,dissapearTimer = 150))

                }else if (time == 600L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 8,dissapearTimer = 150))

                }else if (time == 650L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(), -15,dissapearTimer = 150))

                }else if (time == 700L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), 10,dissapearTimer = 150))

                }else if (time == 750L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), -2,dissapearTimer = 150))

                }else if (time == 800L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(), -12,dissapearTimer = 150))

                }else if (time == 850L) {


                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), 6,dissapearTimer = 150))

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
            8 -> {

                if (time == 0L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 12,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(), -20,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.7).toInt(), -13,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), 15,dissapearTimer = 150))


                }else if (time == 200L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), -22,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(), 10,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.7).toInt(), 11,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), -16,dissapearTimer = 150))

                }else if(time == 400L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.4).toInt(), 15 ,dissapearTimer = 100))

                }else if(time == 450L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.7).toInt(), 15 ,dissapearTimer = 100))

                }else if(time == 500L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(), -18 ,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 5 ,dissapearTimer = 100))

                }else if(time == 550L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), -18 ,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.7).toInt(), 5 ,dissapearTimer = 100))

                }else if(time == 650L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), -10 ,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.7).toInt(),  -5,dissapearTimer = 100))


                }else if(time == 700L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(), 20 ,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(),  -14,dissapearTimer = 100))


                }else if(time == 750L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 5 ,dissapearTimer = 100))


                }else if(time == 800L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.4).toInt(), (screenHeight * 0.3).toInt(), -15 ,dissapearTimer = 100))


                }else if(time == 900L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.7).toInt(), -10 ,dissapearTimer = 300),
                        createCoin("Coin", (screenWidth * 0.4).toInt(), (screenHeight * 0.5).toInt(), 6 ,dissapearTimer = 300),
                        createCoin("Coin", (screenWidth * 0.6).toInt(), (screenHeight * 0.5).toInt(), -20 ,dissapearTimer = 300),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 5 ,dissapearTimer = 300))


                }else if(time == 1200L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.65).toInt(), (screenHeight * 0.7).toInt(), -14 ,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.4).toInt(), (screenHeight * 0.3).toInt(), 10 ,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.6).toInt(), (screenHeight * 0.3).toInt(), -28 ,dissapearTimer = 100))

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
            9 -> {

                if (time == 0L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.75).toInt(), 6 ,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.4).toInt(),  8,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.4).toInt(),  -5,dissapearTimer = 150))

                }else if(time == 230L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.8).toInt(), 5 ,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.8).toInt(),  3,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.25).toInt(),  -9,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.25).toInt(),  -2,dissapearTimer = 150))


                }else if(time == 430L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.4).toInt(), -3,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.7).toInt(),  2,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.8).toInt(),  -10,dissapearTimer = 150))


                }else if(time == 630L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.6).toInt(), (screenHeight * 0.7).toInt(), -3 ,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.35).toInt(),  4,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.8).toInt(),  -4,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.3).toInt(),  10,dissapearTimer = 150))


                }else if(time == 830L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(), 10 ,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.4).toInt(),  -5,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(),  5,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.8).toInt(),  -10,dissapearTimer = 150))


                }else if(time == 1030L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.5).toInt(), -3 ,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(),  4,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.8).toInt(),  -4,dissapearTimer = 150))

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
            10 -> {
                if (time == 50L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.2).toInt(), 3,dissapearTimer = 200))
                }else if (time == 150L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.6).toInt(), 7,dissapearTimer = 200))
                }else if (time == 250L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(), 11,dissapearTimer = 200))
                }else if (time == 350L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.6).toInt(), (screenHeight * 0.7).toInt(), -8,dissapearTimer = 200))
                }else if (time == 450L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 5,dissapearTimer = 200))
                }else if (time == 550L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.35).toInt(), -10,dissapearTimer = 200))
                }else if (time == 650L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.75).toInt(), 8,dissapearTimer = 200))
                }else if (time == 750L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 4,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.7).toInt(), -13,dissapearTimer = 200))
                }else if (time == 850L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.4).toInt(), (screenHeight * 0.6).toInt(), 1,dissapearTimer = 200))
                }else if (time == 950L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 2,dissapearTimer = 200))
                }else if (time == 1050L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 4,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.7).toInt(), -6,dissapearTimer = 200))
                }else if (time == 1150L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 10,dissapearTimer = 200))

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
            11 -> {

                if (time == 50L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.6).toInt(), -4,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.6).toInt(), (screenHeight * 0.6).toInt(), 6,dissapearTimer = 100))

                }else if(time == 150L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.35).toInt(), 1,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.6).toInt(), (screenHeight * 0.8).toInt(), 5,dissapearTimer = 100))

                }else if(time == 250L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(), 10,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), -20,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.8).toInt(), 8,dissapearTimer = 100))

                }else if(time == 500L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(), 10,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), -20,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.8).toInt(), 8,dissapearTimer = 100))


                }else if(time == 700L){

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.4).toInt(), 10,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(), -20,dissapearTimer = 100))

                }else if(time == 800L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.3).toInt(), 1,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 10,dissapearTimer = 100))


                }else if(time == 1050L) {
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.3).toInt(), -5,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 7,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(), 3,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), -11,dissapearTimer = 100))


                }else if(time == 1150L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), 5,dissapearTimer = 100))


                }else if(time == 1250L) {

                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.35).toInt(), -15,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.35).toInt(), 2,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.65).toInt(), 9,dissapearTimer = 200),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.65).toInt(), -6,dissapearTimer = 200))


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
                listOfLimits.add(25)
                listOfLimits.add(50)
            }
            7 -> {
                listOfLimits.add(20)
                listOfLimits.add(40)
            }
            8 -> {
                listOfLimits.add(30)
                listOfLimits.add(70)
            }
            9 -> {
                listOfLimits.add(20)
                listOfLimits.add(40)
            }
            10 -> {
                listOfLimits.add(15)
                listOfLimits.add(35)

            }
            11 -> {
                listOfLimits.add(25)
                listOfLimits.add(35)

            }
        }

        limits = Limits(listOfLimits[0],listOfLimits[1], assets)
        return listOfLimits
    }

}
