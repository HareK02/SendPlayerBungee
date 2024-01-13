package net.hareworks.send_player_bungee;

import org.bukkit.plugin.java.JavaPlugin

public class App : JavaPlugin() {
	companion object {
			lateinit var plugin: App
					private set
	}
    override fun onEnable() {
        plugin = this
        saveDefaultConfig()
				this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord")
        this.getCommand("bsend")?.setExecutor(Command())
    }
}
