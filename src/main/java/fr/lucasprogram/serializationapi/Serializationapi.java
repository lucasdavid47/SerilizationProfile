/*
 * Copyright (c) 2018.
 */

package fr.lucasprogram.serializationapi;

import fr.lucasprogram.serializationapi.listener.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Serializationapi extends JavaPlugin {

    private Serializationapi INSTANCE;

    public Serializationapi getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void onEnable() {
        System.out.println("SerializationAPI basic start");

        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
