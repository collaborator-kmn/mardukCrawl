package kmn.marduk.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Nickolay Burdiladze
 */
public class ReaderUtils {
   FileInputStream fis = null;
   Properties properties = new Properties();

   public String getUsername(){return readMardukResources().getProperty("username");}
   public char[] getPassword(){return readMardukResources().getProperty("password").toCharArray();}
   public String getDatabase(){return readMardukResources().getProperty("database");}
   public String getServer(){return readMardukResources().getProperty("server");}
   public int getPort() { return Integer.parseInt(readMardukResources().getProperty("port"));}

    public Properties readMardukResources() {

        try {
            fis = new FileInputStream("/Users/mihail/IdeaProjects/mardukCrawl/src/main/resources/marduk.properties");
            properties.load(fis);
            return properties;

        } catch (Exception e) {
            System.out.println("Ошибка загрузки");;
        }
        return new Properties();
    }
}