<%@include file="../imports/jsp-imports.jsp" %>

<div class="columns is-vcentered">
    <div class="column">
        <div class="box">
            <p class="title is-4 mt-2 has-text-centered">
                <fmt:message key="unnecessary.expenses"/>
            </p>

            <div class="columns is-multiline">
                <div class="column is-full">
                    <c:choose>
                        <c:when test="${empty unnecessaryExpenditures || unnecessaryExpenditures.isEmpty()}">

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
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach items="${unnecessaryExpenditures.toList()}" var="expenditure"
                                           varStatus="loop">
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
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>

                            <c:set var="_currentPage" value="${unnecessaryExpendituresCurrentPage}"/>
                            <c:set var="_lastPage" value="${unnecessaryExpenditures.totalPages}"/>
                            <c:set var="_parameterName" value="page"/>
                            <%@ include file="../common/pagination.jsp" %>

                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
