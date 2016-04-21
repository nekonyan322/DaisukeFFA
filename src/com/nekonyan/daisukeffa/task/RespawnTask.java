package com.nekonyan.daisukeffa.task;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.nekonyan.daisukeffa.DaisukeFFA;
import com.nekonyan.daisukeffa.GameManager;
import com.nekonyan.daisukeffa.listener.PlayerListener;
import com.nekonyan.daisukeffa.manager.WeaponManager;
public class RespawnTask extends BukkitRunnable{
	

	public static HashMap<Player, Player> killer = new HashMap<Player, Player>();
	public Player player;
	public int tick;

	public RespawnTask(Player player) {
		this.player = player;
		this.tick = 6;
	}

	@Override
	public void run() {
		tick--;
		player.sendMessage(DaisukeFFA.prefix + ChatColor.YELLOW + "ÉäÉXÉ|Å[ÉìÇ‹Ç≈ " + tick + "ïb");
		if(tick == 5 && killer.get(player) == null){
			 /*GameManager.playerTeleportRundom(player);*/
		}
		if(tick == 5){
			Location killerloc = killer.get(player).getLocation();
			player.teleport(killerloc);
			player.setGameMode(GameMode.SPECTATOR);
		}
		if(tick == 0 || player == null || !player.isOnline()){
			this.cancel();
			player.setGameMode(GameMode.SURVIVAL);
			GameManager.onRespawn(player);
			WeaponManager.setWeapons(player);
			//new GodmodeTask(player, 4).runTaskTimer(CoreBreaking.instance, 0, 20);
		}
	}

}
