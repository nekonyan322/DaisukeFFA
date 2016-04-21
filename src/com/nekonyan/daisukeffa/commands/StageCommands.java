package com.nekonyan.daisukeffa.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nekonyan.daisukeffa.DaisukeFFA;
import com.nekonyan.daisukeffa.manager.StageManager;
import com.nekonyan.daisukeffa.task.RespawnTask;
import com.nekonyan.daisukeffa.task.RestartTask;

public class StageCommands implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args){
		if(sender.hasPermission("daisukeffa.stage")){
			if((args.length >= 2) && (args.length <= 4)){
				if ((args[0] == null) || (args.length >= 4) || (args.length == 1)){
					sender.sendMessage(ChatColor.GOLD + "�`��������������܂���B");
					unknown(sender);
					return true;
				}
				if((args[0].equalsIgnoreCase("create")) && (args.length == 2)) {
					String stagename = args[1];
					if((sender instanceof Player)) {
						StageManager.createNewFile(stagename, sender);
					}
				}
				if ((args[0].equalsIgnoreCase("setgamespawn")) && (args.length == 3)) {
					if((sender instanceof Player)) {
						String stagename = args[1];
						String respawnnumber = args[2];
						Player player = (Player)sender;	
						StageManager.setgameSpawn(stagename, player, respawnnumber);
						/*if(respawnnumber == "1" ) {
						StageManager.setgameSpawn(stagename, player, respawnnumber);
						}
						if(respawnnumber == "2" ) {
						StageManager.setgameSpawn(stagename, player, respawnnumber);
						}
						if(respawnnumber == "3" ) {
						StageManager.setgameSpawn(stagename, player, respawnnumber);
						}
						if(respawnnumber == "4" ) {
						StageManager.setgameSpawn(stagename, player, respawnnumber);
						}
						if(respawnnumber == "5" ) {
						StageManager.setgameSpawn(stagename, player, respawnnumber);
						}
						if(respawnnumber == "6" ) {
						StageManager.setgameSpawn(stagename, player, respawnnumber);
						}
						if(respawnnumber == "7" ) {
						StageManager.setgameSpawn(stagename, player, respawnnumber);
						}
						if(respawnnumber == "8" ) {
						StageManager.setgameSpawn(stagename, player, respawnnumber);
						}
						if(respawnnumber == "9" ) {
						StageManager.setgameSpawn(stagename, player, respawnnumber);
						}
						if(respawnnumber == "0" ) {
						StageManager.setgameSpawn(stagename, player, respawnnumber);
						}
						else {
							player.sendMessage("respawnnumber��0~9�Őݒ肵�Ă��������B");
	
}*/
						}
					
				}
				if ((args[0].equalsIgnoreCase("setgamespawn")) && (args.length == 3)) {
				}
					if((sender instanceof Player)) {
						Player p = (Player)sender;
						String stage = args[1];
						String devName = args[2];
						StageManager.setDev(p, stage, devName);
					}
				if ((args[0].equalsIgnoreCase("load")) && (args.length == 2)) {
			          if (args[1].equalsIgnoreCase("all"))
			          {
			            StageManager.loadStages();
			            int stageint = StageManager.stages.size();
			            sender.sendMessage(ChatColor.GREEN + "���ׂẴX�e�[�W���ēǂݍ��݂��܂����B�X�e�[�W��: " + stageint);
			            List<String> list = new ArrayList<String>();
			            for (String s2 : StageManager.stages) {
			              list.add(s2);
			            }
			            StringBuffer a = new StringBuffer();
			            for (int i = 0; i < list.size(); i++)
			            {
			              String name = (String)list.get(i);
			              a.append(name);
			              if (i + 1 < list.size()) {
			                a.append(" , ");
			              }
			            }
			            if (list.size() <= 0)
			            {
			            	sender.sendMessage(DaisukeFFA.prefix + "�X�e�[�W���o�^����Ă��܂���B");
			            }
			            else
			            {
			            	sender.sendMessage(DaisukeFFA.prefix + "�X�e�[�W��:" + list.size());
			            	sender.sendMessage(a.toString());
			            }
			          }
			        }
			        if ((args[0].equalsIgnoreCase("config")) && (args.length == 2)) {
			          if (args[1].equalsIgnoreCase("reload"))
			          {
			            DaisukeFFA.instance.reloadConfig();
			            sender.sendMessage(ChatColor.GREEN + "config.yml���ēǂݍ��݂��܂����B");
			          }
			        }
			        if ((args[0].equalsIgnoreCase("set")) && (args.length == 2)) {
			          if (args[1].equalsIgnoreCase("spawn")) {
			            if ((sender instanceof Player))
			            {
			              Player p = (Player)sender;
			              StageManager.setSpawn(p);
			            }
			          }
			        }

			}
	        else {
	        	unknown(sender);
	        }
		}
		else{
			Player p = (Player)sender;
			sender.sendMessage(DaisukeFFA.prefix + "����[�H" + p.getPlayer().getName() + "����͉^�c�������H�n�o�����ĂȂ��^�c�͂��Ȃ��͂�������^�c����Ȃ��ˁ[");
		}
        
		return false;
	}
	private void unknown(CommandSender sender) {
	    String paramString = "ffastage";
	    sender.sendMessage(DaisukeFFA.prefix + "/" + paramString + " set spawn");
	    sender.sendMessage(DaisukeFFA.prefix + "/" + paramString + " create [stagename]");
	    sender.sendMessage(DaisukeFFA.prefix + "/" + paramString + " setgamespawn [stagename] [spawnnunber]");
	    sender.sendMessage(DaisukeFFA.prefix + "/" + paramString + " config reload");
	    sender.sendMessage(DaisukeFFA.prefix + "/" + paramString + " load all");
	    sender.sendMessage(DaisukeFFA.prefix + "/" + paramString + " setdev [stagename] [playername]");
	  
		
	}

}
