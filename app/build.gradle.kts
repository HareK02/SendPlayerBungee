import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

group = "net.hareworks"
version = "1.0"

plugins {
    kotlin("jvm") version "1.9.22"
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}
repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}
dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}
tasks {
    shadowJar {
        archiveBaseName.set("SendPlayerBungee")
        archiveClassifier.set("")
    }
}

var permissionMessage = "You don't have permission to run this command"
bukkit {
    main = "net.hareworks.send_player_bungee.App"
    name = "SendPlayerBungee"
    description = "just server command to send player to bungee server"
    version = getVersion().toString()
		apiVersion = "1.20"
    authors =
            listOf(
                "Hare-K02",
            )
    commands {
        register("bsend") {
            description = "send player to bungee server"
            usage = "/bsend <player> <server>"
            permission = "bsend.command"
            permissionMessage = permissionMessage
        }
    }
    permissions {
        register("bsend.command") {
            description = "Allows you to run the command"
            default = BukkitPluginDescription.Permission.Default.OP
        }
		}
}
