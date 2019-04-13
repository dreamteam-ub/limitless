package edu.ub.pis.joc.limitless.view.ranking.model

import edu.ub.pis.joc.limitless.view.MAX_LEVEL
import edu.ub.pis.joc.limitless.view.MAX_WORLD
import edu.ub.pis.joc.limitless.view.MIN_LVL_WORLD
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

    var sfx : Int? = null
    var music : Int? = null

    constructor() {
    }

    constructor(userName: String, survived: Long = 0, world: Int = 0, level : Int = 0, sfx : Int = 100,music : Int = 100) {
        this.userName = userName
        this.survived = survived
        this.sfx = sfx
        this.music = music
        this.world = when {
            world > MAX_WORLD -> MAX_WORLD
            world < MIN_LVL_WORLD -> 0
            else -> world
        }
        this.level = when {
            level > MAX_LEVEL -> MAX_LEVEL
            level < MIN_LVL_WORLD -> 0
            else -> level
        }
    }
}