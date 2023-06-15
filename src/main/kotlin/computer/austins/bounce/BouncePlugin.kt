package computer.austins.bounce

import computer.austins.bounce.event.ArrowHitEvent
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class BouncePlugin : JavaPlugin() {
    override fun onEnable() {
        registerEvents()
        this.logger.info("Bounce enabled")
    }

    private fun registerEvents() {
        server.pluginManager.registerEvents(ArrowHitEvent(), this)
    }

}

val logger = Bukkit.getPluginManager().getPlugin("Bounce")!!.logger