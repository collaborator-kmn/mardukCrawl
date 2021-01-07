package kmn.marduk.core.impl;

import kmn.marduk.common.processor.ProcessException;
import kmn.marduk.core.Context;
import kmn.marduk.core.AbstractTransporter;
import kmn.marduk.entity.DataBaseIdentifying;
import kmn.marduk.entity.Marduk;
import kmn.marduk.utils.TransporterConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *Класс, в котором происходит сам процесс транспортировки списка сущностей типа Мардук
 *в список сущностей типа БД Выявлений
 */
public class MardukTransporter extends AbstractTransporter {
    private Date start;
    private Date end;

    public MardukTransporter(Context context){
        super(context);
    }

    public MardukTransporter(Context context, TransporterConfig transporterConfig){
        super(context);
        this.start = transporterConfig.getStartDate();
        this.end = transporterConfig.getEndDate();
    }

    public void run() {
        List<Marduk> listMardukEntity = getContext().getMardukDao().get(start, end);
        List<DataBaseIdentifying> listDataBaseIdentifying = new ArrayList<>();

        for (Marduk marduk : listMardukEntity){
            try {
                listDataBaseIdentifying.add(getContext().getProcess().process(marduk));
            } catch (ProcessException e) {
                e.printStackTrace();
            }
        }
        getContext().getDBIdentifyingDao().put(listDataBaseIdentifying);
    }

}
