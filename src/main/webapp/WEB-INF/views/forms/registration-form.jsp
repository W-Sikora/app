<%@include file="../imports/jsp-imports.jsp"%>

<form:form modelAttribute="form" action="${formAction}" method="post">
    <div class="field">
        <form:label path="username" cssClass="label">
            <fmt:message key="username"/>
            <fmt:message key="required.field.sign"/>
        </form:label>

        <div class="control">
            <form:input path="username" type="text" cssClass="input" cssErrorClass="input is-danger"/>
        </div>

        <p class="validation-message">
            <form:errors path="username" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="password" cssClass="label">
            <fmt:message key="password"/>
            <fmt:message key="required.field.sign"/>
        </form:label>

        <div class="control">
            <form:input path="password" type="password" cssClass="input" cssErrorClass="input is-danger"/>
        </div>

        <p class="validation-message">
            <form:errors path="password" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="repeatedPassword" cssClass="label" >
            <fmt:message key="repeated.password"/>
            <fmt:message key="required.field.sign"/>
        </form:label>

        <div class="control">
            <form:input path="repeatedPassword" type="password" cssClass="input" cssErrorClass="input is-danger"/>
        </div>

        <p class="validation-message">
            <form:errors path="repeatedPassword" cssClass="has-text-danger"/>
        </p>
    </div>

    <%@ include file="../common/required-field-info.jsp" %>

    <div class="field is-grouped is-grouped-centered">
        <div class="control mt-5">
            <button type="submit" class="button is-link is-outlined">
                <fmt:message key="registration.form.button"/>
            </button>
        </div>
    </div>
</form:form>
