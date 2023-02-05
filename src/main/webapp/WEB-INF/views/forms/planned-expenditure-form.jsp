<%@include file="../imports/jsp-imports.jsp"%>

<form:form modelAttribute="form" action="${formAction}" method="post">

    <form:hidden path="plannedExpenditureId"/>

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
                    <form:select path="currencyId" required="required" cssClass="select" cssErrorClass="select is-danger">
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

    <div class="field">
        <form:label path="priorityId" cssClass="label">
            <fmt:message key="priority"/>
            <fmt:message key="required.field.sign"/>
        </form:label>

        <div class="control">
            <div class="select is-fullwidth">
                <form:select path="priorityId" required="required" cssErrorClass="is-danger">
                    <c:forEach items="${priorities}" var="priority">
                        <c:set var="priorityLabel">
                            <fmt:message key="priority.${priority}"/>
                        </c:set>
                        <form:option value="${priority}" label="${priorityLabel}"/>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <p class="help">
            <form:errors path="priorityId" cssClass="has-text-danger"/>
        </p>
    </div>

    <%@ include file="../common/required-field-info.jsp" %>

    <div class="field is-grouped is-grouped-centered">
        <div class="control mt-5">
            <button type="submit" class="button is-link">
                <fmt:message key="save.text"/>
            </button>
        </div>
    </div>
</form:form>
