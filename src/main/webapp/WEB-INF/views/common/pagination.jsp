<%@include file="../imports/jsp-imports.jsp" %>

<div class="field has-addons has-addons-centered mt-5">

    <p class="control">
        <a class="button js-previous-page-button" <c:if test="${_currentPage == 1}">disabled</c:if>>
            <span class="icon is-small">
                <i class="fas fa-chevron-left"></i>
            </span>
        </a>
    </p>

    <p class="control">
        <a class="button">
            <span class="has-text-weight-bold js-current-page">
                ${_currentPage}
            </span>

            <span>/</span>

            <span class="has-text-weight-bold js-last-page">
                ${_lastPage}
            </span>
        </a>
    </p>

    <p>
        <a class="button js-next-page-button" <c:if test="${_currentPage == _lastPage}">disabled</c:if>>
            <span class="icon is-small">
                <i class="fas fa-chevron-right"></i>
            </span>
        </a>
    </p>

    <form class="is-hidden js-pagination-form">
        <sec:csrfMetaTags/>
        <input name="${_page}">
    </form>
</div>
