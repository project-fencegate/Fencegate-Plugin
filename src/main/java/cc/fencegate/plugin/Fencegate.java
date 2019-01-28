package cc.fencegate.plugin;

import cc.fencegate.plugin.commands.MainCommand;
import cc.fencegate.plugin.storage.SQLiteStorage;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Fencegate extends JavaPlugin {
    public static Fencegate instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginCommand("fencegate").setExecutor(new MainCommand());


    }

    private void sync_UserData(){

    }

    private  void loadConfig(){
        getDataFolder().mkdirs();
        File f = new File(getDataFolder(), "config.yml");
        if(!f.exists())
            saveDefaultConfig();
        reloadConfig();

        f = new File(getDataFolder()+File.separator+"data"); //plugins storage
        if(!f.exists())
            f.mkdirs();

        new SQLiteStorage("data");
    }
}
