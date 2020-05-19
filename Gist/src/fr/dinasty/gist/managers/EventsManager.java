package fr.dinasty.gist.managers;

import fr.dinasty.gist.Main;
import fr.dinasty.gist.events.OnJoinEvent;
import fr.dinasty.gist.events.OnLeaveEvent;
import org.bukkit.Bukkit;

public class EventsManager {
    private final Main main;
    public EventsManager(Main main)
    {
        this.main = main;
    }

    public void registerEvents()
    {
        Bukkit.getPluginManager().registerEvents(new OnLeaveEvent(main), main);
        Bukkit.getPluginManager().registerEvents(new OnJoinEvent(main), main);
    }

}
