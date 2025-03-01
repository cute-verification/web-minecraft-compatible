package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible

import io.github.gdrfgdrf.cuteverification.web.mediator.user.IUser
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.enums.KickReasons

interface IExtendedUser : IUser {
    override var id: String?
    override var username: String
    override var code: String
    override var ip: String

    fun kick(reason: KickReasons)
}