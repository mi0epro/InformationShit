package me.mi0.informationshit.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener
{

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore())
        {
            event.setJoinMessage(player.getName() + " do syga ne e igral u servero. ZDR!");
            player.sendMessage("Ako mi pipnesh diamantite she ti potrosha rychichkite!");
        }
        else
        {
            event.setJoinMessage(player.getName() + " vlena!");
        }
    }

    @EventHandler
    void onPlayerLeave(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        event.setQuitMessage(player.getName() + " izlena!");
    }

    @EventHandler
    void onPlayerKill(PlayerDeathEvent event)
    {
        Player player = event.getEntity();
        EntityDamageEvent.DamageCause dmgCause = player.getLastDamageCause().getCause();

        switch (dmgCause)
        {
            case FALL:
                event.setDeathMessage("AHHAHAHAHAHAH! " + player.getName() + " si stroshi krakata!");
                break;
            case LAVA:
                event.setDeathMessage(player.getName() + " umre u lava!(q kazal li sym ti da ne kopash nadole)");
                break;
            case FIRE:
                event.setDeathMessage(player.getName() + " izgore...");
                break;
            case VOID:
                event.setDeathMessage(player.getName() + " padna u voida kato nub!");
                break;
            case MAGIC:
                event.setDeathMessage(player.getName() + " beshe ubit ot tymna magiq!");
                break;
            case ENTITY_ATTACK:
                Player killer = player.getKiller();
                if (killer != null)
                {
                    event.setDeathMessage(player.getName() + " beshe porazen ot " + killer.getName());
                }
                break;
        }
    }
}
