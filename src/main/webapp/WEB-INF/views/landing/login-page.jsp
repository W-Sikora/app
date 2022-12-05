<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>

<%@ include file="../head-import.jsp" %>

<body>
<div>
    <div class="page-container">
        <section class="hero is-fullheight is-fullheight-with-navbar">

            <%@ include file="../navbar-for-main-page.jsp" %>

            <div class="hero-body">
                <div class="container has-text-centered">

                    <div class="columns my-4">
                        <div class="column is-8 is-offset-2 has-medium-bottom-margin">

                            <div class="has-medium-bottom-margin">
                                <h1 class="mb-5 is-size-1 is-size-3-mobile has-text-weight-bold">
                                    <fmt:message key="registration-page.title"/>
                                </h1>
                            </div>

                            <div class="field is-grouped is-grouped-centered">
                                <p class="control">
                                    <button class="button is-medium is-link is-outlined mr-6">
                                        <fmt:message key="main-page.registration.button"/>
                                    </button>
                                </p>

                                <p class="control">
                                    <button class="button is-medium is-link">
                                        <fmt:message key="main-page.login.button"/>
                                    </button>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="columns my-4">
                        <div class="column is-8 is-offset-2 has-medium-bottom-margin">

                            <div class="has-medium-bottom-margin">
                                <h1 class="mb-5 is-size-1 is-size-3-mobile has-text-weight-bold">
                                    <fmt:message key="registration-page.title"/>
                                </h1>
                            </div>

                            <div class="field is-grouped is-grouped-centered">
                                <p class="control">
                                    <button class="button is-medium is-link is-outlined mr-6">
                                        <fmt:message key="main-page.registration.button"/>
                                    </button>
                                </p>

                                <p class="control">
                                    <button class="button is-medium is-link">
                                        <fmt:message key="main-page.login.button"/>
                                    </button>
                                </p>
                            </div>
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
