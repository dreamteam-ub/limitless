package edu.ub.pis.joc.limitless.model

import java.io.Serializable

class User : Serializable {
    var userName: String? = null
    var survived: Long? = null
    var world: Int? = null

    constructor() {
    }

    constructor(userName: String, survived: Long = 0, world: Int = 0) {
        this.userName = userName
        this.survived = survived
        this.world = world
    }
}