package net.ultraMLG1108.ConsoleSend;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendCommand implements CommandExecutor {

	public Main plugin;
	public ConfigManager cfgm;
	
	public SendCommand(Main plugin, ConfigManager cfgm) {
	    this.plugin = plugin;
	    this.cfgm = cfgm;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("console")) {
			
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You must be a player!");
			} else {
				
				Player player = (Player) sender;
				
				if(!cfgm.getPlayers().getList("players").contains(player.getName().toString())) {
					player.sendMessage(ChatColor.RED + "You don't have permission to do this!");
				} else {
					
					if(args.length == 0 || args.length == 1) {
						player.sendMessage(ChatColor.RED + "Too few arguments!");
						player.sendMessage(ChatColor.RED + "/console <send> <command>");
					} else if(args.length == 2) {
						if(args[0].equalsIgnoreCase("send")) {
							Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), args[1]);
						}
					} else if(args.length == 3) {
						if(args[0].equalsIgnoreCase("send")) {
							Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), args[1] + " " + args[2]);
						}
					} else if(args.length == 4) {
						if(args[0].equalsIgnoreCase("send")) {
							Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), args[1] + " " + args[2] + " " + args[3]);
						}
					} else if(args.length == 5) {
						if(args[0].equalsIgnoreCase("send")) {
							Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), args[1] + " " + args[2] + " " + args[3] + " " + args[4]);
						}
					} else {
						player.sendMessage(ChatColor.RED + "Too many arguments!");
						player.sendMessage(ChatColor.RED + "/console <send> <command>");
					}
					
				}
				
			}
			
			
			
			return true;
			
		}
		
		return false;
	}
	
}
