package com.nekonyan.daisukeffa.manager;
import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;;

public class ConfigManager {

	public static File configFile(){
		File file = new File("plugins/DaisukeFFA/config.yml");
		return file;
	}

	public static YamlConfiguration loadConfig(){
		YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile());
		return config;
	}
}
