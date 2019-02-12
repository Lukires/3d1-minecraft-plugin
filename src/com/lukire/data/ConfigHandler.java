package com.lukire.data;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import com.lukire.main.Main;

public class ConfigHandler extends YamlConfiguration
{
    private String filepath;
    private String filename;
    private File configFile;
    private Main main = Main.getPlugin(Main.class);

    public ConfigHandler(String filepath, String filename)
    {
        this.filepath=filepath.startsWith("/")? filepath:"/"+filepath;
        this.filename=filename.endsWith(".yml")? filename:filename+".yml";

        configFile = new File(main.getDataFolder()+this.filepath, this.filename);

        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
        }


        try{
            load(configFile);
        }catch(Exception e) {
            //For some reason the exception "FileNotFoundException" is called every time, even though everything works perfectly
            //I dunno why, but everything works so I'm not really complaining. The whole point of this try catch statement is just to avoid that
            //Annoying "error"
        }


    }
    public void save()
    {
        try{
            save(configFile);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
