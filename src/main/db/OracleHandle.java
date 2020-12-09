package main.db;

import java.util.Properties;


public class OracleHandle extends JDBCHandle {

    private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

    /**
     * Конструктор по умолчанию
     */
    public OracleHandle(){super();}

    /**
     * Конструктор класса в аргумент которого кладем учетные данные сервера
     * @param properties
     * допустимые имена параметров
     * server - сервер бд
     * database - файл бд
     * port - порт
     * user - пользователь
     * password - пароль
     * charset - кодировка
     * @since 1.3
     */
    public OracleHandle(Properties properties){
        super(properties);
    }
    /**
     * Метод возвращающий кодировку соединения по умолчанию(своя для каждой БД)
     * реализуется в унаследованных классах
     *
     * @return charset
     * @since 1.2
     */
    @Override
    protected String getDefaultCharset() {
        return "WIN1251";
    }

    /**
     * Метод возвращающий номер порта по умолчанию(свой для каждой БД)
     * реализуется в унаследованных классах
     *
     * @return port
     * @since 1.2
     */
    @Override
    protected int getDefaultPort() {
        return 1521;
    }

    /**
     * Метод возвращающий имя класса-драйвера для БД
     * реализуется в унаследованных классах
     *
     * @return driver
     * @since 1.2
     */
    @Override
    public String getDriverClassName() {
        return DRIVER_NAME;
    }

    /**
     * Метод формирующий строку подключения к БД
     * реализуется в унаследованных классах
     *
     * @return conection String
     * @since 1.2
     */
    @Override
    public String getURL() {
        return "jdbc:oracle:thin:@"+getServer()+":"+getPort()+"/"+getDatabase();
    }

    /**
     * Метод возвращающий имя параметра кодировки
     *
     * @return string
     * @since 1.3
     */
    @Override
    public String charsetTag() {
        return "WIN1251";
    }
}
