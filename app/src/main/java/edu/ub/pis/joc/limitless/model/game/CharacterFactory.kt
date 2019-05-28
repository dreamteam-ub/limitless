package edu.ub.pis.joc.limitless.model.game

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import android.util.Log
import edu.ub.pis.joc.limitless.view.FullScreenActivity
import edu.ub.pis.joc.limitless.view.IMG_ASSETS
import edu.ub.pis.joc.limitless.view.OptionsActivity
import java.io.BufferedInputStream
import java.io.File
import android.os.Debug.getMemoryInfo
import android.app.ActivityManager




const val BOMB_CHAR = "Bomb"
const val DEMON_CHAR = "Demon"
const val EYE_CHAR = "Eye"
const val GHOST_CHAR = "Ghost"
const val PLAYER_CHARACTER = "PlayerCharacter"
const val PLAYER_CHARACTER2 = "PlayerCharacter2"
const val SKULL_CHAR = "Skull"
const val SKULL_LASER = "SkullLaser"
const val EYE_PROJECTILE = "EyeProjectile"
const val DEMON_FIRE_COLUMN = "DemonFireColumn"

const val NUMBER_COIN = "Coin"

class CharacterFactory(assets: AssetManager) : FactoryPattern {

    var optionsBombs: BitmapFactory.Options = BitmapFactory.Options()
    var optionsEye: BitmapFactory.Options = BitmapFactory.Options()
    var optionsDemon: BitmapFactory.Options = BitmapFactory.Options()
    var optionsSkull: BitmapFactory.Options = BitmapFactory.Options()
    var optionsDemonFire: BitmapFactory.Options = BitmapFactory.Options()
    var optionsEyeProyec: BitmapFactory.Options = BitmapFactory.Options()
    var optionsSkullLaser: BitmapFactory.Options = BitmapFactory.Options()
    var optionsGhost: BitmapFactory.Options = BitmapFactory.Options()
    var optionsCharacter: BitmapFactory.Options = BitmapFactory.Options()
    var optionsCoin: BitmapFactory.Options = BitmapFactory.Options()

    var arrayImatgesBombes: ArrayList<Bitmap>
    var arrayImatgesGhost: ArrayList<Bitmap>
    var arrayImatgesPlayer: ArrayList<Bitmap>
    var arrayImatgesPlayer2: ArrayList<Bitmap>
    var arrayImatgesCoin: ArrayList<Bitmap>
    var arrayImatgesSkullLaser: ArrayList<Bitmap>
    var arrayImatgesEyeProyectile: ArrayList<Bitmap>
    var arrayImatgesDemonColumn: ArrayList<Bitmap>
    var arrayImatgesDemon: ArrayList<Bitmap>
    var arrayImatgesSkull: ArrayList<Bitmap>
    var arrayImatgesEye: ArrayList<Bitmap>

