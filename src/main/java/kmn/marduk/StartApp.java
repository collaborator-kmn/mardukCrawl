package kmn.marduk;


import kmn.marduk.common.impl.MardukOracleFactory;
import kmn.marduk.dao.MardukDAO;
import kmn.marduk.dao.impl.MardukOracleDAO;
import kmn.marduk.entity.Marduk;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Nickolay Burdiladze
 */
public class StartApp {
    public static void main(String[] args) {

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