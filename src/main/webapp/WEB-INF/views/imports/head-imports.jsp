<%@include file="jsp-imports.jsp"%>

<head>
    <meta charset="utf-8">
    <fmt:setBundle basename="messages"/>
    <title><fmt:message key="app.name"/></title>
    <link rel="stylesheet" href="<c:url value="https://unpkg.com/bulma@0.9.0/css/bulma.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="//use.fontawesome.com/releases/v5.0.7/css/all.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js" defer></script>
    <script src="<c:url value="/static/js/main.js"/>" defer></script>
</head>
