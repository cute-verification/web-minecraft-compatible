package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible

import io.github.gdrfgdrf.cuteverification.web.mediator.WebMediator
import io.github.gdrfgdrf.cuteverification.web.mediator.utils.json.Jsons
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.config.Config
import java.io.BufferedOutputStream
import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

object Compatible {
    var config: Config? = null
        private set
    var userPool: IUserPool? = null
        private set

    fun start(userPool: IUserPool) {
        this.userPool = userPool

        prepareConfig()
        config = Jsons.read(File(Constants.CONFIG_FILENAME), Config::class.java)
        if (config == null) {
            throw IllegalArgumentException("the config is null, maybe sme errors occurred during parsing config file")
        }
        if (!config!!.isValid()) {
            throw IllegalArgumentException("the config is invalid, maybe url, username or password is null")
        }
        config!!.fulfill()

        WebMediator.start(
            config!!.url!!,
            config!!.username!!,
            config!!.password!!
        )
    }

    private fun prepareConfig() {
        val file = File(Constants.CONFIG_FILENAME)
        if (!file.exists()) {
            file.createNewFile()
            val config = Config()

            val writer = BufferedWriter(OutputStreamWriter(FileOutputStream(file), Charsets.UTF_8))
            writer.write(Jsons.write(config))
        }
    }
}