<%@include file="../imports/jsp-imports.jsp" %>

<div class="columns is-desktop">
    <div class="column table-container">

        <c:set var="_subtitle" value="planned.expenditures"/>
        <c:set var="_totalMoneyDto" value="${dto.totalPlannedExpenditures}"/>
        <%@ include file="../common/subtitle-with-total.jsp" %>

        <hr class="is-invisible">

        <c:set var="_addUrl" value="${plannedExpenditureAddUrl}"/>

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
                                <fmt:message key="priority.${plannedExpenditure.priority}"/>
                            </td>
                            <td class="has-text-right">
                                ${plannedExpenditure.moneyDto.formattedValue}
                                ${plannedExpenditure.moneyDto.money.currency.sign}
                            </td>
                            <td>
                                <c:set var="_fullEditUrl" value="${plannedExpenditure.urlDto.editUrl}"/>
                                <c:set var="_fullDeleteUrl" value="${plannedExpenditure.urlDto.deleteUrl}"/>

                                <%@include file="../common/options.jsp" %>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <c:set var="_currentPage" value="${plannedExpendituresCurrentPage}"/>
                <c:set var="_lastPage" value="${plannedExpenditures.totalPages}"/>
                <c:set var="_parameterName" value="plannedExpenditurePage"/>
                <%@ include file="../common/pagination.jsp" %>

            </c:otherwise>
        </c:choose>
    </div>

    <div class="column table-container">

        <c:set var="_subtitle" value="planned.revenues"/>
        <c:set var="_totalMoneyDto" value="${dto.totalPlannedRevenues}"/>
        <%@ include file="../common/subtitle-with-total.jsp" %>

        <hr class="is-invisible">

        <c:set var="_addUrl" value="${plannedRevenueAddUrl}"/>

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
                            <fmt:message key="category"/>
                        </th>
                        <th>
                            <fmt:message key="money"/>
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
                                ${plannedRevenue.categoryDto.title}
                            </td>
                            <td>
                                ${plannedRevenue.moneyDto.formattedValue}
                                ${plannedRevenue.moneyDto.money.currency.sign}
                            </td>
                            <td>
                                <c:set var="_fullEditUrl" value="${plannedRevenue.urlDto.editUrl}"/>
                                <c:set var="_fullDeleteUrl" value="${plannedRevenue.urlDto.deleteUrl}"/>

                                <%@include file="../common/options.jsp" %>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <c:set var="_currentPage" value="${plannedRevenuesCurrentPage}"/>
                <c:set var="_lastPage" value="${plannedRevenues.totalPages}"/>
                <c:set var="_parameterName" value="plannedExpenditurePage"/>
                <%@ include file="../common/pagination.jsp" %>

            </c:otherwise>
        </c:choose>
    </div>

    <%@ include file="../common/modal.jsp" %>

</div>
