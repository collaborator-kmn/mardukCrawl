package kmn.marduk.common.impl;

import kmn.marduk.common.processor.ProcessException;
import kmn.marduk.common.processor.Processor;
import kmn.marduk.entity.DataBaseIdentifying;
import kmn.marduk.entity.Marduk;

public class Marduk2DBIdentifyingProcessor implements Processor<Marduk, DataBaseIdentifying> {
    @Override
    public DataBaseIdentifying process(Marduk marduk)  {
        DataBaseIdentifying dataBaseIdentifying = new DataBaseIdentifying();
        dataBaseIdentifying.setDate(marduk.getDATE_BEG());
        dataBaseIdentifying.setFreq(marduk.getFREQ_HZ());
        dataBaseIdentifying.setTown(marduk.getWHO_IS_COUNTRY());
        dataBaseIdentifying.setCoun(marduk.getWHO_IS_BRANCH());
        dataBaseIdentifying.setNum(marduk.getSIG_TYPE());
        dataBaseIdentifying.setOper(marduk.getSEANCE());
//        dataBaseIdentifying.setTo(marduk.getTO());
//        dataBaseIdentifying.setFrom(marduk.getFROM());
        dataBaseIdentifying.setAnal("");
        return dataBaseIdentifying;
    }
}
