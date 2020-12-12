package kmn.marduk.db;

import java.util.Optional;

public interface Connector<T> {
    //метод для подключения к конкретному хранилищу данных

    T connect() throws ConnectorException;
}