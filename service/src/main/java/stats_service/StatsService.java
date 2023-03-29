package stats_service;

public interface StatsService<T> {
    T getMin();
    T getMax();
    T getAvg();

}
