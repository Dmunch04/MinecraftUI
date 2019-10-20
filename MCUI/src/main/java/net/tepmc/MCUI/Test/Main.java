package net.tepmc.MCUI.Test;

import net.tepmc.MCUI.WindowEventHandler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{

    @Override
    public void onEnable ()
    {
        getCommand ("yeet").setExecutor (new TestCommand ());
        Bukkit.getPluginManager ().registerEvents (new WindowEventHandler (), this);
    }

}
