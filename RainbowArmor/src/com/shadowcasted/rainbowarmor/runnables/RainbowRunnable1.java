package com.shadowcasted.rainbowarmor.runnables;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.MaterialData;

public class RainbowRunnable1 implements Runnable{

	
	public RainbowRunnable1(Player p){
		player = p;
	}
	public RainbowRunnable1(String name){
		this(Bukkit.getPlayer(name));
	}

	private Player player;
	public void run() {
		System.out.println("STarted Thread");
		// TODO Auto-generated method stub
		player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET,1));
		ItemStack i = player.getInventory().getHelmet();
		LeatherArmorMeta m = (LeatherArmorMeta)i.getItemMeta();
		while(true){
			try{
				if(player.getInventory().getHelmet().getType() != Material.LEATHER_HELMET){break;}
				m.setColor(Color.fromRGB(r, g, b));
				player.getInventory().getHelmet().setItemMeta(m);
				nextRGB();
				Thread.sleep(10);
			}catch(Exception e){/*CleanUpArmor*/break;}
		}
		System.out.println("Thread Died");
		
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
	

