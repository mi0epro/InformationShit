package me.mi0.informationshit;

import me.mi0.informationshit.executors.InvSeeCommandExecutor;
import me.mi0.informationshit.executors.StopInfoCommandExecutor;
import me.mi0.informationshit.listener.BlockListener;
import me.mi0.informationshit.listener.ExplosionListener;
import me.mi0.informationshit.listener.PlayerListener;
import me.mi0.informationshit.listener.TreeBlockListener;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class InformationShit extends JavaPlugin
{
    public static InformationShit instance = null;

    TypeManager typeManager = null;
    public List<UUID> stoppedPlayers = new ArrayList<UUID>();

    @Override
    public void onEnable()
    {
        instance = this;
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
//        getServer().getPluginManager().registerEvents(new TreeBlockListener(), this);
//        getServer().getPluginManager().registerEvents(new ExplosionListener(), this);


        typeManager = new TypeManager();
        TypeManager.init(typeManager);

        getCommand("stopinfo").setExecutor(new StopInfoCommandExecutor());
        getCommand("invsee").setExecutor(new InvSeeCommandExecutor());
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }

    public TypeManager getTypeManager()
    {
        return typeManager;
    }
}
