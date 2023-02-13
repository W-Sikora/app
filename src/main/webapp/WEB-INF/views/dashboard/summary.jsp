<%@include file="../imports/jsp-imports.jsp" %>

<div class="columns is-vcentered has-text-centered">

    <div class="column mr-6">
        <c:set var="_title" value="expenditures"/>
        <c:set var="_colored" value="${false}"/>
        <c:set var="_planned" value="${totalDto.totalPlannedExpenditure}"/>
        <c:set var="_current" value="${totalDto.totalCurrentExpenditure}"/>
        <%@include file="summary-box.jsp" %>
    </div>

    <div class="column mr-6">
        <c:set var="_title" value="balance"/>
        <c:set var="_colored" value="${true}"/>
        <c:set var="_planned" value="${totalDto.plannedBalance}"/>
        <c:set var="_current" value="${totalDto.currentBalance}"/>
        <%@include file="summary-box.jsp" %>
    </div>

    <div class="column">
        <c:set var="_title" value="revenues"/>
        <c:set var="_colored" value="${false}"/>
        <c:set var="_planned" value="${totalDto.totalPlannedRevenue}"/>
        <c:set var="_current" value="${totalDto.totalCurrentRevenue}"/>
        <%@include file="summary-box.jsp" %>
    </div>
</div>
