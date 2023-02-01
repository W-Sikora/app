<!DOCTYPE html>
<html>

<%@ include file="../imports/head-imports.jsp" %>

<body>
<div>
    <div class="page-container">
        <section class="hero is-fullheight is-fullheight-with-navbar">

            <%@ include file="navbar.jsp" %>

            <div class="hero-body mt-6">
                <div class="container">

                    <div class="columns is-centered">
                        <div class="column is-three-quarters has-medium-vertical-margin">

                            <%@include file="breadcrumb.jsp" %>

                            <div class="has-text-centered">
                                <h1 class="is-size-3">
                                    <c:out value="${pageTitle}"/>
                                </h1>
                            </div>

                        </div>
                    </div>

                    <div class="columns is-centered">
                        <div class="column is-three-quarters has-medium-bottom-margin">

                            <c:import url="${listPage}"/>

                        </div>
                    </div>

                </div>
            </div>

            <%@ include file="footer.jsp" %>

        </section>
    </div>
</div>
</body>
</html>
