<%@include file="../imports/jsp-imports.jsp" %>

<c:set var="_addUrl" value="${addUrl}"/>

<c:if test="${not empty _addUrl}">

    <%@ include file="../common/add.jsp" %>

</c:if>

<c:set var="_keyword" value="${keyword}"/>
<%@ include file="../common/keyword-filter.jsp" %>

<c:choose>
    <c:when test="${empty categories.toList()}">

        <%@include file="../common/no-elements.jsp" %>

    </c:when>

    <c:otherwise>

        <div class="table-container">
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
            <c:forEach items="${categories.toList()}" var="category" varStatus="loop">
                <tr>
                    <th>
                        ${loop.index + 1}
                    </th>
                    <td>
                        ${category.title}
                    </td>
                    <td>
                        <fmt:message key="transaction.type.${category.transactionType}"/>
                    </td>
                    <td>
                        <c:set var="_fullEditUrl" value="${category.urlDto.editUrl}"/>
                        <c:set var="_fullDeleteUrl" value="${category.urlDto.deleteUrl}"/>

                        <%@include file="../common/options.jsp" %>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>

        <c:set var="_currentPage" value="${currentPage}"/>
        <c:set var="_lastPage" value="${categories.totalPages}"/>
        <c:set var="_parameterName" value="page"/>
        <%@ include file="../common/pagination.jsp" %>

    </c:otherwise>
</c:choose>

<%@ include file="../common/modal.jsp" %>
