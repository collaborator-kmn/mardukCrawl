package api.dbms;

import java.util.Properties;

/**
 * Класс реализация паттерна мост для класса <code>JDBCConnector/code>. Предназначен для выполнения подключения к СУБД Interbase
 */

public class InterbaseHandle extends JDBCHandle {

    private final String DRIVER_NAME = "interbase.interclient.Driver";

    /**
     * Конструктор по умолчанию
     */
    public InterbaseHandle(){super();}

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
     */
    public InterbaseHandle(Properties properties){
        super(properties);
    }

    /**
     * Метод возвращающий кодировку соединения по умолчанию(своя для каждой БД)
     * реализуется в унаследованных классах
     *
     * @return charset
     */
    @Override
    protected String getDefaultCharset() {
        return "Cp1251";
    }

    /**
     * Метод возвращающий номер порта по умолчанию(свой для каждой БД)
     * реализуется в унаследованных классах
     *
     * @return port
     */
    @Override
    protected int getDefaultPort() {
        return 3050;
    }

    /**
     * Метод возвращающий имя класса-драйвера для БД
     * реализуется в унаследованных классах
     * @return driver name
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
     */
    @Override
    public String getURL() {
        return "jdbc:interbase://"+getServer()+":"+getPort()+"/"+getDatabase();

    }

    /**
     * Метод возвращающий имя параметра кодировки
     * @return string
     */
    @Override
    public String charsetTag() {
        return "charSet";
    }
}
