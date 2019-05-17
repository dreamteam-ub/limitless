package edu.ub.pis.joc.limitless.model.game

import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import edu.ub.pis.joc.limitless.view.IMG_ASSETS
import java.io.BufferedInputStream


const val BOMB_CHAR = "Bomb"
const val DEMON_CHAR = "Demon"
const val EYE_CHAR = "Eye"
const val GHOST_CHAR = "Ghost"
const val PLAYER_CHARACTER = "PlayerCharacter"
const val SKULL_CHAR = "Skull"
const val SKULL_LASER = "SkullLaser"
const val EYE_PROJECTILE = "EyeProjectile"
const val DEMON_FIRE_COLUMN = "DemonFireColumn"

const val NUMBER_COIN = "Coin"

class CharacterFactory(assets: AssetManager) : FactoryPattern {

    var optionsBombs: BitmapFactory.Options = bmpOptHacks(6)
    var optionsEye: BitmapFactory.Options = bmpOptHacks(3)
    var optionsDemon: BitmapFactory.Options = bmpOptHacks(3)
    var optionsSkull: BitmapFactory.Options = bmpOptHacks(2)
    var optionsDemonFire: BitmapFactory.Options = bmpOptHacks(3)
    var optionsEyeProyec: BitmapFactory.Options = bmpOptHacks(3)
    var optionsSkullLaser: BitmapFactory.Options = bmpOptHacks(2)
    var optionsGhost: BitmapFactory.Options = bmpOptHacks(3)
    var optionsCharacter: BitmapFactory.Options = bmpOptHacks(2)
    var optionsCoin: BitmapFactory.Options = bmpOptHacks(4)

    fun bmpOptHacks(scaleFactor : Int) : BitmapFactory.Options {
        val tmpOpt = BitmapFactory.Options()
        tmpOpt.inSampleSize = scaleFactor
        return tmpOpt
    }

