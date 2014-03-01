package rb.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import rb.runnables.RainbowRunnable1;


public class RainbowArmor implements CommandExecutor{
	
	public Plugin plugin;

	public RainbowArmor(Plugin p){
		plugin = p;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		try{
			if(args != null && cmd.getName().equalsIgnoreCase("rainbowarmor")){
				sender.sendMessage("RainbowArmorStuff");
				//
				//On
				//
				
				if(args[0].toLowerCase().equalsIgnoreCase("on") ){
					rb.resources1.Main.addPlayerArmor((Player)sender);
					if(args[1].equalsIgnoreCase("self")){
						//rainbowify(sender);
						rb.resources1.Main.addPlayerArmor((Player)sender);
						//Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new RainbowRunnable1((Player)sender), 1L, 10L);
						new Thread(new RainbowRunnable1((Player)sender)).start();
						return true;
					}else if(args[1].equalsIgnoreCase("all")){
						//rainbowall();
					}else if(isAPlayer(args[1])){
						//rainbowify(player);
					}else
						sender.sendMessage(ChatColor.RED+"Invalid Parameters of Plugin!");
						return true;
					
				}else if(args[0].equalsIgnoreCase("StoreArmor")){
					sender.sendMessage("Armor Stored");
					rb.resources1.Main.addPlayerArmor((Player)sender);
					return true;
				}else if(args[0].equalsIgnoreCase("RevertArmor")){
					sender.sendMessage("Armor Reverted");
					rb.resources1.Main.revertArmor((Player)sender);
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
