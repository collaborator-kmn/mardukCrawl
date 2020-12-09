package api.connector;

public interface Connector<T> {
    //метод для подключения к конкретному хранилищу данных

    T connect() throws ConnectorException;
}