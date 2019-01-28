package cc.fencegate.plugin;

import cc.fencegate.plugin.commands.MainCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Fencegate extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("fencegate").setExecutor(new MainCommand());
    }
}
