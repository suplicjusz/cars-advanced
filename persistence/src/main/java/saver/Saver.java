package saver;

import java.util.Optional;

public interface Saver<T, U> {
    Optional<U> save(T t);

}
