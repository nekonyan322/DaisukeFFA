package com.nekonyan.daisukeffa.task;

import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.nekonyan.daisukeffa.DaisukeFFA;
import com.nekonyan.daisukeffa.GameManager;

public class RestartTask extends BukkitRunnable{
	
	public Player player;
	public int tick;
	
	public RestartTask() {
		for (Player p : Bukkit.getOnlinePlayers()){
			this.player = p;
			this.tick = 3720;
		}
	}
	
	@Override
	public void run(){
		tick--;
	if(tick == 0){
		 int month;
		Calendar cal1 = Calendar.getInstance();
	      int day = cal1.get(5);
	      int year = cal1.get(1);
	      month = cal1.get(2) + 1;
	      int minute = cal1.get(12);
	      int sc = cal1.get(13);
	      player.kickPlayer(ChatColor.WHITE + "〈定期再起動〉" + year + "年" + month + "月" + day + "日" + minute + "時" + sc + "分に再起動を実行しました");
	      Bukkit.shutdown();
	}else{
		if(tick == 150){
			GameManager.onFinish();
		}
		
		if(tick == 120){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと2分です" + ChatColor.YELLOW + "⚠");
		}
		
		if(tick == 60){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと1分です" + ChatColor.YELLOW + "⚠");
		}
		
		if(tick == 30){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと30秒です" + ChatColor.YELLOW + "⚠");
		}
		
		if(tick == 20){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと20秒です" + ChatColor.YELLOW + "⚠");
		}
		
		if(tick == 15){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと15秒です" + ChatColor.YELLOW + "⚠");
		}
		
		if(tick == 10){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと10秒です" + ChatColor.YELLOW + "⚠");
		}
		
		if(tick == 9){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと9秒です" + ChatColor.YELLOW + "⚠");
		}
		
		if(tick == 8){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと8秒です" + ChatColor.YELLOW + "⚠");
		}
		
		if(tick == 7){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと7秒です" + ChatColor.YELLOW + "⚠");
		}
		
		if(tick == 6){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと6秒です" + ChatColor.YELLOW + "⚠");
		}
		
		if(tick == 5){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと5秒です" + ChatColor.YELLOW + "⚠");
		}
		
		if(tick == 4){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと4秒です" + ChatColor.YELLOW + "⚠");
		}
		
		if(tick == 3){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと3秒です" + ChatColor.YELLOW + "⚠");
		}
		
		if(tick == 2){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと2秒です" + ChatColor.YELLOW + "⚠");
		}
		
		if(tick == 1){
			player.sendMessage(ChatColor.YELLOW + "⚠"+ DaisukeFFA.warning + "再起動まであと1秒です" + ChatColor.YELLOW + "⚠");
		}
	}
	}
}
	
