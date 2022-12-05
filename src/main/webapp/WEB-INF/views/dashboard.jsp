<!DOCTYPE html>
<html lang="pl">

<head>
    <meta charset="utf-8">
    <title>Admin - Free Bulma template</title>
    <%@ include file="head-import.jsp" %>
</head>

<body>

<!-- START NAV -->
<%@ include file="navbar.jsp" %>

<div class="page-container">
    <div class="columns">
        <%@ include file="common/menu.jsp" %>
        <div class="container">

            <%@include file="common/breadcrumb.jsp" %>

            <div class="column is-main-content">
                <section class="hero is-link welcome is-small">
                    <div class="hero-body">
                        <div class="container">
                            <h1 class="title">
                                <fmt:message key="dashboard.hello.text">
                                    <fmt:param value="${userName}"/>
                                </fmt:message>
                            </h1>
                            <h2 class="subtitle">
                                I hope you are having a great day!
                            </h2>
                        </div>
                    </div>
                </section>

                <form method="GET" action="<c:url value="/dashboard"/>">
                    <%@include file="common/period.jsp" %>
                </form>

                <section class="info-tiles">

                    <div class="tile is-ancestor has-text-centered mt-2">
                        <div class="tile is-parent">
                            <article class="tile is-child box">
                                <p class="title">439k</p>
                                <p class="subtitle">Users</p>
                            </article>
                        </div>

                        <div class="tile is-parent">
                            <article class="tile is-child box">
                                <p class="title">59k</p>
                                <p class="subtitle">Products</p>
                            </article>
                        </div>

                        <div class="tile is-parent">
                            <article class="tile is-child box">
                                <p class="title">3.4k</p>
                                <p class="subtitle">Open Orders</p>
                            </article>
                        </div>

                        <div class="tile is-parent">
                            <article class="tile is-child box">
                                <p class="title">19</p>
                                <p class="subtitle">Exceptions</p>
                            </article>
                        </div>
                    </div>
                </section>

                <div class="columns">

                    <%@ include file="recent-transactions.jsp"%>
                    <div class="column is-6">
                        <div class="card">
                            <header class="card-header">
                                <p class="card-header-title">
                                    Inventory Search
                                </p>
                                <a href="#" class="card-header-icon" aria-label="more options">
                  <span class="icon">
                    <i class="fa fa-angle-down" aria-hidden="true"></i>
                  </span>
                                </a>
                            </header>
                            <div class="card-content">
                                <div class="content">
                                    <div class="control has-icons-left has-icons-right">
                                        <input class="input is-large" type="text" placeholder="">
                                        <span class="icon is-medium is-left">
                      <i class="fa fa-search"></i>
                    </span>
                                        <span class="icon is-medium is-right">
                      <i class="fa fa-check"></i>
                    </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <header class="card-header">
                                <p class="card-header-title">
                                    User Search
                                </p>
                                <a href="#" class="card-header-icon" aria-label="more options">
                  <span class="icon">
                    <i class="fa fa-angle-down" aria-hidden="true"></i>
                  </span>
                                </a>
                            </header>
                            <div class="card-content">
                                <div class="content">
                                    <div class="control has-icons-left has-icons-right">
                                        <input class="input is-large" type="text" placeholder="">
                                        <span class="icon is-medium is-left">
                      <i class="fa fa-search"></i>
                    </span>
                                        <span class="icon is-medium is-right">
                      <i class="fa fa-check"></i>
                    </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>
<script>
    document.addEventListener('DOMContentLoaded', function () {

        const dropdown = document.querySelector('.dropdown');

        dropdown.addEventListener('click', function (event) {
            event.stopPropagation();
            dropdown.classList.toggle('is-active');
        });


        const menuButton = document.querySelector('#menuButton');
        const menu = document.querySelector('#menu');

        menuButton.addEventListener('click', function (event) {

            event.stopPropagation();

            if (menu.style.display === 'none') {

                menu.style.display = 'block';
            } else {

                menu.style.display = 'none';
            }
        });
    });

</script>
</body>

</html>
