package edu.ub.pis.joc.limitless.engine

import android.content.Context
import android.widget.Toast
import edu.ub.pis.joc.limitless.model.game.*
import java.util.ArrayList


class GameEngine(context : Context) {

    private var player : PlayerCharacter? = null //habrá un player
    private var enemy : Enemy? = null //habrán indefinidos Enemigos

    private var characterFactory : CharacterFactory? = null
    var listOfCharacters = ArrayList<Enemy>() //tendremos una lista de enemigos la cual iteraremos donde nos interese
    private var listOfCharacterNames = ArrayList<String>()
    // de alguna forma tendremos que poner los nombres de los Enemigos que queramos crear

    init{
        listOfCharacterNames.add("Skull")
        characterFactory= CharacterFactory(context)
        addCharactersToList()


    }


    fun addCharactersToList(){
        for(i in 0 until listOfCharacterNames.size){
            enemy=characterFactory!!.createCharacterByName(listOfCharacterNames.get(i)) as Enemy

            listOfCharacters.add(enemy!!)
        }
    }



}