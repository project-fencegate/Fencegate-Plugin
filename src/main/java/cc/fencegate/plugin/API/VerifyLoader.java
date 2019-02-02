package cc.fencegate.plugin.API;

public class VerifyLoader {
	private static boolean hasBeenLoaded = false;
	public static void load() {
		if (!hasBeenLoaded) {
			SecurePlugin.objectList.put("LOAD_COMPLETE", false);
			//TODO 加载
			SecurePlugin.objectList.put("LOAD_COMPLETE", true);
			hasBeenLoaded = true;
		}
	}
}
