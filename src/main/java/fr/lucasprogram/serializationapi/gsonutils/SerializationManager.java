/*
 * Copyright (c) 2018.
 */

package fr.lucasprogram.serializationapi.gsonutils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.lucasprogram.serializationapi.Profile.Profile;

public class SerializationManager {

    private Gson gson;

    public SerializationManager(){
        this.gson = createGsonInstance();
    }

    /**
     * @return GSON Properly configured
     */
    private Gson createGsonInstance(){
        return new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
    }

    /**
     * Method used to serialize data in
     * .json file
     * @param profile = input data to serialize
     * @return serialized
     */
    public String serialize(Profile profile){
        return this.gson.toJson(profile);
    }

    /**
     * Method used to deserialize data in
     * .json file
     * @param json = input data to serialize
     * @return deserialized
     */
    public Profile deserialize(String json){
        return this.gson.fromJson(json, Profile.class);
    }

}
