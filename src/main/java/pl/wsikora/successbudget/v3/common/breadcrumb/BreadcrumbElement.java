package pl.wsikora.successbudget.v3.common.breadcrumb;

import lombok.Getter;
import org.springframework.util.Assert;


@Getter
public class BreadcrumbElement {

    private final String label;
    private final String url;

    public BreadcrumbElement(String label, String url) {

        Assert.hasText(label, "label must not be empty");
        Assert.hasText(url, "url must not be empty");

        this.label = label;
        this.url = url;
    }

    public BreadcrumbElement(String label) {

        Assert.hasText(label, "label must not be empty");

        this.label = label;
        this.url = null;
    }

}
