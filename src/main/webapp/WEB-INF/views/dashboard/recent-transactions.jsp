<div class="column is-6">
    <div class="card events-card">

        <div class="has-text-centered ">
            <p>
                <fmt:message key="recent.transactions.title"/>
            </p>
        </div>

        <c:choose>
            <c:when test="${empty recentTransactions}">
                brak transakcji!
            </c:when>
            <c:otherwise>
                <div class="card-table">
                    <div class="content">
                        <table class="table is-fullwidth is-striped">
                            <tbody>
                            <c:forEach var="recentTransaction" items="${recentTransactions}">
                                <tr class="mb-4">
                                    <td>
<%--                                        <a href="<c:out value="${recentTransaction._link}"/>">--%>
                                            <c:out value="${recentTransaction.shortTitle}"/>
<%--                                        </a>--%>
                                        <div class="is-size-7">
                                            <fmt:formatDate value="${recentTransaction.date}" pattern="yy/MM/dd HH:mm"/>
                                            <time datetime="2016-1-1">02/12/22 11:11</time>
                                        </div>
                                    </td>
                                    <c:choose>
                                        <c:when test="${recentTransaction.value > 0}">
                                            <c:set var="recentTransactionValueClass" value=""/>
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="recentTransactionValueClass" value=""/>
                                        </c:otherwise>
                                    </c:choose>
                                    <td class="<c:out value="${recentTransactionValueClass}"/>">
                                        <fmt:formatNumber type="number" maxFractionDigits="2"
                                                          value="${recentTransaction.value}"/>
                                        <c:out value="${recentTransaction.currency}"/>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <footer class="card-footer">
                    <a href="#" class="card-footer-item">
                        <fmt:message key="recent.transactions.view.all"/>
                    </a>
                </footer>
            </c:otherwise>
        </c:choose>
    </div>
</div>
