package kmn.marduk.core.impl;

import kmn.marduk.common.processor.ProcessException;
import kmn.marduk.core.Context;
import kmn.marduk.core.AbstractTransporter;
import kmn.marduk.entity.DataBaseIdentifying;
import kmn.marduk.entity.Marduk;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MardukTransporter extends AbstractTransporter {
    private Date start;
    private Date end;

    public MardukTransporter(Context context){
        super(context);
    }

    public MardukTransporter(Context context, Date start, Date end){
        super(context);
        this.start = start;
        this.end = end;
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
