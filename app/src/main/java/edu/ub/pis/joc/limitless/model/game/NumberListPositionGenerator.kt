package edu.ub.pis.joc.limitless.model.game

import android.content.res.Resources
import android.widget.Toast
import edu.ub.pis.joc.limitless.engine.GameEngine
import java.util.ArrayList

class NumberListPositionGenerator {

    private var listOfPositions = ArrayList<Array<Int>>()

    var xPixels = Resources.getSystem().displayMetrics.widthPixels
    var yPixels = Resources.getSystem().displayMetrics.heightPixels


    fun generarPosicions(nivell:Int): ArrayList<Array<Int>> {
        when(nivell){
            0->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.2).toInt()))
                listOfPositions.add(arrayOf((xPixels*0.3).toInt(),(yPixels*0.3).toInt()))
            }
            1->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            2->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            3->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            4->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            5->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            6->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            7->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            8->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            9->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            10->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }
            11->{
                listOfPositions.add(arrayOf((xPixels*0.5).toInt(),(yPixels*0.1).toInt()))
            }

        }
        return listOfPositions
    }

}