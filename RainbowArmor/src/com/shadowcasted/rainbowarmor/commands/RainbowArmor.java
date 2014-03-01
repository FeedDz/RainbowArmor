package com.shadowcasted.rainbowarmor.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.shadowcasted.rainbowarmor.runnables.RainbowRunnable1;



public class RainbowArmor implements CommandExecutor{
	
	public Plugin plugin;

	public RainbowArmor(Plugin p){
		plugin = p;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		try{
			if(args != null && cmd.getName().equalsIgnoreCase("rainbowarmor")){
				//
				//On
				//
				
				if(args[0].toLowerCase().equalsIgnoreCase("on") ){
					com.shadowcasted.rainbowarmor.resources1.Main.addPlayerArmor((Player)sender);
					if(args[1].equalsIgnoreCase("self")){
						com.shadowcasted.rainbowarmor.resources1.Main.addPlayerArmor((Player)sender);
						RainbowRunnable1.rainbowify((Player) sender);
					//	new Thread(new RainbowRunnable1((Player)sender)).start();
						return true;
					}else if(args[1].equalsIgnoreCase("all")){
						for (Player p:Bukkit.getOnlinePlayers()){
							com.shadowcasted.rainbowarmor.resources1.Main.addPlayerArmor(p);
							RainbowRunnable1.rainbowify(p);
						}
					}else if(isAPlayer(args[1])){
							Player p = Bukkit.getPlayer(args[1]);
							com.shadowcasted.rainbowarmor.resources1.Main.addPlayerArmor(p);
							RainbowRunnable1.rainbowify(p);
					} else
						sender.sendMessage(ChatColor.RED+"Invalid Parameters of command!");
						return true;
					
				} else if (args[0].equalsIgnoreCase("off")){
					if (args[1].equalsIgnoreCase("self")){
						com.shadowcasted.rainbowarmor.resources1.Main.revertArmor((Player) sender);
					}
					else if (args[1].equalsIgnoreCase("all")){
						for (Player p: Bukkit.getOnlinePlayers()){
							com.shadowcasted.rainbowarmor.resources1.Main.revertArmor(p);
						}
					}
					else if (isAPlayer(args[1])){
						com.shadowcasted.rainbowarmor.resources1.Main.revertArmor(Bukkit.getPlayer(args[1]));
					}
				}else if(args[0].equalsIgnoreCase("StoreArmor")){
					sender.sendMessage("Armor Stored");
					com.shadowcasted.rainbowarmor.resources1.Main.addPlayerArmor((Player)sender);
					return true;
				}else if(args[0].equalsIgnoreCase("RevertArmor")){
					sender.sendMessage("Armor Reverted");
					com.shadowcasted.rainbowarmor.resources1.Main.revertArmor((Player)sender);
					return true;
				}
				
				
				//
				//On
				//
				
				return true;
			}
		
		}catch(Exception e){
			sender.sendMessage(ChatColor.RED+"Command Error!");
			e.printStackTrace();
			return true;
		}
		return false;
	}
	
	public boolean isAPlayer(String playername){if(Bukkit.getPlayer(playername) != null){return true;}else{return false;}}

}
