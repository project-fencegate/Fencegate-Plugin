package cc.fencegate.plugin.plugins;

import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.*;

import java.io.File;
import java.util.Set;

public class PluginLoader implements PluginManager {
    public void registerInterface(Class<? extends org.bukkit.plugin.PluginLoader> aClass) throws IllegalArgumentException {

    }

    public Plugin getPlugin(String s) {
        return null;
    }

    public Plugin[] getPlugins() {
        return new Plugin[0];
    }

    public boolean isPluginEnabled(String s) {
        return false;
    }

    public boolean isPluginEnabled(Plugin plugin) {
        return false;
    }

    public Plugin loadPlugin(File file) throws InvalidPluginException, InvalidDescriptionException, UnknownDependencyException {
        return null;
    }

    public Plugin[] loadPlugins(File file) {
        return new Plugin[0];
    }

    public void disablePlugins() {

    }

    public void clearPlugins() {

    }

    public void callEvent(Event event) throws IllegalStateException {

    }

    public void registerEvents(Listener listener, Plugin plugin) {

    }

    public void registerEvent(Class<? extends Event> aClass, Listener listener, EventPriority eventPriority, EventExecutor eventExecutor, Plugin plugin) {

    }

    public void registerEvent(Class<? extends Event> aClass, Listener listener, EventPriority eventPriority, EventExecutor eventExecutor, Plugin plugin, boolean b) {

    }

    public void enablePlugin(Plugin plugin) {

    }

    public void disablePlugin(Plugin plugin) {

    }

    public Permission getPermission(String s) {
        return null;
    }

    public void addPermission(Permission permission) {

    }

    public void removePermission(Permission permission) {

    }

    public void removePermission(String s) {

    }

    public Set<Permission> getDefaultPermissions(boolean b) {
        return null;
    }

    public void recalculatePermissionDefaults(Permission permission) {

    }

    public void subscribeToPermission(String s, Permissible permissible) {

    }

    public void unsubscribeFromPermission(String s, Permissible permissible) {

    }

    public Set<Permissible> getPermissionSubscriptions(String s) {
        return null;
    }

    public void subscribeToDefaultPerms(boolean b, Permissible permissible) {

    }

    public void unsubscribeFromDefaultPerms(boolean b, Permissible permissible) {

    }

    public Set<Permissible> getDefaultPermSubscriptions(boolean b) {
        return null;
    }

    public Set<Permission> getPermissions() {
        return null;
    }

    public boolean useTimings() {
        return false;
    }
}
