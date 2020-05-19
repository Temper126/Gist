package fr.dinasty.gist.runnable;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Teleportation extends org.bukkit.scheduler.BukkitRunnable
{
    Player player;
    Location locationBeginning;
    Location location;
    String name;
    int count;

    public Teleportation(Player player, Location location, String name)
    {
        this.name = name;
        this.player = player;
        this.location = location;
        locationBeginning = player.getLocation();
        count = 0;
    }

    public void run()
    {
        if(locationBeginning.getX() != player.getLocation().getX() || locationBeginning.getX() != player.getLocation().getY() || locationBeginning.getZ() != player.getLocation().getZ())
        {
            player.sendMessage("[Gist] Vous avez bougé, votre téléportation est annulée");
            this.cancel();
        }
        count++;
        if(count == 5)
        {
            player.sendMessage("[Gist] Téléportation en cours");
            player.teleport(location);
            this.cancel();
        }
    }

}
