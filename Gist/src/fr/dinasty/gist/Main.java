package fr.dinasty.gist;

import fr.dinasty.gist.managers.CommandsManager;
import fr.dinasty.gist.managers.EventsManager;
import fr.dinasty.gist.managers.ProfilesManager;
import fr.dinasty.gist.managers.WarpsManager;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {
    Logger logger = Logger.getLogger("Gist");
    private CommandsManager cmdM;
    private ProfilesManager profilesManager;
    private WarpsManager warpsManager;
    private EventsManager eventsManager;

    @Override
    public void onEnable() {
        logger.info("[Gist]: Gist est un plugin publique merci de ne pas modifier son code à des fins commerciales");
        cmdM = new CommandsManager(this);
        cmdM.registerCommands();

        eventsManager = new EventsManager(this);
        eventsManager.registerEvents();

        profilesManager = new ProfilesManager();

        warpsManager = new WarpsManager(this);
        warpsManager.loadWarps();
    }

    @Override
    public void onDisable() {
        warpsManager.saveWarps();
    }

    public CommandsManager getCmdM(){
        return cmdM;
    }

    public ProfilesManager getProfilesManager() {
        return profilesManager;
    }

    public WarpsManager getWarpsManager() { return  warpsManager;}
}
