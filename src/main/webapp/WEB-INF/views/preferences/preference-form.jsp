<form:form modelAttribute="preferenceForm" action="/preferences/edit" method="post">

    <form:hidden path="userId" value="${currentlyLoggedInUser.id}"/>

    <div class="field">
        <form:label class="label" path="languageId">
            <fmt:message key="preference-form.language.label"/>
        </form:label>

        <div class="control">
            <div class="select is-fullwidth">
                <form:select path="languageId" required="required" disabled="true">
                    <c:forEach items="${languages}" var="language">
                        <c:set var="languageLabel" value="${language.name} - ${language.code}"/>
                        <form:option value="${language.id}" label="${languageLabel}"/>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <p class="help">
            <form:errors path="languageId" cssClass="has-text-danger"/>
        </p>
    </div>


    <div class="field mb-5">
        <form:label class="label" path="mainCurrencyId">
            <fmt:message key="preference-form.mainCurrency.label"/>
        </form:label>

        <div class="control">
            <div class="select is-fullwidth">
                <form:select path="mainCurrencyId" required="required">
                    <c:forEach items="${currencies}" var="currency">
                        <c:set var="currencyLabel" value="${currency.name} - ${currency.code}"/>
                        <form:option value="${currency.id}" label="${currencyLabel}"/>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <p class="help">
            <form:errors path="languageId" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label class="label" path="enabledCurrencyCodeMode">
            <fmt:message key="preference-form.enabledCurrencyCodeMode.label"/>
        </form:label>

        <div class="control">
            <label class="checkbox">
                <fmt:message key="preference-form.enabledCurrencyCodeMode.text"/>:&nbsp;
                <form:checkbox path="enabledCurrencyCodeMode" value="true"/>
            </label>
        </div>

        <p class="help">
            <form:errors path="enabledCurrencyCodeMode" cssClass="has-text-danger"/>
        </p>
    </div>

    <div class="field">
        <form:label class="label" path="enabledCollaborationMode">
            <fmt:message key="preference-form.enabledCollaborationMode.label"/>
        </form:label>

        <div class="control">
            <label class="checkbox">
                <fmt:message key="preference-form.enabledCollaborationMode.text"/>
                <form:checkbox path="enabledCollaborationMode" value="true"/>
            </label>
        </div>

        <p class="help">
            <form:errors path="enabledCurrencyCodeMode" cssClass="has-text-danger"/>
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
