package kmn.marduk;


import kmn.marduk.common.impl.Marduk2DBIdentifyingProcessor;
import kmn.marduk.common.impl.MardukOracleFactory;
import kmn.marduk.core.impl.ContextImpl;
import kmn.marduk.core.impl.MardukTransporter;
import kmn.marduk.dao.MardukDAO;
import kmn.marduk.dao.impl.DBIdentifyingSQLServerDAO;
import kmn.marduk.dao.impl.MardukOracleDAO;
import kmn.marduk.entity.Marduk;
import kmn.marduk.utils.ReaderUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Properties;

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

        MardukDAO dao = new MardukOracleDAO((MardukOracleFactory) MardukOracleFactory.newInstance());
        List<Marduk> list = dao.get(
                convert(LocalDate.of(2020,11,1)),
                convert(LocalDate.of(2020,12,1))
        );

       list.forEach(System.out::println);
//        list.forEach(System.out.println(list.get()););
    }

    private static Date convert(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

}