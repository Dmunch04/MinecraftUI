package net.tepmc.MCUI;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public interface IWindow extends InventoryHolder
{

    void HandleClick (ClickType Type, Player Clicker, Inventory Target, int Slot);

}
