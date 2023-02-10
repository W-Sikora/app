<%@include file="../imports/jsp-imports.jsp"%>

<hr class="is-invisible">

<form:form modelAttribute="categoryForm" action="${formAction}" method="post">

    <form:hidden path="categoryId"/>

    <div class="field">
        <form:label path="title" cssClass="label">
            <fmt:message key="title"/>
            <fmt:message key="required.field.sign"/>
        </form:label>

        <div class="control">
            <form:input path="title" type="text" cssClass="input" cssErrorClass="input is-danger"/>
        </div>

        <p class="validation-message">
            <form:errors path="title" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="transactionType" cssClass="label">
            <fmt:message key="transaction.type"/>
            <fmt:message key="required.field.sign"/>
        </form:label>

        <div class="control">
            <div class="select is-fullwidth">
                <form:select path="transactionType" required="required" cssErrorClass="is-danger">
                    <c:forEach items="${transactionTypes}" var="type">
                        <form:option value="${type}">
                            <fmt:message key="transaction.type.${type}"/>
                        </form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <p class="help">
            <form:errors path="transactionType" cssClass="has-text-danger"/>
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
