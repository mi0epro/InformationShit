package me.mi0.informationshit.executors;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvSeeCommandExecutor implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!sender.hasPermission("infoshit.invsee"))
        {
            return false;
        }

        if (!(sender instanceof Player))
        {
            sender.sendMessage("Only players can use this command!");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);
        Player player = (Player) sender;
        if (target == null)
        {
            return false;
        }

        player.openInventory(target.getInventory());
        return true;
    }
}
