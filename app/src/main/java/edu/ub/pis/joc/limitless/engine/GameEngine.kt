package edu.ub.pis.joc.limitless.engine

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.Toast
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.game.*
import java.util.ArrayList


class GameEngine(context : Context, nivell:Int) {

    var touched_x = 0
    var touched_y =0
    var touched : Int = 0


    private var personatge : PlayerCharacter? = null //habrá un player
    private var enemy : Enemy? = null //habrán indefinidos Enemigos
    private var inGameBorder : InGameBorder? = null
    private var generador = EnemyListGenerator()
    private var generadorPosicions = EnemyPositionListGenerator()

    private var characterFactory : CharacterFactory? = null
    var listOfCharacters = ArrayList<Enemy>() //tendremos una lista de enemigos la cual iteraremos donde nos interese
    private var listOfCharacterNames = ArrayList<String>()
    private var listOfPositions = ArrayList<Array<Int>>()
    // de alguna forma tendremos que poner los nombres de los Enemigos que queramos crear

    init{
        inGameBorder = InGameBorder(BitmapFactory.decodeResource(context.resources,R.drawable.in_game_border))
        listOfCharacterNames = generador.generarNivell(nivell)
        listOfPositions = generadorPosicions.generarPosicions(nivell)
        characterFactory= CharacterFactory(context)
        personatge = characterFactory!!.createCharacterByName("PlayerCharacter") as PlayerCharacter
        addCharactersToList()
    }


    fun addCharactersToList(){
        for(i in 0 until listOfCharacterNames.size){
            enemy=characterFactory!!.createCharacterByName(listOfCharacterNames.get(i)) as Enemy
            enemy!!.x = listOfPositions[i][0]
            enemy!!.y = listOfPositions[i][1]
            listOfCharacters.add(enemy!!)
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
        if (!personatge!!.image.isRecycled) {
            if (touched == 1) {
                getPlayer().update(touched_x, touched_y, false)
            } else if (touched == 2) {
                getPlayer().update(touched_x, touched_y, true)
            }
        }

    }


    /**
     * Everything that has to be drawn on Canvas
     */
    fun draw(canvas: Canvas) {
        inGameBorder!!.draw(canvas)
        for(i in 0 until listOfCharacters.size) {
            listOfCharacters.get(i).draw(canvas)
        }
        if (!personatge!!.image.isRecycled) {
            getPlayer().draw(canvas)
        }
    }

}