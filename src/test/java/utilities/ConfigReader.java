package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    private static FileInputStream input;
    private static Properties properties;

    // Make a connection once we create an object out of this class
    static{
        String path = "/Users/iliiasnazaraliev/Downloads/MindtekTestNGAutomation/src/test/resources/configurations/Config.properties";
        try {
             input = new FileInputStream(path);
             properties = new Properties();
            properties.load(input);
        } catch (FileNotFoundException e) {
            System.out.println("Path for properties file is invalid");
        }catch (IOException e){
            System.out.println("Couldn't read properties file.");
        }finally {
            try {
                input.close();
            } catch (IOException e) {
                System.out.println("Couldn't close input object.");
            }
        }
    }
    // Method that sends as parameter the key of properties file data and returns the value for that key
    public static String getProperty(String key){
        return properties.getProperty(key);  // key=browser -> value=chrome

    }
    
}
