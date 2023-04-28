package stats_service;

public interface StatsService<T, U> extends StatsAvailable {
    T getMin();
    T getMax();
    U getAvg();

}
