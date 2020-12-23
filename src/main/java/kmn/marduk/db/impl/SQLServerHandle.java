package kmn.marduk.db.impl;

import java.util.Properties;

public class SQLServerHandle extends JDBCHandle{
    private final String DRIVE_NAME = "sqlServer.jdbc.driver.SqlServerDriver";

    public SQLServerHandle(){super();}

    public SQLServerHandle(Properties properties){
        super(properties);
    }
    @Override
    protected String getDefaultCharset() {
        return "WIN1212";
    }

    @Override
    protected int getDefaultPort() {
        return 1702;
    }

    @Override
    public String getDriverClassName() {
        return DRIVE_NAME;
    }

    @Override
    public String getURL() {
        return "jdbc:sql:thin:@"+getServer()+":"+getPort()+"/"+getDatabase();
    }

    @Override
    public String charsetTag() {
        return "WIN1212";
    }
}
