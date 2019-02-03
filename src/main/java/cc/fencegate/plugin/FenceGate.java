package cc.fencegate.plugin;

import cc.fencegate.plugin.API.VerifyLoader;
import cc.fencegate.plugin.local.commands.MainCommand;
import cc.fencegate.plugin.plugin.data.PluginFinder;
import cc.fencegate.plugin.util.HttpsUtil;
import cc.fencegate.plugin.util.SQLiteStorage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.util.HashMap;

/**
 * @author The FenceGate Team
 */
public class FenceGate extends JavaPlugin {
    public static FenceGate instance;
    public static FileConfiguration config;
    private static final String REQUEST_URL = "unknown";
    private static final HttpsUtil utilInstance = new HttpsUtil();

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginCommand("fencegate").setExecutor(new MainCommand());
        if (getServer().getPluginManager().isPluginEnabled("Yum")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "yum delete yum");
            Bukkit.getLogger().info(">> 我们发现了一个Bug并帮您解决了.原因: Yum的存在.");
        }
        Bukkit.getLogger().info(">> 正在同步你的插件数据中...");
        sync_UserData();
        Bukkit.getLogger().info(">> 同步完成!");
        Bukkit.getLogger().info(">> 开始加载插件数据...");
        VerifyLoader.load();
        Bukkit.getLogger().info(">> 加载完成!");
        saveDefaultConfig();
        config = getConfig();
    }

    private void sync_UserData() {
        String outJson = null;
        HashMap<String,Object> jsonGenMap = new HashMap<String, Object>();
        jsonGenMap.put("username", config.getString("login-credentials.username"));
        jsonGenMap.put("uid", config.getString("login-credentials.key"));
        HashMap<String,Object> pluginMD5Map = PluginFinder.requestFindJob();
        jsonGenMap.put("plugins", pluginMD5Map);
        outJson = JSON.toJSONString(jsonGenMap);
        JSONObject jsonRespond = utilInstance.getJSON(REQUEST_URL, "GET", outJson);
        /**
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
