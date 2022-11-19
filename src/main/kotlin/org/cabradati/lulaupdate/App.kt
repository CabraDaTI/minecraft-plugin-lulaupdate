package org.cabradati.lulaupdate

import org.bukkit.plugin.java.JavaPlugin

class App: JavaPlugin() {

    companion object {
        const val VIDA = "config.health"
        const val QUANTIDADE_DE_PEIXES = "config.drop_quantity"
        const val VELOCIDADE_DE_NADO = "config.speed"
        const val SPAWNAR_APENAS_NO_OCEANO = "config.spawn_in_ocean"
        const val ANDAR_EM_BANDO = "config.gang"
    }

    override fun onEnable() {

        config.addDefault(VIDA, 100)
        config.addDefault(QUANTIDADE_DE_PEIXES, 30)
        config.addDefault(VELOCIDADE_DE_NADO, 2)
        config.addDefault(SPAWNAR_APENAS_NO_OCEANO, true)
        config.addDefault(ANDAR_EM_BANDO, true)
        config.options().copyDefaults(true)
        saveConfig()

        val diContainer = DIContainer(
            this,
            server,
            config
        )

        super.onEnable()
    }
}