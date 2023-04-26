package car_service;

import extension.CarServiceParameterResolver;
import lombok.RequiredArgsConstructor;
import model.car.Car;
import model.enums.CarBodyType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import support.CarServiceContent;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@ExtendWith(CarServiceParameterResolver.class)
public class GetCarsFilteredByCarBodyTypeFromPriceCompartmentTest implements CarServiceContent<List<Car>> {
    private final CarService extensionCarService;

    @ParameterizedTest
    @DisplayName("when is down limit of price lower zero")
    @MethodSource("invalidArgumentSource")
    void shouldThrowsIllegalArgumentException(BigDecimal price) {
        Assertions
                .assertThatThrownBy(
                        () -> extensionCarService.getCarsFilteredByCarBodyTypeFromPriceCompartment(
                                CarBodyType.HATCHBACK, price, new BigDecimal("100000")
                        )
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Price cannot be a negative number");
    }

    static Stream<BigDecimal> invalidArgumentSource() {
        return Stream.of(
                new BigDecimal("-100"), new BigDecimal("-50"), new BigDecimal("-1")
        );
    }

    @ParameterizedTest
    @DisplayName("when each of params is correct")
    @MethodSource({"correctMinPriceArgumentSource", "correctMaxPriceArgumentSource"})
    void shouldReturnExpectedList(BigDecimal priceMin, BigDecimal priceMax) {
        org.junit.jupiter.api.Assertions
                .assertEquals(
                        getExpected(),
                        extensionCarService.getCarsFilteredByCarBodyTypeFromPriceCompartment(
                                CarBodyType.HATCHBACK, priceMin, priceMax)
                );
    }

    static Stream<BigDecimal> correctMinPriceArgumentSource() {
        return Stream.of(
                new BigDecimal("0"), new BigDecimal("10000"), new BigDecimal("80000")
        );
    }

    static Stream<BigDecimal> correctMaxPriceArgumentSource() {
        return Stream.of(new BigDecimal("100001"), new BigDecimal("100500"), new BigDecimal("119999"));
    }

    @Override
    public List<Car> getExpected() {
        return List.of(
                findContentCarById(0L), findContentCarById(2L)
        );
    }
}
