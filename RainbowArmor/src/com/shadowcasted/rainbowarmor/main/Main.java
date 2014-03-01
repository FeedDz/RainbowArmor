package com.shadowcasted.rainbowarmor.main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
	@Override
	public void onEnable(){
		getCommand("rainbowarmor").setExecutor(new com.shadowcasted.rainbowarmor.commands.RainbowArmor(this));
	}
	@Override
	public void onDisable(){
		for (Player p: Bukkit.getOnlinePlayers()){
			com.shadowcasted.rainbowarmor.resources1.Main.revertArmor(p);
		}
	}
	
	
}
