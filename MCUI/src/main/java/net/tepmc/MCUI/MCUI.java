package net.tepmc.MCUI;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MCUI extends JavaPlugin
{

    public static MCUI Instance;

    @Override
    public void onEnable ()
    {
        Instance = this;

        Bukkit.getPluginManager ().registerEvents (new WindowEventHandler (), this);
    }

}
