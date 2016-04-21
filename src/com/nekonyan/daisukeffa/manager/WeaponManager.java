package com.nekonyan.daisukeffa.manager;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scoreboard.Team;
public class WeaponManager {

	private static Inventory getInv(Player p){
		return p.getInventory();
	}

	private static EntityEquipment getEquipment(Player p){
		return p.getEquipment();
	}
	
	public static void setWeapons(Player p){
		getInv(p).setItem(0, new ItemStack(Material.GOLD_AXE));
		getInv(p).setItem(1, new ItemStack(Material.GOLD_SPADE));
		getInv(p).setItem(2, new ItemStack(Material.SLIME_BALL, 2));

		getInv(p).setItem(9, new ItemStack(Material.IRON_INGOT, 64));
		getInv(p).setItem(10, new ItemStack(Material.IRON_INGOT, 64));
		getInv(p).setItem(11, new ItemStack(Material.IRON_INGOT, 64));
		getInv(p).setItem(12, new ItemStack(Material.IRON_INGOT, 64));
		getInv(p).setItem(13, new ItemStack(Material.IRON_INGOT, 64));
		getInv(p).setItem(14, new ItemStack(Material.IRON_INGOT, 64));
		getInv(p).setItem(15, new ItemStack(Material.IRON_INGOT, 64));

		getInv(p).setItem(16, new ItemStack(Material.GOLD_INGOT, 64));
		getInv(p).setItem(17, new ItemStack(Material.GOLD_INGOT, 64));
		getInv(p).setItem(18, new ItemStack(Material.GOLD_INGOT, 64));
		getInv(p).setItem(19, new ItemStack(Material.GOLD_INGOT, 64));
	}
	public static void giveAll(){
		for(Player p : Bukkit.getOnlinePlayers()){
			setWeapons(p);
			p.updateInventory();
		}
	}
}
