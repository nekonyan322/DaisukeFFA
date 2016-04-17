package com.nekonyan.daisukeffa.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StageCommands {
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args){
		if (sender.hasPermission("corebreaking.stage")) {
			if((args.length >= 2 ) && (args.length <= 4)){
				if ((args[0] == null) || (args.length>= 4) || (args.length == 1)) {
					sender.sendMessage(ChatColor.GOLD + "");
					unknown(sender);
					return true;
				}
				if((args[0].equalsIgnoreCase("create")) && (args.length == 2));{
					String stagename = args[1];
					if((sender instanceof Player)) {
						StageManager
					}
				}
			}
			
		}
		return false;
	}

	private void unknown(CommandSender sender) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
