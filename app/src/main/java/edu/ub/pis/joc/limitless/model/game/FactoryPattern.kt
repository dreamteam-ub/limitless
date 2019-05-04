package edu.ub.pis.joc.limitless.model.game

import android.content.Context

interface FactoryPattern {
    fun createCharacter(
        character: String,
        posX: Int,
        posY: Int
        ): Character?

    fun createComplexCharacter(
        character: String,
        posX: Int,
        posY: Int,
        childList:Int,
        context: Context
    ): Character?
}