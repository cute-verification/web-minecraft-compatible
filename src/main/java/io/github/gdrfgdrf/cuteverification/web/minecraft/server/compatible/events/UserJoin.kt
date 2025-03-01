package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.events

import io.github.gdrfgdrf.cuteverification.web.mediator.event.user.UserJoinEvent
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.Compatible
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.timers.UserTimeoutTimer

object UserJoin {
    fun timeout(username: String) {
        UserTimeoutTimer.join(username)
    }

    fun call(username: String, code: String, ip: String) {
        UserTimeoutTimer.remove(username)

        val user = Compatible.userPool!!.findUser(username, code, ip)
        UserJoinEvent.main(user).post()
    }
}