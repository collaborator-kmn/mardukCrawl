package kmn.marduk.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Nickolay Burdiladze
 */
public class ReaderUtils {
   FileInputStream fis = null;
   Properties properties = new Properties();

   public ReaderUtils() {

   }


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