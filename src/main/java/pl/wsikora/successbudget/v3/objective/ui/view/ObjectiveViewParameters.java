package pl.wsikora.successbudget.v3.objective.ui.view;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.DEFAULT_PAGINATION_PAGE;
import static pl.wsikora.successbudget.v3.common.util.Constants.DEFAULT_PAGINATION_SIZE;


record ObjectiveViewParameters(Integer page, Integer size, String keyword) {

    ObjectiveViewParameters(Integer page, Integer size, String keyword) {

        this.page = isNull(page) ?
            DEFAULT_PAGINATION_PAGE : page;

        this.size = isNull(size) ?
            DEFAULT_PAGINATION_SIZE : size;

        this.keyword = keyword;
    }

}
