package me.mi0.informationshit.blocks;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BlockUtils
{

    public static List<Block> getVein(Block start, Material type)
    {
        List<Block> blocks = new ArrayList<Block>();
        Stack<Block> unchecked = new Stack<Block>();
        unchecked.push(start);

        World world = start.getWorld();
        Block target = null;
        Block check = null;
        int x, y, z;
        while (!unchecked.isEmpty())
        {
            target = unchecked.pop();
            blocks.add(target);
            x = target.getX() - 1; y = target.getY() - 1; z = target.getZ() - 1;

            for (int xOff = 0; xOff < 3; xOff++)
            {
                for (int yOff = 0; yOff < 3; yOff++)
                {
                    for (int zOff = 0; zOff < 3; zOff++)
                    {
                        check = world.getBlockAt(x + xOff, y + yOff, z + zOff);
                        if (check == target)
                        {
                            continue;
                        }
                        if (check.getType() == type && !blocks.contains(check) && !unchecked.contains(check))
                        {
                            unchecked.push(check);
                        }
                    }
                }
            }
        }

        return blocks;
    }
}
