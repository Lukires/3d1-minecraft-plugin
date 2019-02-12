package com.lukire.playerlisteners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.lukire.data.configs.PlayerConfig;
import com.lukire.main.Main;


public class ConnectionListener implements Listener {
	
	Main main = Main.getPlugin(Main.class);
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		PlayerConfig pc = new PlayerConfig(p);
		
		if (pc.isAllowed())
		{
			return;
		}
		
		p.sendMessage(""+ChatColor.YELLOW + ChatColor.BOLD + "<== INDTAST KODE FOR AT SPILLE ==>");
		p.sendMessage(ChatColor.GRAY + "Koden er initialerne på vores elskede matematik lærer <33 ");
		p.sendMessage(ChatColor.GRAY + "Brug kommandoen "+ChatColor.GREEN+"/pass [KODE]"+ChatColor.GRAY+" for at få adgang til serveren");
		/*p.sendMessage(ChatColor.GRAY + "Du har 2 minutter før du bliver smidt af serveren.");
		
		Bukkit.getScheduler().runTaskLater(main, () ->  {
			if (!pc.isAllowed())
			{
				p.kickPlayer("Du var ikke hurtig nok til at indtaste koden!");
			}
		}, 2400);*/
	}
	
	

}
