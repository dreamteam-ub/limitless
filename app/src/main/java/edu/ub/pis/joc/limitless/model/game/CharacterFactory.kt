package edu.ub.pis.joc.limitless.model.game

import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
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

    var optionsBombs: BitmapFactory.Options
    var optionsEye: BitmapFactory.Options
    var optionsDemon: BitmapFactory.Options
    var optionsSkull: BitmapFactory.Options
    var optionsDemonFire: BitmapFactory.Options
    var optionsEyeProyec: BitmapFactory.Options
    var optionsSkullLaser: BitmapFactory.Options
    var optionsGhost: BitmapFactory.Options
    var optionsCharacter: BitmapFactory.Options
    var optionsCoin: BitmapFactory.Options

    var arrayImatgesBombes: ArrayList<Bitmap>
    var arrayImatgesGhost: ArrayList<Bitmap>
    var arrayImatgesPlayer: ArrayList<Bitmap>
    var arrayImatgesCoin: ArrayList<Bitmap>
    var arrayImatgesSkullLaser: ArrayList<Bitmap>
    var arrayImatgesEyeProyectile: ArrayList<Bitmap>
    var arrayImatgesDemonColumn: ArrayList<Bitmap>
    var arrayImatgesDemon: ArrayList<Bitmap>
    var arrayImatgesSkull: ArrayList<Bitmap>
    var arrayImatgesEye: ArrayList<Bitmap>

    fun fixSample(nexus4Sample : Int) : Int {
        val ratio = 320.toFloat() / Data.screenDpi.toFloat()
        return (ratio * nexus4Sample).toInt()
    }

    init {
        optionsBombs = BitmapFactory.Options()
        optionsBombs.inSampleSize = fixSample(8)

        optionsEye = BitmapFactory.Options()
        optionsEye.inSampleSize = fixSample(8)

        optionsDemon = BitmapFactory.Options()
        optionsDemon.inSampleSize = fixSample(4)

        optionsSkull = BitmapFactory.Options()
        optionsSkull.inSampleSize = fixSample(2)

        optionsDemonFire = BitmapFactory.Options()
        optionsDemonFire.inSampleSize = fixSample(8)

        optionsEyeProyec = BitmapFactory.Options()
        optionsEyeProyec.inSampleSize = fixSample(8)

        optionsSkullLaser = BitmapFactory.Options()
        optionsSkullLaser.inSampleSize = fixSample(2)

        optionsGhost = BitmapFactory.Options()
        optionsGhost.inSampleSize = fixSample(4)

        optionsCharacter = BitmapFactory.Options()
        optionsCharacter.inSampleSize = fixSample(4)

        optionsCoin = BitmapFactory.Options()
        optionsCoin.inSampleSize = fixSample(4)


        arrayImatgesBombes = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "bomb_size6.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "bomb_size5.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "bomb_size4.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "bomb_size3.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "bomb_size2.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "bomb_size1.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "bomb1.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "bomb2.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "bomb3.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "bomb4.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "bomb_spawn1.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "bomb_spawn2.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "bomb_spawn3.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "bomb_spawn4.png")),
                Rect(),
                optionsBombs
            )!!
        )

        arrayImatgesGhost = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "ghost.png")),
                Rect(),
                optionsGhost
            )!!
        )

        arrayImatgesPlayer = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "main_character.png")),
                Rect(),
                optionsCharacter
            )!!
        )

        arrayImatgesCoin = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_size6.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_size5.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_size4.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_size3.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_size2.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_size1.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn1.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn2.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn3.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn4.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn5.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn6.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn7.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn8.png")),
                Rect(),
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "coin_spawn9.png")),
                Rect(),
                optionsCoin
            )!!
        )

        arrayImatgesSkullLaser = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "beam1.png")),
                Rect(),
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "beam1_light.png")),
                Rect(),
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "beam2.png")),
                Rect(),
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "beam2_light.png")),
                Rect(),
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "beam3.png")),
                Rect(),
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "beam3_light.png")),
                Rect(),
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "beam4.png")),
                Rect(),
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "beam4_light.png")),
                Rect(),
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "beam5.png")),
                Rect(),
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "beam5_light.png")),
                Rect(),
                optionsSkullLaser
            )!!
        )

        arrayImatgesEyeProyectile = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_1.png")),
                Rect(),
                optionsEyeProyec
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_2.png")),
                Rect(),
                optionsEyeProyec
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_3.png")),
                Rect(),
                optionsEyeProyec
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_4.png")),
                Rect(),
                optionsEyeProyec
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_5.png")),
                Rect(),
                optionsEyeProyec
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_6.png")),
                Rect(),
                optionsEyeProyec
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_7.png")),
                Rect(),
                optionsEyeProyec
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "eye_projectile_8.png")),
                Rect(),
                optionsEyeProyec
            )!!
        )

        arrayImatgesDemonColumn = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego1.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego2.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego3.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego4.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego5.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego6.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego7.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego8.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego9.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego10.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego11.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego12.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego13.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego14.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego15.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego16.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego17.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego18.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego19.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego20.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego21.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego22.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego23.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego24.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego25.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego26.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego27.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego28.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego29.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego30.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego31.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego32.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego33.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego34.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego35.png")),
                Rect(),
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "fuego36.png")),
                Rect(),
                optionsDemonFire
            )!!
        )

        arrayImatgesDemon = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "demon.png")),
                Rect(),
                optionsDemon
            )!!
        )

        arrayImatgesSkull = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "skull1.png")),
                Rect(),
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "skull2.png")),
                Rect(),
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "skull3.png")),
                Rect(),
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "skull3_light.png")),
                Rect(),
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "skull4.png")),
                Rect(),
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "skull4_light.png")),
                Rect(),
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "skull5.png")),
                Rect(),
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "skull5_light.png")),
                Rect(),
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "skull6.png")),
                Rect(),
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "skull6_light.png")),
                Rect(),
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "skull7.png")),
                Rect(),
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "skull7_light.png")),
                Rect(),
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "skull8.png")),
                Rect(),
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "skull8_light.png")),
                Rect(),
                optionsSkull
            )!!
        )

        arrayImatgesEye = arrayListOf(
            BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "eye1.png")), Rect(), optionsEye)!!,
            BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "eye2.png")), Rect(), optionsEye)!!,
            BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "eye3.png")), Rect(), optionsEye)!!,
            BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + "eye4.png")), Rect(), optionsEye)!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "eye5_test.png")),
                Rect(),
                optionsEye
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + "eye6_test.png")),
                Rect(),
                optionsEye
            )!!
        )

    }

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