package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;
    static
    {
        String filePath="configuration.properties";
        try{
            FileInputStream fis = new FileInputStream(filePath);
            properties=new Properties();
            properties.load(fis);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String Key) {//String bir değer döndürmesi için String bir parametre atarız
        /*
            Test method'undan gönderdiğimiz string key değerini alıp ConfigReader class'ından
        getProperty() methodunu kullanarak bu key'e ait value'yu bize getirir.
         */
        return properties.getProperty(Key);
    }
}
