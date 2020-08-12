package me.mi0.informationshit.listener;

import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class ExplosionListener implements Listener
{
    @EventHandler
    void onBlockPlace(BlockPlaceEvent event)
    {
        Material type = event.getBlock().getType();
        if (type == Material.TNT)
        {
            event.setCancelled(true);
            event.getPlayer().kickPlayer("Bez tnt-ta");
        }
    }

    @EventHandler
    void onTntExplode(ExplosionPrimeEvent event)
    {
        if (event.getEntity() instanceof Creeper)
        {
            return;
        }
        event.setCancelled(true);
    }
}
