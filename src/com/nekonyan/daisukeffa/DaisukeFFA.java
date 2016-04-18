package com.nekonyan.daisukeffa;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.nekonyan.daisukeffa.commands.StageCommands;

public class DaisukeFFA extends JavaPlugin{
	
	public static DaisukeFFA instance;
	
	public static String prefix;
	
	
	
	public void onEnable(){
		reloadConfig();
		instance = this;
		prefix = ChatColor.DARK_AQUA + "FreeForAll" + ChatColor.GRAY + ">" + ChatColor.RESET;
	}
	
	public void registerCommands(){
		this.getCommand("ffastage").setExecutor((CommandExecutor) new StageCommands());
	}


}
