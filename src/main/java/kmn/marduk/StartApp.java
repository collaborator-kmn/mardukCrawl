package kmn.marduk;


import kmn.marduk.common.impl.Marduk2DBIdentifyingProcessor;
import kmn.marduk.common.impl.MardukOracleFactory;
import kmn.marduk.core.impl.ContextImpl;
import kmn.marduk.core.impl.MardukTransporter;
import kmn.marduk.dao.impl.DBIdentifyingSQLServerDAO;
import kmn.marduk.dao.impl.MardukOracleDAO;
import kmn.marduk.utils.Date_Settings;
import kmn.marduk.utils.ReaderUtils;
import kmn.marduk.utils.SettingStorage;


public class StartApp {
    public static void main(String[] args) {

        Date_Settings date_settings = new Date_Settings();

        MardukTransporter mardukTransporter = new MardukTransporter(new ContextImpl(
                (new MardukOracleDAO((MardukOracleFactory)MardukOracleFactory.newInstance())),
                new DBIdentifyingSQLServerDAO(ReaderUtils.readPropertiesFromFile(SettingStorage.SQLSERVER_PROPERTIES)),
                new Marduk2DBIdentifyingProcessor()),date_settings.getStartDate(), date_settings.getEndDate());

        mardukTransporter.run();
    }

}