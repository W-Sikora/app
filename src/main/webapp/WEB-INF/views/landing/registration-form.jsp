<%@ page contentType="text/html;charset=UTF-8" %>

<form:form modelAttribute="registrationForm" action="/registration" method="post">
    <div class="field">
        <form:label path="userName">
            <fmt:message key="registration-form.userName"/>
        </form:label>
        <div class="control">
            <form:input path="userName" type="text" required="required" cssClass="input"/>
        </div>
        <p class="help">
            <form:errors path="userName" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="email">
            <fmt:message key="registration-form.email"/>
        </form:label>
        <div class="control">
            <form:input path="email" type="email" required="required" cssClass="input"/>
        </div>
        <p class="help">
            <form:errors path="email" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="password">
            <fmt:message key="registration-form.password"/>
        </form:label>
        <div class="control">
            <form:input path="password" type="password" required="required" cssClass="input"/>
        </div>
        <p class="help">
            <form:errors path="password" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label path="repeatedPassword">
            <fmt:message key="registration-form.repeatedPassword"/>
        </form:label>
        <div class="control">
            <form:input path="repeatedPassword" type="password" required="required" cssClass="input"/>
        </div>
        <p class="help">
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
