package mcobserver.backend.util;

import mcobserver.backend.model.InfoPacket;
import org.bukkit.Server;
import org.bukkit.entity.Player;

public class InfoPacketBuilder {
   public static InfoPacket buildPacket(String serverName, Server server){
      InfoPacket packet = new InfoPacket();
      packet.setServerInfo(serverName, server.getServerIcon().getData());

      for (Player player : server.getOnlinePlayers()){
         InfoPacket.Player playerInfo = new InfoPacket.Player(
            player.getName(), 
            player.getUniqueId().toString()
         );

         playerInfo.setPosition(
            player.getX(), 
            player.getY(), 
            player.getZ()
         );

         playerInfo.setHeading(
            player.getPitch(), 
            player.getYaw(), 
            player.getFacing().toString()
         );

         packet.addPlayer(playerInfo);
      }

      return packet;
   }
}
