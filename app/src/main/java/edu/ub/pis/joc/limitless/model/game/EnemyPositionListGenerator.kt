package edu.ub.pis.joc.limitless.model.game

import android.content.res.Resources
import java.util.ArrayList

class EnemyPositionListGenerator() {

    private var listOfPositions = ArrayList<Array<Int>>()

    var xPixels = Resources.getSystem().displayMetrics.widthPixels
    var yPixels = Resources.getSystem().displayMetrics.heightPixels


    fun generarPosicions(nivell:Int): ArrayList<Array<Int>>{
        when(nivell){
            1->{
                listOfPositions.add(arrayOf((xPixels*0.2).toInt(),(xPixels*0.2).toInt()))
            }
            2->{
                listOfPositions.add(arrayOf((xPixels*0.2).toInt(),(xPixels*0.2).toInt()))
            }
            3->{
                listOfPositions.add(arrayOf((xPixels*0.2).toInt(),(xPixels*0.2).toInt()))
            }
            4->{
                listOfPositions.add(arrayOf((xPixels*0.2).toInt(),(xPixels*0.2).toInt()))
            }
            5->{
                listOfPositions.add(arrayOf((xPixels*0.2).toInt(),(xPixels*0.2).toInt()))
            }
            6->{
                listOfPositions.add(arrayOf((xPixels*0.2).toInt(),(xPixels*0.2).toInt()))
            }
            7->{
                listOfPositions.add(arrayOf((xPixels*0.2).toInt(),(xPixels*0.2).toInt()))
            }
            8->{
                listOfPositions.add(arrayOf((xPixels*0.2).toInt(),(xPixels*0.2).toInt()))
            }
            9->{
                listOfPositions.add(arrayOf((xPixels*0.2).toInt(),(xPixels*0.2).toInt()))
            }
            10->{
                listOfPositions.add(arrayOf((xPixels*0.2).toInt(),(xPixels*0.2).toInt()))
            }
            11->{
                listOfPositions.add(arrayOf((xPixels*0.2).toInt(),(xPixels*0.2).toInt()))
            }
            12->{
                listOfPositions.add(arrayOf((xPixels*0.2).toInt(),(xPixels*0.2).toInt()))
            }
        }
        return listOfPositions
    }
}