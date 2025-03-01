package io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.timers

import com.google.common.eventbus.Subscribe
import io.github.gdrfgdrf.cuteverification.web.mediator.event.program.ProgramStopEvent
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.Compatible
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.config.Config
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.events.BaseEventListener
import io.github.gdrfgdrf.cuteverification.web.minecraft.server.compatible.events.UserTimeoutEvent
import java.util.concurrent.ConcurrentHashMap

object UserTimeoutTimer {
    private val users = ConcurrentHashMap<String, Long>()

    fun start() {
        Thread(Countdown).start()
    }

    fun join(username: String) {
        users[username] = System.currentTimeMillis()
    }

    fun remove(username: String) {
        users.remove(username)
    }

    object Countdown : Runnable, BaseEventListener() {
        private var stop = false

        @Subscribe
        fun onProgramStop(programStopEvent: ProgramStopEvent) {
            stop = true
        }

        override fun run() {
            val timeout = Compatible.config!!.identificationTimeout!!

            while (!stop) {
                val current = System.currentTimeMillis()

                users.forEach { (username, startTime) ->
                    if (current - startTime < timeout) {
                        return@forEach
                    }
                    UserTimeoutEvent.main(username).post()
                }

            }
        }

    }
}