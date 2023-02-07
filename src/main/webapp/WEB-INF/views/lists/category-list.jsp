<%@include file="../imports/jsp-imports.jsp" %>

<c:set var="_addUrl" value="${addUrl}"/>
<c:set var="_editUrl" value="${editUrl}"/>
<c:set var="_deleteUrl" value="${deleteUrl}"/>
<c:set var="_currentPage" value="${currentPage}"/>
<c:set var="_lastPage" value="${lastPage}"/>

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

        <table class="table is-fullwidth">
            <thead>
            <tr>
                <th></th>
                <th>
                    <fmt:message key="title"/>
                </th>
                <th>
                    <fmt:message key="assigned.transaction.type"/>
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
                        <fmt:message key="assigned.transaction.type.${category.assignedTransactionType}"/>
                    </td>
                    <td>
                        <c:set var="_fullEditUrl" value="${_editUrl}${category.categoryId}"/>
                        <c:set var="_fullDeleteUrl" value="${_deleteUrl}${category.categoryId}"/>

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

