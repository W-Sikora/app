<%@include file="../imports/jsp-imports.jsp" %>

<div class="has-text-centered">
    <h1 class="is-size-3">
        <c:if test="${not empty pageTitle && empty additionalTitle}">
            ${pageTitle}
        </c:if>

        <c:if test="${not empty pageTitle && not empty additionalTitle}">
            <c:out value="${pageTitle} ${additionalTitle}"/>
        </c:if>
    </h1>

    <%@ include file="total.jsp" %>
</div>
