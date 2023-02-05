<%@include file="../imports/jsp-imports.jsp" %>

<div>
    <a class="button is-success">
        <fmt:message key="add.text"/>
    </a>
</div>


<c:choose>
    <c:when test="${empty plannedExpenditure}">
        <fmt:message key="planned.expenditure.list.is.empty"/>
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
                    <fmt:message key="category"/>
                </th>
                <th>
                    <fmt:message key="schedule"/>
                </th>
                <th>
                    <fmt:message key="period"/>
                </th>
                <th></th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${plannedExpenditures}" var="plannedExpenditure" varStatus="loop">
                <tr>
                    <th>${loop.index + 1}</th>
                    <td>${plannedExpenditure.title}</td>
                    <td>${plannedExpenditure.description}</td>
                    <td>${plannedExpenditure.category}</td>
                    <td>${plannedExpenditure.money}</td>
                    <td>${plannedExpenditure.schedule}</td>
                    <td>${plannedExpenditure.yearMonth}</td>
                    <td>
                        <div class="field is-grouped">
                            <p class="control">
                                <a href="${editUrl}${plannedExpenditure.id}" class="button is-info is-outlined">
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

