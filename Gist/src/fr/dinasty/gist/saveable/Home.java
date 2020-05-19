package fr.dinasty.gist.saveable;

import org.bukkit.Location;

public class Home {
    private String worldName,name;
    private Location location;

    public Home(String name, String worldName, Location location)
    {
        this.worldName = worldName;
        this.name = name;
        this.location = location;
    }

    public String getName()
    {
        return name;
    }

    public String getWorldName()
    {
        return worldName;
    }

    public Location getLocation()
    {
        return this.location;
    }
}
