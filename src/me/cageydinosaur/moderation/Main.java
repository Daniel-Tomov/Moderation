package me.cageydinosaur.moderation;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public chatList = 
	
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new Events(this), this);
		getCommand("moderation").setExecutor(new Cmd(this));
		this.saveDefaultConfig();
	}

	public void onDisable() {

	}

	public String playerMessage() {
		return this.getConfig().getString("playerMessage");
	}

	public String adminMessage() {
		return this.getConfig().getString("adminMessage");
	}

	public String blockedWords(String mess) {
		for (int i = 0; i < getConfig().getList("blockedWords").size(); i++) {
			if (mess.contains(getConfig().getList("blockedWords").get(i).toString())) {
				return getConfig().getList("blockedWords").get(i).toString();
			}
		}
		return "";
	}
	
	public void addInfo(Player player, int respawnsL) {
		this.respawnList.add(player.getDisplayName() + ", " + Integer.toString(respawnsL));
	}
	
	public void reloadTheConfig() {
		this.reloadConfig();
	}

	public String chat(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}

}
