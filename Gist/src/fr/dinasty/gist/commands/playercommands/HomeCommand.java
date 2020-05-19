package fr.dinasty.gist.commands.playercommands;

import fr.dinasty.gist.Main;
import fr.dinasty.gist.saveable.Home;
import fr.dinasty.gist.saveable.Profile;
import fr.dinasty.gist.runnable.Teleportation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {
    private final Main main;
    public HomeCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Profile profile = main.getProfilesManager().getProfile(sender.getName());
        if(args.length<1)
        {
            if(profile.getHomes().size() == 1)
            {
                Home home = null;
                for(Home last: main.getProfilesManager().getProfile(sender.getName()).getHomes().values())
                {
                    home = last;
                }
                tp((Player) sender, home);
                return true;
            }
            else if(profile.getHomes().size() == 0)
            {
                sender.sendMessage("[Gist] Vous devez avant tout placer votre home: /sethome <home>");
                return true;
            }
            StringBuilder builder = new StringBuilder();
            int i = 0;
            for(Home last: main.getProfilesManager().getProfile(sender.getName()).getHomes().values())
            {
                builder.append(last.getName());
                if(i<main.getProfilesManager().getProfile(sender.getName()).getHomes().size() -1)
                {
                    builder.append(", ");
                }
                i++;
            }
            sender.sendMessage("[Gist] La liste de vos homes: "+builder.toString());
        }
        else
        {
            if(main.getProfilesManager().getProfile(sender.getName()).getHomes().containsKey(args[0]))
            {
                tp((Player)sender, main.getProfilesManager().getProfile(sender.getName()).getHomes().get(args[0]));
                return true;
            }
            sender.sendMessage("[Gist] Home non trouvé: /home pour afficher le liste de vos homes");
        }

        return true;
    }
    public Boolean tp(Player player, Home home)
    {
        if(player.isOp())
        {
            player.teleport(home.getLocation());
            return true;
        }
        new Teleportation(player, home.getLocation(), player.getName()+"Teleportation").runTaskTimer(main, 0, 20*5);
        return true;
    }
}
