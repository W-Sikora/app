package pl.wsikora.successbudget.v3.common.util;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Locale;


@Service
public class MessageProvider {

    private final MessageSource messageSource;

    private MessageProvider(MessageSource messageSource) {

        this.messageSource = messageSource;
    }

    public String getMessage(String code) {

        Assert.hasText(code, "code must not be empty");

        return messageSource.getMessage(code, null, Locale.getDefault());
    }

    public String getMessage(String code, Object[] attributes) {

        Assert.hasText(code, "code must not be empty");
        Assert.notNull(attributes, "attributes must not be null");

        return messageSource.getMessage(code, attributes, Locale.getDefault());
    }
}