    init {
        optionsBombs.inSampleSize = CharacterData.optionsBombs
        optionsEye.inSampleSize = CharacterData.optionsEye
        optionsDemon.inSampleSize = CharacterData.optionsDemon
        optionsSkull.inSampleSize = CharacterData.optionsSkull
        optionsDemonFire.inSampleSize = CharacterData.optionsDemonFire
        optionsEyeProyec.inSampleSize = CharacterData.optionsEyeProyec
        optionsSkullLaser.inSampleSize = CharacterData.optionsSkullLaser
        optionsGhost.inSampleSize = CharacterData.optionsGhost
        optionsCharacter.inSampleSize = CharacterData.optionsCharacter
        optionsCoin.inSampleSize = CharacterData.optionsCoin


        arrayImatgesBombes = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "bomb_size6.png")),
                null,
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "bomb_size5.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "bomb_size4.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "bomb_size3.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "bomb_size2.png")),
                Rect(),
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "bomb_size1.png")),
                null,
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "bomb1.png")),
                null,
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "bomb2.png")),
                null,
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "bomb3.png")),
                null,
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "bomb4.png")),
                null,
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "bomb_spawn1.png")),
                null,
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "bomb_spawn2.png")),
                null,
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "bomb_spawn3.png")),
                null,
                optionsBombs
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "bomb_spawn4.png")),
                null,
                optionsBombs
            )!!
        )

        arrayImatgesGhost = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "ghost.png")),
                null,
                optionsGhost
            )!!
        )

        arrayImatgesPlayer = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "main_character.png")),
                null,
                optionsCharacter
            )!!
        )

        arrayImatgesPlayer2 = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "main_character_2.png")),
                null,
                optionsCharacter
            )!!
        )

        arrayImatgesCoin = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_size6.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_size5.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_size4.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_size3.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_size2.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_size1.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_spawn1.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_spawn2.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_spawn3.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_spawn4.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_spawn5.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_spawn6.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_spawn7.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_spawn8.png")),
                null,
                optionsCoin
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "coin_spawn9.png")),
                null,
                optionsCoin
            )!!
        )

        arrayImatgesSkullLaser = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "beam1.png")),
                null,
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "beam1_light.png")),
                null,
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "beam2.png")),
                null,
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "beam2_light.png")),
                null,
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "beam3.png")),
                null,
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "beam3_light.png")),
                null,
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "beam4.png")),
                null,
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "beam4_light.png")),
                null,
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "beam5.png")),
                null,
                optionsSkullLaser
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "beam5_light.png")),
                null,
                optionsSkullLaser
            )!!
        )

        arrayImatgesEyeProyectile = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "eye_projectile_1.png")),
                null,
                optionsEyeProyec
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "eye_projectile_2.png")),
                null,
                optionsEyeProyec
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "eye_projectile_3.png")),
                null,
                optionsEyeProyec
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "eye_projectile_4.png")),
                null,
                optionsEyeProyec
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "eye_projectile_5.png")),
                null,
                optionsEyeProyec
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "eye_projectile_6.png")),
                null,
                optionsEyeProyec
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "eye_projectile_7.png")),
                null,
                optionsEyeProyec
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "eye_projectile_8.png")),
                null,
                optionsEyeProyec
            )!!
        )

        arrayImatgesDemonColumn = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego1.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego2.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego3.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego4.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego5.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego6.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego7.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego8.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego9.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego10.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego11.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego12.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego13.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego14.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego15.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego16.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego17.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego18.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego19.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego20.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego21.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego22.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego23.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego24.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego25.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego26.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego27.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego28.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego29.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego30.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego31.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego32.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego33.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego34.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego35.png")),
                null,
                optionsDemonFire
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "fuego36.png")),
                null,
                optionsDemonFire
            )!!
        )

        arrayImatgesDemon = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "demon.png")),
                null,
                optionsDemon
            )!!
        )

        arrayImatgesSkull = arrayListOf(
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "skull1.png")),
                null,
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "skull2.png")),
                null,
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "skull3.png")),
                null,
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "skull3_light.png")),
                null,
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "skull4.png")),
                null,
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "skull4_light.png")),
                null,
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "skull5.png")),
                null,
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "skull5_light.png")),
                null,
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "skull6.png")),
                null,
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "skull6_light.png")),
                null,
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "skull7.png")),
                null,
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "skull7_light.png")),
                null,
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "skull8.png")),
                null,
                optionsSkull
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "skull8_light.png")),
                null,
                optionsSkull
            )!!
        )

        arrayImatgesEye = arrayListOf(
            BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "eye1.png")), null, optionsEye)!!,
            BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "eye2.png")), null, optionsEye)!!,
            BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "eye3.png")), null, optionsEye)!!,
            BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "eye4.png")), null, optionsEye)!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "eye5_test.png")),
                null,
                optionsEye
            )!!,
            BitmapFactory.decodeStream(
                BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "eye6_test.png")),
                null,
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

            PLAYER_CHARACTER2 -> {
                PlayerCharacter(arrayImatgesPlayer2, posX, posY)
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