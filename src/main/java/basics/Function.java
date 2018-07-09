package basics;

/**
 * Created by ypokhrel on 12/27/2017.
 */
public interface Function<T, U> {
    U apply(T arg);
}
