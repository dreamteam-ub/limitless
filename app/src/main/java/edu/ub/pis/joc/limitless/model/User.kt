package edu.ub.pis.joc.limitless.model

import java.io.Serializable

class User : Serializable {
    var userName: String? = null
    var realName: String? = null
    var email: String? = null
    var survived: Long? = null
    var world: Long? = null

    constructor() {
    }

    constructor(userName: String, realName: String, email: String, survived: Long, world: Long) {
        this.userName = userName
        this.realName = realName
        this.email = email
        this.survived = survived
        this.world = world
    }
}