package edu.ub.pis.joc.limitless.engine

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.widget.Toast
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.game.*
import java.util.ArrayList


class GameEngine(context : Context, nivell:Int) {

    var touched_x = 0
    var touched_y =0
    var touched : Int = 0


    private var personatge : PlayerCharacter? = null //habrá un player
    private var inGameBorder : InGameBorder? = null
    private var generador = EnemyListGenerator()
    private var generadorPosicions = EnemyPositionListGenerator()
    private var generadorNumbers = NumberListGenerator()
    private var generadorPosicionsNumbers = NumberListPositionGenerator()

    private var characterFactory : CharacterFactory? = null
    var listOfCharacters = ArrayList<Enemy>() //tendremos una lista de enemigos la cual iteraremos donde nos interese
    private var listOfCharacterNames = ArrayList<String>()
    private var listOfPositions = ArrayList<Array<Int>>()

    private var listOfNumberPositions = ArrayList<Array<Int>>()
    var listOfNumbers = ArrayList<NumberCharacter>()
    private var listOfNumbersName = ArrayList<String>()
    private var listOfNumbersValues = ArrayList<Int>()



    init{
        inGameBorder = InGameBorder(BitmapFactory.decodeResource(context.resources,R.drawable.in_game_border))
        listOfCharacterNames = generador.generarNivell(nivell)
        listOfPositions = generadorPosicions.generarPosicions(nivell)

        listOfNumbersName = generadorNumbers.generateNums(nivell)
        listOfNumbersValues = generadorNumbers.generateNumValues(nivell)
        listOfNumberPositions = generadorPosicionsNumbers.generarPosicions(nivell)

        characterFactory= CharacterFactory(context)
        personatge = characterFactory!!.createCharacterByName("PlayerCharacter") as PlayerCharacter
        addCharactersToList()
        addNumbersToList()
    }

    fun addNumbersToList(){
        for(i in 0 until listOfNumbersName.size){
            val num : NumberCharacter

            num=characterFactory!!.createCharacterByName(listOfNumbersName.get(i)) as NumberCharacter
            num.setValue(listOfNumbersValues.get(i))
            num.x=listOfNumberPositions[i][0]
            num.y=listOfNumberPositions[i][1]
            listOfNumbers.add(num)

        }
    }

    fun addCharactersToList(){
        for(i in 0 until listOfCharacterNames.size){
            val enemy : Enemy//habrán indefinidos Enemigos

            enemy=characterFactory!!.createCharacterByName(listOfCharacterNames.get(i)) as Enemy
            enemy.x = listOfPositions[i][0]
            enemy.y = listOfPositions[i][1]
            listOfCharacters.add(enemy)
        }
    }

    fun getPlayer() : PlayerCharacter{
        return personatge!!
    }



    fun update() {

        for(i in 0 until listOfCharacters.size){
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

        for (i in 0 until listOfNumbers.size){

            personatge!!.takesNumber(listOfNumbers.get(i))

        }

    }


    /**
     * Everything that has to be drawn on Canvas
     */
    var paint = Paint()

    fun draw(canvas: Canvas) {
        inGameBorder!!.draw(canvas)

        if (!personatge!!.imageList[0].isRecycled) {
            getPlayer().draw(canvas)
        }
        for(i in 0 until listOfCharacters.size) {
            listOfCharacters.get(i).draw(canvas)

        }
        for(i in 0 until listOfNumbers.size){
            if(listOfNumbers.get(i).imageList[0].isRecycled){
                listOfNumbers.remove(listOfNumbers.get(i))
            }else {
                listOfNumbers.get(i).draw(canvas)
                paint.color= Color.WHITE
                paint.style= Paint.Style.FILL
                paint.textSize=40.0f
                canvas.drawText(listOfNumbers.get(i).getValue().toString(),
                    listOfNumbers.get(i).x.toFloat(),listOfNumbers.get(i).y.toFloat(),paint)
            }
        }
    }

}