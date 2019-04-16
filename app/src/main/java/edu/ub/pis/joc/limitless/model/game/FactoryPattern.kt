package edu.ub.pis.joc.limitless.model.game

import android.content.Context

interface FactoryPattern {

    fun createCharacterByName(character: String, resources: Context) : Character?
}