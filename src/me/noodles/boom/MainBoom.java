package me.noodles.boom;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class MainBoom extends JavaPlugin implements Listener  {
	
	
	    public static MainBoom plugin;
	    public static Plugin plugin2;
	    private UpdateChecker checker;
	    String DownloaderType;
	    String GsonEntry;
	    String SpigotHost;
	   
		
		
	    public void onEnable() {
	        MainBoom.plugin = this;
	        final PluginDescriptionFile VarUtilType = this.getDescription();
	        this.getLogger().info("Kaboom  V" + VarUtilType.getVersion() + " starting...");
	        this.saveDefaultConfig();
	        this.reloadConfig();
	        registerEvents((Plugin)this, new UpdateJoinEvent());
	        registerEvents(this, this);
	        this.getCommand("kaboom").setExecutor((CommandExecutor)new MainCommand());
	        this.getLogger().info("Kaboom  V" + VarUtilType.getVersion() + " started!");
	        this.setEnabled(true);
	        this.getLogger().info("Kaboom V" + VarUtilType.getVersion() + " checking for updates...");
	        this.checker = new UpdateChecker(this);
	        if (this.checker.isConnected()) {
	            if (this.checker.hasUpdate()) {
	                getServer().getConsoleSender().sendMessage("------------------------");
	                getServer().getConsoleSender().sendMessage("Kaboom is outdated!");
	                getServer().getConsoleSender().sendMessage("Newest version: " + this.checker.getLatestVersion());
	                getServer().getConsoleSender().sendMessage("Your version: " + MainBoom.plugin.getDescription().getVersion());
	                getServer().getConsoleSender().sendMessage("Please Update Here: https://www.spigotmc.org/resources/22841");
	                getServer().getConsoleSender().sendMessage("------------------------");
	            }
	            else {
	                getServer().getConsoleSender().sendMessage("------------------------");
	                getServer().getConsoleSender().sendMessage("Kaboom  is up to date!");
	                getServer().getConsoleSender().sendMessage("------------------------");            }
	        }
	    }
	    
	    public static void registerEvents(final Plugin plugin, final Listener... listeners) {
	        for (final Listener listener : listeners) {
	            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
	        }
	    }
	    
	    @SuppressWarnings({ "unchecked", "rawtypes"})
		public static MainBoom getPlugin() {
	        return (MainBoom)getPlugin((Class)MainBoom.class);
	    }
	    
	    public static Plugin getPlugin2() {
	        return (Plugin)MainBoom.plugin;
	    }
	
	
}

