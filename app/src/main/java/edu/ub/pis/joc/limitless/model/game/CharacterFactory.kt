package edu.ub.pis.joc.limitless.model.game

import android.content.Context
import edu.ub.pis.joc.limitless.R
import android.graphics.BitmapFactory
import android.widget.Toast


class CharacterFactory(context: Context): FactoryPattern {
    var ctxt=context


    override fun createCharacterByName(character: String): Character? {



        return when(character){

            "BlackHole" ->{
                BlackHole(BitmapFactory.decodeResource(ctxt.resources,R.drawable.hole))}

            "Bomb" -> {
                Bomb(BitmapFactory.decodeResource(ctxt.resources,R.drawable.bomb))}

            "Demon" -> {
                Demon(BitmapFactory.decodeResource(ctxt.resources,R.drawable.world3_select)) }

            "Eye" -> {
                Eye(BitmapFactory.decodeResource(ctxt.resources,R.drawable.world2_select)) }

            "Ghost" -> {
                Ghost(BitmapFactory.decodeResource(ctxt.resources,R.drawable.ghost)) }

            "PlayerCharacter" -> {
                PlayerCharacter(BitmapFactory.decodeResource(ctxt.resources, R.drawable.won_heart))}

            "Skull" -> {
                Skull(BitmapFactory.decodeResource(ctxt.resources,R.drawable.world4_select))}

            else -> {

                null }



        }
    }



}