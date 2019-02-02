package cc.fencegate.plugin.util;

public class UnsafeLoadedException extends IllegalArgumentException {
	public UnsafeLoadedException(String reason) {
		super(reason);
	}
}
