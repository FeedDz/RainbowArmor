package com.shadowcasted.rainbowarmor.main;

import org.bukkit.plugin.java.JavaPlugin;

import com.shadowcasted.rainbowarmor.commands.RainbowArmor;


public class Main extends JavaPlugin{

	@Override
	public void onEnable(){
		getCommand("rainbowarmor").setExecutor(new RainbowArmor(this));
	}
	
	
	
}
