package com.nekonyan.daisukeffa;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.nekonyan.daisukeffa.commands.StageCommands;
import com.nekonyan.daisukeffa.listener.PlayerListener;
import com.nekonyan.daisukeffa.manager.ConfigManager;
import com.nekonyan.daisukeffa.manager.StageManager;
import com.nekonyan.daisukeffa.task.RestartTask;

public class DaisukeFFA extends JavaPlugin{
	
	public static DaisukeFFA instance;
	
	public static String prefix;
	
	public static String warning;
	
	  public static StageManager stagemanager;
	  
	  public static GameManager gm;
	  
	  public static PlayerListener playerListener;
	
	
	
	public void onEnable(){
		instance = this;
		prefix = ChatColor.DARK_AQUA + "FreeForAll" + ChatColor.GRAY + ">" + ChatColor.RESET;
		warning = ChatColor.DARK_RED + "ÅsåxçêÅt";
		StageManager.loadStages();
		ConfigManager configmanager = new ConfigManager();
		saveDefaultConfig();
		registerCommands();
		registerEvents();
	}
	
	public void registerCommands(){
		this.getCommand("ffastage").setExecutor(new StageCommands());
	}
	
	public StageManager getStageManager(){
		return DaisukeFFA.stagemanager;
	}
	
	public void registerEvents(){
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerListener(), this);
	}

	
	public void runTask(){
		Bukkit.getServer().getScheduler().runTaskTimer(instance, new Runnable() {
			@Override
			public void run() {
				DaisukeFFA.gm.tick();
			}
		}, 1L, 1L);
	}



}
