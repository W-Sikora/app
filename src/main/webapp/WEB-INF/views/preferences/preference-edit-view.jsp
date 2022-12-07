<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>

<%@ include file="../head-import.jsp" %>

<body>
<div>
    <div class="page-container">
        <section class="hero is-fullheight is-fullheight-with-navbar">

            <%@ include file="../common/navbar.jsp" %>

            <div class="hero-body">
                <div class="container">

                    <div class="columns my-4">
                        <div class="column is-8 is-offset-2 has-medium-bottom-margin">
                            <c:choose>
                                <c:when test="${currentlyLoggedInUser.configured}">
                                    <c:set var="title" value="preferences.edit.title"/>
                                    <nav class="breadcrumb has-medium-top-margin" aria-label="breadcrumbs">
                                        <ul>
                                            <li>
                                                <a href="<c:url value="/dashboard"/>">
                                                    <fmt:message key="dashboard.title"/>
                                                </a>
                                            </li>

                                            <li class="is-active">
                                                <a href="#" aria-current="page">
                                                    <fmt:message key="${title}"/>
                                                </a>
                                            </li>
                                        </ul>
                                    </nav>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="title" value="preferences.first.edit.title"/>
                                </c:otherwise>
                            </c:choose>

                            <div class="has-text-centered mt-6">
                                <h1 class="mb-5 is-size-2 is-size-3-mobile has-text-weight-bold">
                                    <fmt:message key="${title}"/>
                                </h1>
                            </div>
                        </div>
                    </div>

                    <div class="columns my-4">
                        <div class="column is-8 is-offset-2 has-medium-bottom-margin">

                            <%@ include file="preference-form.jsp" %>

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
