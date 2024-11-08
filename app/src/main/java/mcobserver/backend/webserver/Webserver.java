package mcobserver.backend.webserver;

import org.bukkit.plugin.java.JavaPlugin;

import io.javalin.Javalin;

public class Webserver {
   private Javalin app;
   private JavaPlugin plugin;

   public Webserver(JavaPlugin plugin){
      this.plugin =  plugin;
   }
   
   public void start() {
      app = Javalin.create()
         .get("/", ctx -> {
            plugin.getLogger().info("Request Recieved!");
            ctx.status(200);
         })
         .start(25657);
      
   }
}
