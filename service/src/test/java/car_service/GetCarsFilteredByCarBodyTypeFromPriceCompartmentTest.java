package car_service;

import extension.CarServiceParameterResolver;
import lombok.RequiredArgsConstructor;
import model.car.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import support.CarServiceContent;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static model.enums.CarBodyType.HATCHBACK;

@RequiredArgsConstructor
@ExtendWith(CarServiceParameterResolver.class)
public class GetCarsFilteredByCarBodyTypeFromPriceCompartmentTest implements CarServiceContent<List<Car>> {

    private final CarService extensionCarService;

    @ParameterizedTest
    @DisplayName("when is down limit of price lower zero")
    @MethodSource("invalidMinArgumentSource")
    void shouldThrowsIllegalArgumentException(BigDecimal price) {
        Assertions
                .assertThatThrownBy(
                        () -> extensionCarService.getCarsFilteredByCarBodyTypeFromPriceCompartment(
                                HATCHBACK, price, new BigDecimal("100000")
                        )
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid input price");
    }

    static Stream<BigDecimal> invalidMinArgumentSource() {
        return Stream.of(
                new BigDecimal("-100"), new BigDecimal("-50"), new BigDecimal("-1")
        );
    }

    @ParameterizedTest
    @DisplayName("when each of params is correct")
    @MethodSource("correctPriceArgumentSource")
    void shouldReturnExpectedList(BigDecimal priceMin, BigDecimal priceMax) {
        org.junit.jupiter.api.Assertions
                .assertEquals(
                        getExpected(),
                        extensionCarService.getCarsFilteredByCarBodyTypeFromPriceCompartment(
                                HATCHBACK, priceMin, priceMax)
                        );
    }

    static Stream<Arguments> correctPriceArgumentSource() {
        return Stream.of(
                Arguments.of(BigDecimal.ZERO, new BigDecimal("100001")),
                Arguments.of(new BigDecimal("20000"), new BigDecimal("110000")),
                Arguments.of(new BigDecimal("80000"), new BigDecimal("119999"))
        );


    }

    @Override
    public List<Car> getExpected() {
        return List.of(
                findContentCarById(0L), findContentCarById(2L)
        );
    }
}
