package com.nekonyan.daisukeffa.manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.Red;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.nekonyan.daisukeffa.DaisukeFFA;

public class StageManager {
	
	public static List<String> stages = new ArrayList<String>();
	
	public static boolean loadStages(){
		stages.removeAll(stages);
		String path = "plugins/DaisukeFFA/stages";
		File dir = new File(path);
		String[] list = dir.list();
		if(list !=null){
			String[] arrayOfString1;
			int j = (arrayOfString1 = list).length;
			for(int i = 0; i < j; i++){
				String filename = arrayOfString1[i];
				filename = filename.substring(0, filename.indexOf(".yml"));
				stages.add(filename);
				System.out.println("Add Stage :" + filename);
			}
		}
		return true;
	}
	
	public static void createNewFile(String stage, CommandSender sender){
		File file = new File("plugins/DaisukeFFA/stages/" + stage.toString() + ".yml");
		if (!file.exists()) {
			YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
			try{
				file.createNewFile();
				sender.sendMessage(ChatColor.GREEN + "ステージ名: " + stage + "を追加しました。");
				config.set("name", stage);
				config.save(file);
			}catch (IOException e){
				e.printStackTrace();
			}
		}else {
			sender.sendMessage(ChatColor.RED + stage + "は存在しています。");
		}
	}
	public static String getDev(String stage){
		String deta = "";
		File file = new File( "plugins/DaisukeFFA/stages/" + stage.toString() + ".yml");
		if(file.exists()){
			YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
			if(config.contains("dev")) {
				deta = config.getString("dev");
			} else {
				deta = "設定されていません";
			}
		}
		return deta;
	}
	
	public static void setDev(Player p, String stage,String devName){
		File file = new File("plugins/DaisukeFFA/stages/" + stage.toString() + ".yml");
		if(file.exists()){
			YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
			yml.set("dev", devName);
			p.sendMessage(DaisukeFFA.prefix + ChatColor.YELLOW + stage + "の作者を" + devName + "にしました。");			
		}else{
			p.sendMessage(DaisukeFFA.prefix + ChatColor.RED + stage + "の作者は登録されています。");
		}
	}
	
	

}
