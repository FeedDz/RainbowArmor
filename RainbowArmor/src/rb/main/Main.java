package rb.main;

import org.bukkit.plugin.java.JavaPlugin;

import rb.commands.RainbowArmor;

public class Main extends JavaPlugin{

	@Override
	public void onEnable(){
		getCommand("rainbowarmor").setExecutor(new RainbowArmor(this));
	}
	
	
	
}
