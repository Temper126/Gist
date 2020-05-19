package fr.dinasty.gist.saveable;

import java.util.HashMap;

public class Profile {
    private String name;
    private HashMap<String, Home> homes;
    public Profile(String name)
    {
        this.name = name;
        this.homes = homes = new HashMap<>();
    }

    public String getName()
    {
        return name;
    }

    public HashMap<String, Home> getHomes()
    {
        return homes;
    }
}
