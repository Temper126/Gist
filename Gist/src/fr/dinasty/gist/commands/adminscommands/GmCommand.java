package fr.dinasty.gist.commands.adminscommands;

import fr.dinasty.gist.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.swing.*;

public class GmCommand implements CommandExecutor {
    private final Main main;
    Player player;
    String mode;
    public GmCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length < 1)
        {
            sender.sendMessage("[Gist] Utilisation de la commande: /gm <Joueur> <0-1-2>");
            return true;
        }

        if(args.length > 1)
        {
            player = Bukkit.getPlayer(args[0]);
            if(player == null)
            {
                sender.sendMessage("[Gist] Joueur non trouvé");
                return false;
            }
            mode = args[1];
        }
        else
        {
            player = (Player)sender;
            mode = args[0];
        }

        switch (mode)
        {
            case "0":
                player.setGameMode(GameMode.SURVIVAL);
                break;
            case "1":
                player.setGameMode(GameMode.CREATIVE);
                break;
            case "2":
                player.setGameMode(GameMode.ADVENTURE);
                break;
            default:
                sender.sendMessage("[Gist] Utilisation de la commande: /gm <Joueur> <0-1-2>");
                return false;
        }
        sender.sendMessage("[Gist] Mode de jeu update");
        return true;
    }
}
