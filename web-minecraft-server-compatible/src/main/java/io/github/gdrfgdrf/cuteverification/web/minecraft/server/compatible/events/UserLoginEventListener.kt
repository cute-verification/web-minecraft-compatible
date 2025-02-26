package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.events

import com.google.common.eventbus.Subscribe
import io.github.gdrfgdrf.cuteverification.web.mediator.event.bus.EventCenter
import io.github.gdrfgdrf.cuteverification.web.mediator.event.user.UserLoginEvent
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.Compatible
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.IExtendedUser
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.enums.KickReasons

object UserLoginEventListener : BaseEventListener() {
    @Subscribe
    fun failed(userLoginFailed: UserLoginEvent.Failed) {
        val user = userLoginFailed.user as IExtendedUser
        user.kick(KickReasons.LOGIN_FAILED)
    }
}