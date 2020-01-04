package me.aaronlyy.torchfire.main;

import me.aaronlyy.torchfire.listeners.TorchPlaceListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new TorchPlaceListener(), this);
    }
}
