package cc.fencegate.plugin.util.encrypt;

import cc.fencegate.plugin.FenceGate;
import cc.fencegate.plugin.local.lang.Language;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;

public class ZIPEncryptor {
    private static ZipFile data;
    private String k = null;

    public ZIPEncryptor(String file, String key) {
        try {
            data = new ZipFile(new File(FenceGate.instance.getDataFolder(), file));
            k = key;
        } catch (ZipException e) {
            FenceGate.instance.getLogger().info(Language.ENCRYPT_DATAFETCH_FAIL);
            e.printStackTrace();
        }
    }

    public File getFile() {
        return null;
    }

    public File saveFile() {
        return null;
    }

    public File getPlugin(String pluginName) {
        return null;
    }

    public void save_ALL() {

    }
}
