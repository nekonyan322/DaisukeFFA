package com.nekonyan.daisukeffa.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

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
			p.sendMessage(DaisukeFFA.prefix + ChatColor.RED + stage + "は存在しません。");
		}
	}
	
	public static Location loadGameSpawn(String stage, String spawnnumber){
		String deta = "";
		File file = new File("plugins/DaisukeFFA/stages/test.yml");
		if(file.exists()){
			YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
			deta = config.getString(spawnnumber);
		}
		return loadspawn(deta);
	}
	
	
	
	  public static Location loadLobbySpawn()
	  {
		  String sp = "";
	    File file = new File("plugins/DaisukeFFA/stages/test.yml");
	    if (!file.exists())
	    {
	      try
	      {
	        file.createNewFile();
	      }
	      catch (IOException e)
	      {
	        e.printStackTrace();
	      }
	    }
	    else
	    {
	      YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
	      if (config.contains(sp)) {
	        sp = config.getString("spawn");
	      }
	    }
	    return loadspawn(sp);
	  }

	

	
	  public static void setgameSpawn(String stage, Player player ,String respawnnumber)
	  {
	    File file = new File("plugins/DaisukeFFA/stages/" + stage.toString() + ".yml");
	    if (file.exists())
	    {
	      YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
	      Location loc = player.getLocation();
	      String world = loc.getWorld().getName();
	      double x = loc.getX();
	      double y = loc.getY();
	      double z = loc.getZ();
	      float yaw = loc.getYaw();
	      float pitch = loc.getPitch();
	      String locdeta = world + "/" + x + "/" + y + "/" + z + "/" + yaw + "/" + pitch;
	      config.set(respawnnumber, locdeta);
	      try
	      {
	        config.save(file);
	      }
	      catch (IOException e)
	      {
	        e.printStackTrace();
	      }
	      player.sendMessage(ChatColor.GREEN + stage + "の" + respawnnumber + "つ目のスポーン位置を" + locdeta + "に設定しました");
	    }
	    else
	    {
	      player.sendMessage(ChatColor.RED + stage + "は存在しません");
	    }
	  }
	  
	  public static void setSpawn(Player player)
	  {
	    File file = new File("plugins/DaisukeFFA/config.yml");
	    if (file.exists())
	    {
	      YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
	      Location loc = player.getLocation();
	      String world = loc.getWorld().getName();
	      double x = loc.getX();
	      double y = loc.getY();
	      double z = loc.getZ();
	      float yaw = loc.getYaw();
	      float pitch = loc.getPitch();
	      String locdeta = world + "/" + x + "/" + y + "/" + z + "/" + yaw + "/" + pitch;
	      config.set("spawn", locdeta);
	      try
	      {
	        config.save(file);
	      }
	      catch (IOException e)
	      {
	        e.printStackTrace();
	      }
	      player.sendMessage(ChatColor.DARK_GREEN + "ロビーのスポーン位置を" + locdeta + "に設定しました。");
	    }
	    else
	    {
	      try
	      {
	        file.createNewFile();
	        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
	        Location loc = player.getLocation();
	        String world = loc.getWorld().getName();
	        double x = loc.getX();
	        double y = loc.getY();
	        double z = loc.getZ();
	        float yaw = loc.getYaw();
	        float pitch = loc.getPitch();
	        String locdeta = world + "/" + x + "/" + y + "/" + z + "/" + yaw + "/" + pitch;
	        config.set("spawn", locdeta);
	        config.set("gametick", Integer.valueOf(300));
	        config.set("maxplayer", Integer.valueOf(20));
	        config.save(file);
	      }
	      catch (IOException e)
	      {
	        e.printStackTrace();
	      }
	    }
	  }
	  public static YamlConfiguration getConfig()
	  {
	    YamlConfiguration config = null;
	    File file = new File("plugins/DaisukeFFA/config.yml");
	    if (file.exists()) {
	      config = YamlConfiguration.loadConfiguration(file);
	    }
	    return config;
	  }

	  public static Location getSpawn()
	  {
	    String sp = "";
	    File file = new File("plugins/DaisukeFFA/config.yml");
	    if (!file.exists())
	    {
	      try
	      {
	        file.createNewFile();
	      }
	      catch (IOException e)
	      {
	        e.printStackTrace();
	      }
	    }
	    else
	    {
	      YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
	      if (config.contains("spawn")) {
	        sp = config.getString("spawn");
	      }
	    }
	    return loadspawn(sp);
	  }



	  public static Location loadspawn(String deta)
	  {
	    String[] s = deta.split("/");
	    World world = Bukkit.getWorld(s[0]);
	    double x = Double.parseDouble(s[1]);
	    double y = Double.parseDouble(s[2]);
	    double z = Double.parseDouble(s[3]);
	    float yaw = Float.parseFloat(s[4]);
	    float pitch = Float.parseFloat(s[5]);
	    Location location = new Location(world, x, y, z, yaw, pitch);
	    return location;
	  }
	
	  
	  public static void rundumStage(){
		  
	  }

}
