<%@ page contentType="text/html;charset=UTF-8" %>

<div class="dropdown is-right" id="navbarUserDropdown">
    <div class="dropdown-trigger" id="navbarUserDropdownTrigger">
        <a class="navbar-item">
            <i class="fas fa-user-circle fa-2x"></i>
        </a>
    </div>

    <div class="dropdown-menu mt-2">
        <div class="dropdown-content has-rounded-corners">
            <div class="field has-addons has-addons-centered has-small-bottom-margin mt-4">
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

            <a href="/major-currency/edit" class="navbar-item button is-small mb-3">
                <fmt:message key="major.currency"/>
            </a>

            <form id="logout" class="is-hidden" action="<c:url value="/logout"/>" method="post">
                <sec:csrfInput/>
            </form>

            <a id="logoutButton" class="navbar-item button is-small is-danger is-light">
                <fmt:message key="navbar.log.out.text"/>
            </a>
        </div>
    </div>

    <script>

    </script>
</div>
