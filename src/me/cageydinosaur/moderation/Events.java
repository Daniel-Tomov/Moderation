package me.cageydinosaur.moderation;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener{

	Main plugin;
	public Events(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent  e) {
		Player sender = e.getPlayer();
		String message = e.getMessage();
		if (!(plugin.blockedWords(message) == "")){
			e.setCancelled(true);
			sender.sendMessage(plugin.chat(plugin.playerMessage().replace("{usedWord}", plugin.blockedWords(message))));
			
		}
	}
	
	public void onJoin(PlayerJoinEvent e) {
		Player joiner = e.getPlayer();
		if (!(plugin.ifRespawns(joiner))) {
			plugin.addInfo(joiner, 3);
			joiner.sendMessage(ChatColor.GREEN + "You have " + ChatColor.RED + "3" + ChatColor.GREEN
					+ " respawns. If you die you will " + ChatColor.RED + "lose one" + ChatColor.GREEN
					+ " respawn. If you " + ChatColor.RED + "kill" + ChatColor.GREEN + " other players, you will "
					+ ChatColor.RED + "gain one" + ChatColor.GREEN
					+ " respawn. Once you lose all of your respawns, you will be put into " + ChatColor.RED
					+ "Spectator Mode" + ChatColor.GREEN + ". Have fun playing!");
		} else {
			int respawnAmt = plugin.getPlayerRespawns(joiner);
			joiner.sendMessage(ChatColor.GREEN + "Just a reminder, you have " + ChatColor.RED + respawnAmt
					+ ChatColor.GREEN + " respawns.");
		}
	}
	
	
	
}
