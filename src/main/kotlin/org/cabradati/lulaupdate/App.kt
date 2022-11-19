package org.cabradati.lulaupdate

import org.bukkit.plugin.java.JavaPlugin
import org.cabradati.lulaupdate.events.LulaMorteEvent
import org.cabradati.lulaupdate.events.LulaSpawnEvent

class App: JavaPlugin() {

    companion object {
        const val ATIVAR_PLUGIN = "plugin.enabled"
        const val ATIVAR_DEBUG = "plugin.debug"
        const val VIDA = "config.health"
        const val QUANTIDADE_DE_PEIXES = "config.drop_quantity"
    }

    override fun onEnable() {

        config.addDefault(ATIVAR_PLUGIN, true)
        config.addDefault(ATIVAR_DEBUG, false)
        config.addDefault(VIDA, 100)
        config.addDefault(QUANTIDADE_DE_PEIXES, 30)
        config.options().copyDefaults(true)
        saveConfig()

        val diContainer = DIContainer(
            this,
            server,
            config
        )

        if (config.getBoolean(ATIVAR_PLUGIN)) {
            server.pluginManager.registerEvents(
                LulaSpawnEvent(diContainer),
                this
            )

            server.pluginManager.registerEvents(
                LulaMorteEvent(diContainer),
                this
            )
        }

        super.onEnable()

    }
}