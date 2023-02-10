<%@include file="../imports/jsp-imports.jsp" %>

<div class="columns">
    <div class="column">

        <h2 class="is-size-4 has-text-centered">
           <fmt:message key="planned.expenditures"/>
        </h2>

        <hr class="is-invisible">

        <c:set var="_addUrl" value="${plannedExpenditureAddUrl}"/>
        <c:set var="_editUrl" value="${plannedExpenditureEditUrl}"/>
        <c:set var="_deleteUrl" value="${plannedExpenditureDeleteUrl}"/>

        <c:if test="${not empty _addUrl}">

            <%@ include file="../common/add.jsp" %>

        </c:if>

        <c:choose>
            <c:when test="${empty plannedExpenditures}">

                <%@include file="../common/no-elements.jsp" %>

            </c:when>

            <c:otherwise>

                <table class="table is-fullwidth">
                    <thead>
                    <tr>
                        <th></th>
                        <th>
                            <fmt:message key="category"/>
                        </th>
                        <th>
                            <fmt:message key="priority"/>
                        </th>
                        <th>
                            <fmt:message key="money"/>
                        </th>
                        <th></th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${plannedExpenditures.toList()}" var="plannedExpenditure" varStatus="loop">
                        <tr>
                            <th>
                                ${loop.index + 1}
                            </th>
                            <td>
                                ${plannedExpenditure.categoryDto.title}
                            </td>
                            <td>
                                <fmt:message key="priority.${plannedExpenditure.plannedExpenditureId}"/>
                            </td>
                            <td class="has-text-right">
                                ${plannedExpenditure.moneyDto.formattedValue}
                                <fmt:message key="currency.${plannedExpenditure.moneyDto.currencyId}.sign"/>
                            </td>
                            <td>
                                <c:set var="_fullEditUrl" value="${_editUrl}${plannedExpenditure.plannedExpenditureId}"/>
                                <c:set var="_fullDeleteUrl" value="${_deleteUrl}${plannedExpenditure.plannedExpenditureId}"/>

                                <%@include file="../common/options.jsp" %>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <c:set var="_currentPage" value="${currentPage}"/>
                <c:set var="_lastPage" value="${categories.totalPages}"/>
                <%@ include file="../common/pagination.jsp" %>

                <%@ include file="../common/modal.jsp" %>

            </c:otherwise>
        </c:choose>
    </div>

    <div class="column">

        <h2 class="is-size-4 has-text-centered">
            <fmt:message key="planned.revenues"/>
        </h2>

        <hr class="is-invisible">

        <c:set var="_addUrl" value="${plannedRevenueAddUrl}"/>
        <c:set var="_editUrl" value="${plannedRevenueEditUrl}"/>
        <c:set var="_deleteUrl" value="${plannedRevenueDeleteUrl}"/>

        <c:if test="${not empty _addUrl}">

            <%@ include file="../common/add.jsp" %>

        </c:if>

        <c:choose>
            <c:when test="${empty plannedRevenues}">

                <%@include file="../common/no-elements.jsp" %>

            </c:when>

            <c:otherwise>

                <table class="table is-fullwidth">
                    <thead>
                    <tr>
                        <th></th>
                        <th>
                            <fmt:message key="title"/>
                        </th>
                        <th>
                            <fmt:message key="transaction.type"/>
                        </th>
                        <th></th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${plannedRevenues.toList()}" var="plannedRevenue" varStatus="loop">
                        <tr>
                            <th>
                                ${loop.index + 1}
                            </th>
                            <td>

                            </td>
                            <td>

                            </td>
                            <td>
                                <c:set var="_fullEditUrl" value="${_editUrl}${plannedRevenue.plannedRevenueId}"/>
                                <c:set var="_fullDeleteUrl" value="${_deleteUrl}${plannedRevenue.plannedRevenueId}"/>

                                <%@include file="../common/options.jsp" %>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <c:set var="_currentPage" value="${currentPage}"/>
                <c:set var="_lastPage" value="${categories.totalPages}"/>
                <%@ include file="../common/pagination.jsp" %>

                <%@ include file="../common/modal.jsp" %>

            </c:otherwise>
        </c:choose>
    </div>
</div>
