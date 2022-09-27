package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private  static Properties properties= new Properties();

    static{
        try {
            //open the file in hava memory: file input stream
            FileInputStream file= new FileInputStream("configuration.properties");
            //load the properties object using file input stream object
            properties.load(file);
            //close the file
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("File not found in the Configuration Reader class");        }
    }

    //use it to get the value of any keyword
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }



}
