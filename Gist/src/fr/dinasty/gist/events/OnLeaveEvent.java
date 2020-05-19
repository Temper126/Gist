package fr.dinasty.gist.events;

import fr.dinasty.gist.Main;
import fr.dinasty.gist.saveable.Profile;
import fr.dinasty.gist.utils.FileUtils;
import org.bukkit.craftbukkit.libs.org.ibex.nestedvm.util.Seekable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.util.HashMap;

public class OnLeaveEvent implements Listener {
    private final Main main;
    private final File saveDirectory;
    public OnLeaveEvent(Main main)
    {
        this.main = main;
        saveDirectory = new File(main.getDataFolder(),"/profiles/");
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        main.getCmdM().getReplyTarget().remove(player.getName());

        Profile profile;

        File profileFile = new File(saveDirectory, player.getName()+".json");

        for(Profile curseur: main.getProfilesManager().getProfiles())
        {
            if(curseur.getName().equals(player.getName()))
            {
                FileUtils.save(profileFile, main.getProfilesManager().serialize(curseur));
                main.getProfilesManager().getProfiles().remove(curseur);
                break;
            }
        }

        profile = main.getProfilesManager().getProfile(player.getName());
        FileUtils.save(profileFile, main.getProfilesManager().serialize(profile));
        main.getProfilesManager().getProfiles().remove(profile);
    }

}
