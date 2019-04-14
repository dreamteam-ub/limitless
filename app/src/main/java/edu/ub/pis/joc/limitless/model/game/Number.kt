package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class Number(image: Bitmap) : Character(image), ObjectsInGameInterface {
    override fun update() {

    }

    override fun isTaken() {

        image.recycle()

    }
}