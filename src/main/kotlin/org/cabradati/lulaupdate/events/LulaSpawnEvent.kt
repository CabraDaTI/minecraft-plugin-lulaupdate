package org.cabradati.lulaupdate.events

import org.bukkit.attribute.Attribute
import org.bukkit.entity.Squid
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.CreatureSpawnEvent
import org.cabradati.lulaupdate.App
import org.cabradati.lulaupdate.DIContainer

class LulaSpawnEvent(
    private val diContainer: DIContainer
) : Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    fun onLulaSpawn(event: CreatureSpawnEvent) {
        if (event.entity !is Squid) return

        val world = diContainer.server.getWorld(event.entity.location.world.uid)
        val biome = world?.getBiome(event.entity.location)?.name?.lowercase() ?: ""

        if (!biome.contains("ocean")) {
            event.isCancelled = true
        }

        val lula = event.entity as Squid

        val vida = diContainer.config.getDouble(App.VIDA)
        if (lula.getAttribute(Attribute.GENERIC_MAX_HEALTH) != null) {
            lula.getAttribute(Attribute.GENERIC_MAX_HEALTH)!!.baseValue = vida
            lula.health = vida
        }

    }

}