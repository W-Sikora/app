<%@ page contentType="text/html;charset=UTF-8" %>

<sec:authorize access="isAuthenticated()">
    <nav class="navbar">
        <div class="navbar-brand">

            <div class="navbar-items-left">
                <a class="navbar-item is-size-4	has-text-weight-bold ml-3" href="<c:url value="/home"/>">
                    <fmt:message key="app.name"/>
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
                                <%@ include file="user-navbar-dropdown.jsp" %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </nav>
</sec:authorize>

<sec:authorize access="isAnonymous()">
    <nav class="navbar-for-main-page">
        <div class="navbar-brand">
            <div class="navbar-items-left">
                <a class="navbar-item is-size-4	has-text-weight-bold ml-3" href="<c:url value="/"/>">
                    <fmt:message key="app.name"/>
                </a>
            </div>
        </div>
    </nav>
</sec:authorize>
