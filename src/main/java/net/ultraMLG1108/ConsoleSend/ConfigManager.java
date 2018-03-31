package net.ultraMLG1108.ConsoleSend;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {

	private Main plugin = Main.getPlugin(Main.class);
	private FileConfiguration playerscfg;
	private File playersfile;
	
	public void setup() {
		if(!plugin.getDataFolder().exists()) {
				plugin.getDataFolder().mkdir();
		}
		
		playersfile = new File(plugin.getDataFolder(), "players.yml");
		
		if(!playersfile.exists()) {
			try {
				playersfile.createNewFile();
			} catch(IOException e) {
				plugin.getLogger().log(Level.SEVERE, "Could not create players.yml file ");
				e.printStackTrace();
			}
		}
		
		playerscfg = YamlConfiguration.loadConfiguration(playersfile);
		
	}
	
	public FileConfiguration getPlayers() throws NullPointerException {
		return playerscfg;
	}
	
	public void savePlayers() {
		try {
			playerscfg.save(playersfile);
		} catch(IOException e) {
			plugin.getLogger().log(Level.SEVERE, "Could not save players.yml ");
			e.printStackTrace();
		}
		
	}
	
	public void reloadPlayers() {
		playerscfg = YamlConfiguration.loadConfiguration(playersfile);
	}
	
	public void saveDefaultConfig() {
	    if (playersfile == null) {
	        playersfile = new File(plugin.getDataFolder(), "players.yml");
	    }
	    if (!playersfile.exists()) {          
	         plugin.saveResource("players.yml", false);
	     }
	}
	
	
}
