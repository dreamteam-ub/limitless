package edu.ub.pis.joc.limitless.model

import java.io.Serializable

const val USER_NAME = "userName"
const val SURVIVED = "survived"
const val VIBRATION = "vibration"
const val MUSIC = "music"
const val ANDROIDCHAR = "androidchar"

class User : Serializable {
    var userName: String? = null
    var survived: Long? = null
    var world: Int? = null
    var level: Int? = null

    var tutorial: Int? = null

    var vibration: Boolean? = null
    var music: Int? = null

    var androidchar: Boolean? = null

    constructor() {
    }

    constructor(
        userName: String,
        survived: Long = 0,
        world: Int = 0,
        level: Int = 0,
        vibration: Boolean = true,
        music: Int = 100,
        tutorial: Int = 0,
        androidchar : Boolean = false
    ) {
        this.userName = userName
        this.survived = survived
        this.vibration = vibration
        this.music = music
        this.world = world
        this.level = level
        this.tutorial = tutorial
        this.androidchar = androidchar
    }
}