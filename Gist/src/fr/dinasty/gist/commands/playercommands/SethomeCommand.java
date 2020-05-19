package fr.dinasty.gist.commands.playercommands;

import fr.dinasty.gist.Main;
import fr.dinasty.gist.saveable.Home;
import fr.dinasty.gist.saveable.Profile;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SethomeCommand implements CommandExecutor {
    private final Main main;
    public SethomeCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        String homeName;
        Profile profile = main.getProfilesManager().getProfile(player.getName());
        if(args.length < 1)
        {
            homeName = "home";
        }
        else
        {
            homeName = args[0];
        }

        if(profile.getHomes().containsKey(homeName))
        {
            player.sendMessage("[Gist] Le home "+homeName+" a été modifié");
        }
        else
        {
            player.sendMessage("[Gist] Le home "+homeName+" a été créé");
        }

        Location location = player.getLocation();
        profile.getHomes().put(homeName, new Home(homeName,location.getWorld().getName(),location));
        return true;
    }
}
