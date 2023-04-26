package collector;

import collector.model.BigDecimalStatistics;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.math.RoundingMode;

@EqualsAndHashCode
public class BigDecimalSummaryStatisticsAccumulator {

    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal sum;
    private BigDecimal avg;

    private int counter;

    public void update(BigDecimal value) {
        updateMin(value);
        updateMax(value);
        updateSum(value);
        updateCounter(1);
        updateAvg();
    }

    public void update(BigDecimalSummaryStatisticsAccumulator accumulator) {
        updateMin(accumulator.min);
        updateMax(accumulator.max);
        updateSum(accumulator.sum);
        updateCounter(accumulator.counter);
        updateAvg();
    }

    private void updateMin(BigDecimal value) {
        if (this.min == null) {
            this.min = value;
            return;
        }
        this.min = this.min.compareTo(value) <= 0 ? this.min : value;
    }

    private void updateMax(BigDecimal value) {
        if (this.max == null) {
            this.max = value;
            return;
        }
        this.max = this.max.compareTo(value) >= 0 ? this.max : value;
    }

    private void updateSum(BigDecimal value) {
        if (this.sum == null) {
            this.sum = value;
            return;
        }
        this.sum = this.sum.add(value);
    }

    private void updateCounter(int value) {
        this.counter += value;
    }

    private void updateAvg() {
        if (sum != null && counter > 0) {
            this.avg = sum.divide(BigDecimal.valueOf(counter), RoundingMode.CEILING);
        }
    }

    public BigDecimalStatistics toBigDecimalStatistics() {
        return new BigDecimalStatistics(max, min, sum, avg, counter);
    }
}
