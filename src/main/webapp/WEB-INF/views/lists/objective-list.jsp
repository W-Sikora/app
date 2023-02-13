<%@include file="../imports/jsp-imports.jsp" %>

<c:set var="_addUrl" value="${addUrl}"/>
<c:set var="_editUrl" value="${editUrl}"/>
<c:set var="_deleteUrl" value="${deleteUrl}"/>

<c:if test="${not empty _addUrl}">

    <%@ include file="../common/add.jsp" %>

</c:if>

<c:set var="_keyword" value="${keyword}"/>
<%@ include file="../common/keyword-filter.jsp" %>

<c:choose>
    <c:when test="${empty objectives || objectives.isEmpty()}">

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
                    <fmt:message key="description"/>
                </th>
                <th>
                    <fmt:message key="necessary.money"/>
                </th>
                <th>
                    <fmt:message key="raised.money"/>
                </th>
                <th>
                    <fmt:message key="realized"/>
                </th>
                <th></th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${objectives.toList()}" var="objective" varStatus="loop">
                <tr>
                    <th>
                            ${loop.index + 1}
                    </th>
                    <td>
                            ${objective.title}
                    </td>
                    <td>
                            ${objective.description}
                    </td>
                    <td>
                            ${objective.necessaryMoneyDto.formattedValue}
                        <fmt:message key="currency.${objective.necessaryMoneyDto.currencyId}"/>
                    </td>
                    <td>
                            ${objective.raisedMoneyDto.formattedValue}
                        <fmt:message key="currency.${objective.raisedMoneyDto.currencyId}"/>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${objective.realized}">
                                <fmt:message key="yes"/>
                            </c:when>
                            <c:otherwise>
                                <fmt:message key="no"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:set var="_fullEditUrl" value="${_editUrl}${objective.categoryId}"/>
                        <c:set var="_fullDeleteUrl" value="${_deleteUrl}${objective.categoryId}"/>

                        <%@include file="../common/options.jsp" %>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <c:set var="_currentPage" value="${currentPage}"/>
        <c:set var="_lastPage" value="${objectives.totalPages}"/>
        <%@ include file="../common/pagination.jsp" %>

        <%@ include file="../common/modal.jsp" %>

    </c:otherwise>
</c:choose>

