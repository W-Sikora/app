<%@include file="../imports/jsp-imports.jsp" %>

<c:if test="${not empty plannedExpenditureCategories and not empty plannedRevenueCategories}">
    <div class="has-text-centered">
        <form class="is-filter js-category-filter" data-name-first="${_name1}" data-name-second="${_name2}">

            <sec:csrfMetaTags/>

            <div class="field">
                <label class="label has-text-left has-text-weight-normal" for="expenditureCategoryId">
                    <fmt:message key="select.category.for.planned.expenditures"/>
                </label>

                <div class="select is-small is-fullwidth">
                    <select id="expenditureCategoryId" name="expenditureCategoryId">
                        <option value="">
                            <fmt:message key="select.category"/>
                        </option>
                        <c:forEach items="${plannedExpenditureCategories}" var="category">
                            <option value="${category.categoryId}" label="${category.title}"></option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="field">
                <label class="label has-text-left has-text-weight-normal" for="revenueCategoryId">
                    <fmt:message key="select.category.for.planned.revenues"/>
                </label>

                <div class="select is-small is-fullwidth">
                    <select id="revenueCategoryId" name="revenueCategoryId">
                        <option value="">
                            <fmt:message key="select.category"/>
                        </option>
                        <c:forEach items="${plannedRevenueCategories}" var="category">
                            <option value="${category.categoryId}" label="${category.title}"></option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="field is-grouped is-grouped-centered">
                <p class="control mr-5">
                    <button class="button is-small" type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </p>

                <p class="control">
                    <button class="button is-small js-clear-category">
                        <i class="fas fa-eraser"></i>
                    </button>
                </p>
            </div>

        </form>
    </div>

    <hr class="is-invisible">
</c:if>
