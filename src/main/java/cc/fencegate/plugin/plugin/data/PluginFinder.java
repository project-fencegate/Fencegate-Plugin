package cc.fencegate.plugin.plugin.data;

import cc.fencegate.plugin.FenceGate;
import cc.fencegate.plugin.util.MD5Util;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class PluginFinder {
	private static final String PLUGIN_DIR = ".//plugins//FenceGate//";
	private static final String FILE_SUFFIX = ".zip";
	private static final String REQUEST_STRING = "request_download";
	public static HashMap<String,Object> requestFindJob() {
		HashMap<String,Object> mapRequested = new HashMap<String, Object>();
		List<String> pluginKnown = FenceGate.config.getStringList("plugins");
		for (String plugin : pluginKnown) {
			File targetFile = new File(PLUGIN_DIR + plugin + FILE_SUFFIX);
			if (!targetFile.exists()) {
				mapRequested.put(plugin, REQUEST_STRING);
				continue;
			}
			mapRequested.put(plugin, MD5Util.getMD5Three(targetFile.getPath()));
		}
		return mapRequested;
	}
}
