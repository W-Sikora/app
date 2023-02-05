<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>

<%@ include file="../imports/head-imports.jsp" %>

<body>
<div>
    <div class="page-container">
        <div class="hero is-fullheight is-fullheight-with-navbar">

            <%@ include file="../common/navbar.jsp" %>

            <div class="hero-body has-large-top-margin">
                <div class="container main-section">

                    <div class="columns is-centered">
                        <div class="column is-10">

                            <div class="has-text-centered mb-4">
                                <h1 class="is-size-3">
                                    <c:out value="${pageTitle}"/>
                                </h1>
                            </div>

                            <%@include file="period.jsp" %>

                            <hr>

                            <%@ include file="menu.jsp" %>

                            <hr>
                        </div>
                    </div>

                    <div class="columns is-centered">
                        <div class="column is-10">

                            <%@include file="summary.jsp" %>

                            <%@include file="chart.jsp"%>

                            <%@ include file="conclusion.jsp"%>

                        </div>
                    </div>

                </div>
            </div>

        </div>
    </div>

    <%@ include file="../common/footer.jsp" %>
</div>

</body>
</html>
