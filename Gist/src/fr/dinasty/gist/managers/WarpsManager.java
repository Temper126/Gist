package fr.dinasty.gist.managers;

import fr.dinasty.gist.Main;
import fr.dinasty.gist.saveable.Warp;
import fr.dinasty.gist.utils.FileUtils;
import net.minecraft.util.com.google.gson.Gson;
import net.minecraft.util.com.google.gson.GsonBuilder;

import java.io.File;
import java.util.ArrayList;

public class WarpsManager {

    private final Gson gson;
    private ArrayList<Warp> warps;
    private final Main main;
    File saveDirectory;

    public WarpsManager(Main main)
    {
        gson = createGsonInstance();
        warps = new ArrayList<Warp>();
        this.main = main;
        saveDirectory = new File(main.getDataFolder(), "/warps/");
    }

    private Gson createGsonInstance()
    {
        return new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
    }

    public String serialize(Warp warp)
    {
        return gson.toJson(warp);
    }

    public Warp deserialize(String json)
    {
        return gson.fromJson(json, Warp.class);
    }

    public ArrayList<Warp> getWarps()
    {
        return warps;
    }

    public Warp getWarp(String name)
    {
        for (Warp curseur: warps)
        {
            if(curseur.getName().equals(name))
            {
                return curseur;
            }
        }
        return null;
    }

    public void loadWarps()
    {
        File[] files=saveDirectory.listFiles();

        for (int i =0 ; i < files.length; i++)
        {
            warps.add(deserialize(FileUtils.loadContent(files[i])));
        }
    }

    public void saveWarps()
    {
      for(Warp warp : warps)
      {
          FileUtils.save(new File(saveDirectory, warp.getName()), serialize(warp));
      }
    }
}
