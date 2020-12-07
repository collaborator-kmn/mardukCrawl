package marduk;

public interface Repository<T> {
    //создание сущности
    void create(T entity);
    //удаление
    void delete(T entity);
}
