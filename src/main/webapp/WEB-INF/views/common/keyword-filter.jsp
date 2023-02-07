<%@include file="../imports/jsp-imports.jsp" %>

<form class="js-keyword-filter" method="get">

    <sec:csrfMetaTags/>

    <label class="label has-text-centered" for="keyword">
        <fmt:message key="keyword"/>
    </label>

    <div class="field is-grouped">

        <p class="control is-expanded">
            <input class="input is-small" type="text" name="keyword" id="keyword" placeholder="${_keyword}">
        </p>

        <p class="control">
            <button class="button is-small" type="submit">
                <i class="fas fa-search"></i>
            </button>
        </p>

        <p class="control">
            <button class="button is-small js-clear">
                <i class="fas fa-eraser"></i>
            </button>
        </p>
    </div>

</form>

<hr class="is-invisible">
