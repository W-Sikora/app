<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>

<%@ include file="../imports/head-imports.jsp" %>

<body>
<div>
    <div class="page-container">
        <section class="hero is-fullheight is-fullheight-with-navbar">

            <%@ include file="../common/navbar.jsp" %>

            <div class="hero-body">

                <%@include file="../common/menu.jsp"%>

                <div class="container">
                    <div class="columns my-4">
                        <div class="column is-8 is-offset-2 has-medium-bottom-margin">
                            <div class="has-text-centered">
                                <h1 class="mb-5 is-size-2 is-size-3-mobile has-text-weight-bold">
                                    <fmt:message key="dashboard.title"/>
                                </h1>
                            </div>
                        </div>
                    </div>

                    <div class="columns my-4">
                        <div class="column is-8 is-offset-2 has-medium-bottom-margin">

                        </div>
                    </div>

                </div>
            </div>

            <%@ include file="../common/footer.jsp" %>

        </section>
    </div>
</div>
</body>
</html>
