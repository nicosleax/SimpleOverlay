package de.phoenix_interactive_studios.spigot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(this, this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        event.setJoinMessage(getConfig().getString("Prefix") + getConfig().getString("JoinSymbol") + ChatColor.GOLD + event.getPlayer().getName() + getConfig().getString("Join"));
        event.getPlayer().sendTitle(ChatColor.DARK_GREEN + "Willkommen, ", ChatColor.GREEN + event.getPlayer().getName(), 10, 70, 20);
        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        event.setQuitMessage(getConfig().getString("Prefix") + getConfig().getString("QuitSymbol") + ChatColor.GOLD + event.getPlayer().getName() + getConfig().getString("Quit"));
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {

        String originalMessage = event.getMessage();
        String modifiedMessage = ChatColor.GOLD + event.getPlayer().getName() + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + originalMessage;
        event.setFormat(modifiedMessage);
    }


}