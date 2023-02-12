<%@include file="../imports/jsp-imports.jsp" %>

<div class="has-text-centered">
    <p class="subtitle is-4 has-text-grey">
        <fmt:message key="${errorMessage}"/>
    </p>

    <button class="button is-link is-outlined mt-3" onclick="history.back()">
        <i class="fas fa-chevron-left mr-3"></i>
        <fmt:message key="back.to.previous.page.button"/>
    </button>
</div>
