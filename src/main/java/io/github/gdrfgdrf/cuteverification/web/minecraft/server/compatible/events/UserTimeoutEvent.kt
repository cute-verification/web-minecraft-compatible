package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.events

import io.github.gdrfgdrf.cuteverification.web.mediator.event.BaseEvent
import io.github.gdrfgdrf.cuteverification.web.mediator.event.bus.EventCompanion

class UserTimeoutEvent(
    val username: String
) : BaseEvent() {
    companion object : EventCompanion<UserTimeoutEvent>()
}