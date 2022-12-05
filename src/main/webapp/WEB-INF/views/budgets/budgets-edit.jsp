<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form method="post" action="/budgets/edit" modelAttribute="budgetForm">
        <form:hidden path="id"/>
        <form:hidden path="creatorId"/>

    <div>
        <form:label path="name">
            <fmt:message key="footer.app.name"/>
        </form:label>
        <form:input path="name" type="text" required="required"/>
        <form:errors path="name" cssClass="error"/>
    </div>

    <div>
        <form:label path="manager">manager</form:label>
        <form:select path="manager.id">
            <c:forEach items="${managers}" var="manager">
                <c:set var="label" value="${manager.name} ${manager.lastName}"/>
                <form:option value="${manager.id}" label="${label}"/>
            </c:forEach>
        </form:select>
        <form:errors path="manager" cssClass="error"/>
    </div>

    <button type="submit">Submit</button>
</form:form>
</body>
</html>
