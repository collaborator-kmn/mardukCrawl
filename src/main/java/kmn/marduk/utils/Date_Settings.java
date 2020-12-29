package kmn.marduk.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Date_Settings {

    public Date_Settings(Date start, Date end) {

        if (Files.exists(Paths.get(SettingStorage.DATA_SETTINGS))){
            ReaderUtils.readPropertiesFromFile(SettingStorage.DATA_SETTINGS);
        }
        else {
            LocalDate firstDate = LocalDate.now();
            LocalDate secondDate = LocalDate.now().minusDays(1);
            LocalTime time = LocalTime.of(9, 00,00);
//            LocalDateTime start = LocalDateTime.of(firstDate, time);
//            LocalDateTime end = LocalDateTime.of(secondDate, time);
           start = convertToDate((LocalDateTime.of(firstDate, time)));
           end = convertToDate((LocalDateTime.of(secondDate, time)));
        }

    }


    public Date convertToDate(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }

}
