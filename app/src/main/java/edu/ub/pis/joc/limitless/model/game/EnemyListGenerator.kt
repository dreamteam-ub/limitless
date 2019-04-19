package edu.ub.pis.joc.limitless.model.game

import java.util.ArrayList

class EnemyListGenerator() {

    private var listOfCharacters = ArrayList<String>()


    fun generarNivell(nivell:Int): ArrayList<String>{
        when(nivell){
            0->{
                listOfCharacters.add("Demon")
            }
            1->{
                listOfCharacters.add("Skull")
            }
            2->{
                listOfCharacters.add("Demon")
            }
            3->{
                listOfCharacters.add("Eye")
            }
            4->{
                listOfCharacters.add("Demon")
            }
            5->{
                listOfCharacters.add("Skull")
            }
            6->{
                listOfCharacters.add("Demon")
            }
            7->{
                listOfCharacters.add("Skull")
            }
            8->{
                listOfCharacters.add("Demon")
            }
            9->{
                listOfCharacters.add("Skull")
            }
            10->{
                listOfCharacters.add("Demon")
            }
            11->{
                listOfCharacters.add("Skull")
            }

        }
        return listOfCharacters
    }
}