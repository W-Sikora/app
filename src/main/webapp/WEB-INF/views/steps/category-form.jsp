<%@include file="../imports/jsp-imports.jsp"%>

<form:form modelAttribute="category" action="/categories/add" method="post">

    <div class="field">
        <form:label path="category.name" cssClass="label">Nazwa</form:label>

        <div class="control">
            <form:input path="category.name" type="text" cssClass="input" cssErrorClass="input is-danger"/>
        </div>

        <p class="validation-message">
            <form:errors path="category.name" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="category.type" cssClass="label">
            <fmt:message key="assigned.transaction.type"/>
        </form:label>

        <div class="control">
            <div class="select is-fullwidth">
                <form:select path="category.type" cssErrorClass="is-danger">
                    <c:forEach items="${assignedTransactionTypes}" var="type">
                        <c:set var="typeLabel">
                            <fmt:message key="assigned.transaction.type.${type}"/>
                        </c:set>
                        <form:option value="${type}" label="${typeLabel}"/>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <p class="help">
            <form:errors path="category.type" cssClass="has-text-danger"/>
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
