<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>View Tickets by Route</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>View Tickets by Route</h1>

        <form action="${pageContext.request.contextPath}/admin/viewTicketsByRoute" method="GET">
            <div class="form-group">
                <label for="routeNo">Enter Route Number:</label>
                <input type="text" id="routeNo" name="routeNo" required>
            </div>
            <button type="submit" class="button">View Tickets</button>
        </form>

        <c:if test="${not empty error}">
            <div class="error-message">${error}</div>
        </c:if>

        <a href="${pageContext.request.contextPath}/admin/viewReports" class="button">Back to Reports</a>
    </div>
</body>
</html>