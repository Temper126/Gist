package fr.dinasty.gist.events;

import fr.dinasty.gist.Main;
import fr.dinasty.gist.saveable.Profile;
import fr.dinasty.gist.utils.FileUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;

public class OnJoinEvent implements Listener {
    private final Main main;
    private final File saveDirectory;
    public OnJoinEvent(Main main)
    {
        this.main = main;
        saveDirectory = new File(main.getDataFolder(),"/profiles/");
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        File profileFile = new File(saveDirectory, player.getName()+".json");
        Profile profile;
        if(!profileFile.exists())
        {
            profile = new Profile(player.getName());
        }
        else {
            profile = main.getProfilesManager().deserialize(FileUtils.loadContent(profileFile));
        }
        main.getProfilesManager().getProfiles().add(profile);
    }
}
