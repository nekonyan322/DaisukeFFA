package com.nekonyan.daisukeffa;

import java.nio.file.Path;

import org.bukkit.ChatColor;

public class DaisukeFFA {
	
	public static DaisukeFFA instance;
	
	public static String prefix;
	
	
	
	public void onEnable(){
		instance = this;
		prefix = ChatColor.DARK_AQUA + "FreeForAll" + ChatColor.GRAY + ">" + ChatColor.RESET;
	}


}
