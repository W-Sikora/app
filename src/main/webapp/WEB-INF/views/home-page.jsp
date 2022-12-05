<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="head-import.jsp" %>
<html>
<body>
<div class="page-container">

    <%@ include file="navbar-for-home-page.jsp" %>

    <div class="page-container">
        <section class="hero">
            <div class="hero-body">
                <div class="container has-text-centered">
                    <div class="columns is-variable">
                        <div class="column is-two-thirds has-text-left">
                            <section class="section">
                                <h1 class="title is-1">
                                    <fmt:message key="footer.app.name"/>
                                </h1>
                                <p class="is-size-4">
                                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nulla
                                </p>
                            </section>

                            <section class="section">
                                <p class="title">
                                    <fmt:message key="app.description.1.title"/>
                                </p>
                                <p class="subtitle">
                                    <fmt:message key="app.description.1.text"/>
                                </p>
                            </section>

                            <section class="section">
                                <h1 class="title">Medium section</h1>
                                <h2 class="subtitle">
                                    A simple container to divide your page into <strong>sections</strong>, like the one
                                    you're currently reading.
                                </h2>
                            </section>
                        </div>
                        <div class="column is-one-third has-text-left mt-6">
                            <%@ include file="login-form.jsp" %>
                            <%--                            <%@ include file="login-form.jsp"%>--%>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <%@ include file="common/footer.jsp" %>
</div>
</body>
</html>
