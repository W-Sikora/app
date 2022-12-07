<%@include file="../imports/jsp-imports.jsp"%>

<form action="<c:url value="/login"/>" method="post">

    <sec:csrfMetaTags/>

    <div class="field">
        <label for="email" class="<c:if test="${invalid}">has-text-danger</c:if>">
            <fmt:message key="email"/>
        </label>
        <div class="control">
            <input name="email" id="email" type="email" class="input" required/>
        </div>
    </div>

    <div class="field">
        <label for="password" class="<c:if test="${invalid}">has-text-danger</c:if>">
            <fmt:message key="password"/>
        </label>
        <div class="control">
            <input name="password" id="password" type="password" class="input" required/>
        </div>
        <c:if test="${invalid}">
            <p class="validation-message has-text-danger">
                <fmt:message key="login-form.invalid"/>
            </p>
        </c:if>
    </div>

    <div class="field is-grouped is-grouped-centered">
        <div class="control mt-5">
            <button type="submit" class="button is-link">
                <fmt:message key="login-form.button"/>
            </button>
        </div>
    </div>
</form>
