package pl.wsikora.successbudget.common;

import java.util.UUID;

public class UuidGenerator {

    private UuidGenerator() {

    }

    public static String generateUuid() {

        return UUID.randomUUID().toString();
    }
}
