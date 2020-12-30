package kmn.marduk;


import kmn.marduk.common.impl.MardukOracleFactory;
import kmn.marduk.dao.MardukDAO;
import kmn.marduk.dao.impl.MardukOracleDAO;
import kmn.marduk.entity.Marduk;
import kmn.marduk.utils.SettingStorage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

/**
 * Nickolay Burdiladze
 */
public class StartApp {
    public static void main(String[] args) {

//        Properties properties = ReaderUtils.readMardukResources();
//
//
//         MardukTransporter mardukTransporter = new MardukTransporter(new ContextImpl((new MardukOracleDAO(new MardukOracleFactory(properties))),
//                new DBIdentifyingSQLServerDAO(), new Marduk2DBIdentifyingProcessor()));
        SettingStorage settingStorage = new SettingStorage();
//        System.out.println(settingStorage.getStartDate());
//        System.out.println(settingStorage.getEndDate());

        MardukDAO dao = new MardukOracleDAO((MardukOracleFactory) MardukOracleFactory.newInstance());

        List<Marduk> list = dao.get(
                settingStorage.getStartDate(), settingStorage.getEndDate()
        );

       list.forEach(System.out::println);
    }

}