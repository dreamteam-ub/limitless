package edu.ub.pis.joc.limitless.model

import java.io.Serializable

const val USER_NAME = "userName"
const val SURVIVED = "survived"

class User : Serializable {
    var userName: String? = null
    var survived: Long? = null
    var world: Int? = null
    var level: Int? = null

    var tutorial: Int? = null

    var sfx : Int? = null
    var music : Int? = null

    constructor() {
    }

    constructor(userName: String, survived: Long = 0, world: Int = 0, level : Int = 0, sfx : Int = 100, music : Int = 100, tutorial : Int = 0) {
        this.userName = userName
        this.survived = survived
        this.sfx = sfx
        this.music = music
        this.world = world
        this.level = level
        this.tutorial = tutorial
    }
}