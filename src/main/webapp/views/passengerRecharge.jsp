<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Recharge Card</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>Recharge Card</h1>
        <h3>RFID: ${rfid}</h3>

        <form action="${pageContext.request.contextPath}/process_recharge" method="post">
            <input type="hidden" name="rfid" value="${rfid}">

            <div class="form-group">
                <label for="amount">Enter Amount:</label>
                <input type="number" id="amount" name="amount" min="1" required>
            </div>

            <button type="submit" class="button">Recharge</button>
        </form>

        <c:if test="${not empty error}">
            <div class="error-message">${error}</div>
        </c:if>

        <a href="passenger_login" class="button">Back to Login</a>
    </div>
</body>
</html>