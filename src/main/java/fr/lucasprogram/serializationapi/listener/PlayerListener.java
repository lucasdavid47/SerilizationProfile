package fr.lucasprogram.serializationapi.listener;

import fr.lucasprogram.serializationapi.Profile.Profile;
import fr.lucasprogram.serializationapi.Serializationapi;
import fr.lucasprogram.serializationapi.gsonutils.SerializationManager;
import fr.lucasprogram.serializationapi.utils.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;

public class PlayerListener implements Listener{

    private Serializationapi serializationapi;
    private File saveDirectory;

    public PlayerListener(Serializationapi serializationapi) {
        this.serializationapi = serializationapi;
        this.saveDirectory = new File(serializationapi.getDataFolder() + "/profiles/");
    }


    /**
     * Basic listening join event
     * @param e = event.
     */
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        File playerFile = new File(saveDirectory, e.getPlayer().getName() + ".json");

        if(playerFile.exists()){
            final SerializationManager serializationManager = new SerializationManager();
            final String json = FileUtils.loadContent(playerFile);
            final Profile profile = serializationManager.deserialize(json);

            Bukkit.getServer().broadcastMessage("§6Le joueur " +
                    profile.getName() + " à pour UUID " + profile.getId() +
                    " et est en: X " + profile.getX() + " Y " + profile.getY() + " Z " + profile.getZ()
                    + " et à " + profile.getLevel() + " points d'xp !");


        }else{
            e.getPlayer().sendMessage("Profil non trouvé, création du compte lors de la prochaine déconnection!");
        }

    }


    /**
     * Basic listening quit event
     * @param e = event.
     */

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        File playerFile = new File(saveDirectory, e.getPlayer().getName() + ".json");
        final SerializationManager serializationManager = new SerializationManager();
        final Profile profile = Profile.createProfile(e.getPlayer());
        final String json = serializationManager.serialize(profile);

        FileUtils.save(playerFile, json);
    }


}
