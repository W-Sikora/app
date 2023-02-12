package pl.wsikora.successbudget.v3.category.ui.view;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.DEFAULT_PAGINATION_PAGE;
import static pl.wsikora.successbudget.v3.common.util.Constants.DEFAULT_PAGINATION_SIZE;


record CategoryViewParameters(Integer page, Integer size, String keyword) {

    CategoryViewParameters(Integer page, Integer size, String keyword) {

        this.page = isNull(page) ?
            DEFAULT_PAGINATION_PAGE : page;

        this.size = isNull(size) ?
            DEFAULT_PAGINATION_SIZE : size;

        this.keyword = keyword;
    }

}
