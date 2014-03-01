package com.shadowcasted.rainbowarmor.runnables;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class RainbowRunnable1 extends BukkitRunnable{
public static ArrayList<String> players = new ArrayList<String>();
	public static void rainbowify(Player p){
		players.add(p.getName());
		p.sendMessage(ChatColor.MAGIC + "|||" + ChatColor.RESET + "" + ChatColor.GOLD + "You are now wearing rainbow armor!" +ChatColor.RESET + ""+ ChatColor.MAGIC + "|||");
	}
	public static void rainbowify(String s){
		players.add(s);
		Bukkit.getPlayer(s).sendMessage(ChatColor.MAGIC + "|||" + ChatColor.RESET + "" + ChatColor.GOLD + "You are now wearing rainbow armor!" +ChatColor.RESET + ""+ ChatColor.MAGIC + "|||");
	}
	public void run() {
		// TODO Auto-generated method stub
		for (String s: players){
			Player player = Bukkit.getPlayer(s);
			if (player != null){
		player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET,1));
		player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE,1));
		player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS,1));
		player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS,1));
		ItemStack i = player.getInventory().getHelmet();
		LeatherArmorMeta m = (LeatherArmorMeta)i.getItemMeta();
				if(player.getInventory().getHelmet().getType() != Material.LEATHER_HELMET){}
				if(player.getInventory().getChestplate().getType() != Material.LEATHER_CHESTPLATE){}
				if(player.getInventory().getBoots().getType() != Material.LEATHER_BOOTS){}
				if(player.getInventory().getLeggings().getType() != Material.LEATHER_LEGGINGS){}
				m.setColor(Color.fromRGB(r, g, b));
				player.getInventory().getHelmet().setItemMeta(m);
				player.getInventory().getBoots().setItemMeta(m);
				player.getInventory().getChestplate().setItemMeta(m);
				player.getInventory().getLeggings().setItemMeta(m);
				nextRGB();
		}
		}
	}

	private int r=255;
	  private int g=0;
	  private int b=0;
	  private void nextRGB()
	  {
	    if ( r == 255 && g < 255 && b == 0 )
	      {
	      g++;
	      }
	    if ( g == 255 && r > 0 && b == 0 )
	      {
	      r--;
	      }
	    if ( g == 255 && b < 255 && r == 0 )
	      {
	      b++;
	      }
	    if ( b == 255 && g > 0 && r == 0 )
	      {
	      g--;
	      }
	    if ( b == 255 && r < 255 && g == 0 )
	      {
	      r++;
	      }
	    if ( r == 255 && b > 0 && g == 0 )
	      {
	      b--;
	      }
	  }
	  
}
	
	
	//Bukkit.getScheduler().registerSychRepeatingTask(plugin, task (this), delay, intervals);
	

