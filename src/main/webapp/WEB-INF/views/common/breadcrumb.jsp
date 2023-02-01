<%@ page contentType="text/html;charset=UTF-8" %>

<c:if test="${not empty breadcrumbElements}">
    <nav class="breadcrumb has-medium-top-margin" aria-label="breadcrumbs">
        <ul>
            <c:forEach items="${breadcrumbElements}" var="breadcrumbElement" varStatus="status">
                <c:choose>
                    <c:when test="${status.isLast()}">
                        <li class="is-active">
                            <a href="#" aria-current="page">
                                    ${breadcrumbElement.label}
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="${breadcrumbElement.url}">
                                    ${breadcrumbElement.label}
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ul>
    </nav>
</c:if>
