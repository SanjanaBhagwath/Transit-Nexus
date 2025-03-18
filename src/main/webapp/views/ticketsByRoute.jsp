<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Tickets by Route</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>Tickets for Route ${routeNo}</h1>

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
                            <td>${ticket.getTicket_No()}</td>
                            <td>${ticket.getTimestamp()}</td>
                            <td>${ticket.getDate()}</td>
                            <td>${ticket.getStartStop()}</td>
                            <td>${ticket.getEndStop()}</td>
                            <td>${ticket.getRFID_No()}</td>
                            <td>${ticket.getRoute_No()}</td>
                            <td>${ticket.getFare()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty tickets}">
            <p>No tickets found for route ${routeNo}</p>
        </c:if>

        <a href="${pageContext.request.contextPath}/admin/ticketsByRoutePage" class="button">Back</a>
        <a href="${pageContext.request.contextPath}/admin/viewReports" class="button">Back to Reports</a>
    </div>
</body>
</html>