package net.hareworks.send_player_bungee;

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import com.google.common.io.ByteStreams

class Command : CommandExecutor {
    override fun onCommand(
            sender: CommandSender,
            command: Command,
            label: String,
            args: Array<String>
    ): Boolean {
        when (command.name) {
            "bsend" -> return bsend(sender, args)
        }
        return true
    }
}

fun bsend(sender: CommandSender, args: Array<String>): Boolean {
		if (args.size < 2) {
				sender.sendMessage("§cUsage: /bsend <player> <server>")
				return true
		}
		val player = Bukkit.getPlayer(args[0])
		if (player == null) {
				sender.sendMessage("§cPlayer not found")
				return true
		}
		val out = ByteStreams.newDataOutput();
		out.writeUTF("Connect");
		out.writeUTF(args[1]);
		val data = out.toByteArray();
		player.sendPluginMessage(App.plugin, "BungeeCord", data) 
		sender.sendMessage("§aSent " + player.getName() + " to " + args[1]) 
		return true
}