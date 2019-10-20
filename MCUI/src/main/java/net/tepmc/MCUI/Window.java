package net.tepmc.MCUI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class Window implements IWindow
{

    private static Inventory GUI = null;

    private static Map<Integer, Slot> Items = new HashMap<Integer, Slot> ();

    private static String Title = Helper.Colorfy ("&a&lWindow");
    private static int Rows = 6;
    private static Material Background = Material.BLACK_STAINED_GLASS_PANE;

    public Window () { }

    public Window (String Title)
    {
        this.Title = Helper.Colorfy (Title);

        this.GUI = Bukkit.createInventory (null, this.Rows * 9, this.Title);
    }

    public Window (String Title, int Rows)
    {
        this.Title = Helper.Colorfy (Title);
        this.Rows = Rows;

        this.GUI = Bukkit.createInventory (null, Rows * 9, this.Title);
    }

    public Window (String Title, int Rows, Material Background)
    {
        this.Title = Helper.Colorfy (Title);
        this.Rows = Rows;
        this.Background = Background;

        this.GUI = Bukkit.createInventory (this, Rows * 9, this.Title);
    }

    @Override
    public Inventory getInventory ()
    {
        return this.GUI;
    }

    @Override
    public void HandleClick (ClickType Type, Player Clicker, Inventory Target, int Slot)
    {
        if (Items.containsKey (Slot))
        {
            Slot Item = Items.get (Slot);
            Item.OnClick (Type, Clicker, Target, Slot);

            if (Type.isLeftClick ())
            {
                Item.OnLeftClick (Type, Clicker, Target, Slot);
            }

            else if (Type.isRightClick ())
            {
                Item.OnRightClick (Type, Clicker, Target, Slot);
            }
        }
    }

    public void Show (Player Target)
    {
        Helper.FillInventory (this.GUI, Background);

        for (int Index = 0; Index < Items.size (); Index++)
        {
            Slot Item = Items.get (Index);
            GUI.setItem (Index, Item.GetStack ());
        }

        Target.openInventory (GUI);
    }

    public void SetItem (int Slot, Slot Item)
    {
        Items.put (Slot, Item);
    }

    public boolean HasItem (Slot Item)
    {
        if (Items.containsValue (Item)) return true;

        return false;
    }

    public boolean HasItem (int Slot)
    {
        if (Items.containsKey (Slot)) return true;

        return false;
    }

    public boolean HasItem (ItemStack Stack)
    {
        for (Slot Value : Items.values ())
        {
            if (Value.GetStack ().equals (Stack)) return true;
        }

        return false;
    }

    public boolean HasItem (Material Type)
    {
        for (Slot Value : Items.values ())
        {
            if (Value.GetType ().equals (Type)) return true;
        }

        return false;
    }

    @Nullable
    public Slot GetItem (Slot Item)
    {
        for (Slot Value : Items.values ())
        {
            if (Value.equals (Item)) return Value;
        }

        return null;
    }

    @Nullable
    public Slot GetItem (int Slot)
    {
        return Items.get (Slot);
    }

    @Nullable
    public Slot GetItem (ItemStack Stack)
    {
        for (Slot Value : Items.values ())
        {
            if (Value.GetStack ().equals (Stack)) return Value;
        }

        return null;
    }

    @Nullable
    public Slot GetItem (Material Type)
    {
        for (Slot Value : Items.values ())
        {
            if (Value.GetType ().equals (Type)) return Value;
        }

        return null;
    }

}
