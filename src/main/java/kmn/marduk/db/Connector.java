package kmn.marduk.db;

import kmn.marduk.db.impl.ConnectorException;

//метод для подключения к конкретному хранилищу данных

public interface Connector<T> {

    T connect() throws ConnectorException;
}