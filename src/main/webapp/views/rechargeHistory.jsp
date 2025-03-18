<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Recharge History</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>Recharge History for ${selectedDate}</h1>

        <c:if test="${not empty rechargeHistory}">
            <table class="data-table">
                <thead>
                    <tr>
                        <th>RFID</th>
                        <th>Amount</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="recharge" items="${rechargeHistory}">
                        <tr>
                            <td>${recharge.RFID_No}</td>
                            <td>${recharge.getRecharge_Amount()}</td>
                            <td>${recharge.getRecharge_Date()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty rechargeHistory}">
            <p>No recharge records found for the selected date.</p>
        </c:if>

        <a href="${pageContext.request.contextPath}/admin/viewReports" class="button">Back to Reports</a>
    </div>
</body>
</html>