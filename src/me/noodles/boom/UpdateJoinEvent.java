package me.noodles.boom;

import org.bukkit.event.player.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class UpdateJoinEvent implements Listener
{
	
	public UpdateChecker checker;
	
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
    	Player p = e.getPlayer();
    	if (p.hasPermission("kaboom.update")) {
    		if (MainBoom.getPlugin().getConfig().getBoolean("Update.Enabled") == true){
    		this.checker = new UpdateChecker(MainBoom.plugin);
                        if (this.checker.isConnected()) {
                            if (this.checker.hasUpdate()) {
                            	p.sendMessage(ChatColor.GRAY + "=========================");
                                p.sendMessage(ChatColor.RED + "Kaboom is outdated!");
                                p.sendMessage(ChatColor.GREEN + "Newest version: " + this.checker.getLatestVersion());
                                p.sendMessage(ChatColor.RED + "Your version: " + MainBoom.plugin.getDescription().getVersion());
                                p.sendMessage(ChatColor.GRAY + "=========================");
                            }
                        }               
       }
    }
}
}
    