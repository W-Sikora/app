<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">

<head>
    <%@ include file="../head-import.jsp" %>
</head>

<%@ include file="../common/navbar.jsp" %>

<body>
<div class="page-container">
    <section class="hero is-fullheight">
        <div class="hero-body">
            <div class="container">
                <div class="columns is-mobile is-centered is-vcentered">
                    <div class="column is-5-tablet is-9-mobile">
                        <nav class="breadcrumb" aria-label="breadcrumbs">
                            <ul>
                                <li><a href="#">Bulma</a></li>
                                <li><a href="#">Documentation</a></li>
                                <li><a href="#">Components</a></li>
                                <li class="is-active"><a href="#" aria-current="page">Breadcrumb</a></li>
                            </ul>
                        </nav>
                        <%@ include file="preference-form.jsp" %>
                    </div>
                </div>
            </div>
        </div>
    </section>

</div>

<%@ include file="../common/footer.jsp" %>
</body>
</html>
