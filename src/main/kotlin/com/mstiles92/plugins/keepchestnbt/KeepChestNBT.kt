package com.mstiles92.plugins.keepchestnbt

import com.mstiles92.plugins.keepchestnbt.listeners.BlockListener
import org.bukkit.plugin.java.JavaPlugin
import org.mcstats.Metrics
import java.io.IOException

class KeepChestNBT : JavaPlugin() {
    companion object {
        var instance: KeepChestNBT? = null
        private set
    }

    override fun onEnable() {
        instance = this

        server.pluginManager.registerEvents(BlockListener, this)

        try {
            val metrics = Metrics(this)
            metrics.start()
        } catch (e: IOException) {
            logger.warning("Unable to start Plugin Metrics!")
        }
    }
}