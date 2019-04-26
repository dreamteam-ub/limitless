package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import edu.ub.pis.joc.limitless.model.Data.screenHeight
import edu.ub.pis.joc.limitless.model.Data.screenWidth

open class Enemy(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Character(image, posX, posY), EnemyInterface {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 10

    open var activeEnemy: Boolean = false
    open var behaviour : Int = 0 //por defecto


    //a no ser que la clase que herede haga un override del update, por defecto se llamara
    //al update de la clase Enemy. De esta forma facilitamos la creación de objetos con el
    //patron Factory
    override fun update(behaviour: Int) {
        when (behaviour) {
        0 -> {
            if (x > screenWidth - w || x < w) {
                xVelocity *= -1
            }
            if (y > screenHeight - h || y < h) {
                yVelocity *= -1
            }

            x += (xVelocity)
            y += (yVelocity)
        }
    }
}

    fun characterHitsPlayer(playerCharacter: PlayerCharacter) {
        if (this.rect.intersect(playerCharacter.rect) && this.activeEnemy) {
            playerCharacter.die()
        }
    }
}