package com.nekonyan.daisukeffa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.nekonyan.daisukeffa.listener.PlayerListener;
import com.nekonyan.daisukeffa.manager.ConfigManager;
import com.nekonyan.daisukeffa.manager.StageManager;
import com.nekonyan.daisukeffa.task.RestartTask;

public class GameManager {
	
	public String stagename;
	
	public static List<Player> gamePlayers = new ArrayList<Player>();
	
	public int tick = 0;
	
	public static int timer = 0;
	
	public static int playerPoint = 0;
	
	
	public boolean gameActive = false;
	
	public boolean countdownActive = false;
	
	public boolean endActive = false;
	
	public boolean pregameActive = false;
	
	public boolean restart = false;
	
	public int configRestart = ConfigManager.loadConfig().getInt("restart");
	
	public int restartCount = configRestart;
	
	public void tick(){
		tick++;
		if(tick % 20 == 0){
			timer();
		}
		if(tick % 5 == 0){
			for(@SuppressWarnings("unused") Player player : Bukkit.getOnlinePlayers()){
			}
		}
		if(tick == 1000){
			tick = 0;
		}
	}
	
	public void timer(){
		
		
	}	


	public static void onFinish() {
	    Location spawnloc = StageManager.getSpawn();
	    for (Player p : Bukkit.getOnlinePlayers())
	    {
	      if (p.getGameMode() != GameMode.CREATIVE)
	      {
	        p.teleport(spawnloc);
	        p.setGameMode(GameMode.ADVENTURE);
	      }
	      p.getInventory().clear();
	      p.setHealth(20.0);
	      p.setFoodLevel(20);
	      p.getInventory().clear();
	      p.getInventory().setHelmet(null);
		  p.getInventory().setChestplate(null);
		  p.getInventory().setLeggings(null);
		  p.getInventory().setBoots(null);
		  
		  gamePlayers.clear();
		  }
	}
	public static void  onRespawn(Player player) {
		
		DaisukeFFA.gm.playerTeleportRundom(player);
		
		
	}
	
	
	public static void playerTeleportRundom(Player player){
		
        Random rnd = new Random();

        int ran = rnd.nextInt(10);
        
        /*if(ran == 0){
        	String spawnnumber = "0";
            Location loc = StageManager.loadGameSpawn(DaisukeFFA.gm.stagename, spawnnumber);
            player.teleport(loc);
        }
        if(ran == 1){
        	String spawnnumber = "1";
            Location loc = StageManager.loadGameSpawn(DaisukeFFA.gm.stagename, spawnnumber);
            player.teleport(loc);
        }
        if(ran == 2){
        	String spawnnumber = "2";
            Location loc = StageManager.loadGameSpawn(DaisukeFFA.gm.stagename, spawnnumber);
            player.teleport(loc);
        }
        if(ran == 3){
        	String spawnnumber = "3";
            Location loc = StageManager.loadGameSpawn(DaisukeFFA.gm.stagename, spawnnumber);
            player.teleport(loc);
        }
        if(ran == 4){
        	String spawnnumber = "4";
            Location loc = StageManager.loadGameSpawn(DaisukeFFA.gm.stagename, spawnnumber);
            player.teleport(loc);
            
        }
        if(ran == 5){
        	String spawnnumber = "5";
            Location loc = StageManager.loadGameSpawn(DaisukeFFA.gm.stagename, spawnnumber);
            player.teleport(loc);
        }
        if(ran == 6){
        	String spawnnumber = "6";
            Location loc = StageManager.loadGameSpawn(DaisukeFFA.gm.stagename, spawnnumber);
            player.teleport(loc);
        }
        if(ran == 7){
        	String spawnnumber = "7";
            Location loc = StageManager.loadGameSpawn(DaisukeFFA.gm.stagename, spawnnumber);
            player.teleport(loc);
        }
        if(ran == 8){
        	String spawnnumber = "8";
            Location loc = StageManager.loadGameSpawn(DaisukeFFA.gm.stagename, spawnnumber);
            player.teleport(loc);
        }
        if(ran == 9){
        	String spawnnumber = "9";
            Location loc = StageManager.loadGameSpawn(DaisukeFFA.gm.stagename, spawnnumber);
            player.teleport(loc);
        }*/

        if(ran == 0){
        	String spawnnumber = "0";
            Location loc = StageManager.loadGameSpawn("test", spawnnumber);
            player.teleport(loc);
        }
        if(ran == 1){
        	String spawnnumber = "1";
            Location loc = StageManager.loadGameSpawn("test", spawnnumber);
            player.teleport(loc);
        }
        if(ran == 2){
        	String spawnnumber = "2";
            Location loc = StageManager.loadGameSpawn("test", spawnnumber);
            player.teleport(loc);
        }
        if(ran == 3){
        	String spawnnumber = "3";
            Location loc = StageManager.loadGameSpawn("test", spawnnumber);
            player.teleport(loc);
        }
        if(ran == 4){
        	String spawnnumber = "4";
            Location loc = StageManager.loadGameSpawn("test", spawnnumber);
            player.teleport(loc);
            
        }
        if(ran == 5){
        	String spawnnumber = "5";
            Location loc = StageManager.loadGameSpawn("test", spawnnumber);
            player.teleport(loc);
        }
        if(ran == 6){
        	String spawnnumber = "6";
            Location loc = StageManager.loadGameSpawn("test", spawnnumber);
            player.teleport(loc);
        }
        if(ran == 7){
        	String spawnnumber = "7";
            Location loc = StageManager.loadGameSpawn("test", spawnnumber);
            player.teleport(loc);
        }
        if(ran == 8){
        	String spawnnumber = "8";
            Location loc = StageManager.loadGameSpawn("test", spawnnumber);
            player.teleport(loc);
        }
        if(ran == 9){
        	String spawnnumber = "9";
            Location loc = StageManager.loadGameSpawn("test", spawnnumber);
            player.teleport(loc);
        }

	}




	public void loadStageDeta(String stagename){
		File file = new File("plugins/DaisukeFFA/stages/" + stagename.toString()+".yml");
		YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);

	}

	
	public String RandomStage()
	{
		String stage = null;
		if(StageManager.stages.size() != 0)
		{
			int rand = new Random().nextInt(StageManager.stages.size());
			stage = StageManager.stages.get(rand).toString();
			loadStageDeta(stage);
			for(Player p :Bukkit.getOnlinePlayers()){
				p.sendMessage(ChatColor.GRAY + "============ [" +ChatColor.DARK_AQUA + " Stage Info " + ChatColor.GRAY + "] ============");
				p.sendMessage(ChatColor.GREEN + "Next stage" + ChatColor.GRAY + "> " + ChatColor.WHITE +  stage);
				p.sendMessage(ChatColor.GREEN + "Mapper" + ChatColor.GRAY + "> " + ChatColor.WHITE + StageManager.getDev(stage));
				p.sendMessage(ChatColor.GRAY + "======================================");
			}
		} else {
			System.out.println("ステージが未登録なため、処理を終了しました。");
			endActive = false;
			gameActive = false;
			countdownActive = false;
			Bukkit.broadcastMessage("ステージが登録されていません。");
		}
		return stage;
	}
}
