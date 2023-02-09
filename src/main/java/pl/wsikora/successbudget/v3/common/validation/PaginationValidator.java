package pl.wsikora.successbudget.v3.common.validation;

public class PaginationValidator {

    private PaginationValidator() {}

    public static boolean isValid(int page, int size) {

        return page >= 0 && size >= 0;
    }

}
