package pl.wsikora.successbudget.v3.common.type;

import lombok.Getter;


@Getter
public class BreadcrumbElement {

    private final String label;
    private final String url;

    public BreadcrumbElement(String label, String url) {

        this.label = label;
        this.url = url;
    }

    public BreadcrumbElement(String label) {

        this.label = label;
        this.url = null;
    }
}
