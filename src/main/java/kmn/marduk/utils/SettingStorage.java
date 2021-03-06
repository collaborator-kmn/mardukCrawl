package kmn.marduk.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

/**Установки хранилища
 *
 */

public class SettingStorage {

    static final String HOME_PATH = System.getProperty("user.home")+ File.separator+".crawl";
    public static final String MARDUK_PROPERTIES = HOME_PATH + File.separator + "marduk.properties";
    public static final String SQLSERVER_PROPERTIES = HOME_PATH + File.separator+"sqlserver.properties";
    public static final String TRANSPORT_PROPERTIES = HOME_PATH + File.separator + "transport.properties";

    private SettingStorage(){
    }

    public static void init() {
        if (!Files.exists(Paths.get(HOME_PATH))) {
            try {
                Files.createDirectories(Paths.get(HOME_PATH));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            if (!Files.exists(Paths.get(MARDUK_PROPERTIES)) && !Files.exists(Paths.get(SQLSERVER_PROPERTIES))) {
                Files.copy(Objects.requireNonNull(SettingStorage.class.getClassLoader()
                        .getResourceAsStream("marduk.properties")), Paths.get(MARDUK_PROPERTIES));
                Files.copy(Objects.requireNonNull(SettingStorage.class.getClassLoader()
                        .getResourceAsStream("sqlserver.properties")), Paths.get(SQLSERVER_PROPERTIES));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

