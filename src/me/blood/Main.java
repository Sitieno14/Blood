package me.blood;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public void onEnable()
	{
		Bukkit.getPluginManager().registerEvents(this, this);
		getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "-------------------");
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "Blood Enabled");
		getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "-------------------");
		saveDefaultConfig();
	}
	
	public void onDisable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "-------------------");
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "Blood Disabled");
		getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "-------------------");
	}
	
	@EventHandler
	public void onBlood(EntityDamageByEntityEvent e)
	{
		Entity entity = e.getEntity();
		Location entityloc = entity.getLocation();
		if (entity.getType() != EntityType.ITEM_FRAME) {
			entity.getWorld().playEffect(entityloc, Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("blood")) {
			if (!p.hasPermission("Blood.admin"))
			{
				p.sendMessage(getConfig().getString("NoPerms").replaceAll("&", "§"));
			}
			else
			{
				if (args.length == 0)
				{
					p.sendMessage("§4================");
					p.sendMessage("§4Blood");
					p.sendMessage("");
					p.sendMessage("§r/Blood info");
					p.sendMessage("§r/blood reload");
					p.sendMessage("");
					p.sendMessage("§4Blood");
					p.sendMessage("§4================");
					return true;
				}
				if (args[0].equalsIgnoreCase("info"))
				{
					p.sendMessage("§4================");
					p.sendMessage("§4Blood info");
					p.sendMessage("");
					p.sendMessage("§rName: Blood");
					p.sendMessage("§rVersion: 1.0");
					p.sendMessage("§rCreator: FeatherDev");
					p.sendMessage("");
					p.sendMessage("§4Blood info");
					p.sendMessage("§4================");
				}
				if (args[0].equalsIgnoreCase("reload"))
				{
					reloadConfig();
					sender.sendMessage("§aConfig has been reloaded");
				}
			}
		}
		return false;
	}

}
