package rb.resources1;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ArmorSet {

	ItemStack[] armorset;
	public Player player;

	@Deprecated
	public ArmorSet(Player p, ItemStack[] a){
		player = p;
		armorset = a;
	}
	public ArmorSet(Player p){
		player = p;
		armorset = p.getInventory().getArmorContents();
	}

	public void revertArmor(){
		if(armorset != null){
			player.getInventory().setArmorContents(armorset);
		}
	}

}
