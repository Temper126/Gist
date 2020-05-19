package fr.dinasty.gist.managers;

import fr.dinasty.gist.Main;
import fr.dinasty.gist.commands.adminscommands.FlyCommand;
import fr.dinasty.gist.commands.adminscommands.HealCommand;
import fr.dinasty.gist.commands.adminscommands.GmCommand;
import fr.dinasty.gist.commands.adminscommands.SetWarpCommand;
import fr.dinasty.gist.commands.playercommands.*;

import java.util.HashMap;

public class CommandsManager {

    private final Main main;
    private HashMap<String, String> replyTarget;
    public CommandsManager(Main main)
    {
        this.main = main;
        this.replyTarget = new HashMap<String, String>();
    }

    public void registerCommands()
    {
        main.getCommand("m").setExecutor(new MsgCommmand(this.main));
        main.getCommand("r").setExecutor(new RCommand(this.main));
        main.getCommand("sethome").setExecutor(new SethomeCommand(this.main));
        main.getCommand("home").setExecutor(new HomeCommand(this.main));
        main.getCommand("gm").setExecutor(new GmCommand(this.main));
        main.getCommand("feed").setExecutor(new FeedCommand(this.main));
        main.getCommand("heal").setExecutor(new HealCommand(this.main));
        main.getCommand("fly").setExecutor(new FlyCommand(this.main));
        main.getCommand("warp").setExecutor(new WarpCommand(this.main));
        main.getCommand("setwarp").setExecutor( new SetWarpCommand(this.main));
    }

    public HashMap<String, String> getReplyTarget(){
        return this.getReplyTarget();
    }
}
