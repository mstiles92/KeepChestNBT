package com.mstiles92.plugins.keepchestnbt

import org.bukkit.plugin.java.JavaPlugin

class KeepChestNBT : JavaPlugin() {
    companion object {
        var instance: KeepChestNBT? = null
        private set
    }

    override fun onEnable() {
        instance = this
    }
}