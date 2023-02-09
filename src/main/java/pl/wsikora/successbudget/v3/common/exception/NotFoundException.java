package pl.wsikora.successbudget.v3.common.exception;

public class NotFoundException extends IllegalArgumentException {

    private static final String MESSAGE = "%s not found";
    private static final String MESSAGE_WITH_ID =  MESSAGE + " for id: %d";

    public NotFoundException(String name) {

        super(String.format(MESSAGE, name));
    }

    public NotFoundException(String name, long id) {

        super(String.format(MESSAGE_WITH_ID, name, id));
    }

    public NotFoundException(String name, int id) {

        super(String.format(MESSAGE_WITH_ID, name, id));
    }

}
