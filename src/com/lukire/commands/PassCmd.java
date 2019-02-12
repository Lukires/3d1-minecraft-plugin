package com.lukire.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lukire.data.configs.PlayerConfig;


public class PassCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player))
		{
			sender.sendMessage("Only players may execute this command");
			return false;
		}
		
		Player p = (Player) sender;
		
		if (args[0] == null)
		{
			p.sendMessage(ChatColor.GRAY+"Du bruger kommandoen forkert. Det er"+ChatColor.GREEN+" /pass [KODE]");
			return false;
		}
		
		String pass = args[0];
		
		if (!pass.equalsIgnoreCase("JASH"))
		{
			p.sendMessage(ChatColor.RED+"Forkert kode!");
			return true;
		}
		
		PlayerConfig pc = new PlayerConfig(p);
		pc.allowPlayer();
		p.sendMessage(ChatColor.GREEN+"Koden er korrekt! Du kan nu spille :)");
		p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
		
		return true;
	}

}
