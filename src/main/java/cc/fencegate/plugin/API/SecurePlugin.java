package cc.fencegate.plugin.API;

import cc.fencegate.plugin.util.UnsafeLoadedException;
import org.bukkit.plugin.java.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;

public abstract class SecurePlugin extends JavaPlugin {
    private static final String RESOURCE_PATH = ".//plugins//FenceGate//resources//";
    private static final HashMap<String,SecurePlugin> pluginList = new HashMap<String, SecurePlugin>();
    protected static final HashMap<String,Object> objectList = new HashMap<String, Object>();
    private static Field dataFolderField;

    static {
        objectList.put("LOAD_COMPLETE", false);
        try {
            dataFolderField = JavaPlugin.class.getDeclaredField("dataFolder");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        dataFolderField.setAccessible(true);
    }

    public SecurePlugin() {
        super();
        if ((Boolean)objectList.get("LOAD_COMPLETE") && pluginList.containsKey(this.getName())) {
            throw new UnsafeLoadedException("Fucking hack!");
        }
        pluginList.put(this.getName(), this);
        try {
            File folderPath = new File(".//plugins//" + this.getName());
            dataFolderField.set(this, folderPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public InputStream getResource(String name) {
        File resourceFile = new File(RESOURCE_PATH + name);
        if (!resourceFile.exists()) {
            return null;
        }
        try {
            return new FileInputStream(resourceFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
