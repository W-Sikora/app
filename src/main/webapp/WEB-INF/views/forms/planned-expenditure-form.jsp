<%@include file="../imports/jsp-imports.jsp"%>

<hr class="is-invisible">

<form:form modelAttribute="plannedExpenditureForm" action="${formAction}" method="post">

    <form:hidden path="plannedExpenditureId"/>

    <form:hidden path="budgetId"/>

    <div class="field">
        <form:label path="categoryId" cssClass="label">
            <fmt:message key="category"/>
            <fmt:message key="required.field.sign"/>
        </form:label>

        <div class="control">
            <div class="select is-fullwidth">
                <form:select path="categoryId" required="required" cssErrorClass="is-danger">
                    <c:forEach items="${categories}" var="category">
                        <form:option value="${category.categoryId}" label="${category.title}"/>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <p class="help">
            <form:errors path="categoryId" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">

        <form:label path="value" cssClass="label">
            <fmt:message key="money"/>
            <fmt:message key="required.field.sign"/>
        </form:label>

        <div class="field has-addons">
            <p class="control is-expanded">
                <form:input path="value" type="number" cssClass="input" cssErrorClass="input is-danger"/>
            </p>

            <p class="control">
                <span class="select">
                    <form:select path="currency" required="required" cssClass="select" cssErrorClass="select is-danger">
                        <c:forEach items="${currencies}" var="currencyId">
                            <form:option value="${currencyId}">
                                <fmt:message key="currency.${currencyId}.sign"/>
                            </form:option>
                        </c:forEach>
                    </form:select>
                </span>
            </p>
        </div>

        <p class="help">
            <form:errors path="value" cssClass="has-text-danger"/>
            <form:errors path="currency" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="priority" cssClass="label">
            <fmt:message key="priority"/>
            <fmt:message key="required.field.sign"/>
        </form:label>

        <div class="control">
            <div class="select is-fullwidth">
                <form:select path="priority" required="required" cssErrorClass="is-danger">
                    <c:forEach items="${priorities}" var="priorityId">
                        <form:option value="${priorityId}">
                            <fmt:message key="priority.${priorityId}"/>
                        </form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <p class="help">
            <form:errors path="priority" cssClass="has-text-danger"/>
        </p>
    </div>

    <%@ include file="../common/required-field-info.jsp" %>

    <div class="field is-grouped is-grouped-centered">
        <div class="control mt-5">
            <button type="submit" class="button is-link is-outlined">
                <fmt:message key="save.text"/>
            </button>
        </div>
    </div>
</form:form>
