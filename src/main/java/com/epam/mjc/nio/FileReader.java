package com.epam.mjc.nio;

import java.io.*;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileReader {
    Logger logger = Logger.getLogger(FileReader.class.getName());

    public Profile getDataFromFile(File file) {
        StringBuilder bld = new StringBuilder();
        try(BufferedReader bufferedReader = Files.newBufferedReader(file.toPath());)
        {
            String line = null;
            while((line= bufferedReader.readLine())!=null)
                bld.append(line);
        }catch (IOException ioException)
        {
            logger.log(Level.INFO, ioException.toString());
        }
        String fileContent = bld.toString();

        String[] parts = fileContent.split("\\s+");

        return new Profile(parts[1], Integer.parseInt(parts[3]), parts[5], Long.parseLong(parts[7]) );
    }
}
