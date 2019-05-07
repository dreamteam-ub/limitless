package edu.ub.pis.joc.limitless.engine

import android.content.Context
import edu.ub.pis.joc.limitless.model.Data.screenHeight
import edu.ub.pis.joc.limitless.model.Data.screenWidth
import edu.ub.pis.joc.limitless.model.game.*
import edu.ub.pis.joc.limitless.view.end_game
import java.util.ArrayList

const val FONT_CRIME_SIX = "fonts/Crimes Times Six.ttf"

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
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.4).toInt(), (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 50L) {
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 200L) {
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.8).toInt(), (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.6).toInt(), (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 300L) {
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
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.3).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 100L) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.1).toInt(),2,150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 200L) {
                    listOfEnemyCharacters.clear()
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.7).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.2).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 350L){
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
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.1).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.1).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 100L) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.2).toInt(),2,150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 200L) {
                    listOfEnemyCharacters.clear()
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.1).toInt(), 1, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.1).toInt(), 1, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.3).toInt(), 2, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.7).toInt(), 2, 150)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 250L){
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.75).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.2).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.75).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.2).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 400L){
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
                    tmpEye.projectileDraw[2] = true
                    tmpEye.projectileRelocate[2] = true
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 150L){
                    listOfEnemyCharacters.clear()
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 1), (screenHeight * 0.5).toInt(), 1, 150,1)
                    listOfTmpEnemies.add(tmp)
                    //end_game=true
                }else if(time == 175L) {
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true
                    tmpEye.projectileDraw[0] = true
                    tmpEye.projectileRelocate[0] = true
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 200L) {
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.projectileDraw[0] = true
                    tmpEye.projectileDraw[1] = true
                    tmpEye.projectileRelocate[1] = true
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 225L) {
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.projectileDraw[1] = true
                    tmpEye.projectileDraw[2] = true
                    tmpEye.projectileRelocate[2] = true
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
                if (time == 0L) {
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.5).toInt(), 0, 2, 150,2)
                    listOfTmpEnemies.add(tmp)
                } else if(time == 25L){
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true
                    tmpEye.projectileDraw[0] = true
                    tmpEye.projectileRelocate[0] = true
                    listOfEnemyCharacters[0] = tmpEye
                } else if(time == 50L){
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.projectileDraw[1] = true
                    tmpEye.projectileDraw[1] = true
                    tmpEye.projectileRelocate[1] = true
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 75L) {
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.projectileDraw[1] = true
                    tmpEye.projectileDraw[2] = true
                    tmpEye.projectileRelocate[2] = true
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 150L){
                    listOfEnemyCharacters.clear()
                    tmp = createComplexEnemy(EYE_CHAR, (screenWidth * 0.5).toInt(), (screenWidth * 2), 3, 150,3)
                    listOfTmpEnemies.add(tmp)
                    //end_game=true
                }else if(time == 175L) {
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.drawChild = true
                    tmpEye.projectileDraw[0] = true
                    tmpEye.projectileRelocate[0] = true
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 200L) {
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.projectileDraw[0] = true
                    tmpEye.projectileDraw[1] = true
                    tmpEye.projectileRelocate[1] = true
                    listOfEnemyCharacters[0] = tmpEye
                }else if(time == 225L) {
                    tmpEye = listOfEnemyCharacters[0] as Eye
                    tmpEye.projectileDraw[1] = true
                    tmpEye.projectileDraw[2] = true
                    tmpEye.projectileRelocate[2] = true
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
                    tmp = createComplexEnemy(DEMON_CHAR, screenWidth , (screenHeight * 0.5).toInt(), 1, 300,3)
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
                } else if (time == 300L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), 4,dissapearTimer = 100))
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
                if (time == 50L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 5,dissapearTimer = 120))
                } else if (time == 220L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(), 1,dissapearTimer = 120))
                } else if (time == 275L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), 1,dissapearTimer = 120))
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
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 3,dissapearTimer = 150))

                } else if (time == 100L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(), 2,dissapearTimer = 150))

                } else if (time == 300L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), 5,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), 3,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.4).toInt(), 2,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(), 4,dissapearTimer = 150))
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
                if (time == 20L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.4).toInt(), 3,dissapearTimer = 100))
                }else if (time == 70L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.4).toInt(), 8,dissapearTimer = 100))
                }else if (time == 200L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), 4,dissapearTimer = 100))
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
                listOfLimits.add(100)
            }
            4 -> {
                listOfLimits.add(12)
                listOfLimits.add(100)
            }
            5 -> {
                listOfLimits.add(12)
                listOfLimits.add(100)
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
        return listOfLimits
    }

}
