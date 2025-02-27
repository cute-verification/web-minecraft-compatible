package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.events

import com.google.common.eventbus.Subscribe
import io.github.gdrfgdrf.cuteverification.web.mediator.event.bus.EventCenter
import io.github.gdrfgdrf.cuteverification.web.mediator.event.user.GetUserRestrictedErrorEvent
import io.github.gdrfgdrf.cuteverification.web.mediator.event.user.UserRestrictedEvent
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.Compatible
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.IExtendedUser
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.enums.KickReasons

object UserRestrictedEventListener : BaseEventListener() {

    @Subscribe
    fun userRestrictedError(userRestrictedErrorEvent: GetUserRestrictedErrorEvent) {
        val user = userRestrictedErrorEvent.user as IExtendedUser
        user.kick(KickReasons.RESTRICTION_ERROR)
    }

    @Subscribe
    fun userRestricted(userRestrictedEvent: UserRestrictedEvent) {
        val user = userRestrictedEvent.user as IExtendedUser
        user.kick(KickReasons.RESTRICTED)
    }
}