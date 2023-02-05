<%@include file="../imports/jsp-imports.jsp" %>

<c:set var="addUrl" value="aa"/>
<%@ include file="../common/add.jsp" %>


<c:choose>
    <c:when test="${empty categories}">

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
            <c:forEach items="${categories}" var="category" varStatus="loop">
                <tr>
                    <th>${loop.index + 1}</th>
                    <td>${category.title}</td>
                    <td>${category.assignedTransactionType}</td>
                    <td>
                        <div class="field is-grouped">
                            <p class="control mr-6">
                                <a class="button is-small is-info is-outlined" href="${editUrl}${category.categoryId}">
                                    <fmt:message key="edit.text"/>
                                </a>
                            </p>
                            <p class="control">
                                <button class="button is-small is-danger is-outlined">
                                    <fmt:message key="delete.text"/>
                                </button>
                            </p>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="field has-addons has-addons-centered mt-6">
            <p class="control">
                <a class="button">
                  <span class="icon is-small">
                    <i class="fas fa-chevron-left"></i>
                  </span>
                </a>
            </p>
            <p class="control mx-6 mt-2">
                <strong>
                    AAAAB${currentPage}
                </strong>
            </p>
            <p>
                <a class="button">
                  <span class="icon is-small">
                    <i class="fas fa-chevron-right"></i>
                  </span>
                </a>
            </p>
        </div>

    </c:otherwise>
</c:choose>

