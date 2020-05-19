package fr.dinasty.gist.managers;

import fr.dinasty.gist.saveable.Profile;
import net.minecraft.util.com.google.gson.Gson;
import net.minecraft.util.com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class ProfilesManager
{
    private final Gson gson;
    private ArrayList<Profile> profiles;

    public ProfilesManager()
    {
        gson = createGsonInstance();
        profiles = new ArrayList<Profile>();
    }

    private Gson createGsonInstance()
    {
        return new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
    }

    public String serialize(Profile profile)
    {
        return gson.toJson(profile);
    }

    public Profile deserialize(String json)
    {
        return gson.fromJson(json, Profile.class);
    }

    public ArrayList<Profile> getProfiles()
    {
        return profiles;
    }

    public Profile getProfile(String name)
    {
        for (Profile curseur: profiles)
        {
            if(curseur.getName().equals(name))
            {
                return curseur;
            }
        }
        return null;
    }
}
