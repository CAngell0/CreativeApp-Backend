package mcobserver.backend;

import org.bukkit.plugin.java.JavaPlugin;

import mcobserver.backend.webserver.Webserver;

import mcobserver.backend.util.InfoPacketBuilder;
import mcobserver.backend.model.InfoPacket;

public class MCObserver extends JavaPlugin {

   public Webserver webserver;

   public MCObserver() {
      super();
      webserver = new Webserver(this);
   }

   @Override
   public void onLoad() {
      webserver.start();
      this.getLogger().info("Loaded!");
   }

   @Override
   public void onEnable() {
      this.getLogger().info("Enabled!");
   }

   @Override
   public void onDisable() {
      InfoPacket packet = InfoPacketBuilder.buildPacket("Groupies", this.getServer());
      getLogger().info(packet.toString());
      this.getLogger().info("Disabled!");
   }
}
