<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>

<%@ include file="../head-import.jsp" %>

<body>
<div>
    <div class="page-container">
        <section class="hero is-fullheight is-fullheight-with-navbar">

            <%@ include file="../common/navbar-for-main-page.jsp" %>

            <div class="hero-body">
                <div class="container">

                    <div class="columns my-4">
                        <div class="column is-8 is-offset-2 has-medium-bottom-margin">
                            <nav class="breadcrumb" aria-label="breadcrumbs">
                                <ul>
                                    <li>
                                        <a href="<c:url value="/"/>">
                                            <fmt:message key="landing-page.title"/>
                                        </a>
                                    </li>
                                    <li class="is-active">
                                        <a href="#" aria-current="page">
                                            <fmt:message key="registration-page.title"/>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                            <div class="has-text-centered">
                                <h1 class="mb-5 is-size-2 is-size-3-mobile has-text-weight-bold">
                                    <fmt:message key="registration-page.title"/>
                                </h1>
                            </div>
                        </div>
                    </div>

                    <div class="columns my-4">
                        <div class="column is-8 is-offset-2 has-medium-bottom-margin">

                            <%@ include file="registration-form.jsp"%>

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
