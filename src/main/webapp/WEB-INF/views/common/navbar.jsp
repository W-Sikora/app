<%@ page contentType="text/html;charset=UTF-8" %>


<nav class="navbar">
    <div class="navbar-brand">

        <div class="navbar-items-left">
            <a class="navbar-item is-size-4	has-text-weight-bold ml-3" href="${logoAppUrl}">
                <fmt:message key="app.name"/>
            </a>
        </div>

        <div class="navbar-items-right">
            <sec:authorize access="isAuthenticated()">
                <sec:authorize access="hasAuthority('USER')">
                    <div class="navbar-item has-dropdown is-hoverable is-right mr-5">
                        <%@ include file="navbar-user-dropdown.jsp" %>
                    </div>
                </sec:authorize>
            </sec:authorize>

            <div class="navbar-item has-dropdown is-hoverable is-right mr-5">
                <%@ include file="navbar-locale-dropdown.jsp" %>
            </div>
        </div>
    </div>
</nav>
