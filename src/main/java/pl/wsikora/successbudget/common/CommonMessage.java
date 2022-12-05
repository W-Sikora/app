package pl.wsikora.successbudget.common;

public class CommonMessage {

    public static final String NO_VALUE_FOUND = "no value found";

    private static final String NOT_NULL_MESSAGE_FORMAT = "%s must not be null";

    private static final String ENTITY_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT = "%s with id: %d not found";

    private CommonMessage() {

    }

    public static String getNotNullErrorMessage(String value) {

        return String.format(NOT_NULL_MESSAGE_FORMAT, value);
    }

    public static <Entity> String getEntityNotFoundExceptionMessage(Entity entity, Long id){

        return String.format(ENTITY_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT, entity.getClass().getSimpleName(), id);
    }
}
