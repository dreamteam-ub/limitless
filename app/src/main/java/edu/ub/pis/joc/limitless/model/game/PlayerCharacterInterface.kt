package edu.ub.pis.joc.limitless.model.game

interface PlayerCharacterInterface {

    fun update(x : Int, y : Int)
    fun playerTakesNumber(number: Number)
    fun die()
}