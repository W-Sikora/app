<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>
    <title><fmt:message key="app.name"/></title>
    <link rel="stylesheet" href="<c:url value="https://unpkg.com/bulma@0.9.0/css/bulma.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="//use.fontawesome.com/releases/v5.0.7/css/all.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>"/>
    <link rel="script" href="../../static/js/script.js">
    <fmt:setLocale value="pl"/>
    <fmt:setBundle basename="messages"/>
</head>
