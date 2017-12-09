package me.noodles.boom;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class MainCommand implements CommandExecutor  {

	String Message1;
	
	 public MainCommand() {
	        this.Message1 = ChatColor.translateAlternateColorCodes('&', MainBoom.getPlugin().getConfig().getString("Messages.Message1"));
	
	 } 
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kaboom")) {
			if (!sender.hasPermission("kaboom.use")) {
			    sender.sendMessage(ChatColor.RED + "(!) You don't have permssion to use this command!");	
			}else
			for (Player players : Bukkit.getOnlinePlayers()) {
			if (sender.hasPermission("kaboom.use")) {
		players.getWorld().strikeLightningEffect(players.getLocation());
		players.setVelocity(new Vector(0, 64, 0));
		players.setFallDistance(-65.0F);
		players.sendMessage(String.valueOf(this.Message1));
			}
		}
	}
	return true;
	}
	
}
