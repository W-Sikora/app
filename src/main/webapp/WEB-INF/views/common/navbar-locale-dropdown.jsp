<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../imports/jsp-imports.jsp" %>

<div class="dropdown" id="navbarLocaleDropdown">
    <div class="dropdown-trigger" id="navbarLocaleDropdownTrigger">
        <a class="navbar-item">
            <i class="fas fa-language fa-2x"></i>
        </a>
    </div>
    <div class="dropdown-menu mt-2">
        <div class="dropdown-content is-narrow-dropdown-content has-rounded-corners">
            <ul class="mt-3">
                <c:set var="currentLocale" value="${pageContext.response.locale.toString()}"/>
                <c:if test="${!currentLocale.equals('pl')}">
                    <li>
                        <a class="change-locale" data-code="pl">
                            <img alt="pl" width="32px" src="<c:url value="/static/icons/pl.png"/>"/>
                        </a>
                    </li>
                </c:if>

                <c:if test="${!currentLocale.equals('en')}">
                    <li class="mt-4">
                        <a class="change-locale" data-code="en">
                            <img alt="en" width="32px" src="<c:url value="/static/icons/en.png"/>"/>
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</div>

<script>

</script>
