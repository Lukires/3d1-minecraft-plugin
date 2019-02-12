package com.lukire.playerlisteners;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import com.lukire.data.configs.PlayerConfig;

public class PreventPlayerAction implements Listener {
	/*
	 * AllowedPlayers is there to enhance the performance
	 */
	
	private static ArrayList<Player> allowedPlayers = new ArrayList<Player>();
	
	@EventHandler
	public void onInteraction(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		if (allowedPlayers.contains(p)) return;
		PlayerConfig pc = new PlayerConfig(p);
		
		if (pc.isAllowed())
		{
			return;
		}
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onMovement(PlayerMoveEvent e) {
		
		
		Player p = e.getPlayer();
		if (allowedPlayers.contains(p)) return;
		if (e.getTo().distanceSquared(e.getFrom()) == 0) return;
		
		PlayerConfig pc = new PlayerConfig(p);
		if (pc.isAllowed()) {
			allowedPlayers.add(p);
			return;
		}
		e.setCancelled(true);
	}

}
