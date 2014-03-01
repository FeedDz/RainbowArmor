package com.shadowcasted.rainbowarmor.resources1;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Main {

	
	private static HashMap<Player, ArmorSet> StoredArmor = new HashMap<Player, ArmorSet>();
	
	
	public static HashMap<Player, ArmorSet> getArmorMap(){return StoredArmor;}
	
	//@Deprecated
	public static void addPlayerArmor(Player player, ArmorSet a){
		if(!StoredArmor.containsKey(player)){
			StoredArmor.put(player, a);
			
		}
	}
	public static void addPlayerArmor(Player player){
		if(!StoredArmor.containsKey(player)){
			StoredArmor.put(player, new ArmorSet(player));
			try{
				player.getInventory().setArmorContents(new ItemStack[]{(new ItemStack(Material.AIR,1)),(new ItemStack(Material.AIR,1)),(new ItemStack(Material.AIR,1)),(new ItemStack(Material.AIR,1)) });
			}catch(Exception e){System.out.println("Failed to remove armor");}
		}else{
			removePlayerArmor(player);
			StoredArmor.put(player, new ArmorSet(player));
			try{
				player.getInventory().setArmorContents(new ItemStack[]{(new ItemStack(Material.AIR,1)),(new ItemStack(Material.AIR,1)),(new ItemStack(Material.AIR,1)),(new ItemStack(Material.AIR,1)) });
			}catch(Exception e){System.out.println("Failed to remove armor");}
		}
	}
	public static void removePlayerArmor(Player player){
		if(StoredArmor.containsKey(player)){
			StoredArmor.remove(player);
		}
	}
	
	public static void revertArmor(Player player){
		if(StoredArmor.containsKey(player)){
			ArmorSet atemp = StoredArmor.get(player);
			atemp.revertArmor();
		}else
			player.sendMessage("Sorry but you don't have any stored armor");
	}
	
	
	
	
	
}
