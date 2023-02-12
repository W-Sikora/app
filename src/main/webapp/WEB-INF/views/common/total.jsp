<%@include file="../imports/jsp-imports.jsp" %>

<c:set var="_totalMoneyDto" value="${dto}"/>

<c:if test="${not empty _totalMoneyDto}">
    <div class="has-text-centered">
        <div class="field is-grouped is-grouped-centered mt-5">
            <p class="control is-size-5">
                <fmt:message key="balance"/>:
            </p>
            <c:choose>
                <c:when test="${_totalMoneyDto.balance.money.value < 0}">
                    <c:set var="cssClass" value="has-text-danger"/>
                </c:when>
                <c:otherwise>
                    <c:set var="cssClass" value="has-text-success"/>
                </c:otherwise>
            </c:choose>
            <p class="control is-size-5">
                <span class="has-text-weight-semibold ${cssClass}">
                    ${_totalMoneyDto.balance.formattedValue}
                </span>
                <span>
                    ${_totalMoneyDto.balance.money.currency.sign}
                </span>
            </p>
        </div>
    </div>
</c:if>
