package cc.fencegate.plugin.API;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

public abstract class PaidPlugin implements Plugin {
    public File getDataFolder() {
        return null;
    }

    public PluginDescriptionFile getDescription() {
        return null;
    }

    public FileConfiguration getConfig() {
        return null;
    }

    public InputStream getResource(String s) {
        return null;
    }

    public void saveConfig() {

    }

    public void saveDefaultConfig() {

    }

    public void saveResource(String s, boolean b) {

    }

    public void reloadConfig() {

    }

    public PluginLoader getPluginLoader() {
        return null;
    }

    public Server getServer() {
        return null;
    }

    public boolean isEnabled() {
        return false;
    }

    public void onDisable() {

    }

    public void onLoad() {

    }

    public void onEnable() {
        //verification?
    }

    public boolean isNaggable() {
        return false;
    }

    public void setNaggable(boolean b) {

    }

    public ChunkGenerator getDefaultWorldGenerator(String s, String s1) {
        return null;
    }

    public Logger getLogger() {
        return null;
    }

    public String getName() {
        return null;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }

    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }
}
