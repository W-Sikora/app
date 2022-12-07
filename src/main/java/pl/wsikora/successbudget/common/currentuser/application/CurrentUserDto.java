package pl.wsikora.successbudget.common.currentuser.application;

public class CurrentUserDto {

    private final Long id;
    private final String name;
    private final String email;
    private final String uuid;
    private final boolean configured;

    public CurrentUserDto(Long id,
                          String name,
                          String email,
                          String uuid,
                          boolean configured) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.uuid = uuid;
        this.configured = configured;
    }

    public Long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public String getEmail() {

        return email;
    }

    public String getUuid() {

        return uuid;
    }

    public boolean isConfigured() {

        return configured;
    }
}
