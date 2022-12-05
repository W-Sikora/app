<form:form method="POST" action="/" modelAttribute="registrationForm">

    <div class="field">
        <form:label class="label" for="name" path="registrationForm.name" >
            <fmt:message key="login.form.email"/>
        </form:label>
        <div class="control">
            <form:input class="input is-medium" type="text" id="name" path="registrationForm.name"/>
        </div>
        <p class="help is-danger">
            <form:errors path="registrationForm.name"/>
        </p>
    </div>

    <div class="field">
        <form:label class="label" for="email" path="registrationForm.email" >
            <fmt:message key="login.form.email"/>
        </form:label>
        <div class="control">
            <form:input class="input is-medium" type="email" id="email" path="registrationForm.email"/>
        </div>
        <p class="help is-danger">
            <form:errors path="registrationForm.email"/>
        </p>
    </div>

    <div class="field">
        <form:label class="label" for="password" path="registrationForm.password">
            <fmt:message key="login.form.password"/>
        </form:label>
        <div class="control">
            <form:input class="input is-medium" type="password" id="password" path="registrationForm.password"/>
        </div>
        <p class="help is-danger">
            <form:errors path="registrationForm.password"/>
        </p>
    </div>

    <div class="field">
        <form:label class="label" for="repeatedPassword" path="registrationForm.repeatedPassword">
            <fmt:message key="login.form.password"/>
        </form:label>
        <div class="control">
            <form:input class="input is-medium" type="password" id="repeatedPassword" path="registrationForm.repeatedPassword"/>
        </div>
        <p class="help is-danger">
            <form:errors path="registrationForm.repeatedPassword"/>
        </p>
    </div>

    <div class="control">
        <button type="submit"
                class="button is-link is-fullwidth has-text-weight-medium is-medium">
            Send Message
        </button>
    </div>
</form:form>
