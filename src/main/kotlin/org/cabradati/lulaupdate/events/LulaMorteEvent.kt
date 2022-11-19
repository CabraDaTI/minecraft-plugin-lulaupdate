package org.cabradati.lulaupdate.events

import org.bukkit.Material
import org.bukkit.entity.Squid
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.inventory.ItemStack
import org.cabradati.lulaupdate.App
import org.cabradati.lulaupdate.DIContainer

class LulaMorteEvent(private val diContainer: DIContainer) : Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    fun onLulaMorte(event: EntityDeathEvent) {
        if (event.entity !is Squid) return

        val quantidade = diContainer.config.getInt(App.QUANTIDADE_DE_PEIXES)

        event.drops.add(ItemStack(Material.SALMON, quantidade))
    }

}