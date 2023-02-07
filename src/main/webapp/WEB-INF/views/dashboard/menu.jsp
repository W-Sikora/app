<%@include file="../imports/jsp-imports.jsp" %>

<div class="tabs is-centered is-medium">
    <ul>
        <li class="mr-4">
            <a href="${objectiveUrl}">
                <fmt:message key="objectives"/>
            </a>
        </li>

        <li class="mr-4">
            <a href="${categoryUrl}">
                <fmt:message key="categories"/>
            </a>
        </li>

        <li class="mr-4">
            <a href="${budgetUrl}">
                <fmt:message key="budget"/>
            </a>
        </li>

        <li>
            <a href="${cashFlowUrl}">
                <fmt:message key="cash.flow"/>
            </a>
        </li>
    </ul>
</div>
