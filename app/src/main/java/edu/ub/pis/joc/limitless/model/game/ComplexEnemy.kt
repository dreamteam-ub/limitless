package edu.ub.pis.joc.limitless.model.game

import android.content.res.AssetManager
import android.graphics.Bitmap

open class ComplexEnemy(image: ArrayList<Bitmap>, posX: Int, posY: Int, childList: Int, assets: AssetManager, behaviour:Int) : Enemy(image, posX, posY, behaviour), EnemyInterface {


    var characterFactory: CharacterFactory = CharacterFactory(assets)
    open var childListConditional = childList
    open var projectileDraw : ArrayList<Boolean> = ArrayList()
    open var projectileRelocate : ArrayList<Boolean> = ArrayList()

}