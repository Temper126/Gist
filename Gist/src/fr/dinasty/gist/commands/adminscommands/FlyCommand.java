package fr.dinasty.gist.commands.adminscommands;

import fr.dinasty.gist.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    private final Main main;
    Player player;
    public FlyCommand(Main main)
    {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

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

        player.setAllowFlight(!player.getAllowFlight());
        player.sendMessage("[Gist] Fly activé");
        return true;
    }
}
