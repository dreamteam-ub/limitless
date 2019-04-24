package edu.ub.pis.joc.limitless.engine

import android.content.Context
import android.graphics.*
import android.util.Log
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.game.*
import edu.ub.pis.joc.limitless.view.GameScreen.InGameBorder
import edu.ub.pis.joc.limitless.view.GameScreen.PauseButton
import java.util.*


class GameEngine(context: Context, nivell: Int) {

    var touched_x = 0
    var touched_y = 0
    var touched: Int = 0
    val nivellActual : Int = nivell


    private var personatge: PlayerCharacter? = null //habrá un player
    private var inGameBorder: InGameBorder? = null
    var pauseButton: PauseButton? = null
    private val contextEngine: Context = context

    private var characterFactory: CharacterFactory? = null
    var listOfCharacters = ArrayList<Enemy>() //tendremos una lista de enemigos la cual iteraremos donde nos interese
    private var listOfCharacterNames = ArrayList<String>()
    private var listOfPositions = ArrayList<Array<Int>>()

    private var listOfNumberPositions = ArrayList<Array<Int>>()
    var listOfNumbers = ArrayList<NumberCharacter>()
    private var listOfNumbersName = ArrayList<String>()
    private var listOfNumbersValues = ArrayList<Int>()

    private var generadorNivells : LevelGenerator = LevelGenerator()


    init {
        inGameBorder = InGameBorder(
            BitmapFactory.decodeResource(
                context.resources,
                R.drawable.in_game_border
            )
        )
        pauseButton = PauseButton(BitmapFactory.decodeResource(context.resources, R.drawable.pause_button))

        characterFactory = CharacterFactory(context)
        personatge = characterFactory!!.createCharacterByName("PlayerCharacter") as PlayerCharacter
    }

    fun addNumbersToList() {
        for (i in 0 until listOfNumbersName.size) {
            val num: NumberCharacter =
                characterFactory!!.createCharacterByName(listOfNumbersName.get(i)) as NumberCharacter
            num.setValue(listOfNumbersValues.get(i))
            num.x = listOfNumberPositions[i][0]
            num.y = listOfNumberPositions[i][1]
            listOfNumbers.add(num)

        }
    }

    fun addCharactersToList() {
        Log.d("BORRANT LLISTA","a")
        for (i in 0 until listOfCharacterNames.size) {
            val enemy: Enemy =
                characterFactory!!.createCharacterByName(listOfCharacterNames.get(i)) as Enemy//habrán indefinidos Enemigos

            enemy.x = listOfPositions[i][0]
            enemy.y = listOfPositions[i][1]
            listOfCharacters.add(enemy)
        }
    }

    fun getPlayer(): PlayerCharacter {
        return personatge!!
    }

    fun update(timeInMilis:Long) {

        var newListOfCharacterNames = generadorNivells.generarEnemics(nivellActual,timeInMilis)
        var newListOfPositions = generadorNivells.generarPosicionsEnemics(nivellActual,timeInMilis)

        var newListOfNumbersName = generadorNivells.generarMonedes(nivellActual,timeInMilis)
        var newListOfNumbersValues = generadorNivells.generarValorMonedes(nivellActual,timeInMilis)
        var newListOfNumberPositions = generadorNivells.generarPosicionsMonedes(nivellActual,timeInMilis)

        if(generadorNivells.enemyChange) {
            listOfCharacterNames = newListOfCharacterNames
            listOfPositions = newListOfPositions
            listOfNumbersName = newListOfNumbersName
            listOfNumbersValues = newListOfNumbersValues
            listOfNumberPositions = newListOfNumberPositions
            listOfCharacters.clear()
            listOfNumbers.clear()
            addCharactersToList()
            addNumbersToList()
        }

        for (i in 0 until listOfCharacters.size) {
            listOfCharacters.get(i).update()
            listOfCharacters.get(i).characterHitsPlayer(personatge!!)
        }
        if (!personatge!!.imageList[0].isRecycled) {

            if (touched == 1) {
                getPlayer().update(touched_x, touched_y, false)
            } else if (touched == 2) {
                getPlayer().update(touched_x, touched_y, true)
            }
        }

        for (i in 0 until listOfNumbers.size) {

            personatge!!.takesNumber(listOfNumbers.get(i))

        }

    }

    /**
     * Everything that has to be drawn on Canvas
     */
    var paint = Paint()
    val fuenteNueva: Typeface = Typeface.createFromAsset(contextEngine.assets, "fonts/Crimes Times Six.ttf")

    fun draw(canvas: Canvas) {
        inGameBorder!!.draw(canvas)
        pauseButton!!.draw(canvas)

        if (!personatge!!.imageList[0].isRecycled) {
            getPlayer().draw(canvas)
        }
        for (i in 0 until listOfCharacters.size) {
            listOfCharacters.get(i).draw(canvas)

        }
        for (i in 0 until listOfNumbers.size) {
            if (listOfNumbers[i].imageList[0].isRecycled) {
                listOfNumbers.remove(listOfNumbers.get(i))
            } else {
                listOfNumbers[i].draw(canvas)
                paint.color = Color.WHITE
                paint.style = Paint.Style.FILL
                paint.textSize = 40.0f
                paint.typeface = fuenteNueva
                val text: String = listOfNumbers[i].getValue().toString()
                canvas.drawText(text, listOfNumbers[i].x.toFloat() - 20f, listOfNumbers.get(i).y.toFloat() + 10f, paint)
            }
        }
    }

}