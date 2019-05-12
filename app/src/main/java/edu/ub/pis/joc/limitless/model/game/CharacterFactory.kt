package edu.ub.pis.joc.limitless.model.game

import android.content.Context
import android.graphics.Bitmap
import edu.ub.pis.joc.limitless.R
import android.graphics.BitmapFactory
import android.util.Log

const val BLACKHOLE_CHAR = "BlackHole"
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

class CharacterFactory(context: Context) : FactoryPattern {
    var contextApp = context
    var optionsBombs : BitmapFactory.Options
    var optionsEye : BitmapFactory.Options
    var optionsDemon : BitmapFactory.Options
    var optionsSkull : BitmapFactory.Options
    var optionsDemonFire : BitmapFactory.Options
    var optionsEyeProyec : BitmapFactory.Options
    var optionsSkullLaser : BitmapFactory.Options
    var optionsGhost : BitmapFactory.Options
    var optionsCharacter : BitmapFactory.Options
    var optionsCoin : BitmapFactory.Options

    init {
        optionsBombs  = BitmapFactory.Options()
        optionsBombs.inSampleSize = 16

        optionsEye = BitmapFactory.Options()
        optionsEye.inSampleSize = 8

        optionsDemon = BitmapFactory.Options()
        optionsDemon.inSampleSize = 8

        optionsSkull = BitmapFactory.Options()
        optionsSkull.inSampleSize = 4

        optionsDemonFire = BitmapFactory.Options()
        optionsDemonFire.inSampleSize = 8

        optionsEyeProyec = BitmapFactory.Options()
        optionsEyeProyec.inSampleSize = 8

        optionsSkullLaser = BitmapFactory.Options()
        optionsSkullLaser.inSampleSize = 4

        optionsGhost = BitmapFactory.Options()
        optionsGhost.inSampleSize = 8

        optionsCoin = BitmapFactory.Options()
        optionsCoin.inSampleSize = 1

        optionsCharacter = BitmapFactory.Options()
        optionsCharacter.inSampleSize = 1

    }



    val arrayImatgesBombes: ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_size6, optionsBombs),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_size5, optionsBombs),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_size4, optionsBombs),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_size3, optionsBombs),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_size2, optionsBombs),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_size1, optionsBombs),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb1, optionsBombs),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb2, optionsBombs),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb3, optionsBombs),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb4, optionsBombs),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_spawn1, optionsBombs),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_spawn2, optionsBombs),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_spawn3, optionsBombs),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_spawn4, optionsBombs)
    )
    val arrayImatgesGhost : ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.ghost, optionsGhost)
    )

    val arrayImatgesPlayer : ArrayList<Bitmap> =  arrayListOf(
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.main_character,optionsCharacter)
    )

    val arrayImatgesCoin : ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.coin, optionsCoin)
    )
    val arrayImatgesSkullLaser : ArrayList<Bitmap> = arrayListOf(
    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam1, optionsSkullLaser),
    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam1_light, optionsSkullLaser),
    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam2, optionsSkullLaser),
    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam2_light, optionsSkullLaser),
    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam3, optionsSkullLaser),
    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam3_light, optionsSkullLaser),
    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam4, optionsSkullLaser),
    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam4_light, optionsSkullLaser),
    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam5, optionsSkullLaser),
    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam5_light, optionsSkullLaser)
    )

    val arrayImatgesEyeProyectile : ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_1, optionsEyeProyec),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_2, optionsEyeProyec),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_3, optionsEyeProyec),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_4, optionsEyeProyec),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_5, optionsEyeProyec),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_6, optionsEyeProyec),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_7, optionsEyeProyec),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_8, optionsEyeProyec)
    )

    val arrayImatgesDemonColumn : ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego1, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego2, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego3, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego4, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego5, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego6, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego7, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego8, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego9, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego10, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego11, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego12, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego13, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego14, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego15, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego16, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego17, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego18, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego19, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego20, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego21, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego22, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego23, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego24, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego25, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego26, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego27, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego28, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego29, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego30, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego31, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego32, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego33, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego34, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego35, optionsDemonFire),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego36, optionsDemonFire)
    )

    val arrayImatgesDemon : ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.demon, optionsDemon)
    )



    val arrayImatgesEye : ArrayList<Bitmap> = arrayListOf(
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye1, optionsEye),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye2, optionsEye),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye3 ,optionsEye),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye4,optionsEye),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye5_test,optionsEye),
        BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye6_test,optionsEye)
    )

    override fun createCharacter(character: String, posX: Int, posY: Int, behaviour : Int, wParent:Int, hParent:Int): Character? {

        return when (character) {
            BLACKHOLE_CHAR -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.hole)
                )
                BlackHole(arrayImatges, posX, posY, behaviour)
            }

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

                SkullLaser(arrayImatgesSkullLaser, posX, posY,behaviour,wParent,hParent)
            }
            EYE_PROJECTILE -> {
                EyeProjectile(arrayImatgesEyeProyectile, posX, posY, behaviour)
            }
            DEMON_FIRE_COLUMN -> {
                Log.d("HPARENT",hParent.toString())
                DemonFireColumn(arrayImatgesDemonColumn, posX, posY, behaviour,wParent,hParent)
            }
            else -> {
                null
            }
        }
    }

    override fun createComplexCharacter(character: String, posX: Int, posY: Int, childList:Int, context: Context, behaviour: Int): Character? {
        return when (character) {

            DEMON_CHAR -> {
                Demon(arrayImatgesDemon, posX, posY,childList,context, behaviour)
            }

            EYE_CHAR -> {

                Eye(arrayImatgesEye, posX, posY,childList,context, behaviour)
            }

            SKULL_CHAR -> {

                val arrayImatgesSkull : ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull1, optionsSkull),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull2, optionsSkull),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull3, optionsSkull),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull3_light, optionsSkull),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull4, optionsSkull),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull4_light, optionsSkull),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull5, optionsSkull),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull5_light, optionsSkull),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull6, optionsSkull),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull6_light, optionsSkull),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull7, optionsSkull),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull7_light, optionsSkull),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull8, optionsSkull),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull8_light, optionsSkull)
                )

                Skull(arrayImatgesSkull, posX, posY,childList,context,behaviour)
            }

            else -> {
                null
            }
        }
    }
}