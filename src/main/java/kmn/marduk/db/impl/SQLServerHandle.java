package kmn.marduk.db.impl;

import java.util.Properties;

public class SQLServerHandle extends JDBCHandle{
    private final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public SQLServerHandle(){super();}

    public SQLServerHandle(Properties properties){
        super(properties);
    }
    @Override
    protected String getDefaultCharset() {
        return "utf8";
    }

    @Override
    protected int getDefaultPort() {
        return 1433;
    }

    @Override
    public String getDriverClassName() {
        return DRIVER_NAME;
    }

    @Override
    public String getURL() {
        return "jdbc:sqlserver://localhost:1433;databaseName=PUBS";
    }

    @Override
    public String charsetTag() {
        return "utf8";
    }
}
