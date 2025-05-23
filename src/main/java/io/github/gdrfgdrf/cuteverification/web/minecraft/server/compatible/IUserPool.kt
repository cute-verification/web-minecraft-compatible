package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible

import io.github.gdrfgdrf.cuteverification.web.mediator.enums.IdentificationPlatforms

interface IUserPool {
    fun findUser(
        username: String,
        code: String,
        platform: IdentificationPlatforms,
        ip: String
    ): IExtendedUser?
}