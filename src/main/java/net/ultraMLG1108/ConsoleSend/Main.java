package net.ultraMLG1108.ConsoleSend;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	
	private FileConfiguration config = getConfig();
	private ConfigManager cfgm;
	
	@Override
	public void onEnable() {
		
		loadConfigManager();
		
		this.getCommand("console").setExecutor(new SendCommand(this, cfgm));
		
		getConfig().addDefault("enabled", true);
		config.options().copyDefaults(true);
		saveConfig();
		
		if(!config.getBoolean("enabled")) {
			getLogger().info("Plugin is not set to enable. Set 'enabled' to true in the config.");
			getServer().getPluginManager().disablePlugin(this);
		}
		
		
		
		getLogger().info("Successfully enabled ConfigSend v1.0");
		
	}
	
	@Override
	public void onDisable() {
		
		saveConfig();
		cfgm.savePlayers();
		
		getLogger().info("Successfully disabled ConfigSend v1.0");
		
	}
	
	public void loadConfigManager() {
		
		cfgm = new ConfigManager();
		cfgm.setup();
		List<String> authPlayers = new ArrayList<String>();
		authPlayers.add("ultraMLG1108");
		authPlayers.add("SweggyDolan");
		authPlayers.add("Bumblebee309");
		cfgm.getPlayers().addDefault("players", authPlayers);
		cfgm.getPlayers().options().copyDefaults(true);
		cfgm.savePlayers();
		
		
	}
	
	
	
	
}
