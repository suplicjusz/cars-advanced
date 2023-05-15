package validator;

import validator.exception.ValidatorException;

import java.math.BigDecimal;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public interface Validator<T> {

    T validate(T t);

    static long validateLong(long num, LongPredicate longTester, String message) {

        if (longTester == null) {
            throw new NullPointerException("LongPredicate is null");
        }
        if (message == null) {
            throw new NullPointerException("Message of ValidatorException is null");
        }
        if (!longTester.test(num)) {
            throw new ValidatorException(message);
        }

        return num;
    }

    static int validateInt(int num, IntPredicate intTester, String message) {

        if (intTester == null) {
            throw new NullPointerException("IntPredicate is null");
        }
        if (message == null) {
            throw new NullPointerException("Message of ValidatorException is null");
        }
        if (!intTester.test(num)) {
            throw new ValidatorException(message);
        }

        return num;
    }

    static String validateString(String regex, String expression, String message) {

        if (regex == null) {
            throw new NullPointerException("Regex is null");
        }
        if (expression == null) {
            throw new NullPointerException("Expression is null");
        }
        if (message == null) {
            throw new NullPointerException("Message of validation is null");
        }

        if (!expression.matches(regex)) {
            throw new ValidatorException(message);
        }

        return expression;
    }

    static BigDecimal validateBigDecimal(BigDecimal num, Predicate<BigDecimal> bigDecimalTester, String message) {

        if (num == null) {
            throw new NullPointerException("BigDecimal is null");
        }
        if (bigDecimalTester == null) {
            throw new NullPointerException("Predicate is null");
        }
        if (message == null) {
            throw new NullPointerException("Message of validator is null");
        }
        if (!bigDecimalTester.test(num)) {
            throw new ValidatorException(message);
        }

        return num;
    }


}


