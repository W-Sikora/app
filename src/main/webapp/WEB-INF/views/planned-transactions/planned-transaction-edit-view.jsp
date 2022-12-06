<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">

<head>
    <%@ include file="../head-import.jsp" %>
</head>

<%@ include file="../common/navbar.jsp" %>

<body>
<div class="page-container">
    <div class="container">
        <div class="columns is-centered is-mobile">
            <div class="column is-5-tablet is-9-mobile">
                <%@ include file="planned-transaction-form.jsp" %>
            </div>
        </div>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>

<script src="<c:url value="/static/js/main.js"/>"></script>

</body>
</html>
