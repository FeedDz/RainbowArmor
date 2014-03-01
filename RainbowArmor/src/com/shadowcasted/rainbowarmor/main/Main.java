package com.shadowcasted.rainbowarmor.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.shadowcasted.rainbowarmor.events.Click;
import com.shadowcasted.rainbowarmor.events.Leave;
import com.shadowcasted.rainbowarmor.runnables.RainbowRunnable1;


public class Main extends JavaPlugin{
	@Override
	public void onEnable(){
		getCommand("rainbowarmor").setExecutor(new com.shadowcasted.rainbowarmor.commands.RainbowArmor(this));
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new RainbowRunnable1(), 10L, 1L);
		Bukkit.getPluginManager().registerEvents(new Leave(), this);
		Bukkit.getPluginManager().registerEvents(new Click(), this);
	}
	@Override
	public void onDisable(){
		for (Player p: Bukkit.getOnlinePlayers()){
			com.shadowcasted.rainbowarmor.resources1.Main.revertArmor(p);
		}
	}
	
	
}
