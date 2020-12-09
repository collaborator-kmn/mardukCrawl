package main;

import main.dao.MardukDAO;
import main.dao.MardukOracleDAO;
import main.entity.Marduk;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Nickolay Burdiladze
 */
public class StartApp {
    public static void main(String[] args) {
        MardukDAO dao = new MardukOracleDAO();
        List<Marduk> list = dao.get(
                convert(LocalDate.of(2020,11,1)),
                convert(LocalDate.of(2020,12,1))
        );

        list.forEach(System.out::println);
    }

    private static Date convert(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
}