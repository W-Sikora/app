<%@ page contentType="text/html;charset=UTF-8" %>

<nav class="navbar">
    <div class="navbar-brand">

        <div class="navbar-items-left">
            <a class="navbar-item ml-4" id="menuButton">
                <i class="fa fa-bars fa-2x" aria-hidden="true"></i>
            </a>
        </div>

        <div class="navbar-items-right">
            <div class="navbar-item has-dropdown is-hoverable is-right mr-5">
                <div class="dropdown is-right" id="navbarDropdown">
                    <div class="dropdown-trigger" id="navbarDropdownTrigger">
                        <a class="navbar-item">
                            <i class="fas fa-user-circle fa-2x"></i>
                        </a>
                    </div>
                    <div class="dropdown-menu">
                        <div class="dropdown-content has-rounded-corners">
                            <%@ include file="user-navbar-dropdown.jsp"%>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</nav>

<script src="<c:url value="/static/js/main.js"/>"></script>
