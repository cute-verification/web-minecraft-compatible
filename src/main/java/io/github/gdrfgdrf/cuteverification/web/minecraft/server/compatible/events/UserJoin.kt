package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.events

import io.github.gdrfgdrf.cuteverification.web.mediator.enums.IdentificationPlatforms
import io.github.gdrfgdrf.cuteverification.web.mediator.event.user.UserJoinEvent
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.Compatible
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.timers.UserTimeoutTimer

object UserJoin {
    fun timeout(username: String) {
        UserTimeoutTimer.join(username)
    }

    fun call(username: String, code: String, platform: IdentificationPlatforms, ip: String) {
        UserTimeoutTimer.remove(username)

        val user = Compatible.userPool!!.findUser(username, code, platform, ip)
        UserJoinEvent.main(user).post()
    }
}