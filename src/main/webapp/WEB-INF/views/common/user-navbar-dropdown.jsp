<%@ page contentType="text/html;charset=UTF-8" %>

<sec:authorize access="isAuthenticated()">
    <div class="user-info has-text-centered">

        <strong>
            <c:out value="${currentlyLoggedInUser.name}"/>
        </strong><br>

        <div class="is-size-7 mt-2">
            <c:out value="${currentlyLoggedInUser.email}"/>
        </div>

        <sec:authorize access="hasAuthority('user')">
            <div class="field has-addons has-addons-centered mt-4">
                <div class="control">
                    <label>
                        <input class="input is-small" type="text" value="${currentlyLoggedInUser.uuid}" id="uuidInput" readonly>
                    </label>
                </div>

                <div class="control" id="copyUuid">
                    <a class="button is-small">
                        <i class="far fa-copy"></i>
                    </a>
                </div>
            </div>
        </sec:authorize>
    </div>

    <a class="navbar-item mb-3" href="<c:url value="/settings"/>">
        <i class="fas fa-cogs mr-2"></i>
        <span>
            <fmt:message key="navbar.settings.text"/>
        </span>
    </a>
</sec:authorize>

<a class="navbar-item button is-danger is-light" href="<c:url value="/logout"/>">
    <span>
        <fmt:message key="navbar.log.out.text"/>
    </span>
</a>
