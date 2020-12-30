package kmn.marduk.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Date_Settings {

    public Date getStartDate(){

        if (Files.exists(Paths.get(SettingStorage.DATE_SETTINGS))){
            ReaderUtils.readPropertiesFromFile(SettingStorage.DATE_SETTINGS);
        }
        else {
            LocalDate firstDate = LocalDate.now();
            LocalTime time = LocalTime.of(9, 00,00);
            return convertToDate((LocalDateTime.of(firstDate, time)));
        }
        return getStartDate();
    }


    public Date getEndDate(){
        if (Files.exists(Paths.get(SettingStorage.DATE_SETTINGS))){
            ReaderUtils.readPropertiesFromFile(SettingStorage.DATE_SETTINGS);
        }
        else {
            LocalDate secondDate = LocalDate.now().minusDays(1);
            LocalTime time = LocalTime.of(9, 00,00);
            return convertToDate((LocalDateTime.of(secondDate, time)));
        }
        return getEndDate();
    }


    public Date convertToDate(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }
}
