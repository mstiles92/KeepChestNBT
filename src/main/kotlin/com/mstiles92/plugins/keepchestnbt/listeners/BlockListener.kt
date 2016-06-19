package com.mstiles92.plugins.keepchestnbt.listeners

import com.mstiles92.plugins.keepchestnbt.KeepChestNBT
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.block.Chest
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.inventory.meta.BlockStateMeta

object BlockListener : Listener {
    @EventHandler
    fun onBlockPlace(event: BlockPlaceEvent) {
        if (event.itemInHand.type == Material.CHEST) {
            val meta = event.itemInHand.itemMeta

            if (meta is BlockStateMeta && meta.hasBlockState()) {
                val state = meta.blockState

                if (state is Chest) {
                    val location = event.block.location
                    val invContents = state.inventory.contents.clone()

                    Bukkit.getScheduler().runTaskLater(KeepChestNBT.instance, {
                        if (location.block.type == Material.CHEST) {
                            val chestState = location.block.state

                            if (chestState is Chest) {
                                chestState.blockInventory.contents = invContents
                                chestState.update()
                            }
                        }
                    }, 1)
                }
            }
        }
    }
}