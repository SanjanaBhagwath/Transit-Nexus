<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report Options</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>Report Options</h1>
        <h2>Select a Report to View:</h2>
        <ul class="report-options">
            <li><a href="/admin/rechargeHistoryPage" class="button">View Recharge History</a></li>
            <li><a href="/admin/ticketsByDatePage" class="button">Tickets Generated on a Specific Date</a></li>
            <li><a href="/admin/ticketsByRoutePage" class="button">Tickets Generated on a Specific Route</a></li>
            <li><a href="/admin/rechargesByRFIDPage" class="button">Recharges by RFID</a></li>
        </ul>
        <a href="/admin/dashboard" class="button">Back to Dashboard</a>
    </div>
</body>
</html>