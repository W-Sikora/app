<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>

<%@ include file="../imports/head-imports.jsp" %>

<body>
<div>
    <div class="page-container">
        <div class="hero is-fullheight is-fullheight-with-navbar">

            <%@ include file="../common/navbar.jsp" %>

            <div class="hero-body has-large-top-margin">
                <div class="container has-text-centered">

                    <div class="columns my-4">
                        <div class="column is-8 is-offset-2 has-medium-bottom-margin">

                            <div class="has-medium-bottom-margin">
                                <h1 class="mb-5 is-size-1 is-size-3-mobile has-text-weight-bold">
                                    <fmt:message key="app.name"/>
                                </h1>

                                <p class="subtitle has-text-grey">
                                    <fmt:message key="info.main"/>
                                </p>
                            </div>

                            <div class="field is-grouped is-grouped-centered">
                                <p class="control">
                                    <a class="button is-link is-outlined mr-6"
                                       href="${registration}">
                                        <fmt:message key="landing.page.registration.button"/>
                                    </a>
                                </p>

                                <p class="control">
                                    <a class="button is-link" href="${login}">
                                        <fmt:message key="landing.page.login.button"/>
                                    </a>
                                </p>
                            </div>

                            <hr>

                        </div>
                    </div>

                    <div class="columns is-multiline">

                        <div class="column is-12 is-5-desktop">

                            <div class="has-large-bottom-margin">
                                <div>
                                    <h4 class="is-size-4 has-text-weight-bold mb-2">
                                        <fmt:message key="info.label.1"/>
                                    </h4>
                                    <p class="subtitle has-text-grey">
                                        <fmt:message key="info.text.1"/>
                                    </p>
                                </div>
                            </div>

                            <div class="has-large-bottom-margin">
                                <div>
                                    <h4 class="is-size-4 has-text-weight-bold mb-2">
                                        Lorem ipsum dolor
                                    </h4>
                                    <p class="subtitle has-text-grey">
                                        Pellentesque eu quam vitae mi lacinia consequat quis in metus.
                                    </p>
                                </div>
                            </div>

                        </div>

                        <div class="column is-2 is-block-desktop"></div>

                        <div class="column is-12 is-5-desktop">

                            <div class="has-large-bottom-margin">
                                <div>
                                    <h4 class="is-size-4 has-text-weight-bold mb-2">
                                        Lorem ipsum dolor
                                    </h4>
                                    <p class="subtitle has-text-grey">
                                        Pellentesque eu quam vitae mi lacinia consequat quis in metus.
                                    </p>
                                </div>
                            </div>

                            <div class="has-large-bottom-margin">
                                <div>
                                    <h4 class="is-size-4 has-text-weight-bold mb-2">
                                        Lorem ipsum dolor
                                    </h4>
                                    <p class="subtitle has-text-grey">
                                        Pellentesque eu quam vitae mi lacinia consequat quis in metus.
                                    </p>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>
