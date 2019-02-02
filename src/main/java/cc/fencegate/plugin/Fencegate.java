package cc.fencegate.plugin;

import cc.fencegate.plugin.commands.MainCommand;
import cc.fencegate.plugin.util.SQLiteStorage;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * @author FenceGate Studio
 */
public class Fencegate extends JavaPlugin {
    public static Fencegate instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginCommand("fencegate").setExecutor(new MainCommand());

        if (getServer().getPluginManager().isPluginEnabled("Yum")) {
            getLogger().warning("对不起，本插件不兼容Yum，请手动卸载Yum 插件");
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    private void sync_UserData(){

        /*
        Sample data request JSON
        {
          "username": "example@fencegate.cc",
          "uid": "key(different per-server maybe?)",
          "plugins": {
            "plugin1-id": "plugin1 md-5 value",
            "XXXX-XXXX-XXXX-XXXX p2 uuid": "plugin2 md-5 value"
          }
        }


        data return JSON
        {
          "uid": "if uid doesnt match stop",
          "plugins": {
            "plugin1-id": "secret key",
            "plugin2-id": "secret key",
            "plugin3-id": null <- doesnt load plugin3
          }
        }

        the secret key will be used to "unlock" the plugin(all plugins that extend
        SecurePlugin base will be locked and will require an unlock to work.

        unlocking sends the server-id, plugin-uid, md-5, and secret key to server,
        server returns a value that allows the plugin's onEnable() to be called.
         */
    }

    private  void loadConfig(){
        getDataFolder().mkdirs();
        File f = new File(getDataFolder(), "config.yml");
        if(!f.exists())
            saveDefaultConfig();
        reloadConfig();

        f = new File(getDataFolder() + File.separator + "data"); //plugins util
        if(!f.exists())
            f.mkdirs();

        new SQLiteStorage("data");
    }
}
