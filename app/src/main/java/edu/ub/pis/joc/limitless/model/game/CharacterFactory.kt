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
                Toast.makeText(ctxt, "1", Toast.LENGTH_SHORT).show()
                BlackHole(BitmapFactory.decodeResource(ctxt.resources,R.drawable.hole))}

            "Bomb" -> {
                Toast.makeText(ctxt, "2", Toast.LENGTH_SHORT).show()
                Bomb(BitmapFactory.decodeResource(ctxt.resources,R.drawable.bomb))}

            "Demon" -> {
                Toast.makeText(ctxt, "3", Toast.LENGTH_SHORT).show()
                Demon(BitmapFactory.decodeResource(ctxt.resources,R.drawable.world3_select)) }

            "Eye" -> {
                Toast.makeText(ctxt, "4", Toast.LENGTH_SHORT).show()
                Eye(BitmapFactory.decodeResource(ctxt.resources,R.drawable.world2_select)) }

            "Ghost" -> {
                Toast.makeText(ctxt, "5", Toast.LENGTH_SHORT).show()
                Ghost(BitmapFactory.decodeResource(ctxt.resources,R.drawable.ghost)) }

            "PlayerCharacter" -> {
                //Toast.makeText(ctxt, "6", Toast.LENGTH_SHORT).show()
                PlayerCharacter(BitmapFactory.decodeResource(ctxt.resources, R.drawable.won_heart))}

            "Skull" -> {
                Toast.makeText(ctxt, "7", Toast.LENGTH_SHORT).show()
                Skull(BitmapFactory.decodeResource(ctxt.resources,R.drawable.world4_select))}

            else -> {
                System.exit(0)
                Toast.makeText(ctxt, "8", Toast.LENGTH_SHORT).show()
                null }



        }
    }



}