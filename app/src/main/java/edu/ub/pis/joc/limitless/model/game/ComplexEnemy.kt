package edu.ub.pis.joc.limitless.model.game

import android.content.Context
import android.graphics.Bitmap

open class ComplexEnemy(image: ArrayList<Bitmap>, posX: Int, posY: Int, childList: Int, context: Context) : Enemy(image, posX, posY), EnemyInterface {


    var characterFactory: CharacterFactory = CharacterFactory(context)
    open var childListConditional = childList
    open var projectileDraw : ArrayList<Boolean> = ArrayList()
    open var projectileRelocate : ArrayList<Boolean> = ArrayList()

}