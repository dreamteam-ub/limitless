package edu.ub.pis.joc.limitless.model.game

import android.graphics.Typeface

interface FactoryPattern {
    fun createCharacter(
        character: String,
        posX: Int,
        posY: Int,
        value : Int = 10,
        font : Typeface? = null
    ): Character?
}