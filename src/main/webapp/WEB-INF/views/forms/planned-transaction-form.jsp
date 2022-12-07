<%@include file="../imports/jsp-imports.jsp"%>

<form:form modelAttribute="plannedTransactionForm" action="${action}" method="post">

    <form:hidden path="id" value="${id}"/>

    <form:hidden path="budgetId" value="${budgetId}"/>

    <div class="field">
        <form:label path="name" cssClass="label">
            <fmt:message key="planned-transaction-form.name.label"/>
        </form:label>

        <div class="control">
            <form:input path="name" value="${name}" type="text" required="required" cssClass="input"/>
        </div>

        <p class="help">
            <form:errors path="name" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="transactionTypeId" cssClass="label">
            <fmt:message key="planned-transaction-form.transactionTypeId.label"/>
        </form:label>

        <div class="control">
            <div class="select is-fullwidth">
                <form:select path="transactionTypeId" required="required">
                    <c:forEach items="${transactionTypes}" var="transactionType">
                        <c:set var="transactionTypeLabel">
                            <fmt:message key="transaction.type.label.${transactionType.id}"/>"
                        </c:set>
                        <form:option value="${transactionType.id}" label="${transactionTypeLabel}"/>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <p class="help">
            <form:errors path="transactionTypeId" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="categoryId" cssClass="label">
            <fmt:message key="planned-transaction-form.categoryId.label"/>
        </form:label>

        <form:hidden path="parentCategoryId" value="${parentCategoryId}"/>

        <div class="control">
            <div class="select is-fullwidth">
                <form:select path="categoryId" required="required" cssClass="select">
                    <c:forEach items="${categories}" var="category">
                        <form:option value="${category.id}" label="${category.name}"/>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <p class="help">
            <form:errors path="parentCategoryId" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="value" cssClass="label">
            <fmt:message key="planned-transaction-form.value.label"/>
        </form:label>

        <div class="field has-addons">
            <p class="control">
                <form:input path="value" id="valueInput" type="number" cssClass="input"
                            min="0.01" max="999_999_999" step="1"/>
            </p>

            <p class="control">
                <span class="select is-fullwidth">
                  <form:select path="currencyId" required="required" cssClass="select">
                      <c:forEach items="${currencies}" var="currency">
                          <form:option value="${currency.id}" label="${currency.code}"/>
                      </c:forEach>
                  </form:select>
                </span>
            </p>
        </div>

        <p class="help">
            <form:errors path="value" cssClass="has-text-danger"/>
            <form:errors path="currencyId" cssClass="has-text-danger"/>
        </p>
    </div>

    <form:hidden path="createdByUserId" value="${createdByUserId}"/>

    <div class="field">
        <form:label class="label" path="cycleValue">
            <fmt:message key="planned-transaction-form.cycleValue.label"/>
        </form:label>

        <div class="control">
            <form:input path="cycleValue" value="${cycleValue}" type="text" required="required" cssClass="input"/>
        </div>

        <p class="help">
            <form:errors path="cycleValue" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label class="label" path="accountingPeriod">
            <fmt:message key="planned-transaction-form.accountingPeriod.label"/>
        </form:label>

        <div class="control">
            <form:input path="accountingPeriod" type="month" required="required" value="${accountingPeriod}"
                        cssClass="input"/>
        </div>

        <p class="help">
            <form:errors path="accountingPeriod" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field is-grouped is-grouped-centered">
        <div class="control mt-5">
            <button class="button is-link" type="submit">
                <fmt:message key="save.text"/>
            </button>
        </div>
    </div>
</form:form>
