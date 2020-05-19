package fr.dinasty.gist.commands.playercommands;

import fr.dinasty.gist.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    private final Main main;
    Player player;
    public FeedCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        //Check si il y a un joueur visé por la commande
        if(args.length > 0)
        {
            player = Bukkit.getPlayer(args[0]);
            if(player == null)
            {
                sender.sendMessage("[Gist] Joueur non trouvé");
                return false;
            }
        }
        else
        {
            player = (Player)sender;
        }
        //Nourriture resrtauré
        player.setFoodLevel(20);
        player.sendMessage("[Gist] Nourriture restaurée");
        return true;
    }
}
