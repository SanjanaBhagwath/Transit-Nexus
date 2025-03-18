<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>View Recharges by RFID</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>View Recharges by RFID</h1>

        <form action="${pageContext.request.contextPath}/admin/viewRechargesByRFID" method="GET">
            <div class="form-group">
                <label for="rfidNo">Enter RFID Number:</label>
                <input type="number" id="rfidNo" name="rfidNo" required>
            </div>
            <button type="submit" class="button">View Recharges</button>
        </form>

        <c:if test="${not empty error}">
            <div class="error-message">${error}</div>
        </c:if>

        <a href="${pageContext.request.contextPath}/admin/viewReports" class="button">Back to Reports</a>
    </div>
</body>
</html>