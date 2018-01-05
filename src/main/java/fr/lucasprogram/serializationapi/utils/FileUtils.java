/*
 * Copyright (c) 2018.
 */

package fr.lucasprogram.serializationapi.utils;

import java.io.*;

public class FileUtils {


    /**
     * This method is used to create new .JSON files
     * @param file = file will be create
     * @throws IOException
     */
    public static void createFile(File file)throws IOException{
        if(!file.exists()){
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
    }


    /**
     * This method is used to flush data on disk
     * @param file = Input file
     * @param data = Input data to write in file
     */
    public static void save(File file, String data){
        final FileWriter fileWriter;

        try{
            createFile(file);

            fileWriter = new FileWriter(file);
            fileWriter.write(data);
            fileWriter.flush();
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method is used to load a file
     * @param file = Input file
     * @return all content of the file
     */
    public static String loadContent(File file){
        try{
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            final StringBuilder text = new StringBuilder();

            String line;

            while((line = reader.readLine()) != null){
                text.append(line);

            }
            reader.close();

            return text.toString();

        }catch(IOException e){
            e.printStackTrace();
        }

        return "";
    }
}
