<%@include file="../imports/jsp-imports.jsp" %>

<div class="column is-full">
    <p>aaaaaaaaaaaaaa${category.name}</p>
    <progress class="progress" value="${category.currentValue}" max="${category.plannedValue}">
        aaa<fmt:formatNumber value="${category.percentage}" type="number" maxFractionDigits="2"/>
    </progress>
</div>
