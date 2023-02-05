<!DOCTYPE html>
<html>

<%@ include file="../imports/head-imports.jsp" %>

<body>
<div>
    <div class="page-container">
        <section class="hero is-fullheight is-fullheight-with-navbar">

            <%@ include file="navbar.jsp" %>

            <div class="hero-body">
                <div class="container">

                    <div class="columns is-centered">
                        <div class="column is-three-quarters has-medium-bottom-margin has-text-centered">

                            <c:import url="${stepPage}"/>

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
