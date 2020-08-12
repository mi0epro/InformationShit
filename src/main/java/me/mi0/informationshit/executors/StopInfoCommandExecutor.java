package me.mi0.informationshit.executors;

import me.mi0.informationshit.InformationShit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class StopInfoCommandExecutor implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage("Only players can use this command");
            return false;
        }

        Player player = (Player) sender;
        List<UUID> list = InformationShit.instance.stoppedPlayers;
        if (list.contains(player.getUniqueId()))
        {
            list.remove(player.getUniqueId());
            player.sendMessage("Information on!");
        }
        else
        {
            list.add(player.getUniqueId());
            player.sendMessage("Information off!");
        }

        return true;
    }
}
