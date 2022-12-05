<%@ page contentType="text/html;charset=UTF-8" %>

<nav class="navbar is-white">
    <div class="navbar-brand">

        <div class="navbar-items-left">
            <a class="navbar-item ml-3" id="menuButton">
                <i class="fa fa-bars fa-2x" aria-hidden="true"></i>
            </a>
        </div>

        <div class="navbar-items-right">
            <a class="navbar-item mr-6">
                <i class="fa fa-plus fa-2x" aria-hidden="true"></i>
            </a>

            <a class="navbar-item mr-6">
                <i class="far fa-bell fa-2x"></i>
            </a>

            <div class="navbar-item has-dropdown is-hoverable mr-6">

                <div class="dropdown is-right">
                    <div class="dropdown-trigger">
                        <a class="navbar-item">
                            <i class="fas fa-user-circle fa-2x"></i>
                        </a>
                    </div>
                    <div class="dropdown-menu" id="dropdown-menu" role="menu">
                        <div class="dropdown-content  dropdown-content-modified">

                            <div class="user-info">
                                <strong>
                                    <c:out value="${userName}"/>
                                </strong><br>
                                <div class="is-size-7	">
                                    <c:out value="${userEmail}"/>
                                </div>
                            </div>

                            <a class="dropdown-item" href="<fmt:message key="navbar.settings.link"/>">
                                <i class="fas fa-cogs mr-1"></i>
                                <span>
                                    <fmt:message key="navbar.settings.text"/>
                                </span>
                            </a>

                            <hr class="dropdown-divider">

                            <a class="dropdown-item" href="<fmt:message key="navbar.log.out.link"/>">
                                <i class="fas fa-sign-out-alt mr-1"></i>
                                <span class="has-text-danger">
                                    <fmt:message key="navbar.log.out.text"/>
                                </span>

                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</nav>
