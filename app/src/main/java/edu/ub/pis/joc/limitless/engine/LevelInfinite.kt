package edu.ub.pis.joc.limitless.engine

import android.content.res.AssetManager
import android.graphics.Typeface
import android.util.Log
import edu.ub.pis.joc.limitless.model.game.*
import edu.ub.pis.joc.limitless.view.gamescreen.Limits
import java.io.File
import java.util.*
import kotlin.random.Random

@Suppress("NAME_SHADOWING")
class LevelInfinite(assets: AssetManager,
                    listOfEnemyCharacters: ArrayList<Enemy>,
                    listOfCoins: ArrayList<Coin>):
                    Level(assets,listOfEnemyCharacters,listOfCoins) {

    var autoLvl = AutoLevelGenerate()
    var coinSpawnInf = false //con esto controlaremos cuando debe haber spawn de monedas, ya que si usamos
    //el tiempo, no será preciso porque la llamada del método de generar monedas se llama despues del de enemigos
    // en el gamEngine
    var infiniteStage = 0
    init {
        limits = Limits(autoLvl.limitLow,autoLvl.limitHigh, assets)
    }
    var skullCtr = 0
    /**
    *Funcio amb la que crearem enemics i els posarem a la llista dels enemics per a ser dibuixats/
    *actualitzats.
    * @param Int
    * @param Long
     */
    @Synchronized
    override fun buildEnemies(levelWorld: Int, time: Long) {
        val listOfTmpEnemies = ArrayList<Enemy>()
        when (levelWorld) {
            -1 -> {

                if (time == 0L) {   //primera stage de bombes per començar
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    autoLvl.positiveCoins = 0
                    autoLvl.negativeCoins = 0
                    var parameters : ArrayList<Any>
                    for (i in 0 until 5){
                        var enemy : Enemy
                        parameters = autoLvl.generateEnemiesInPreviousStages(BOMB_CHAR)
                        enemy = (createEnemy(
                            parameters[0].toString(),
                            parameters[1].toString().toInt(),
                            parameters[2].toString().toInt(),
                            parameters[3].toString().toInt(),
                            parameters[4].toString().toInt()
                        ))
                        while (autoLvl.reallocateBombs(listOfTmpEnemies,enemy)){
                            parameters = autoLvl.generateEnemiesInPreviousStages(BOMB_CHAR)
                            enemy = (createEnemy(
                                parameters[0].toString(),
                                parameters[1].toString().toInt(),
                                parameters[2].toString().toInt(),
                                parameters[3].toString().toInt(),
                                parameters[4].toString().toInt()
                            ))
                        }
                        listOfTmpEnemies.add(enemy)
                        listOfTmpEnemies[i].appearTime = Random.nextLong(0L, 250L)
                    }

                }else if (time == 300L) { //segona stage ghosts
                    infiniteStage = 1
                    newStage = true
                    autoLvl.positiveCoins = 0
                    autoLvl.negativeCoins = 0
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    var parameters : ArrayList<Any>
                    for (i in 0 until 4){
                        parameters = autoLvl.generateEnemiesInPreviousStages(GHOST_CHAR)
                        listOfTmpEnemies.add(createEnemy(
                            parameters[0].toString(),
                            parameters[1].toString().toInt(),
                            parameters[2].toString().toInt(),
                            parameters[3].toString().toInt(),
                            parameters[4].toString().toInt()
                        ))
                        listOfTmpEnemies[i].appearTime = Random.nextLong(300L, 450L)

                    }

                    //HARDCODEAR MAXIMO Y MINIMO PUNTUACION
                }else if (time == 600L) {   // Tercera stage eyes
                    infiniteStage = 2
                    newStage = true
                    autoLvl.positiveCoins = 0
                    autoLvl.negativeCoins = 0
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    var parameters : ArrayList<Any>
                    for (i in 0 until autoLvl.spawnEnemyFreq){
                        parameters = autoLvl.generateEnemiesInPreviousStages(EYE_CHAR)
                        val eye : Eye = (createComplexEnemy(
                            parameters[0].toString(),
                            parameters[1].toString().toInt(),
                            parameters[2].toString().toInt(),
                            parameters[3].toString().toInt(),
                            parameters[4].toString().toInt(),
                            parameters[5].toString().toInt()
                        )) as Eye
                        listOfTmpEnemies.add(eye)
                        listOfTmpEnemies[i].appearTime = Random.nextLong(600L, 650L)

                    }
                    //HARDCODEAR MAXIMO Y MINIMO PUNTUACION
                }else if (time == 900L) {   // quarta stage demons
                    infiniteStage = 3
                    newStage = true
                    autoLvl.positiveCoins = 0
                    autoLvl.negativeCoins = 0
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    var parameters : ArrayList<Any>
                    for (i in 0 until autoLvl.spawnEnemyFreq) {
                        parameters = autoLvl.generateEnemiesInPreviousStages(DEMON_CHAR)
                        listOfTmpEnemies.add(
                            createComplexEnemy(
                                parameters[0].toString(),
                                parameters[1].toString().toInt(),
                                parameters[2].toString().toInt(),
                                parameters[3].toString().toInt(),
                                parameters[4].toString().toInt(),
                                parameters[5].toString().toInt()
                            )
                        )
                        listOfTmpEnemies[i].appearTime = Random.nextLong(900L, 1150L)

                    }
                    //HARDCODEAR MAXIMO Y MINIMO PUNTUACION
                }else if (time == 1200L) { //cinquena stage skulls
                    infiniteStage = 4
                    newStage = true
                    autoLvl.positiveCoins = 0
                    autoLvl.negativeCoins = 0
                    listOfEnemyCharacters.clear()
                    coinSpawnInf = true
                    var parameters : ArrayList<Any>
                    for (i in 0 until autoLvl.spawnEnemyFreq) {
                        parameters = autoLvl.generateEnemiesInPreviousStages(SKULL_CHAR)
                        listOfTmpEnemies.add(
                            createComplexEnemy(
                                parameters[0].toString(),
                                parameters[1].toString().toInt(),
                                parameters[2].toString().toInt(),
                                parameters[3].toString().toInt(),
                                parameters[4].toString().toInt(),
                                parameters[5].toString().toInt()
                            )
                        )
                        listOfTmpEnemies[i].appearTime = Random.nextLong(1200L, 1450L)

                    }
                } else if (time%autoLvl.time == 0L){
                    infiniteMode = true
                    autoLvl.positiveCoins = 0
                    autoLvl.negativeCoins = 0
                    listOfEnemyCharacters.clear()
                    autoLvl.increaseTime()
                    newStage = true
                    coinSpawnInf = true
                    var parameters : ArrayList<Any>
                    for (i in 0 until autoLvl.spawnEnemyFreq) {
                        parameters = autoLvl.generateEnemy()
                        if(parameters.size == 5){
                            var enemy : Enemy
                            enemy=(createEnemy(
                                parameters[0].toString(),
                                parameters[1].toString().toInt(),
                                parameters[2].toString().toInt(),
                                parameters[3].toString().toInt(),
                                parameters[4].toString().toInt()
                            ))
                            while (autoLvl.reallocateBombs(listOfTmpEnemies,enemy)){
                                parameters = autoLvl.generateEnemiesInPreviousStages(BOMB_CHAR)
                                enemy = (createEnemy(
                                    parameters[0].toString(),
                                    parameters[1].toString().toInt(),
                                    parameters[2].toString().toInt(),
                                    parameters[3].toString().toInt(),
                                    parameters[4].toString().toInt()
                                ))
                            }
                            listOfTmpEnemies.add(enemy)
                        } else if(parameters[0].toString()== EYE_CHAR) {
                            val eye : Eye = (createComplexEnemy(
                                parameters[0].toString(),
                                parameters[1].toString().toInt(),
                                parameters[2].toString().toInt(),
                                parameters[3].toString().toInt(),
                                parameters[4].toString().toInt(),
                                parameters[5].toString().toInt()
                            )) as Eye
                            listOfTmpEnemies.add(eye)
                        }else{
                            if (parameters[0].toString().equals(SKULL_CHAR)){
                                var skull : Skull
                                if (skullCtr < 5){
                                    skull = (createComplexEnemy(
                                        parameters[0].toString(),
                                        parameters[1].toString().toInt(),
                                        parameters[2].toString().toInt(),
                                        parameters[3].toString().toInt(),
                                        parameters[4].toString().toInt(),
                                        parameters[5].toString().toInt()
                                    )) as Skull
                                    while(autoLvl.reallocSkulls(skull,listOfTmpEnemies)){
                                        parameters = autoLvl.generateEnemiesInPreviousStages(SKULL_CHAR)
                                        skull = (createComplexEnemy(
                                            parameters[0].toString(),
                                            parameters[1].toString().toInt(),
                                            parameters[2].toString().toInt(),
                                            parameters[3].toString().toInt(),
                                            parameters[4].toString().toInt(),
                                            parameters[5].toString().toInt()
                                        )) as Skull
                                    }
                                    skullCtr++
                                    listOfTmpEnemies.add(skull)
                                }else{
                                    while(parameters[0].toString().equals(SKULL_CHAR)){
                                        parameters = autoLvl.generateEnemy()
                                    }
                                    listOfTmpEnemies.add(
                                        createComplexEnemy(
                                            parameters[0].toString(),
                                            parameters[1].toString().toInt(),
                                            parameters[2].toString().toInt(),
                                            parameters[3].toString().toInt(),
                                            parameters[4].toString().toInt(),
                                            parameters[5].toString().toInt()
                                        )
                                    )

                                }
                            }else {
                                listOfTmpEnemies.add(
                                    createComplexEnemy(
                                        parameters[0].toString(),
                                        parameters[1].toString().toInt(),
                                        parameters[2].toString().toInt(),
                                        parameters[3].toString().toInt(),
                                        parameters[4].toString().toInt(),
                                        parameters[5].toString().toInt()
                                    )
                                )
                            }
                        }
                        if (listOfTmpEnemies[i] is Eye){
                            listOfTmpEnemies[i].appearTime = Random.nextLong(time,time+100L)

                        }else {
                            listOfTmpEnemies[i].appearTime = Random.nextLong(time, time + 200L)
                        }

                    }
                }


                var contador = 0
                while (contador < listOfEnemyCharacters.size) {
                    if (listOfEnemyCharacters.get(contador).dissapearTimer == -1) {
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    listOfTmpEnemies.clear()
                    skullCtr = 0
                    contador++
                }
            }

        }
        listOfEnemyCharacters.addAll(listOfTmpEnemies)
    }
    /**
    Funcio amb la que crearem monedes i les posarem a la llista de les monedes per a ser dibuixades/
    actualitzades.
    *@param  Int
    *@param Long
     */
    @Synchronized
    override fun buildCoins(levelWorld: Int, time: Long) {
        val tmpListOfCoins: ArrayList<Coin> = ArrayList()
        var coin : Coin
        when (levelWorld) {
            -1 -> {
                if (!infiniteMode && coinSpawnInf){
                    listOfCoins.clear()
                    for (j in 0 until autoLvl.spawnCoinFreq) {
                        val parameters = autoLvl.generateCoins()

                        coin = createCoin(
                            parameters[0].toString(),
                            parameters[1].toString().toInt(),
                            parameters[2].toString().toInt(),
                            parameters[3].toString().toInt(),
                            Typeface.createFromAsset(assets, FONTS_ASSETS + File.separator + FONT_COINS),
                            parameters[4].toString().toInt()
                        )

                        while (autoLvl.reallocateCoin(tmpListOfCoins,coin) || autoLvl.reallocCoinsAndBombs(coin,listOfEnemyCharacters,tmpListOfCoins)){
                            if (coin.value > 0){
                                autoLvl.positiveCoins--
                            }else if (coin.value < 0){
                                autoLvl.negativeCoins--
                            }
                            val parameters = autoLvl.generateCoins()
                            coin = createCoin(
                                parameters[0].toString(),
                                parameters[1].toString().toInt(),
                                parameters[2].toString().toInt(),
                                parameters[3].toString().toInt(),
                                Typeface.createFromAsset(assets, FONTS_ASSETS + File.separator + FONT_COINS),
                                parameters[4].toString().toInt()
                            )

                        }


                        tmpListOfCoins.add(coin)



                        if (time<1000) {
                            tmpListOfCoins[j].appearTime = Random.nextLong(time, time +150L)
                        }

                    }
                    coinSpawnInf = false

                }

                else if (time!= 0L && coinSpawnInf && infiniteMode) {
                    listOfCoins.clear()
                    for (j in 0 until autoLvl.spawnCoinFreq) {
                        val parameters = autoLvl.generateCoins()

                        coin = createCoin(
                            parameters[0].toString(),
                            parameters[1].toString().toInt(),
                            parameters[2].toString().toInt(),
                            parameters[3].toString().toInt(),
                            Typeface.createFromAsset(assets, FONTS_ASSETS + File.separator + FONT_COINS),
                            parameters[4].toString().toInt()
                        )
                        while (autoLvl.reallocateCoin(tmpListOfCoins,coin) || autoLvl.reallocCoinsAndBombs(coin,listOfEnemyCharacters,tmpListOfCoins)){
                            if (coin.value > 0){
                                autoLvl.positiveCoins--
                            }else if (coin.value < 0){
                                autoLvl.negativeCoins--
                            }
                            val parameters = autoLvl.generateCoins()
                            coin = createCoin(
                                parameters[0].toString(),
                                parameters[1].toString().toInt(),
                                parameters[2].toString().toInt(),
                                parameters[3].toString().toInt(),
                                Typeface.createFromAsset(assets, FONTS_ASSETS + File.separator + FONT_COINS),
                                parameters[4].toString().toInt()
                            )
                        }
                        tmpListOfCoins.add(coin)
                        tmpListOfCoins[j].appearTime = Random.nextLong(time, time+150)


                    }
                    coinSpawnInf = false
                }
                var contador = 0
                while (contador < listOfCoins.size) {
                    if (listOfCoins[contador].dissapearTimer == 0) {
                        listOfCoins.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
        }
        listOfCoins.addAll(tmpListOfCoins)
    }

    /**
    Funcio on els limits del mode infinit seràn creats
    *@param Int

    *@return : ArrayList<Int>
     */
    override fun createLimits(levelWorld: Int): ArrayList<Int> {
        val limit = ArrayList<Int>()
        if (!infiniteMode){
            when(infiniteStage){
                0 -> {
                    limits.min = 15
                    limits.max = 40
                    autoLvl.limitLow=15
                    autoLvl.limitHigh=40
                    limit.add(limits.min)
                    limit.add(limits.max)
                }
                1 -> {
                    limits.min = 20
                    limits.max = 40
                    autoLvl.lastLow = autoLvl.limitLow
                    autoLvl.limitLow=20
                    autoLvl.limitHigh=40
                    limit.add(limits.min)
                    limit.add(limits.max)
                }
                2 -> {
                    limits.min = 15
                    limits.max = 35
                    autoLvl.lastLow = autoLvl.limitLow
                    autoLvl.limitLow=15
                    autoLvl.limitHigh=35
                    limit.add(limits.min)
                    limit.add(limits.max)
                }
                3 -> {
                    limits.min = 20
                    limits.max = 35
                    autoLvl.lastLow = autoLvl.limitLow
                    autoLvl.limitLow=20
                    autoLvl.limitHigh=35
                    limit.add(limits.min)
                    limit.add(limits.max)
                }
                4 -> {
                    limits.min = 15
                    limits.max = 25
                    autoLvl.lastLow = autoLvl.limitLow
                    autoLvl.limitLow=15
                    autoLvl.limitHigh=25
                    limit.add(limits.min)
                    limit.add(limits.max)
                }
            }
        }
        else{
            val lims = (autoLvl.generateAutoLimits())
            limits.min = lims[0]
            limits.max = lims[1]

            return lims
        }
        return limit
    }
}