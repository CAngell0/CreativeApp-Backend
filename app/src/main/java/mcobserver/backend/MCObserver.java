package mcobserver.backend;

import org.bukkit.plugin.java.JavaPlugin;

import mcobserver.backend.webserver.Webserver;

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
      this.getLogger().info("Disabled!");
   }
}
