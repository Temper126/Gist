package fr.dinasty.gist.commands.playercommands;

import fr.dinasty.gist.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MsgCommmand implements CommandExecutor {
    private final Main main;
    public MsgCommmand(Main main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length <2){
            sender.sendMessage("[Gist] Utilisation Correct: /m <Player> <Message>");
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);

        if(target == null){
            sender.sendMessage("[Gist] Le joueur ciblé n'a pas été trouvé");
            return false;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i= 1; i<args.length; i++){
            stringBuilder.append(args[i]);
            if(i != args.length-1){
                stringBuilder.append(" ");
            }
        }
        target.sendMessage("["+sender.getName()+"] -> [Moi]: "+stringBuilder.toString());
        sender.sendMessage("[Moi] -> ["+target.getName()+"]"+stringBuilder.toString());

        main.getCmdM().getReplyTarget().put(sender.getName(), target.getName());
        main.getCmdM().getReplyTarget().put(target.getName(), sender.getName());
        
        return true;
    }
}
