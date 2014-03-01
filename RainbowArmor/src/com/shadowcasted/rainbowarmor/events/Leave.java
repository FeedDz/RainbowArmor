package com.shadowcasted.rainbowarmor.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.shadowcasted.rainbowarmor.runnables.RainbowRunnable1;

public class Leave implements Listener{
@EventHandler
public void quit(PlayerQuitEvent e){
	for (Player p:Bukkit.getOnlinePlayers()){
		if (RainbowRunnable1.players.contains(p.getName())){
			com.shadowcasted.rainbowarmor.resources1.Main.revertArmor(p);
		}
		if (com.shadowcasted.rainbowarmor.resources1.Main.getArmorMap().keySet().contains(p.getName())){
			com.shadowcasted.rainbowarmor.resources1.Main.revertArmor(p);
		}
	}
}
}
