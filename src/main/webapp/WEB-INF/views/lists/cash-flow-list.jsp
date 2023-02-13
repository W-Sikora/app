<%@include file="../imports/jsp-imports.jsp" %>

<div class="columns is-desktop">
    <div class="column table-container">

        <c:set var="_subtitle" value="expenditures"/>
        <c:set var="_totalMoneyDto" value="${dto.totalPlannedExpenditures}"/>
        <%@ include file="../common/subtitle-with-total.jsp" %>

        <hr class="is-invisible">

        <c:set var="_addUrl" value="${expenditureAddUrl}"/>

        <c:if test="${not empty _addUrl}">

            <%@ include file="../common/add.jsp" %>

        </c:if>

        <c:choose>
            <c:when test="${not empty expenditures}">

                <%@include file="../common/no-elements.jsp" %>

            </c:when>

            <c:otherwise>

                <table class="table is-fullwidth">
                    <thead>
                    <tr>
                        <th></th>
                        <th>
                            <fmt:message key="date"/>
                        </th>
                        <th>
                            <fmt:message key="title"/>
                        </th>
                        <th>
                            <fmt:message key="category"/>
                        </th>
                        <th>
                            <fmt:message key="priority"/>
                        </th>
                        <th>
                            <fmt:message key="payee"/>
                        </th>
                        <th>
                            <fmt:message key="money"/>
                        </th>
                        <th></th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${expenditures.toList()}" var="expenditure" varStatus="loop">
                        <tr>
                            <th>
                                    ${loop.index + 1}
                            </th>
                            <td>
                                    ${expenditure.date}
                            </td>
                            <td>
                                    ${expenditure.title}
                            </td>
                            <td>
                                    ${expenditure.categoryDto.title}
                            </td>
                            <td>
                                <fmt:message key="priority.${expenditure.priority}"/>
                            </td>
                            <td>
                                    ${expenditure.payee}
                            </td>
                            <td class="has-text-right">
                                    ${expenditure.moneyDto.formattedValue}
                                    ${expenditure.moneyDto.sign}
                            </td>
                            <td>
                                <c:set var="_fullEditUrl" value="${expenditure.urlDto.editUrl}"/>
                                <c:set var="_fullDeleteUrl" value="${expenditure.urlDto.deleteUrl}"/>

                                <%@include file="../common/options.jsp" %>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <c:set var="_currentPage" value="${expendituresCurrentPage}"/>
                <c:set var="_lastPage" value="${expenditures.totalPages}"/>
                <c:set var="_parameterName" value="expenditurePage"/>
                <%@ include file="../common/pagination.jsp" %>

            </c:otherwise>
        </c:choose>
    </div>

    <div class="column table-container">

        <c:set var="_subtitle" value="revenues"/>
        <c:set var="_totalMoneyDto" value="${dto.totalPlannedRevenues}"/>
        <%@ include file="../common/subtitle-with-total.jsp" %>

        <hr class="is-invisible">

        <c:set var="_addUrl" value="${revenueAddUrl}"/>

        <c:if test="${not empty _addUrl}">

            <%@ include file="../common/add.jsp" %>

        </c:if>

        <c:choose>
            <c:when test="${not empty revenues}">

                <%@include file="../common/no-elements.jsp" %>

            </c:when>

            <c:otherwise>

                <table class="table is-fullwidth">
                    <thead>
                    <tr>
                        <th></th>
                        <th>
                            <fmt:message key="date"/>
                        </th>
                        <th>
                            <fmt:message key="title"/>
                        </th>
                        <th>
                            <fmt:message key="category"/>
                        </th>
                        <th>
                            <fmt:message key="payer"/>
                        </th>
                        <th>
                            <fmt:message key="money"/>
                        </th>
                        <th></th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${revenues.toList()}" var="revenue" varStatus="loop">
                        <tr>
                            <th>
                                    ${loop.index + 1}
                            </th>
                            <td>
                                    ${revenue.date}
                            </td>
                            <td>
                                    ${revenue.categoryDto.title}
                            </td>
                            <td>
                                    ${revenue.payer}
                            </td>
                            <td>
                                    ${revenue.moneyDto.formattedValue}
                                    ${revenue.moneyDto.sign}
                            </td>
                            <td>
                                <c:set var="_fullEditUrl" value="${revenue.urlDto.editUrl}"/>
                                <c:set var="_fullDeleteUrl" value="${revenue.urlDto.deleteUrl}"/>

                                <%@include file="../common/options.jsp" %>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <c:set var="_currentPage" value="${revenuesCurrentPage}"/>
                <c:set var="_lastPage" value="${revenues.totalPages}"/>
                <c:set var="_parameterName" value="expenditurePage"/>
                <%@ include file="../common/pagination.jsp" %>

            </c:otherwise>
        </c:choose>
    </div>

    <%@ include file="../common/modal.jsp" %>

</div>
