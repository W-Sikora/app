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
                <div class="container">
                    <div class="columns my-4">
                        <div class="column is-8 is-offset-2 has-medium-bottom-margin">
                            <div class="has-text-centered">
                                <h1 class="mb-5 is-size-2 is-size-3-mobile has-text-weight-bold">
                                    ${errorCode}
                                </h1>
                                <p class="subtitle has-text-grey">
                                    <fmt:message key="${errorMessage}"/>
                                </p>

                                <button class="button is-link is-outlined" onclick="history.back()">
                                    <i class="fas fa-chevron-left mr-3"></i>
                                    <fmt:message key="back.to.previous.page.button"/>
                                </button>


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
