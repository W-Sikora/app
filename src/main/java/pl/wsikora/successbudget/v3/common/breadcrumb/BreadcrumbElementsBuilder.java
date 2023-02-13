package pl.wsikora.successbudget.v3.common.breadcrumb;

import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.PathUtils.pathWithPeriod;


public class BreadcrumbElementsBuilder {

    private final List<BreadcrumbElement> breadcrumbElements;
    private final MessageProvider messageProvider;

    private BreadcrumbElementsBuilder(MessageProvider messageProvider) {

        Assert.notNull(messageProvider, "messageProvider must not be null");

        this.breadcrumbElements = new ArrayList<>();
        this.messageProvider = messageProvider;
    }

    public static BreadcrumbElementsBuilder builder(MessageProvider messageProvider) {

        return new BreadcrumbElementsBuilder(messageProvider);
    }

    public BreadcrumbElementsBuilder add(String labelCode, String url) {

        Assert.hasText(labelCode, "labelCode must not be empty");
        Assert.hasText(url, "url must not be empty");

        String label = messageProvider.getMessage(labelCode);

        breadcrumbElements.add(BreadcrumbElement.of(label, url));

        return this;
    }

    public BreadcrumbElementsBuilder addWithPeriod(String labelCode, String url, YearMonth period) {

        Assert.hasText(labelCode, "labelCode must not be empty");
        Assert.hasText(url, "url must not be empty");

        String label = messageProvider.getMessage(labelCode);

        breadcrumbElements.add(BreadcrumbElement.of(label, pathWithPeriod(url, period)));

        return this;
    }

    public BreadcrumbElementsBuilder addLandingPage() {

        String label = messageProvider.getMessage(LANDING_PAGE_TITLE);

        breadcrumbElements.add(BreadcrumbElement.of(label, LANDING_PAGE_PATH));

        return this;
    }

    public BreadcrumbElementsBuilder addDashboard(YearMonth period) {

        String label = messageProvider.getMessage(DASHBOARD_TITLE);

        breadcrumbElements.add(BreadcrumbElement.of(label, pathWithPeriod(DASHBOARD_PATH, period)));

        return this;
    }

    public BreadcrumbElementsBuilder add(String label) {

        Assert.hasText(label, "label must not be empty");

        breadcrumbElements.add(BreadcrumbElement.of(label));

        return this;
    }

    public List<BreadcrumbElement> build() {

        return breadcrumbElements;
    }

}
