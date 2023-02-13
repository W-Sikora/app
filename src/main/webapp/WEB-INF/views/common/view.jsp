<!DOCTYPE html>
<html lang="${cookie['language'].value}">

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

                            <%@include file="title.jsp" %>

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
