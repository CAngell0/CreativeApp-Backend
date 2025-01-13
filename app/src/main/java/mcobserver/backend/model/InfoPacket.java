package mcobserver.backend.model;

import java.util.ArrayList;

public class InfoPacket {
   private String packetType = "info";
   private ServerInfo serverInfo;
   private ArrayList<Player> players;
   private String console;

   public InfoPacket(){
      this.serverInfo = null;
      this.players = new ArrayList<Player>();
      this.console = "";
   }
   public InfoPacket(ServerInfo serverInfo, ArrayList<Player> players, String console){
      this.serverInfo = serverInfo;
      this.players = players;
      this.console = console;
   }
   
   public static class ServerInfo {
      private String name;
      private String icon;
      public ServerInfo(String name, String icon){
         this.name = name;
         this.icon = icon;
      }

      @Override
      public String toString() {
         return "\nServer Info: \n\tName: " + name + "\n\tIcon: " + icon;
      }
   }

   public static class Player {
      private String name;
      private String UUID;
      private PlayerPosition pos;
      private PlayerHeading facing;
      public Player(String name, String UUID){
         this.name = name;
         this.UUID = UUID;
         this.pos = null;
         this.facing = null;
      }
      public Player(String name, String UUID, PlayerPosition pos, PlayerHeading facing){
         this.name = name;
         this.UUID = UUID;
         this.pos = pos;
         this.facing = facing;
      }

      public void setPosition(double x, double y, double z){
         this.pos = new PlayerPosition(x, y, z);
      }
      public void setHeading(double pitch, double yaw, String direction){
         this.facing = new PlayerHeading(pitch, yaw, direction);
      }

      @Override
      public String toString() {
         String posString = pos.toString();
         String facingString = facing.toString();
         return "\n\tName: " + name + "\n\tUUID: " + UUID + posString + facingString;
      }
   }
   public static class PlayerPosition {
      private double x;
      private double y;
      private double z;
      public PlayerPosition(double x, double y, double z){
         this.x = x;
         this.y = y;
         this.z = z;
      }

      @Override
      public String toString() {
         return "\n\tPosition: (" + x + ", " + y + ", " + z + ")";
      }
   }
   public static class PlayerHeading {
      private double pitch;
      private double yaw;
      private String direction;
      public PlayerHeading(double pitch, double yaw, String direction){
         this.pitch = pitch;
         this.yaw = yaw;
         this.direction = direction;
      }
      
      @Override
      public String toString() {
         return "\n\tFacing: \n\t\tYaw: " + yaw + "\n\t\tPitch: " + pitch + "\n\t\tDirection: " + direction;
      }
   }

   public void setServerInfo(String name, String icon){
      ServerInfo serverInfo = new ServerInfo(name, icon);
      this.serverInfo = serverInfo;
   }
   public void addPlayer(Player player){
      this.players.add(player);
   }
   public ArrayList<Player> getPlayers(){
      return this.players;
   }

   public void setConsole(String console){
      this.console = console;
   }

   @Override
   public String toString() {
      String packetString = "\nPacket Type: info";

      String serverInfoString = serverInfo.toString();
      packetString += serverInfoString;

      packetString += "\nPlayers:";
      for (Player player : players){
         packetString += player.toString();
      }

      return packetString;
   }
}
