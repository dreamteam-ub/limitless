package edu.ub.pis.joc.limitless.model

import java.io.Serializable

const val LEVEL = "level"
const val WORLD = "world"

const val USER_NAME = "userName"
const val SURVIVED = "survived"

class User : Serializable {
    var userName: String? = null
    var survived: Long? = null
    var world: Int? = null
    var level: Int? = null

    constructor() {
    }

    constructor(userName: String, survived: Long = 0, world: Int = 0, level : Int = 0) {
        this.userName = userName
        this.survived = survived
        this.world = world
        this.level = level
    }
}