package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

open class Enemy(image: ArrayList<Bitmap>) : Character(ArrayList<Bitmap>()), EnemyInterface {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 10


    //a no ser que la clase que herede haga un override del update, por defecto se llamara
    //al update de la clase Enemy. De esta forma facilitamos la creación de objetos con el
    //patron Factory
    override fun update() {


        if (x > this.getScreenWidth() - w || x < w) {
            xVelocity *= -1
        }
        if (y > this.getScreenHeight() - h || y < h) {
            yVelocity *= -1
        }


        x += (xVelocity)
        y += (yVelocity)

    }

    fun characterHitsPlayer(playerCharacter: PlayerCharacter) {
        if (this.rect.intersect(playerCharacter.rect)) {
            playerCharacter.die()
        }

    }

}