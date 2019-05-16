package edu.ub.pis.joc.limitless.model.game

import android.content.res.AssetManager

interface FactoryPattern {
    fun createCharacter(
        character: String,
        posX: Int,
        posY: Int,
        behaviour: Int = 0,
        wParent : Int = 0,
        hParent : Int = 0
        ): Character?

    fun createComplexCharacter(
        character: String,
        posX: Int,
        posY: Int,
        childList:Int,
        assets: AssetManager,
        behaviour : Int = 0
    ): Character?
}