package cc.fencegate.plugin.API;

import cc.fencegate.plugin.plugin.SecurePluginLoad;

public class VerifyLoader {
	private static boolean hasBeenLoaded = false;
	public static void load() {
		if (!hasBeenLoaded) {
			SecurePlugin.objectList.put("WILL_LOAD", true);
			SecurePlugin.objectList.put("LOAD_COMPLETE", false);
			SecurePlugin.objectList.put("WILL_LOAD2", false);
			SecurePluginLoad.loadAll();
			SecurePlugin.objectList.put("LOAD_COMPLETE", true);
			SecurePlugin.objectList.put("WILL_LOAD2", false);
			SecurePlugin.objectList.put("WILL_LOAD", false);
			hasBeenLoaded = true;
		}
	}
}