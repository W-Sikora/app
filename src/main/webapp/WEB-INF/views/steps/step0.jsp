<%@include file="../imports/jsp-imports.jsp" %>


<div class="columns is-centered">
    <div class="column is-three-quarters has-medium-vertical-margin">

        <section class="section is-large">
            <p class="is-size-1">
                <fmt:message key="step.0.welcome"/> <sec:authentication property="principal.username"/>
            </p>
            <p class="subtitle mt-4">
                <fmt:message key="step.0.text"/>
            </p>
            <p class="is-size-2">
                <fmt:message key="app.name"/>
            </p>

            <section class="mt-6">
                <p class="subtitle">
                    <fmt:message key="step.0.instruction"/> <fmt:message key="next"/>.
                </p>
                <div class="has-text-centered mt-6">
                    <a href="/adventure/1" class="button is-link">
                        <fmt:message key="next"/>
                    </a>
                </div>
            </section>
        </section>

    </div>
</div>
