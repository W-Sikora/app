<%@ page contentType="text/html;charset=UTF-8" %>

<div class="dropdown is-right" id="navbarUserDropdown">
    <div class="dropdown-trigger" id="navbarUserDropdownTrigger">
        <a class="navbar-item">
            <i class="fas fa-user-circle fa-2x"></i>
        </a>
    </div>

    <div class="dropdown-menu mt-2">
        <div class="dropdown-content has-rounded-corners">
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
        </div>
    </div>

    <script>

    </script>
</div>
