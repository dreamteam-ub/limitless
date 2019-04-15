package edu.ub.pis.joc.limitless.model.game

interface EnemyInterface {

    var xVelocity: Int
    var yVelocity: Int

    fun update()

}