package me.aaronlyy.torchfire.main;

import me.aaronlyy.torchfire.listeners.BlockPlaceListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main plugin;

    @Override
    public void onEnable() {

        plugin = this;

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BlockPlaceListener(), this);
    }

    public static Main getPlugin(){
        return plugin;
    }
}
