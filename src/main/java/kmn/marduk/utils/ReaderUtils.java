package kmn.marduk.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Nickolay Burdiladze
 */
public class ReaderUtils {


   public ReaderUtils() {
   }

    public static Properties readMardukResources(){
        Properties properties = new Properties();

        try(FileInputStream fis = new FileInputStream("/Users/mihail/IdeaProjects/mardukCrawl/src/main/resources/marduk.properties")){
            properties.load(fis);
            return properties;
        } catch (IOException e) {
            System.out.println("Ошибка загрузки ");;
        }
        return new Properties();
    }
}