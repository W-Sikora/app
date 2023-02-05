package pl.wsikora.successbudget.v3.common.type;

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

        BreadcrumbElement breadcrumbElement = new BreadcrumbElement(label, url);

        breadcrumbElements.add(breadcrumbElement);

        return this;
    }

    public BreadcrumbElementsBuilder add(String label) {

        BreadcrumbElement breadcrumbElement = new BreadcrumbElement(label);

        breadcrumbElements.add(breadcrumbElement);

        return this;
    }

    public List<BreadcrumbElement> build() {

        return breadcrumbElements;
    }
}
