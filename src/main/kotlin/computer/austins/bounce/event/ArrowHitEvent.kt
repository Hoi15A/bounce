package computer.austins.bounce.event

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.entity.Arrow
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ProjectileHitEvent
import org.bukkit.util.Vector

class ArrowHitEvent : Listener {

    @EventHandler
    private fun onArrowHit(e: ProjectileHitEvent) {
        if (e.entity.type != EntityType.ARROW) return
        val arrow = e.entity as Arrow
        val velocity = arrow.velocity
        velocity.multiply(Vector(-1.0, -1.0, -1.0))
        velocity.multiply(0.8)
        val speed = velocity.length()

        if (speed <= 0.5) {
            Bukkit.broadcast(Component.text("Too slow"))
            return
        }

        val hitLocation = arrow.location
        val world = hitLocation.world

        val newArrow = world.spawnArrow(hitLocation, velocity, speed.toFloat(), 0F)

        newArrow.shooter = arrow.shooter

        arrow.remove()

        Bukkit.broadcast(Component.text("Arrow Hit"))
    }

}