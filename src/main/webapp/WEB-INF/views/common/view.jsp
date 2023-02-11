<!DOCTYPE html>
<html>

<%@ include file="../imports/head-imports.jsp" %>

<body>
<div>
    <div class="page-container">
        <div class="hero is-fullheight is-fullheight-with-navbar">

            <%@ include file="navbar.jsp" %>

            <div class="hero-body has-large-top-margin">
                <div class="container main-section">

                    <div class="columns is-centered">
                        <div class="column">

                            <%@include file="breadcrumb.jsp" %>

                            <div class="has-text-centered">
                                <h1 class="is-size-3">
                                    <c:choose>
                                        <c:when test="${empty additionalTitle}">
                                            <c:out value="${pageTitle}"/>
                                        </c:when>
                                        <c:otherwise>
                                            <c:out value="${pageTitle} ${additionalTitle}"/>
                                        </c:otherwise>
                                    </c:choose>
                                </h1>
                                <c:if test="${not empty dto}">

                                    <%@ include file="total.jsp" %>

                                </c:if>
                            </div>

                        </div>
                    </div>

                    <div class="columns is-centered">
                        <div class="column ${columnSize}">
                            <c:import url="${pagePath}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp" %>

</div>
</body>
</html>
