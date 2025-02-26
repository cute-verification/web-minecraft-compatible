package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible

data class Config(
    var url: String? = null,
    var username: String? = null,
    var password: String? = null
) {

    fun isValid(): Boolean {
        return !url.isNullOrBlank() && !username.isNullOrBlank() && !password.isNullOrBlank()
    }

}