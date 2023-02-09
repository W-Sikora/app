package pl.wsikora.successbudget.v3.common.breadcrumb;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;


public class BreadcrumbElementsBuilder {

    private final List<BreadcrumbElement> breadcrumbElements;

    private BreadcrumbElementsBuilder() {

        breadcrumbElements = new ArrayList<>();
    }

    public static BreadcrumbElementsBuilder builder() {

        return new BreadcrumbElementsBuilder();
    }

    public BreadcrumbElementsBuilder add(String label, String url) {

        Assert.hasText(label, "label must not be empty");
        Assert.hasText(url, "url must not be empty");

        BreadcrumbElement breadcrumbElement = new BreadcrumbElement(label, url);

        breadcrumbElements.add(breadcrumbElement);

        return this;
    }

    public BreadcrumbElementsBuilder add(String label) {

        Assert.hasText(label, "label must not be empty");

        BreadcrumbElement breadcrumbElement = new BreadcrumbElement(label);

        breadcrumbElements.add(breadcrumbElement);

        return this;
    }

    public List<BreadcrumbElement> build() {

        return breadcrumbElements;
    }

}
