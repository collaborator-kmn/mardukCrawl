package kmn.marduk.core.transportation.impl;

import kmn.marduk.core.transformation.marduk2sqlserver.processor.ProcessException;
import kmn.marduk.core.transportation.AbstractTransporter;
import kmn.marduk.core.context.Context;
import kmn.marduk.core.transportation.Transporter;
import kmn.marduk.entity.DataBaseIdentifying;
import kmn.marduk.entity.Marduk;
import kmn.marduk.utils.TransporterConfig;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *Класс, в котором происходит сам процесс транспортировки списка сущностей типа Мардук
 *в список сущностей типа БД Выявлений
 */
public class MardukTransporter extends AbstractTransporter {
    private static final Logger logger = Logger.getLogger(Transporter.class);
    private Date start;
    private Date end;

    public MardukTransporter(Context context){
        super(context);
    }

    public MardukTransporter(Context context, TransporterConfig transporterConfig){
        super(context);
        this.start = transporterConfig.getStartDate();
        this.end = transporterConfig.getEndDate();
        logger.info("get context and transporter config");
    }

    public void run() {
        List<Marduk> listMardukEntity = getContext().getMardukDao().get(start, end);
        logger.info("get listMardukEntity");
        List<DataBaseIdentifying> listDataBaseIdentifying = new ArrayList<>();
        logger.info("create listDataBaseIdentifying");

        for (Marduk marduk : listMardukEntity){
            try {
                listDataBaseIdentifying.add(getContext().getProcess().process(marduk));
            } catch (ProcessException e) {
                logger.log(Level.ERROR, "Error to add entity in listDataBaseIdentifying");
            }
        }
        getContext().getDBIdentifyingDao().put(listDataBaseIdentifying);
        logger.info("Successful put listMardukEntity in to listDataBaseIdentifying ");
    }

}
