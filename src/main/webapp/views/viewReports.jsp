<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Reports</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>View Reports</h1>

        <h2>Recharge History</h2>
        <form action="/admin/rechargeHistory" method="get">
            <label for="date">Select Date:</label>
            <input type="date" id="date" name="date" required>
            <button type="submit" class="button">View Recharge History</button>
        </form>
        <c:if test="${not empty rechargeHistory}">
            <h3>Recharge History:</h3>
            <ul>
                <c:forEach var="recharge" items="${rechargeHistory}">
                    <li>${recharge}</li> <!-- Customize this based on your Recharge object -->
                </c:forEach>
            </ul>
        </c:if>

        <h2>Tickets Generated on a Specific Date</h2>
        <form action="/admin/ticketsByDate" method="get">
            <label for="date">Select Date:</label>
            <input type="date" id="date" name="date" required>
            <button type="submit" class="button">View Tickets</button>
        </form>
        <c:if test="${not empty ticketCount}">
            <h3>Tickets Generated: ${ticketCount}</h3>
        </c:if>

        <h2>Tickets Generated on a Specific Route</h2>
        <form action="/admin/ticketsByRoute" method="get">
            <label for="routeNo">Route No:</label>
            <input type="text" id="routeNo" name="routeNo" required>
            <button type="submit" class="button">View Tickets</button>
        </form>
        <c:if test="${not empty routeNo}">
            <h3>Tickets Generated on Route ${routeNo}: ${ticketCount}</h3>
        </c:if>

        <h2>Recharges by RFID</h2>
        <form action="/admin/rechargesByRFID" method="get">
            <label for="rfid">RFID:</label>
            <input type="text" id="rfid" name="rfid" required>
            <button type="submit" class="button">View Recharges</button>
        </form>
        <c:if test="${not empty recharges}">
            <h3>Recharges:</h3>
            <ul>
                <c:forEach var="recharge" items="${recharges}">
                    <li>${recharge}</li> <!-- Customize this based on your Recharge object -->
                </c:forEach>
            </ul>
        </c:if>
    </div>
</body>
</html>