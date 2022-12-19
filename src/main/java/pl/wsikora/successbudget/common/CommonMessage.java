package pl.wsikora.successbudget.common;

public class CommonMessage {

    public static final String NO_VALUE_FOUND = "no value found";

    private static final String NOT_NULL_FORMAT = "%s must not be null";
    private static final String NOT_GREATER_THEN_ZERO_FORMAT = "%s must be greater then zero";
    private static final String NOT_IDENTICAL_FORMAT = "%s must be greater then zero";
    private static final String NOT_EMPTY_FORMAT = "%s must not be empty";
    private static final String NOT_EMPTY_COLLECTION_FORMAT =  NOT_EMPTY_FORMAT;

    private static final String ENTITY_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT = "%s with id: %d not found";

    private CommonMessage() {

    }

    public static String getNotNullMessage(String value) {

        return String.format(NOT_NULL_FORMAT, value);
    }

    public static String getNotGreaterThenZeroMessage(String value) {

        return String.format(NOT_GREATER_THEN_ZERO_FORMAT, value);
    }

    public static String getNotIdenticalMessage(String value) {

        return String.format(NOT_IDENTICAL_FORMAT, value);
    }

    public static String getNotEmptyCollectionMessage(String value) {

        return String.format(NOT_EMPTY_COLLECTION_FORMAT, value);
    }

    public static String getNotEmptyMessage(String value) {

        return String.format(NOT_EMPTY_FORMAT, value);
    }

    public static <Entity> String getEntityNotFoundExceptionMessage(Entity entity, Long id){

        return String.format(ENTITY_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT, entity.getClass().getSimpleName(), id);
    }
}
