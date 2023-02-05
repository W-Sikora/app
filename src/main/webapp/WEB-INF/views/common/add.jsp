<%@include file="../imports/jsp-imports.jsp" %>

<c:if test="${not empty addUrl}">
    <div class="has-text-centered">
        <hr>
        <a class="button is-success is-outlined" href="${addUrl}">
            <fmt:message key="add.text"/>
        </a>
        <hr>
    </div>
</c:if>
