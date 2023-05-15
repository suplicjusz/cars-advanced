package collector.model;

import java.math.BigDecimal;

public record BigDecimalStatistics(
        BigDecimal min,
        BigDecimal max,
        BigDecimal sum,
        BigDecimal avg,
        int counter
) {
    public BigDecimalStatistics() {
        this(null, null, null, null, 0);
    }
}
