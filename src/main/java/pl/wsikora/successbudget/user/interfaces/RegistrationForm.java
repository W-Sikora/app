package pl.wsikora.successbudget.user.interfaces;

import pl.wsikora.successbudget.user.application.command.RegistrationFormAttribute;


class RegistrationForm implements RegistrationFormAttribute {

    static final String F_USER_NAME = "userName";
    static final String F_EMAIL = "email";
    static final String F_PASSWORD = "password";
    static final String F_REPEATED_PASSWORD = "repeatedPassword";

    private String userName;
    private String email;
    private String password;
    private String repeatedPassword;

    @Override
    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    @Override
    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    @Override
    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getRepeatedPassword() {

        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {

        this.repeatedPassword = repeatedPassword;
    }
}
