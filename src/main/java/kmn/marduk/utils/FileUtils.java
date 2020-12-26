package kmn.marduk.utils;

import java.io.File;

public class FileUtils {

    public static String mardukLocation(){
        return System.getProperty("user.home")+ File.separator+".crawl"+"marduk.properties";
    };
    public static String sqlLocation(){
        return System.getProperty("user.home")+ File.separator+".crawl"+"sqlserver.properties";
    };

}
