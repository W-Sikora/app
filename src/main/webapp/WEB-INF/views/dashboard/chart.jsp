<%@include file="../imports/jsp-imports.jsp" %>

<div class="columns is-vcentered has-text-centered">

    <div class="column mr-6">
        <div class="box">
            <p class="title is-4">
                <fmt:message key="expenditures.realization.in.groups"/>
            </p>

            <div class="columns is-multiline">
                <div class="column is-full">
                    <p class="subtitle">
                        <fmt:message key="planned"/>
                    </p>
                </div>

                <div class="column is-full">

                </div>
            </div>
        </div>
    </div>

    <div class="column">
        <div class="box">
            <p class="title is-4">
                <fmt:message key="expenditures.in.groups"/>
            </p>

            <div class="columns is-multiline has-text-left">
                <div class="column is-full">
                    <div class="columns is-multiline">
                        <c:forEach items="categoriesProgress" var="category">
                            <c:if test="${not empty category}">
                                <c:import url="progress.jsp" />
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
