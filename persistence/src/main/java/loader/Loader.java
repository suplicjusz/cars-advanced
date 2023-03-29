package loader;

public interface Loader<T> {
    T load(String filename);
}
