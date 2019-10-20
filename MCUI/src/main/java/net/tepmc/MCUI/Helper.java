package net.tepmc.MCUI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Helper
{

    public static String Colorfy (String Message)
    {
        return ChatColor.translateAlternateColorCodes ('&', Message);
    }

    public static void FillInventory (Inventory Target, ItemStack Stack)
    {
        Stack.getItemMeta ().setDisplayName (" ");

        for (int Index = 0; Index < Target.getSize (); Index++)
        {
            Target.setItem (Index, Stack);
        }
    }

    public static void FillInventory (Inventory Target, Material Type)
    {
        ItemStack Stack = new ItemStack (Type, 1);
        Stack.getItemMeta ().setDisplayName (" ");

        for (int Index = 0; Index < Target.getSize (); Index++)
        {
            Target.setItem (Index, Stack);
        }
    }

}
