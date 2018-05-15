package me.blood;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Blood extends JavaPlugin implements Listener {
	
	public void onEnable()
	{
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onBlood(EntityDamageEvent e)
	{
		Entity entity = e.getEntity();
		Location entityloc = entity.getLocation();
		if (entity.getType() != EntityType.ITEM_FRAME) {
			entity.getWorld().playEffect(entityloc, Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
		}
	}

}
