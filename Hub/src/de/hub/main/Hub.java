package de.hub.main;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Hub extends JavaPlugin {
	
	public void onEnable() {
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("hub")) {
			if(!(sender instanceof Player))
				return true;
			
			Player p = (Player) sender;
			
			ByteArrayOutputStream b = new ByteArrayOutputStream();
			DataOutputStream out = new DataOutputStream(b);
			
			try {
				out.writeUTF("Connect");
				out.writeUTF("lobby");
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			p.sendPluginMessage(this, "BungeeCord", b.toByteArray());
		}
		return true;
	}
	
}
