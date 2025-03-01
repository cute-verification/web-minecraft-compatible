package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.config

import com.fasterxml.jackson.annotation.JsonProperty

data class Config(
    var url: String? = null,
    var username: String? = null,
    var password: String? = null,
    @JsonProperty("identification-timeout")
    var identificationTimeout: Long? = null
) {

    fun isValid(): Boolean {
        return !url.isNullOrBlank() && !username.isNullOrBlank() && !password.isNullOrBlank()
    }

    fun fulfill() {
        if (identificationTimeout == null) {
            identificationTimeout = 5000
        }
    }

}