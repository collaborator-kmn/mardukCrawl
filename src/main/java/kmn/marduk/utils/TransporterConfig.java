package kmn.marduk.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Properties;

public class TransporterConfig {

    Date start;
    Date end;
    
    public TransporterConfig(){
        this.start = new Date(new Date().getTime()-1000*60*60);
        //start;
        this.end = new Date();
        // end;
    }

    public TransporterConfig(Date start, Date end){
        this.start = new Date(new Date().getTime()-1000*60*60);
                //start;
        this.end = new Date();
        // end;
    }

    public Date getStartDate(){
            return start;
    }

    public Date getEndDate(){
            return end;
    }

    public static TransporterConfig newInstance(){
//        if (Files.exists(Paths.get(SettingStorage.DATE_SETTINGS))){
//            Properties properties = ReaderUtils.readPropertiesFromFile(SettingStorage.DATE_SETTINGS);
//            String start = properties.getProperty("start");
//            String end = properties.getProperty("end");
//            LocalDate localDateStart = LocalDate.parse(start);
//            LocalDate localDateEnd = LocalDate.parse(end);
//            Date dateStart = converter(localDateStart);
//            Date dateEnd = converter(localDateEnd);
//
//            return new TransporterConfig(dateStart, dateEnd);
//        }
//
//        LocalDate firstDate = LocalDate.now();
//        LocalTime time = LocalTime.of(9, 00,00);
//        LocalDate secondDate = LocalDate.now().minusDays(1);
//
//        return new TransporterConfig(convertToDate(LocalDateTime.of(secondDate, time)), convertToDate(LocalDateTime.of(firstDate,time)));
        return new TransporterConfig();
    }

}
