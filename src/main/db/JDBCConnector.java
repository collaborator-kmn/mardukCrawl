package main.db;

import java.sql.Connection;
import java.sql.SQLException;

//Класс для подключения к JDBC совместимым базам данных.

public class JDBCConnector implements Connector<Connection> {

    /**
     * объект-мост к конкретной реализации базы данных
     *
     */
    private JDBCHandle handle;

    /**
     * Конструктонр класса
     *
     * @param handle объект-мост к конкретной реализации
     */
    public JDBCConnector(JDBCHandle handle) {
        this.handle = handle;
    }

    /**
     * Метод устанавливающий объект-мост
     *
     * @param handle объект-мост к конкретной реализации
     */
    public void setHandle(JDBCHandle handle) {
        this.handle = handle;
    }

    /**
     * Получаем имя базы данных
     *
     * @return имя базы данных
     */
    public String getDatabase() {
        return handle.getDatabase();
    }

    /**
     * Устанавливает имя базы данных
     *
     * @param database
     */
    public void setDatabase(String database) {
        handle.setDatabase(database);
    }

    /**
     * Получаем имя сервера базы данных
     *
     * @return имя сервера
     */
    public String getServer() {
        return handle.getServer();
    }

    /**
     * Устанавливаем имя сервера
     *
     * @param server
     */
    public void setServer(String server) {
        handle.setServer(server);
    }

    /**
     * Получаем порт
     *
     * @return номер порта
     */
    public int getPort() {
        return handle.getPort();
    }

    /**
     * Задаем порт
     *
     * @param port
     */
    public void setPort(int port) {
        handle.setPort(port);
    }

    /**
     * Получаем имя пользователя
     *
     * @return имя пользователя
     */
    public String getUsername() {
        return handle.getUsername();
    }

    /**
     * Задаем имя пользователя
     *
     * @param username
     */
    public void setUsername(String username) {
        handle.setUsername(username);
    }

    /**
     * Задаем пароль пользователя
     *
     * @param password
     */
    public void setPassword(char[] password) {
        handle.setPassword(password);
    }

    /**
     * Получаем кодировку соединения
     *
     * @return значение кодировки
     */
    public String getCharset() {
        return handle.getCharset();
    }

    /**
     * Задаем кодировку соединения
     *
     * @param charset
     */
    public void setCharset(String charset) {
        this.handle.setCharset(charset);
    }

    /**
     * Выполняем подключение к базе данных
     *
     * @return <code>Connection</code> при успешном подключении или <code>null</code> если произошла ошибка
     */
//    @Override
    public Connection connect() throws ConnectorException {
        try {
            return handle.performConnect();
        } catch (SQLException e) {
            throw new ConnectorException("SQLException "+e.getMessage());
        }
    }


}