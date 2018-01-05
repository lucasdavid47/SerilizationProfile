/*
 * Copyright (c) 2018.
 */

package fr.lucasprogram.serializationapi.Profile;

import org.bukkit.entity.Player;

import java.util.UUID;

public class Profile {


    private UUID id;
    private String name;
    private Integer level;
    private double x;
    private double y;
    private double z;


    /**
     * Constructor of the profile
     *
     * @param id
     * @param name
     * @param level
     * @param x
     * @param y
     * @param z
     */
    public Profile(UUID id, String name, Integer level, double x, double y, double z) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public static Profile createProfile(Player player) {
            return new Profile(player.getUniqueId(), player.getName(), player.getLevel(), player.getLocation().getX(),
                    player.getLocation().getY(), player.getLocation().getZ());

    }
}
