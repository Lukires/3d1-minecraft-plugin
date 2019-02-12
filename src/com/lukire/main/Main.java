package com.lukire.main;

import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.lukire.commands.PassCmd;
import com.lukire.playerlisteners.ConnectionListener;
import com.lukire.playerlisteners.PreventPlayerAction;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable()
	{		
		
		Server server = getServer();
		PluginManager pm = server.getPluginManager();
		pm.registerEvents(new ConnectionListener(), this);
		pm.registerEvents(new PreventPlayerAction(), this);
		server.getPluginCommand("pass").setExecutor(new PassCmd());
	}
	
	@Override
	public void onDisable()
	{
		
	}

}
