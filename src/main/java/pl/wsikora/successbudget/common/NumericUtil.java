package pl.wsikora.successbudget.common;

public class NumericUtil {

    private NumericUtil() {

    }

    public static boolean isBetweenInclusive(int number, int fromNumber, int toNumber) {

        return number >= fromNumber && number <= toNumber;
    }

    public static boolean isBeyond(int number, int fromNumber, int toNumber) {

        return !isBetweenInclusive(number, fromNumber, toNumber);
    }
}
