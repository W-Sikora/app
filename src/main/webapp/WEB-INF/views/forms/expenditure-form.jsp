<%@include file="../imports/jsp-imports.jsp"%>

<form:form modelAttribute="categoryForm" action="${formAction}" method="post">

    <form:hidden path="cashFlowCashFlowId"/>

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
        <form:label path="description" cssClass="label">
            <fmt:message key="description"/>
        </form:label>

        <div class="control">
            <form:textarea path="description" type="text" cssClass="textarea" cssErrorClass="textarea is-danger"/>
        </div>

        <p class="validation-message">
            <form:errors path="description" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="categoryId" cssClass="label">
            <fmt:message key="assigned.transaction.type"/>
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

    !

    <div class="field">
        <form:label path="priorityId" cssClass="label">
            <fmt:message key=""/>
            <fmt:message key="required.field.sign"/>
        </form:label>

        <div class="control">
            <div class="select is-fullwidth">
                <form:select path="priorityId" required="required" cssErrorClass="is-danger">
                    <c:forEach items="${priority}" var="priority">
                        <c:set var="typeLabel">
                            <fmt:message key="priority.${priority}"/>
                        </c:set>
                        <form:option value="${type}" label="${typeLabel}"/>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <p class="help">
            <form:errors path="priorityId" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="payee" cssClass="label">
            <fmt:message key="payee"/>
            <fmt:message key="required.field.sign"/>
        </form:label>

        <div class="control">
            <form:input path="payee" type="text" cssClass="input" cssErrorClass="input is-danger"/>
        </div>

        <p class="validation-message">
            <form:errors path="payee" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="scheduleId" cssClass="label">
            <fmt:message key="schedule"/>
            <fmt:message key="required.field.sign"/>
        </form:label>

        <div class="control">
            <div class="select is-fullwidth">
                <form:select path="scheduleId" required="required" cssErrorClass="is-danger">
                    <option value="">
                        <fmt:message key="no.schedule"/>
                    </option>
                    <c:forEach items="${schedules}" var="schedule">
                        <c:set var="scheduleLabel">
                            <fmt:message key="schedule.${schedule}"/>
                        </c:set>
                        <form:option value="${schedule}" label="${scheduleLabel}"/>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <p class="help">
            <form:errors path="date" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="date" cssClass="label">
            <fmt:message key="date"/>
            <fmt:message key="required.field.sign"/>
        </form:label>

        <div class="control">
            <form:input path="date" type="date" cssClass="input" cssErrorClass="input is-danger"/>
        </div>

        <p class="validation-message">
            <form:errors path="date" cssClass="has-text-danger"/>
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
