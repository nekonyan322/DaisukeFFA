package com.nekonyan.daisukeffa.listener;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import com.nekonyan.daisukeffa.DaisukeFFA;
import com.nekonyan.daisukeffa.GameManager;
import com.nekonyan.daisukeffa.manager.ConfigManager;
import com.nekonyan.daisukeffa.manager.StageManager;
import com.nekonyan.daisukeffa.task.RespawnTask;
import com.nekonyan.daisukeffa.task.RestartTask;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		Player killer = p.getKiller();
		p.setHealth(20);
		e.setDroppedExp(0);
		e.getDrops().clear();
		p.getInventory().clear();

		new RespawnTask(p).runTaskTimer(DaisukeFFA.instance, 0, 20);
	}
	
	
	@EventHandler
	public void onWeather(WeatherChangeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerFoodLevelChg(FoodLevelChangeEvent e) {
		if((e.getEntity() instanceof Player)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player player = e.getPlayer();
		
		player.getInventory().clear();
		player.setHealth(20.0);
		player.setFoodLevel(20);
		player.getInventory().setHelmet(null);
		player.getInventory().setChestplate(null);
		player.getInventory().setLeggings(null);
		player.getInventory().setBoots(null);
		Location location = StageManager.loadLobbySpawn();
		player.teleport(location);
		//String url = "https://dl.dropboxusercontent.com/s/gqfirk18z5cgv1r/legacy_infect.zip?dl=0";
		//String url = "https://dl.dropboxusercontent.com/s/gqfirk18z5cgv1r/legacy_infect.zip";
		String url = "https://dl.dropboxusercontent.com/s/wqteamt3dg2ei9g/legacy_infectgun.zip";
		player.setResourcePack(url);
		
		
		
		//String url = ConfigManager.loadConfig().getString("ResouceURL");

	}

	@EventHandler
	public void dropitem(PlayerDropItemEvent e){
		Player player = e.getPlayer();
		if(!player.isOp()){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		Player player = e.getPlayer();
		
	}
}
