package main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Класс-мост для <code>JDBCConnector</code> выполняющий примитивные операции
 * например подключение в базе данных и возврат объектра <code>Connection</code>

 */
public abstract class JDBCHandle {

    /**
     * сервер БД
     * @since 1.0
     */
    private String server;

    /**
     * имя БД
     * @since 1.0
     */
    private String database;

    /**
     * порт сервера
     * @since 1.1
     */
    private int port = 0;

    /**
     * пользователь бд
     * @since 1.0
     */
    private String username;

    /**
     * пароль пользователя
     * @since 1.0
     */
    private char[] password;

    /**
     * кодировка соединения
     * @since 1.2
     */
    private String charset;

    /**
     * Получаем имя базы данных
     * @return имя базы данных
     * @since 1.0
     */
    public String getDatabase() {
        return database;
    }

    /**
     * Устанавливает имя базы данных
     * @param database
     * @since 1.0
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * Получаем имя сервера базы данных
     * @return имя сервера
     * @since 1.0
     */
    public String getServer() {
        return server;
    }

    /**
     * Устанавливаем имя сервера
     * @param server
     * @since 1.0
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * Получаем порт, если порт не задан то получаем порт по умолчанию
     * @return номер порта
     * @since 1.1
     */
    public int getPort() {
        return port == 0 ? getDefaultPort() : port;
    }

    /**
     * Задаем порт
     * @param port
     * @since 1.1
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Получаем имя пользователя
     * @return имя пользователя
     * @since 1.0
     */
    public String getUsername() {
        return username;
    }

    /**
     * Задаем имя пользователя
     * @param username
     * @since 1.0
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * получить пароль можно только внутри класса
     * @return пароль
     */
    private char[] getPassword() {
        return password;
    }

    /**
     * Задаем пароль пользователя
     * @param password
     * @since 1.0
     */
    public void setPassword(char[] password) {
        this.password = password;
    }

    /**
     * Получаем кодировку соединения
     * @return значение кодировки
     * @since 1.2
     */
    public String getCharset() {
        return charset == null ? getDefaultCharset() : charset;
    }

    /**
     * Задаем кодировку соединения
     * @param charset
     * @since 1.2
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * собираем дополнителоьные свойства в объект <code>Properties</code>
     * @return properties
     * @since 1.2
     */
    protected Properties connectionProperties(){
        Properties properties = new Properties();
        properties.setProperty("user",getUsername());
        properties.setProperty("password",String.valueOf(getPassword()));
        properties.setProperty(charsetTag(), getCharset());
        return properties;
    }

    /**
     * Конструктор по умолчанию
     */
    public JDBCHandle(){

    }

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
     * @since 1.4
     */
    public JDBCHandle(Properties properties){
        setServer(properties.getProperty("server"));
        setDatabase(properties.getProperty("database"));
        if(properties.containsKey("port"))setPort(Integer.parseInt(properties.getProperty("port")));
        setUsername(properties.getProperty("user"));
        setPassword(properties.getProperty("password").toCharArray());
        if(properties.containsKey("charset"))setCharset(properties.getProperty("charset"));
    }

    /**
     * Шаблонный метод класса выполняющий подключение к БД на основе примитивных операций
     * реализованных в производных классах
     * @return <code>Connection</code> подключение к БД
     * @throws SQLException
     * @since 1.0
     */
    public final Connection performConnect() throws SQLException{
        try {
            Class.forName(getDriverClassName());
            Connection connection = DriverManager.getConnection(getURL(),connectionProperties());
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Метод возвращающий кодировку соединения по умолчанию(своя для каждой БД)
     * реализуется в унаследованных классах
     * @return charset
     * @since 1.2
     */
    protected abstract String getDefaultCharset();

    /**
     * Метод возвращающий номер порта по умолчанию(свой для каждой БД)
     * реализуется в унаследованных классах
     * @return port
     * @since 1.2
     */
    protected abstract int getDefaultPort();

    /**
     * Метод возвращающий имя класса-драйвера для БД
     * реализуется в унаследованных классах
     * @return driver
     * @since 1.2
     */
    public abstract String getDriverClassName();

    /**
     * Метод формирующий строку подключения к БД
     * реализуется в унаследованных классах
     * @return conection String
     * @since 1.2
     */
    public abstract String getURL();

    /**
     * Метод возвращающий имя параметра кодировки
     * @return string
     * @since 1.3
     */
    public abstract String charsetTag();
}