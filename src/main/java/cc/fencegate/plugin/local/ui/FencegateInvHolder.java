package cc.fencegate.plugin.local.ui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * Used for recognizing and cancelling events operated on Fencegate-UI
 *
 * @author berry64
 * @see org.bukkit.inventory.InventoryHolder
 */
public class FencegateInvHolder implements InventoryHolder {

    /**
     * This method is here for the sake of implementing the InventoryHolder Class
     * @see InventoryHolder
     *
     * @deprecated The inventory contains nothing
     * @return Returns a dummy inventory to prevent most plugins from crashing
     */
    public Inventory getInventory() {
        return Bukkit.createInventory(this, 81, "Dummy-UI");
    }
}