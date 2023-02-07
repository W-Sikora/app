<%@include file="../imports/jsp-imports.jsp" %>

<div class="field has-addons has-addons-centered mt-5">

    <p class="control">
        <a class="button" <c:if test="${_currentPage == 1}">disabled</c:if>>
            <span class="icon is-small">
                <i class="fas fa-chevron-left"></i>
            </span>
        </a>
    </p>

    <p class="control">
        <a class="button">
            <strong>${_currentPage}</strong>
            &nbsp;/&nbsp;${_lastPage}
        </a>
    </p>

    <p>
        <a class="button" <c:if test="${_currentPage == _lastPage}">disabled</c:if>>
            <span class="icon is-small">
                <i class="fas fa-chevron-right"></i>
            </span>
        </a>
    </p>
</div>
