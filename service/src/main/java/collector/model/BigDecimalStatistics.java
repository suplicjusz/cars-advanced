package collector.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = false)
@Getter
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
