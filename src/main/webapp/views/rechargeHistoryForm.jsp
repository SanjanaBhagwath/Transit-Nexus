<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>View Recharge History</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>View Recharge History</h1>

        <form action="${pageContext.request.contextPath}/admin/viewRechargeHistory" method="GET">
            <div class="form-group">
                <label for="date">Select Date:</label>
                <input type="date" id="date" name="date" value="${today}" required>
            </div>

            <button type="submit" class="button">View Recharges</button>
        </form>

        <c:if test="${not empty error}">
            <div class="error-message">
                ${error}
            </div>
        </c:if>

        <a href="${pageContext.request.contextPath}/admin/viewReports" class="button">Back to Reports</a>
    </div>
</body>
</html>