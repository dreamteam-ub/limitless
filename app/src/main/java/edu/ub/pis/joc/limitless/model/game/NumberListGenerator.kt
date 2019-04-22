package edu.ub.pis.joc.limitless.model.game

import java.util.ArrayList

class NumberListGenerator {

    private var listOfNumbers = ArrayList<String>()
    private var listOfNumberValues = ArrayList<Int>()
    //we generate the amount of numbers of each level
    fun generateNums( nivell : Int ) : ArrayList<String>{

        when(nivell) {
            0 -> {
                listOfNumbers.add("NumberCharacter")
                listOfNumbers.add("NumberCharacter")
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


    fun generateNumValues( nivell : Int ) : ArrayList<Int>{

        when(nivell) {
            0 -> {
                listOfNumberValues.add(10)
                listOfNumberValues.add(20)

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