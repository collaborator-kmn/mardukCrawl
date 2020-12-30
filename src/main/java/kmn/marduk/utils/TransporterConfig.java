package kmn.marduk.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class TransporterConfig {

    public TransporterConfig(){
        if (!Files.exists(Paths.get(SettingStorage.DATE_SETTINGS))) {
            getStartDate();
            getEndDate();
        }
    }

    public Date getStartDate(){
            LocalDate firstDate = LocalDate.now();
            LocalTime time = LocalTime.of(9, 00,00);
            return convertToDate((LocalDateTime.of(firstDate, time)));
    }


    public Date getEndDate(){
            LocalDate secondDate = LocalDate.now().minusDays(1);
            LocalTime time = LocalTime.of(9, 00,00);
            return convertToDate((LocalDateTime.of(secondDate, time)));
    }

    public static TransporterConfig newInstance(){
        if (Files.exists(Paths.get(SettingStorage.DATE_SETTINGS))){
            ReaderUtils.readPropertiesFromFile(SettingStorage.DATE_SETTINGS);
        }
        return new TransporterConfig();
    }

    public Date convertToDate(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }
}
