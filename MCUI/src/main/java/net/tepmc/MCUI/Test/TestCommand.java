package net.tepmc.MCUI.Test;

import net.tepmc.MCUI.Slot;
import net.tepmc.MCUI.Window;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TestCommand implements CommandExecutor
{

    @Override
    public boolean onCommand (CommandSender Sender, Command Command, String Label, String[] Args)
    {
        Window test = new Window ("&aTitle", 6, Material.BLACK_STAINED_GLASS_PANE);
        test.SetItem(0, new Slot (Material.ACACIA_BOAT, "&b&lYeet") {
            @Override
            public void OnClick (ClickType Type, Player Clicker, Inventory TargetInventory, int Slot)
            {
                if (Type.isShiftClick ())
                {
                    Clicker.sendMessage ("hi");
                    ItemStack Stack = TargetInventory.getItem (Slot);
                    assert Stack == this.GetStack ();

                    // TODO: Make something like this work. Maybe make a function in the Window class to update a slot, so like: test.UpdateSlot (this);
                    this.SetAmount (this.GetAmount () + 1);
                }
            }

            @Override
            public void OnLeftClick (ClickType Type, Player Clicker, Inventory TargetInventory, int Slot)
            {

            }

            @Override
            public void OnRightClick (ClickType Type, Player Clicker, Inventory TargetInventory, int Slot)
            {

            }
        });
        test.Show ((Player) Sender);

        return true;
    }

}
