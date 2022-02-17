package me.cageydinosaur.moderation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Cmd implements CommandExecutor{

	Main plugin;
	public Cmd(Main plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("moderation.reload") && args[0].equalsIgnoreCase("reload")) {
			plugin.reloadConfig();
			sender.sendMessage("Reloaded the plugin");
			return true;
		} 
		
		
		return true;
	}

}
