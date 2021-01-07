package kmn.marduk.common.processor;

/** Преобразование типа Т к типу S
 *
 * @param <T>
 * @param <S>
 */

public interface Processor<T,S>{
    S process(T t) throws ProcessException;
}
