package edu.ub.pis.joc.limitless.model.game

interface PlayerCharacterInterface {

    fun update(_x: Int, _y: Int, canFast: Boolean)
    fun takesNumber(numberCharacter: NumberCharacter)
    fun die()
}