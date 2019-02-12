package com.lukire.data.configs;

import java.util.UUID;

import org.bukkit.OfflinePlayer;

import com.lukire.data.ConfigHandler;

public class PlayerConfig extends ConfigHandler {


    public PlayerConfig(OfflinePlayer p) {
        this(p.getUniqueId());
    }

    public PlayerConfig(UUID uuid) {
        super("/players", uuid.toString()+".yml");
    }
    
    public boolean isAllowed() {
    	return this.contains("allowed") && this.getBoolean("allowed");
    }
    
    public void allowPlayer()
    {
    	this.set("allowed", true);
    	this.save();
    }
    

}
