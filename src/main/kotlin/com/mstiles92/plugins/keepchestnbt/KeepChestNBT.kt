package com.mstiles92.plugins.keepchestnbt

import com.mstiles92.plugins.keepchestnbt.listeners.BlockListener
import org.bukkit.plugin.java.JavaPlugin

class KeepChestNBT : JavaPlugin() {
    companion object {
        var instance: KeepChestNBT? = null
        private set
    }

    override fun onEnable() {
        instance = this

        server.pluginManager.registerEvents(BlockListener, this)
    }
}