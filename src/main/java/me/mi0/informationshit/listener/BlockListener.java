package me.mi0.informationshit.listener;

import me.mi0.informationshit.InformationShit;
import me.mi0.informationshit.TypeManager;
import me.mi0.informationshit.blocks.BlockUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;

import java.util.*;

public class BlockListener implements Listener
{
    Map<UUID, List<Block>> lastVein = new HashMap<UUID, List<Block>>();

    @EventHandler
    void onBlockBreak(BlockBreakEvent event)
    {
        TypeManager manager = InformationShit.instance.getTypeManager();

        if (!manager.contains(event.getBlock().getType()))
        {
            return;
        }

        Player player = event.getPlayer();
        Block block = event.getBlock();
        Material type = block.getType();

        List<Block> lastVeinObj = lastVein.get(player.getUniqueId());
        if (lastVeinObj != null && lastVeinObj.contains(block))
        {
            lastVeinObj.remove(block);
            if (!lastVeinObj.isEmpty())
            {
                lastVein.replace(player.getUniqueId(), lastVeinObj);
                return;
            }
            lastVein.remove(player);
            return;
        }

        List<Block> vein = BlockUtils.getVein(block, type);

        Collection<Player> onlinePlayers = (Collection<Player>) Bukkit.getOnlinePlayers();
        for (Player target : onlinePlayers)
        {
            if (InformationShit.instance.stoppedPlayers.contains(target.getUniqueId()))
            {
                continue;
            }
            target.sendMessage(ChatColor.GREEN + player.getName() + ChatColor.YELLOW + " found " +
                    ChatColor.RED + getProperTypeName(type) + ChatColor.YELLOW + " vein! Size " + ChatColor.RED + vein.size());
        }

        vein.remove(block);
        lastVein.put(player.getUniqueId(), vein);
    }

    private String getProperTypeName(Material type)
    {
        return type.toString().replaceAll("_", " ").toLowerCase();
    }
}
