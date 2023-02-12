package pl.wsikora.successbudget.v3.common.util.title;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;

import static java.util.Objects.isNull;


public class TitleProvider {

    private final MessageProvider messageProvider;

    public TitleProvider(MessageProvider messageProvider) {

        this.messageProvider = messageProvider;
    }

    public String provideTitle(@Nullable Long identifier, String addTitleCode, String editTitleCode) {

        Assert.hasText(addTitleCode, "addTitleCode must not be empty");
        Assert.hasText(editTitleCode, "editTitleCode must not be empty");

        String titleCode = isNull(identifier) ? addTitleCode : editTitleCode;

        return messageProvider.getMessage(titleCode);
    }

}
