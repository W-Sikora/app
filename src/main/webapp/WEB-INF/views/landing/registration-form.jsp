<%@ page contentType="text/html;charset=UTF-8" %>

<form:form modelAttribute="registrationForm" action="/registration" method="post">
    <div class="field">
        <form:label path="userName" cssErrorClass="has-text-danger">
            <fmt:message key="userName"/>
        </form:label>
        <div class="control">
            <form:input path="userName" type="text" cssClass="input"/>
        </div>
        <p class="validation-message">
            <form:errors path="userName" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="email" cssErrorClass="has-text-danger">
            <fmt:message key="email"/>
        </form:label>
        <div class="control">
            <form:input path="email" type="email" cssClass="input"/>
        </div>
        <p class="validation-message">
            <form:errors path="email" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="password" cssErrorClass="has-text-danger">
            <fmt:message key="password"/>
        </form:label>
        <div class="control">
            <form:input path="password" type="password" cssClass="input"/>
        </div>
        <p class="validation-message">
            <form:errors path="password" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="repeatedPassword" cssErrorClass="has-text-danger">
            <fmt:message key="repeatedPassword"/>
        </form:label>
        <div class="control">
            <form:input path="repeatedPassword" type="password" cssClass="input"/>
        </div>
        <p class="validation-message">
            <form:errors path="repeatedPassword" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field is-grouped is-grouped-centered">
        <div class="control mt-5">
            <button type="submit" class="button is-link">
                <fmt:message key="registration-form.button"/>
            </button>
        </div>
    </div>
</form:form>
