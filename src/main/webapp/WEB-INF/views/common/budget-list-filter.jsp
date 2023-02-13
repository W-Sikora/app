<%@include file="../imports/jsp-imports.jsp" %>

<c:if test="${not empty plannedExpenditureCategories and not empty plannedRevenueCategories}">
    <div class="has-text-centered">
        <form class="is-filter js-budget-list-filter">

            <sec:csrfMetaTags/>

            <div class="field">
                <label class="label has-text-left has-text-weight-normal" for="plannedExpenditureCategoryId">
                    <fmt:message key="select.category.for.planned.expenditures"/>
                </label>

                <div class="select is-small is-fullwidth">
                    <select id="plannedExpenditureCategoryId" name="plannedExpenditureCategoryId">
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
                <label class="label has-text-left has-text-weight-normal" for="plannedRevenueCategoryId">
                    <fmt:message key="select.category.for.planned.revenues"/>
                </label>

                <div class="select is-small is-fullwidth">
                    <select id="plannedRevenueCategoryId" name="plannedRevenueCategoryId">
                        <option value="">
                            <fmt:message key="select.category"/>
                        </option>
                        <c:forEach items="${plannedRevenueCategories}" var="category">
                            <option value="${category.categoryId}" label="${category.title}"></option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="field is-grouped is-grouped-centered has-mb-10">
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

            <input class="is-hidden" name="period" value="${sessionScope.period}"/>
        </form>
    </div>

    <hr class="is-invisible">
</c:if>
