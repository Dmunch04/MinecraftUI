package net.tepmc.MCUI;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class Slot
{

    private static ItemStack Stack;
    private static Material Type;
    private static int Amount;
    private static String Title;

    public Slot (ItemStack Stack)
    {
        this.Stack = Stack;
        this.Type = Stack.getType ();
        this.Amount = Stack.getAmount ();
        this.Title = Stack.getItemMeta ().getDisplayName ();
    }

    public Slot (ItemStack Stack, int Amount)
    {
        this.Stack = Stack;
        this.Type = Stack.getType ();
        this.Amount = Amount;
        this.Title = Stack.getItemMeta ().getDisplayName ();

        this.Stack.setAmount (Amount);
    }

    public Slot (ItemStack Stack, String Title)
    {
        this.Stack = Stack;
        this.Type = Stack.getType ();
        this.Amount = Stack.getAmount ();
        Title = Helper.Colorfy (Title);
        this.Title = Title;

        this.Stack.setAmount (Amount);
        Stack.getItemMeta ().setDisplayName (Title);
    }

    public Slot (Material Type)
    {
        this.Stack = new ItemStack (Type, 1);
        this.Type = Type;
        this.Amount = Stack.getAmount ();
        this.Title = Stack.getItemMeta ().getDisplayName ();
    }

    public Slot (Material Type, int Amount)
    {
        this.Stack = new ItemStack (Type, Amount);
        this.Type = Type;
        this.Amount = Amount;
        this.Title = Stack.getItemMeta ().getDisplayName ();
    }

    public Slot (Material Type, String Title)
    {
        this.Stack = new ItemStack (Type, Amount);
        this.Type = Type;
        this.Amount = Stack.getAmount ();
        Title = Helper.Colorfy (Title);
        this.Title = Title;

        Stack.getItemMeta ().setDisplayName (Title);
    }

    public abstract void OnClick (ClickType Type, Player Clicker, Inventory TargetInventory, int Slot);
    public abstract void OnLeftClick (ClickType Type, Player Clicker, Inventory TargetInventory, int Slot);
    public abstract void OnRightClick (ClickType Type, Player Clicker, Inventory TargetInventory, int Slot);

    public ItemStack GetStack ()
    {
        return this.Stack;
    }

    public void SetStack (ItemStack Value)
    {
        Stack = Value;
        Type = Value.getType ();
        Amount = Value.getAmount ();
    }

    public Material GetType ()
    {
        return this.Type;
    }

    public void SetType (Material Value)
    {
        Stack = new ItemStack (Value, Amount);
        Type = Value;
    }

    public int GetAmount ()
    {
        return this.Amount;
    }

    public void SetAmount (int Value)
    {
        Stack.setAmount (Value);
        Amount = Value;
    }

    public String GetTitle ()
    {
        return this.Title;
    }

    public void SetTitle (String Value)
    {
        Value = Helper.Colorfy (Value);
        Stack.getItemMeta ().setDisplayName (Value);
        Title = Value;
    }

}
