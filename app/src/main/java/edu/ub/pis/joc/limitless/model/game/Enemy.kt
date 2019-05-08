package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import edu.ub.pis.joc.limitless.model.Data.screenHeight
import edu.ub.pis.joc.limitless.model.Data.screenWidth

open class Enemy(image: ArrayList<Bitmap>, posX: Int, posY: Int, behaviour:Int) : Character(image, posX, posY), EnemyInterface {

    override var xVelocity: Int = 20
    override var yVelocity: Int = 20

    open var activeEnemy: Boolean = false

    open var concreteBehaviour : Int = behaviour

    override var dissapearTimer : Int = 0

    //a no ser que la clase que herede haga un override del update, por defecto se llamara
    //al update de la clase Enemy. De esta forma facilitamos la creación de objetos con el
    //patron Factory
    override fun update() {
        when (concreteBehaviour) {
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

    open fun characterHitsPlayer(playerCharacter: PlayerCharacter) : Boolean {
        var hit = false
        if (this.rect.intersects(playerCharacter.rect.left,playerCharacter.rect.top,playerCharacter.rect.right,playerCharacter.rect.bottom) && this.activeEnemy) {
            playerCharacter.die()
            hit = true
        }
        return hit
    }
}