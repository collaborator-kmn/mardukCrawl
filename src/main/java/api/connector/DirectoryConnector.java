package api.connector;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

//Класс для подключения к директориям файловой системы.

public class DirectoryConnector implements Connector<Path>{

    /**
     * Дескриптор директории
     * @since 1.0
     */
    private Path path;

    /**
     * Путь к директории
     * @since 1.0
     */
    private String pathName;

    /**
     * Конструктор класса
     * @param path строка с путем к необходимой директории
     * @since 1.0
     */
    public DirectoryConnector(String path){this.pathName = path;}

    /**
     * Получаем дескриптор директории
     * @return <code>Path</code> или <code>null</code> при ошибке
     * @since 1.0
     */
    public Path connect() throws ConnectorException{
        try {
            path = Paths.get(pathName);
            return path;
        }catch (InvalidPathException e){
            throw new ConnectorException("InvalidPathException");
        }
    }
}
