<%@include file="../imports/jsp-imports.jsp" %>

<div class="field is-grouped">
    <p class="control mr-6">
        <a href="${_fullEditUrl}" class="button is-small is-info is-outlined">
            <fmt:message key="edit.text"/>
        </a>
    </p>
    <p class="control">
        <button data-delete="${_fullDeleteUrl}" class="button is-small is-danger is-outlined js-delete-button">
            <fmt:message key="delete.text"/>
        </button>
    </p>
</div>
