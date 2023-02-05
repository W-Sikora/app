<%@include file="../imports/jsp-imports.jsp" %>

<div>
    <a class="button is-success">
        <fmt:message key="add.text"/>
    </a>
</div>


<c:choose>
    <c:when test="${empty categories}">
        <fmt:message key="category.list.is.empty"/>
    </c:when>

    <c:otherwise>
        <table class="table">
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
                    <td>${category.description}</td>
                    <td>${category.assignedTransactionType}</td>
                    <td>
                        <div class="field is-grouped">
                            <p class="control">
                                <a href="${editUrl}${category.id}" class="button is-info is-outlined">
                                    <fmt:message key="edit.text"/>
                                </a>
                            </p>
                            <p class="control">
                                <button class="button is-danger is-outlined is-">
                                    <fmt:message key="delete.text"/>
                                </button>
                            </p>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

