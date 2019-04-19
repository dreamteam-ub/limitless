package edu.ub.pis.joc.limitless.model.game

import android.content.Context
import edu.ub.pis.joc.limitless.R
import android.graphics.BitmapFactory


class CharacterFactory(context: Context): FactoryPattern {
    var ctxt=context


    override fun createCharacterByName(character: String): Character? {

        
        return when(character){

            "BlackHole" ->{
                BlackHole(BitmapFactory.decodeResource(ctxt.resources,R.drawable.hole))}

            "Bomb" -> {
                Bomb(BitmapFactory.decodeResource(ctxt.resources,R.drawable.bomb))}

            "Demon" -> {
                Demon(BitmapFactory.decodeResource(ctxt.resources,R.drawable.demon)) }

            "Eye" -> {
                Eye(BitmapFactory.decodeResource(ctxt.resources,R.drawable.eye)) }

            "Ghost" -> {
                Ghost(BitmapFactory.decodeResource(ctxt.resources,R.drawable.ghost)) }

            "PlayerCharacter" -> {
                PlayerCharacter(BitmapFactory.decodeResource(ctxt.resources, R.drawable.won_heart))}

            "Skull" -> {
                Skull(BitmapFactory.decodeResource(ctxt.resources,R.drawable.skull))}

            "NumberCharacter" ->{
                NumberCharacter(BitmapFactory.decodeResource(ctxt.resources,R.drawable.corazon_muerte))
            }

            else -> {

                null }

        }
    }



}