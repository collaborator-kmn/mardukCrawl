package kmn.marduk.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

public class TransporterConfig {

    Date start;
    Date end;

    public TransporterConfig(){
    }

    public TransporterConfig(Date start, Date end){
        this.start = start;
        this.end = end;
    }

    public Date getStartDate(){
            return start;
    }

    public Date getEndDate(){
            return end;
    }

    public static TransporterConfig newInstance() {

        if (Files.exists(Paths.get(SettingStorage.DATE_SETTINGS))){
            Properties properties = ReaderUtils.readPropertiesFromFile(SettingStorage.DATE_SETTINGS);
            String start = properties.getProperty("start");
            String end = properties.getProperty("end");
            try {
                Date dateStart = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(start);
                Date dateEnd = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(end);
                return new TransporterConfig(dateStart, dateEnd);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

            LocalDate firstDate = LocalDate.now().minusDays(1);
            LocalTime time = LocalTime.of(9, 00, 00);
            LocalDate secondDate = LocalDate.now();
            LocalDateTime startM = LocalDateTime.of(firstDate, time);
            LocalDateTime endM = LocalDateTime.of(secondDate, time);

            return new TransporterConfig(Date.from(startM.atZone(ZoneId.systemDefault()).toInstant()),
                    Date.from(endM.atZone(ZoneId.systemDefault()).toInstant()));
        }

}
