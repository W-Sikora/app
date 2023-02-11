<%@include file="../imports/jsp-imports.jsp"%>

<c:if test="${not empty _subtitle || not empty _totalMoneyDto}">
    <div class="has-text-centered">
        <c:if test="${not empty _subtitle}">
            <h2 class="is-size-4 mb-4">
                <fmt:message key="${_subtitle}"/>
            </h2>
        </c:if>

        <c:if test="${not empty _totalMoneyDto}">
            <div class="field is-grouped is-grouped-centered mt-5">
                <p class="control is-size-5">
                    <fmt:message key="total"/>:
                </p>
                <p class="control is-size-5">
                    <span class="has-text-weight-semibold">
                        ${_totalMoneyDto.formattedValue}
                    </span>
                    <span>
                        ${_totalMoneyDto.money.currency.sign}
                    </span>
                </p>
            </div>
        </c:if>
    </div>
</c:if>
