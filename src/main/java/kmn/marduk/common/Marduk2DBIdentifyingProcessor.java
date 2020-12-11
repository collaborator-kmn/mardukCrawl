package kmn.marduk.common;

import kmn.marduk.common.processor.ProcessException;
import kmn.marduk.common.processor.Processor;
import kmn.marduk.entity.DataBaseIdentifying;
import kmn.marduk.entity.Marduk;

public class Marduk2DBIdentifyingProcessor implements Processor<Marduk, DataBaseIdentifying> {
    @Override
    public DataBaseIdentifying process(Marduk marduk) throws ProcessException {
        DataBaseIdentifying dataBaseIdentifying = new DataBaseIdentifying();
        dataBaseIdentifying.setDBIdentifying_datatime(marduk.getMarduk_date());
        dataBaseIdentifying.setDBIdentifying_frequency(marduk.getMarduk_frequency());
        dataBaseIdentifying.setDBIdentifying_place(marduk.getMarduk_placeWork());
        dataBaseIdentifying.setDBIdentifying_country(marduk.getMarduk_country());
        dataBaseIdentifying.setDBIdentifying_speed(marduk.getMarduk_speed());
        dataBaseIdentifying.setDBIdentifying_period(marduk.getMarduk_duration()); // уточнить!
        dataBaseIdentifying.setDBIdentifying_ERBD(marduk.getMarduk_typeSignal());
        dataBaseIdentifying.setDBIdentifying_name(marduk.getMarduk_note());
        dataBaseIdentifying.setDBIdentifying_RadioNetwork(marduk.getMarduk_RadioNetwork());
        dataBaseIdentifying.setDBIdentifying_operator(marduk.getMarduk_session());
        dataBaseIdentifying.setDBIdentifying_NL(marduk.getMarduk_latitude());
        dataBaseIdentifying.setDBIdentifying_EL(marduk.getMarduk_longitude());
        return dataBaseIdentifying;
    }
}
