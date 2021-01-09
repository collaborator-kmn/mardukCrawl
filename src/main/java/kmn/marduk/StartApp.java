package kmn.marduk;

import kmn.marduk.core.transformation.marduk2sqlserver.Marduk2DBIdentifyingProcessor;
import kmn.marduk.common.impl.MardukOracleFactory;
import kmn.marduk.core.transportation.Transporter;
import kmn.marduk.core.context.impl.ContextImpl;
import kmn.marduk.core.transportation.impl.MardukTransporter;
import kmn.marduk.dao.impl.DBIdentifyingSQLServerDAO;
import kmn.marduk.dao.impl.MardukOracleDAO;
import kmn.marduk.utils.TransporterConfig;
import kmn.marduk.utils.ReaderUtils;
import kmn.marduk.utils.SettingStorage;


public class StartApp {
    public static void main(String[] args) {

        SettingStorage.init();

        MardukOracleDAO mardukOracleDAO = new MardukOracleDAO((MardukOracleFactory)MardukOracleFactory.newInstance());
        DBIdentifyingSQLServerDAO dbIdentifyingSQLServerDAO = new DBIdentifyingSQLServerDAO(ReaderUtils.readPropertiesFromFile(SettingStorage.SQLSERVER_PROPERTIES));
        Marduk2DBIdentifyingProcessor marduk2DBIdentifyingProcessor = new Marduk2DBIdentifyingProcessor();
        ContextImpl context = new ContextImpl(mardukOracleDAO, dbIdentifyingSQLServerDAO,marduk2DBIdentifyingProcessor);

        Transporter mardukTransporter =
                new MardukTransporter(context, TransporterConfig.newInstance());

        mardukTransporter.run();
    }

}