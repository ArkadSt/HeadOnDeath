package org.arkadst.headondeath;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;


public class EventListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        Player player = event.getEntity();
        Player killer = player.getKiller();

        if (killer != null) {
            if (player.getLastDamageCause().getCause() == DamageCause.ENTITY_ATTACK) {
                switch (killer.getInventory().getItemInMainHand().getType()) {
                    case WOODEN_SWORD:
                    case STONE_SWORD:
                    case IRON_SWORD:
                    case GOLDEN_SWORD:
                    case DIAMOND_SWORD:
                    case NETHERITE_SWORD:
                    case WOODEN_AXE:
                    case STONE_AXE:
                    case IRON_AXE:
                    case GOLDEN_AXE:
                    case DIAMOND_AXE:
                    case NETHERITE_AXE:
                        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                        SkullMeta skull_meta = (SkullMeta) head.getItemMeta();
                        skull_meta.setOwningPlayer(player);
                        head.setItemMeta(skull_meta);
                        event.getDrops().add(head);
                        break;
                }

            }
        }
    }
}
