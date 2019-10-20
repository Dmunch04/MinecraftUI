package net.tepmc.MCUI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryDragEvent;

public class WindowEventHandler implements Listener
{

    @EventHandler
    public void onInventoryDrag (InventoryDragEvent Event)
    {
        if (Event.getInventory ().getHolder () instanceof IWindow)
        {
            Event.setCancelled (true);
        }
    }

    @EventHandler
    public void onInventoryClick (InventoryClickEvent Event)
    {
        if (Event.getInventory ().getHolder () instanceof IWindow)
        {
            Event.setCancelled (true);
            IWindow GUI = (IWindow) Event.getInventory ().getHolder ();
            GUI.HandleClick (Event.getClick (), (Player) Event.getWhoClicked (), Event.getInventory (), Event.getRawSlot ());
        }
    }

}
