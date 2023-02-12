<%@include file="../imports/jsp-imports.jsp" %>

<div class="has-text-centered">
    <form class="keyword-filter js-keyword-filter" method="get">

        <sec:csrfMetaTags/>

        <label class="label" for="categorySelect">
            <fmt:message key="category"/>
        </label>

        <div class="field is-grouped">

            <p class="control is-expanded">
                <div class="select is-fullwidth is-small mr-3">
                    <select id="categorySelect" class="">
                        <option value="">
                            <fmt:message key="select.category"/>
                        </option>
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.categoryId}" label="${category.title}"/>
                        </c:forEach>
                    </select>
                </div>
            </p>

            <p class="control">
                <button class="button is-small" type="submit">
                    <i class="fas fa-search"></i>
                </button>
            </p>

            <p class="control">
                <button class="button is-small js-clear-category">
                    <i class="fas fa-eraser"></i>
                </button>
            </p>
        </div>

    </form>
</div>

<hr class="is-invisible">
