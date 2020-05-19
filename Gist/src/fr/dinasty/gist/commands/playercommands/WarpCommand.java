package fr.dinasty.gist.commands.playercommands;

import fr.dinasty.gist.Main;
import fr.dinasty.gist.runnable.Teleportation;
import fr.dinasty.gist.saveable.Warp;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {
    private final Main main;
    public WarpCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length < 1)
        {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i <main.getWarpsManager().getWarps().size(); i++)
            {
                stringBuilder.append(main.getWarpsManager().getWarps().get(i).getName());
                if(i<main.getWarpsManager().getWarps().size()-1)
                {
                    stringBuilder.append(" ;");
                }
            }
            sender.sendMessage("[Gist] Listes des Warps: " + stringBuilder.toString());
            return true;
        }
        Warp warp = null;
        for (int i = 0; i <main.getWarpsManager().getWarps().size(); i++)
        {
            if(args[0].equalsIgnoreCase(main.getWarpsManager().getWarps().get(i).getName()));
            {
                warp = main.getWarpsManager().getWarps().get(i);
                break;
            }
        }
        if(warp == null)
        {
            sender.sendMessage("[Gist] Warp non trouvé");
            return false;
        }
        new Teleportation((Player)sender, warp.getLocation(), sender.getName()+"Teleportation").runTaskTimer(main, 0, 20*5);

        return true;
    }
}
