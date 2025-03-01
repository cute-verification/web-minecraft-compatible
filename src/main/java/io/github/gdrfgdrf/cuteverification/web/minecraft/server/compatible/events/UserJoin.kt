package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.events

import io.github.gdrfgdrf.cuteverification.web.mediator.event.user.UserJoinEvent
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.Compatible

object UserJoin {

    fun call(username: String, code: String, ip: String) {
        val user = Compatible.userPool!!.findUser(username, code, ip)
        UserJoinEvent.main(user).post()
    }
}