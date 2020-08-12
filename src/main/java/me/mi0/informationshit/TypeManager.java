package me.mi0.informationshit;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class TypeManager
{
    List<Material> materialList = null;

    public TypeManager()
    {
        materialList = new ArrayList<Material>();
        materialList.add(Material.DIAMOND_ORE);
    }

    public void addType(Material type)
    {
        if (materialList.contains(type))
        {
            return;
        }

        materialList.add(type);
    }

    public void removeType(Material type)
    {
        materialList.remove(type);
    }

    public boolean contains(Material type)
    {
        return materialList.contains(type);
    }

    public static void init(TypeManager obj)
    {
        obj.addType(Material.DIAMOND_ORE);
        obj.addType(Material.EMERALD_ORE);
        obj.addType(Material.IRON_ORE);
        obj.addType(Material.GOLD_ORE);
        obj.addType(Material.LAPIS_ORE);
        obj.addType(Material.REDSTONE_ORE);
        obj.addType(Material.NETHER_GOLD_ORE);
        obj.addType(Material.ANCIENT_DEBRIS);
    }
}
