package me.mi0.informationshit.listener;

import me.mi0.informationshit.blocks.BlockUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Arrays;
import java.util.List;

public class TreeBlockListener implements Listener
{
    Material[] woodMaterials = {
            Material.OAK_LOG,
            Material.ACACIA_LOG,
            Material.BIRCH_LOG,
            Material.DARK_OAK_LOG,
            Material.JUNGLE_LOG,
            Material.SPRUCE_LOG
    };

    @EventHandler
    void onBlockBreak(BlockBreakEvent event)
    {
        Block block = event.getBlock();
        Material type = block.getType();

        if (!Arrays.asList(woodMaterials).contains(type))
        {
            return;
        }

        World world = block.getWorld();
        Player player = event.getPlayer();
        PlayerInventory inv = player.getInventory();
        ItemStack itemStack = inv.getItemInMainHand();
        if (!itemStack.getType().toString().endsWith("AXE"))
        {
            return;
        }

        List<Block> trees = BlockUtils.getVein(block, type);
        for (Block tree : trees)
        {
            tree.breakNaturally(itemStack);
        }
        player.sendMessage(ChatColor.YELLOW + "You broke " + ChatColor.RED + trees.size() + ChatColor.YELLOW + " logs!");
    }
}
