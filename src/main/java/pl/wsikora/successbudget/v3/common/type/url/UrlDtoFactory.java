package pl.wsikora.successbudget.v3.common.type.url;

import org.springframework.util.Assert;

import static pl.wsikora.successbudget.v3.common.type.url.UrlFactory.createPath;


public class UrlDtoFactory {

    private UrlDtoFactory() {}

    public static UrlDto create(String editPath, String deletePath, Long... identifiers) {

        Assert.hasText(editPath, "editPath must not be empty");
        Assert.hasText(deletePath, "deletePath must not be empty");
        Assert.notEmpty(identifiers, "identifiers must not be empty");

        return new UrlDto(
            createPath(editPath, identifiers),
            createPath(deletePath, identifiers)
        );
    }

}
