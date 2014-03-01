package com.shadowcasted.rainbowarmor.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;

import com.shadowcasted.rainbowarmor.runnables.RainbowRunnable1;

public class Click implements Listener{
@EventHandler
public void click(InventoryClickEvent e){
	if (RainbowRunnable1.players.contains(e.getWhoClicked().getName())){
		if (e.getSlotType() == SlotType.ARMOR){
			e.setCancelled(true);
			((Player) e.getWhoClicked()).sendMessage(ChatColor.GOLD + "You can't do that while you are wearing rainbow armor!");
		}
	}
}
}
