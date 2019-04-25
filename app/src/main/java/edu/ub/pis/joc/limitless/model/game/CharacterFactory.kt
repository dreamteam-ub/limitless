package edu.ub.pis.joc.limitless.model.game

import android.content.Context
import android.graphics.Bitmap
import edu.ub.pis.joc.limitless.R
import android.graphics.BitmapFactory

const val BLACKHOLE_CHAR = "BlackHole"
const val BOMB_CHAR = "Bomb"
const val DEMON_CHAR = "Demon"
const val EYE_CHAR = "Eye"
const val GHOST_CHAR = "Ghost"
const val PLAYER_CHARACTER = "PlayerCharacter"
const val SKULL_CHAR = "Skull"

const val SKULL_LASER = "SkullLaser"

const val NUMBER_COIN = "Coin"

class CharacterFactory(context: Context) : FactoryPattern {
    var contextApp = context

    override fun createCharacter(character: String, posX: Int, posY: Int): Character? {
        return when (character) {
            BLACKHOLE_CHAR -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.hole)
                )
                BlackHole(arrayImatges, posX, posY)
            }

            BOMB_CHAR -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb1),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb2),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb3),
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.bomb4)
                )
                Bomb(arrayImatges, posX, posY)
            }

            DEMON_CHAR -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.demon)
                )
                Demon(arrayImatges, posX, posY)
            }

            EYE_CHAR -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.eye)
                )
                Eye(arrayImatges, posX, posY)
            }

            GHOST_CHAR -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.ghost)
                )
                Ghost(arrayImatges, posX, posY)
            }

            PLAYER_CHARACTER -> {
                val arrayImatges: ArrayList<Bitmap> = arrayListOf(
                    BitmapFactory.decodeResource(contextApp.resources, R.drawable.main_character)
                )
                PlayerCharacter(arrayImatges, posX, posY)
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
                Skull(arrayImatges, posX, posY)
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
                SkullLaser(arrayImatges, posX, posY)
            }
            else -> {
                null
            }
        }
    }
}