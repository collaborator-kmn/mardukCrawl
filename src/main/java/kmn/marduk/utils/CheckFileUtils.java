package kmn.marduk.utils;

import java.io.File;

public class CheckFileUtils {

   public CheckFileUtils(String file) {
      defaultPath(file);
   }


   private String defaultPath (String file){
       if (!file.equals(System.getProperty("user.home") + File.separator + ".crawl" + "marduk.properties")) {
          return System.getProperty("/Users/mihail/IdeaProjects/mardukCrawl/src/main/resources/marduk.properties");
       } else if (!file.equals(System.getProperty("user.home") + File.separator + ".crawl" + "sqlserver.properties")){
          return System.getProperty("/Users/mihail/IdeaProjects/mardukCrawl/src/main/resources/sqlserver.properties");
       }
      return file;
   }
}
