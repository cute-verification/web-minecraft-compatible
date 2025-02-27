package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible

import io.github.gdrfgdrf.cuteverification.web.mediator.user.IUser
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.enums.KickReasons

interface IExtendedUser : IUser {
    fun kick(reason: KickReasons)
}