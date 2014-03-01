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
	public String addRandom(String s){
		return ChatColor.MAGIC + "|||" + ChatColor.RESET + s + ChatColor.RESET + "" + ChatColor.MAGIC + "|||";
	}
	String noperm = ChatColor.RED + "You don't have permission to do this!";
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
			if(args != null && cmd.getName().equalsIgnoreCase("rainbowarmor")){
				//
				//On
				//
				if (args.length == 0){
					if (sender.hasPermission("rainbowarmor.help")){
						sender.sendMessage(ChatColor.MAGIC + "|||" + ChatColor.RESET + "" + ChatColor.GOLD + " RainbowArmor help menu!" + ChatColor.RESET + " " + ChatColor.MAGIC + "|||" );
						sender.sendMessage(ChatColor.GOLD + "/rainbowarmor on self turns rainbow armor on for yourself!");
						sender.sendMessage(ChatColor.GOLD + "/rainbowarmor on all turns rainbow armor on for everyone!");
						sender.sendMessage(ChatColor.GOLD + "/rainbowarmor on (playername) turns rainbowarmor on for the specified player!");
						sender.sendMessage(ChatColor.GOLD + "/rainbowarmor off self turns rainbow armor off for yourself!");
						sender.sendMessage(ChatColor.GOLD + "/rainbowarmor off all turns rainbow armor off for everyone!");
						sender.sendMessage(ChatColor.GOLD + "/rainbowarmor off (playername) turns rainbowarmor off for the specified player!");
						sender.sendMessage(ChatColor.GOLD + "/rainbowarmor storeamor stores your armor!");
						sender.sendMessage(ChatColor.GOLD + "/rainbowarmor revertarmor reverts your armor!");
					return true;
					} else {
						sender.sendMessage(noperm);
						return true;
					}
				} else {
				if(args[0].toLowerCase().equalsIgnoreCase("on") ){
					com.shadowcasted.rainbowarmor.resources1.Main.addPlayerArmor((Player)sender);
					if(args[1].equalsIgnoreCase("self")){
						if (sender.hasPermission("rainbowarmor.self")){
							if (RainbowRunnable1.players.contains(sender.getName()) == false){
						com.shadowcasted.rainbowarmor.resources1.Main.addPlayerArmor((Player)sender);
						RainbowRunnable1.rainbowify(sender.getName());
						return true;
							} else {
								sender.sendMessage(addRandom(ChatColor.GOLD + "You are already wearing rainbow armor!"));
								return true;
							}
						} else {
							sender.sendMessage(noperm);
							return true;
						}
					}else if(args[1].equalsIgnoreCase("all")){
						if (sender.hasPermission("rainbowarmor.all")){
						for (Player p:Bukkit.getOnlinePlayers()){
							if (!RainbowRunnable1.players.contains(p.getName())){
							RainbowRunnable1.rainbowify(p.getName());
							com.shadowcasted.rainbowarmor.resources1.Main.addPlayerArmor(p);
							}
						}
						return true;
						} else {
							sender.sendMessage(noperm);
							return true;
						}
					}else if(isAPlayer(args[1])){
						if (sender.hasPermission("rainbowarmor.others")){
							Player p = Bukkit.getPlayer(args[1]);
							if (p != null){
								if (!RainbowRunnable1.players.contains(p.getName())){
							com.shadowcasted.rainbowarmor.resources1.Main.addPlayerArmor(p);
							RainbowRunnable1.rainbowify(p);
							return true;
								} else {
									sender.sendMessage(addRandom(ChatColor.GOLD + "That player is already wearing rainbow armor!"));
									return true;
								}
							} else {
								sender.sendMessage(addRandom(ChatColor.GOLD + "That player is not online!"));
								return true;
							}
						} else {
							sender.sendMessage(noperm);
							return true;
						}
					} 
				} else if (args[0].equalsIgnoreCase("off")){
					if (args[1].equalsIgnoreCase("self")){
						if (sender.hasPermission("rainbowarmor.self")){
						com.shadowcasted.rainbowarmor.resources1.Main.revertArmor((Player) sender);
						} else {
							sender.sendMessage(noperm);
							return true;
						}
					}
					else if (args[1].equalsIgnoreCase("all")){
						if (sender.hasPermission("rainbowarmor.all")){
						for (Player p: Bukkit.getOnlinePlayers()){
							com.shadowcasted.rainbowarmor.resources1.Main.revertArmor(p);
						}
					} else {
						sender.sendMessage(noperm);
						return true;
					}
					}
					else if (isAPlayer(args[1])){
						if (sender.hasPermission("rainbowarmor.others")){
						com.shadowcasted.rainbowarmor.resources1.Main.revertArmor(Bukkit.getPlayer(args[1]));
						} else {
							sender.sendMessage(noperm);
							return true;
						}
					}
				}else if(args[0].equalsIgnoreCase("StoreArmor")){
					if (sender.hasPermission("rainbowarmor.storearmor")){
					sender.sendMessage("Armor Stored");
					com.shadowcasted.rainbowarmor.resources1.Main.addPlayerArmor((Player)sender);
					} else {
						sender.sendMessage(noperm);
					}
					return true;
				}else if(args[0].equalsIgnoreCase("RevertArmor")){
					if (sender.hasPermission("rainbowarmor.storearmor")){
					sender.sendMessage("Armor Reverted");
					com.shadowcasted.rainbowarmor.resources1.Main.revertArmor((Player)sender);
					return true;
					} else {
						sender.sendMessage(noperm);
						return true;
					}
				} else {
					sender.sendMessage(addRandom(ChatColor.RED + "Invalid usage! Use /rb for help!"));
					return true;
				}
				
				
				//
				//On
				//
				
				return true;
				}
				}
		return false;
	}
	
	public boolean isAPlayer(String playername){if(Bukkit.getPlayer(playername) != null){return true;}else{return false;}}

}