    val arrayImatgesBombes: ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "bomb_size6.png")),
            null,
            optionsBombs
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "bomb_size5.png")),
            null,
            optionsBombs
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "bomb_size4.png")),
            null,
            optionsBombs
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "bomb_size3.png")),
            null,
            optionsBombs
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "bomb_size2.png")),
            null,
            optionsBombs
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "bomb_size1.png")),
            null,
            optionsBombs
        )!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "bomb1.png")), null, optionsBombs)!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "bomb2.png")), null, optionsBombs)!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "bomb3.png")), null, optionsBombs)!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "bomb4.png")), null, optionsBombs)!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "bomb_spawn1.png")),
            null,
            optionsBombs
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "bomb_spawn2.png")),
            null,
            optionsBombs
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "bomb_spawn3.png")),
            null,
            optionsBombs
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "bomb_spawn4.png")),
            null,
            optionsBombs
        )!!
    )
    val arrayImatgesGhost: ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "ghost.png")),
            null,
            optionsGhost
        )!!
    )

    val arrayImatgesPlayer: ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "main_character.png")),
            null,
            optionsCharacter
        )!!
    )

    val arrayImatgesCoin: ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_size6.png")),
            null,
            optionsCoin
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_size5.png")),
            null,
            optionsCoin
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_size4.png")),
            null,
            optionsCoin
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_size3.png")),
            null,
            optionsCoin
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_size2.png")),
            null,
            optionsCoin
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_size1.png")),
            null,
            optionsCoin
        )!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "coin.png")), null, optionsCoin)!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn1.png")),
            null,
            optionsCoin
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn2.png")),
            null,
            optionsCoin
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn3.png")),
            null,
            optionsCoin
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn4.png")),
            null,
            optionsCoin
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn5.png")),
            null,
            optionsCoin
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn6.png")),
            null,
            optionsCoin
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn7.png")),
            null,
            optionsCoin
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn8.png")),
            null,
            optionsCoin
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn9.png")),
            null,
            optionsCoin
        )!!
    )
    val arrayImatgesSkullLaser: ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "beam1.png")),
            null,
            optionsSkullLaser
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "beam1_light.png")),
            null,
            optionsSkullLaser
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "beam2.png")),
            null,
            optionsSkullLaser
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "beam2_light.png")),
            null,
            optionsSkullLaser
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "beam3.png")),
            null,
            optionsSkullLaser
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "beam3_light.png")),
            null,
            optionsSkullLaser
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "beam4.png")),
            null,
            optionsSkullLaser
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "beam4_light.png")),
            null,
            optionsSkullLaser
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "beam5.png")),
            null,
            optionsSkullLaser
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "beam5_light.png")),
            null,
            optionsSkullLaser
        )!!
    )

    val arrayImatgesEyeProyectile: ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_1.png")),
            null,
            optionsEyeProyec
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_2.png")),
            null,
            optionsEyeProyec
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_3.png")),
            null,
            optionsEyeProyec
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_4.png")),
            null,
            optionsEyeProyec
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_5.png")),
            null,
            optionsEyeProyec
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_6.png")),
            null,
            optionsEyeProyec
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_7.png")),
            null,
            optionsEyeProyec
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_8.png")),
            null,
            optionsEyeProyec
        )!!
    )

    val arrayImatgesDemonColumn: ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego1.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego2.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego3.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego4.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego5.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego6.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego7.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego8.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego9.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego10.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego11.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego12.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego13.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego14.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego15.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego16.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego17.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego18.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego19.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego20.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego21.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego22.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego23.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego24.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego25.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego26.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego27.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego28.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego29.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego30.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego31.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego32.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego33.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego34.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego35.png")),
            null,
            optionsDemonFire
        )!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "fuego36.png")),
            null,
            optionsDemonFire
        )!!
    )

    val arrayImatgesDemon: ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "demon.png")), null, optionsDemon)!!
    )

    val arrayImatgesSkull: ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "skull1.png")), null, optionsSkull)!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "skull2.png")), null, optionsSkull)!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "skull3.png")), null, optionsSkull)!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "skull3_light.png")),
            null,
            optionsSkull
        )!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "skull4.png")), null, optionsSkull)!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "skull4_light.png")),
            null,
            optionsSkull
        )!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "skull5.png")), null, optionsSkull)!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "skull5_light.png")),
            null,
            optionsSkull
        )!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "skull6.png")), null, optionsSkull)!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "skull6_light.png")),
            null,
            optionsSkull
        )!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "skull7.png")), null, optionsSkull)!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "skull7_light.png")),
            null,
            optionsSkull
        )!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "skull8.png")), null, optionsSkull)!!,
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + "skull8_light.png")),
            null,
            optionsSkull
        )!!
    )

    val arrayImatgesEye: ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "eye1.png")), null, optionsEye)!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "eye2.png")), null, optionsEye)!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "eye3.png")), null, optionsEye)!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "eye4.png")), null, optionsEye)!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "eye5_test.png")), null, optionsEye)!!,
        BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "eye6_test.png")), null, optionsEye)!!
    )

    override fun createCharacter(
        character: String,
        posX: Int,
        posY: Int,
        behaviour: Int,
        wParent: Int,
        hParent: Int
    ): Character? {

        return when (character) {
            BOMB_CHAR -> {
                Bomb(arrayImatgesBombes, posX, posY, behaviour)
            }

            GHOST_CHAR -> {
                Ghost(arrayImatgesGhost, posX, posY, behaviour)
            }

            PLAYER_CHARACTER -> {
                PlayerCharacter(arrayImatgesPlayer, posX, posY)
            }

            NUMBER_COIN -> {
                Coin(arrayImatgesCoin, posX, posY)
            }

            SKULL_LASER -> {

                SkullLaser(arrayImatgesSkullLaser, posX, posY, behaviour, wParent, hParent)
            }
            EYE_PROJECTILE -> {
                EyeProjectile(arrayImatgesEyeProyectile, posX, posY, behaviour)
            }
            DEMON_FIRE_COLUMN -> {
                Log.d("HPARENT", hParent.toString())
                DemonFireColumn(arrayImatgesDemonColumn, posX, posY, behaviour, wParent, hParent)
            }
            else -> {
                null
            }
        }
    }

    override fun createComplexCharacter(
        character: String,
        posX: Int,
        posY: Int,
        childList: Int,
        assets: AssetManager,
        behaviour: Int
    ): Character? {
        return when (character) {

            DEMON_CHAR -> {
                Demon(arrayImatgesDemon, posX, posY, childList, assets, behaviour)
            }

            EYE_CHAR -> {
                Eye(arrayImatgesEye, posX, posY, childList, assets, behaviour)
            }

            SKULL_CHAR -> {
                Skull(arrayImatgesSkull, posX, posY, childList, assets, behaviour)
            }

            else -> {
                null
            }
        }
    }
}