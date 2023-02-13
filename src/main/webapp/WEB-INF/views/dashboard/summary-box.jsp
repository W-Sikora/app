<%@include file="../imports/jsp-imports.jsp" %>

<div class="box">
    <p class="title is-4">
        <fmt:message key="${_title}"/>
    </p>

    <c:set var="cssClass" value=""/>
    <div class="columns">
        <div class="column">
            <c:if test="${_colored and not empty _planned}">
                <c:choose>
                    <c:when test="${_planned.negative}">
                        <c:set var="cssClass" value="has-text-danger"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="cssClass" value="has-text-success"/>
                    </c:otherwise>
                </c:choose>
            </c:if>
            <p class="subtitle is-6">
                <fmt:message key="planned"/>
            </p>
            <p class="subtitle is-4 ${cssClass}">
                <c:choose>
                    <c:when test="${not empty _planned}">
                        ${_planned.formattedValue} ${_planned.sign}
                    </c:when>
                    <c:otherwise>
                        <%@include file="../common/no-elements.jsp" %>
                    </c:otherwise>
                </c:choose>
            </p>
        </div>

        <div class="column">
            <c:if test="${_colored and not empty _current}">
                <c:choose>
                    <c:when test="${_current.negative}">
                        <c:set var="cssClass" value="has-text-danger"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="cssClass" value="has-text-success"/>
                    </c:otherwise>
                </c:choose>
            </c:if>
            <p class="subtitle is-6">
                <fmt:message key="current"/>
            </p>
            <p class="subtitle is-4 ${cssClass}">
                <c:choose>
                    <c:when test="${not empty _current}">
                        ${_current.formattedValue} ${_current.sign}
                    </c:when>
                    <c:otherwise>
                        <%@include file="../common/no-elements.jsp" %>
                    </c:otherwise>
                </c:choose>
            </p>
        </div>
    </div>
</div>
