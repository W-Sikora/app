<%@include file="../imports/jsp-imports.jsp"%>

<form action="<c:url value="${formAction}"/>" method="post">

    <sec:csrfMetaTags/>

    <div class="field">
        <label for="username" class="label">
            <fmt:message key="username"/>
            <fmt:message key="required.field.sign"/>
        </label>
        <div class="control">
            <input name="username" id="username" type="text" class="input <c:if test="${invalid}">is-danger</c:if>"/>
        </div>
    </div>

    <div class="field">
        <label for="password" class="label">
            <fmt:message key="password"/>
            <fmt:message key="required.field.sign"/>
        </label>
        <div class="control">
            <input name="password" id="password" type="password" class="input <c:if test="${invalid}">is-danger</c:if>"/>
        </div>
        <c:if test="${invalid}">
            <p class="validation-message has-text-danger">
                <fmt:message key="login.form.invalid"/>
            </p>
        </c:if>
    </div>

    <%@ include file="../common/required-field-info.jsp" %>

    <div class="field is-grouped is-grouped-centered">
        <div class="control mt-5">
            <button type="submit" class="button is-link is-outlined">
                <fmt:message key="login.form.button"/>
            </button>
        </div>
    </div>
</form>
