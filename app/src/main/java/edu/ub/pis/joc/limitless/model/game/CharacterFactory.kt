package edu.ub.pis.joc.limitless.model.game

import android.content.Context
import android.graphics.Bitmap
import edu.ub.pis.joc.limitless.R
import android.graphics.BitmapFactory
import android.support.design.widget.CoordinatorLayout

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

    override fun createCharacter(character: String, posX: Int, posY: Int, behaviour : Int, wParent:Int, hParent:Int): Character? {
        return when (character) {
            BLACKHOLE_CHAR -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.hole)
                )
                BlackHole(arrayImatges, posX, posY, behaviour)
            }

            BOMB_CHAR -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_size6),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_size5),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_size4),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_size3),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_size2),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_size1),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb1),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb2),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb3),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb4),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_spawn1),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_spawn2),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_spawn3),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb_spawn4)
                )
                Bomb(arrayImatges, posX, posY, behaviour)
            }

            GHOST_CHAR -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.ghost)
                )
                Ghost(arrayImatges, posX, posY, behaviour)
            }

            PLAYER_CHARACTER -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.main_character)
                )
                PlayerCharacter(arrayImatges, posX, posY)
            }

            NUMBER_COIN -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.coin)
                )
                Coin(arrayImatges, posX, posY)
            }

            SKULL_LASER -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam1),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam1_light),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam2),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam2_light),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam3),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam3_light),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam4),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam4_light),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam5),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.beam5_light)
                )
                SkullLaser(arrayImatges, posX, posY,behaviour,wParent,hParent)
            }
            EYE_PROJECTILE -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_1),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_2),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_3),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_4),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_5),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_6),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_7),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye_projectile_8)
                )
                EyeProjectile(arrayImatges, posX, posY, behaviour)
            }
            DEMON_FIRE_COLUMN -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego1),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego2),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego3),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego4),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego5),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego6),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego7),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego8),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego9),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego10),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego11),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego12),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego13),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego14),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego15),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego16),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego17),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego18),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego19),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego20),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego21),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego22),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego23),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego24),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego25),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego26),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego27),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego28),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego29),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego30),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego31),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego32),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego33),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego34),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego35),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.fuego36)
                )
                DemonFireColumn(arrayImatges, posX, posY, behaviour,wDemon = 0,hDemon = hParent)
            }
            else -> {
                null
            }
        }
    }

    override fun createComplexCharacter(character: String, posX: Int, posY: Int, childList:Int, context: Context, behaviour: Int): Character? {
        return when (character) {

            DEMON_CHAR -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.demon)
                )
                Demon(arrayImatges, posX, posY,childList,context, behaviour)
            }

            EYE_CHAR -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye1),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye2),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye3),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye4),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye5_test),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye6_test)
                )
                Eye(arrayImatges, posX, posY,childList,context, behaviour)
            }

            SKULL_CHAR -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull1),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull2),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull3),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull3_light),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull4),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull4_light),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull5),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull5_light),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull6),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull6_light),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull7),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull7_light),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull8),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.skull8_light)
                )
                Skull(arrayImatges, posX, posY,childList,context,behaviour)
            }

            else -> {
                null
            }
        }
    }
}