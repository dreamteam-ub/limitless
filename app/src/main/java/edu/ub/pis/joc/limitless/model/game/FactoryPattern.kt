package edu.ub.pis.joc.limitless.model.game

interface FactoryPattern {
    fun createCharacter(
        character: String,
        posX: Int,
        posY: Int
        ): Character?
}