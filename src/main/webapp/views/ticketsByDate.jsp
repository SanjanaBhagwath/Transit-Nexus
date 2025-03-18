<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Ticket History</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>Ticket History for ${selectedDate}</h1>

        <c:if test="${not empty tickets}">
            <table class="data-table">
                <thead>
                    <tr>
                        <th>Ticket No</th>
                        <th>Time</th>
                        <th>Date</th>
                        <th>Start Stop</th>
                        <th>End Stop</th>
                        <th>RFID No</th>
                        <th>Route No</th>
                        <th>Fare</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ticket" items="${tickets}">
                        <tr>
                            <td>${ticket.ticket_No}</td>
                            <td>${ticket.timestamp}</td>
                            <td>${ticket.date}</td>
                            <td>${ticket.startStop}</td>
                            <td>${ticket.endStop}</td>
                            <td>${ticket.RFID_No}</td>
                            <td>${ticket.route_No}</td>
                            <td>${ticket.fare}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty tickets}">
            <p>No tickets found for the selected date.</p>
        </c:if>

        <a href="${pageContext.request.contextPath}/admin/ticketsByDatePage" class="button">Back</a>
        <a href="${pageContext.request.contextPath}/admin/viewReports" class="button">Back to Reports</a>
    </div>
</body>
</html>