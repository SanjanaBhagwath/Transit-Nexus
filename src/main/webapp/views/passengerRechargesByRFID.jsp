<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Recharges by RFID</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>Recharge History for RFID: ${rfidNo}</h1>

        <c:if test="${not empty recharges}">
            <table class="data-table">
                <thead>
                    <tr>
                        <th>RFID No</th>
                        <th>Amount</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="recharge" items="${recharges}">
                        <tr>
                            <td>${recharge.RFID_No}</td>
                            <td>${recharge.getRecharge_Amount()}</td>
                            <td>${recharge.getRecharge_Date()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty recharges}">
        <p>No recharge history found for RFID: ${rfidNo}</p>
        </c:if>

        <a href="passenger_login" class="button">Back to Login</a>
        </div>
</body>
</html>