<%@include file="../imports/jsp-imports.jsp" %>

<div class="modal" id="modal">

    <div class="modal-background"></div>

    <div class="modal-card box has-text-centered">

        <p class="subtitle is-4 mt-3">
            <fmt:message key="want.to.delete.text"/>
        </p>

        <div class="field is-grouped is-grouped-centered mt-3">
            <p class="control mr-6">
                <button class="button is-outlined js-cancel-button">
                    <fmt:message key="cancel.text"/>
                </button>
            </p>

            <p class="control">
                <form class="js-final-delete" method="post">
                    <sec:csrfInput/>
                    <button type="submit" class="button is-danger is-outlined">
                        <fmt:message key="delete.text"/>
                    </button>
                </form>
            </p>
        </div>
    </div>

</div>
