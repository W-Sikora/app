package pl.wsikora.successbudget.v3.common.breadcrumb;

import lombok.Getter;
import org.springframework.util.Assert;


@Getter
public class BreadcrumbElement {

    private final String label;
    private final String url;

    private BreadcrumbElement(String label, String url) {

        this.label = label;
        this.url = url;
    }

    public static BreadcrumbElement of(String label, String url) {

        Assert.hasText(label, "label must not be empty");
        Assert.hasText(url, "url must not be empty");

        return new BreadcrumbElement(label, url);
    }

    public static BreadcrumbElement of(String label) {

        Assert.hasText(label, "label must not be empty");

        return new BreadcrumbElement(label, "#");
    }

}
