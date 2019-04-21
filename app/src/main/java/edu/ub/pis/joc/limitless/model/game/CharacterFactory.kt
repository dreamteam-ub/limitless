package edu.ub.pis.joc.limitless.model.game

import android.content.Context
import android.graphics.Bitmap
import edu.ub.pis.joc.limitless.R
import android.graphics.BitmapFactory
import android.graphics.drawable.AnimationDrawable
import android.widget.ImageView
import android.widget.Toast


class CharacterFactory(context: Context): FactoryPattern {
    var ctxt=context


    override fun createCharacterByName(character: String): Character? {

        
        return when(character){

            "BlackHole" ->{
                var arrayImatges : ArrayList<Bitmap> = ArrayList<Bitmap>()
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.hole))
                BlackHole(arrayImatges)}

            "Bomb" -> {
                var arrayImatges : ArrayList<Bitmap> = ArrayList<Bitmap>()
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.bomb1))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.bomb2))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.bomb3))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.bomb4))
                Bomb(arrayImatges)}

            "Demon" -> {
                var arrayImatges : ArrayList<Bitmap> = ArrayList<Bitmap>()
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.demon))
                Demon(arrayImatges) }

            "Eye" -> {
                var arrayImatges : ArrayList<Bitmap> =  ArrayList<Bitmap>()
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.eye))
                Eye(arrayImatges) }

            "Ghost" -> {
                var arrayImatges : ArrayList<Bitmap> =  ArrayList<Bitmap>()
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.ghost))
                Ghost(arrayImatges) }

            "PlayerCharacter" -> {
                var arrayImatges : ArrayList<Bitmap> = ArrayList<Bitmap>()
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.main_character))
                PlayerCharacter(arrayImatges)}

            "Skull" -> {
                var arrayImatges : ArrayList<Bitmap> =  ArrayList<Bitmap>()
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull1))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull2))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull3))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull3_light))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull4))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull4_light))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull5))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull5_light))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull6))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull6_light))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull7))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull7_light))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull8))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull8_light))
                Skull(arrayImatges)}

            "NumberCharacter" ->{
                var arrayImatges : ArrayList<Bitmap> =  ArrayList<Bitmap>()
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.coin))
                NumberCharacter(arrayImatges)
            }

            "SkullLaser" -> {
                var arrayImatges : ArrayList<Bitmap> =  ArrayList<Bitmap>()
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.beam1))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.beam1_light))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.beam2))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.beam2_light))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.beam3))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.beam3_light))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.beam4))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.beam4_light))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.beam5))
                arrayImatges.add(BitmapFactory.decodeResource(ctxt.resources,R.drawable.beam5_light))
                SkullLaser(arrayImatges)}

            else -> {

                null }

        }
    }



}