package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible

interface IUserPool {
    fun findUser(username: String, code: String, ip: String): IExtendedUser?
}