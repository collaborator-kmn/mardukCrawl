package kmn.marduk.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SettingStorage {
    public static final String HOME_PATH = System.getProperty("user.home")+ File.separator+".crawl";
    public static final String MARDUK_PROPERTIES = HOME_PATH + File.separator + "marduk.properties";
    public static final String SQLSERVER_PROPERTIES = HOME_PATH + File.separator+"sqlserver.properties";
    public static final String DATA_SETTINGS = HOME_PATH + File.separator + "date_settings.properties";

    public SettingStorage(){
    if (!Files.exists(Paths.get(HOME_PATH))) {
        try {
            Files.createDirectories(Paths.get(HOME_PATH));
            if (!Files.exists(Paths.get(MARDUK_PROPERTIES)) && !Files.exists(Paths.get(SQLSERVER_PROPERTIES))) {
                //TODO
                getClass().getClassLoader().getResource("marduk.properties").getFile();
                getClass().getClassLoader().getResource("sqlserver.properties").getFile();
                //files.create
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    }
}

