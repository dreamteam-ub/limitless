package edu.ub.pis.joc.limitless.model

import java.io.Serializable

const val USER_NAME = "userName"
const val SURVIVED = "survived"
const val VIBRATION = "vibration"
const val MUSIC = "music"
const val SKINSELECTED = "skinSelected"
const val ANDROIDCHAR = "androidchar"
const val TUTORIAL_INF = "tutorial_inf"
const val TUTORIAL_VS = "tutorial_vs"

class User : Serializable {
    var userName: String? = null
    var survived: Long? = 0
    var world: Int? = 0
    var level: Int? = 0

    var tutorial: Int? = 0

    var vibration: Boolean? = true
    var music: Int? = 100

    var skinSelected: Int? = 0

    var androidchar: Boolean? = false

    var tutorial_inf: Boolean? = false
    var tutorial_vs: Boolean? = false

    constructor() {
    }

    /**
     * Metodo constructor de cada usuario del juego
     * @param String
     * @param Long
     * @param Int
     * @param Int
     * @param Boolean
     * @param Int
     * @param Int
     * @param Int
     * @param Boolean
     */
    constructor(
        userName: String,
        survived: Long = 0,
        world: Int = 0,
        level: Int = 0,
        vibration: Boolean = true,
        music: Int = 100,
        tutorial: Int = 0,
        skinSelected : Int = 0,
        androidchar : Boolean = false,
        tutorial_inf : Boolean = false,
        tutorial_vs : Boolean = false
    ) {
        this.userName = userName
        this.survived = survived
        this.vibration = vibration
        this.music = music
        this.world = world
        this.level = level
        this.tutorial = tutorial
        this.skinSelected = skinSelected
        this.androidchar = androidchar
        this.tutorial_inf = tutorial_inf
        this.tutorial_vs = tutorial_vs
    }
}