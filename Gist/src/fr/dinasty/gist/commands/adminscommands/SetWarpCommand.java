package fr.dinasty.gist.commands.adminscommands;

import fr.dinasty.gist.Main;
import fr.dinasty.gist.saveable.Warp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarpCommand implements CommandExecutor {
    private final Main main;
    Warp warp;
    public SetWarpCommand(Main main)
    {
        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length <1)
        {
            sender.sendMessage("[Gist] Utilisation correct: /setwarp <name>");
            return false;
        }
        Player player = (Player)sender;
        warp = new Warp(args[0], player.getLocation());
        for(int i =0; i<main.getWarpsManager().getWarps().size(); i++)
        {
            if(main.getWarpsManager().getWarps().get(i).getName().equalsIgnoreCase(warp.getName()))
            {
                main.getWarpsManager().getWarps().add(i, warp);
                sender.sendMessage("[Gist] Warp modifié");
                return true;
            }
        }

        main.getWarpsManager().getWarps().add(warp);
        sender.sendMessage("[Gist] Warp ajouté");
        return true;
    }
}
