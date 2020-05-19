package fr.dinasty.gist.commands.playercommands;

import fr.dinasty.gist.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RCommand implements CommandExecutor {
    private final Main main;
    public RCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length < 1)
        {
            sender.sendMessage("[Gist] Utilisation Correct: /r <Message>");
            return false;
        }

        if(!main.getCmdM().getReplyTarget().containsKey(sender.getName()))
        {
            sender.sendMessage("[Gist] Vous n'avez pas de correspondant recent");
            sender.sendMessage("[Gist] Utiliser en priorité: /m <Player> <Message>");
            return false;
        }
        Player target = Bukkit.getPlayer(main.getCmdM().getReplyTarget().get(sender.getName()));
        if(target == null){
            sender.sendMessage("[Gist] Votre correspondant s'est déconnecté");
            main.getCmdM().getReplyTarget().remove(sender.getName());
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
