<%@ page contentType="text/html;charset=UTF-8" %>

<sec:authorize access="isAuthenticated()">
    <sec:authorize access="hasAuthority('USER')">

        <div class="field has-addons has-addons-centered mt-4">
            <div class="control">
                <label>
                    <input class="input is-small" type="text" id="uuidInput"
                           value="<sec:authentication property="principal.username"/>" readonly>
                </label>
            </div>

            <div class="control" id="copyUuid">
                <a class="button is-small">
                    <i class="far fa-copy"></i>
                </a>
            </div>
        </div>

        <a class="navbar-item button is-danger is-light" href="<c:url value="/logout"/>">
            <span>
                <fmt:message key="navbar.log.out.text"/>
            </span>
        </a>
    </sec:authorize>
</sec:authorize>
