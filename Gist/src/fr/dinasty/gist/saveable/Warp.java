package fr.dinasty.gist.saveable;


import org.bukkit.Location;

public class Warp {
    private String name;
    private Location location;

    public Warp(String name, Location location)
    {
        this.name = name;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
