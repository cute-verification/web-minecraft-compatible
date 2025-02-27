package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.events

import io.github.gdrfgdrf.cuteverification.web.mediator.event.bus.EventCenter
import io.github.gdrfgdrf.cuteverification.web.mediator.utils.log

abstract class BaseEventListener {
    init {
        "Registering an event listener ${this::class.java.simpleName}".log()
        EventCenter.register(this)
    }
}