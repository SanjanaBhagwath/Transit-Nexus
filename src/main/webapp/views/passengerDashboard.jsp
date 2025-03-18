<!DOCTYPE html>
<html>
<head>
    <title>Passenger Dashboard</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>Welcome</h1>
        <h3>RFID: ${rfid}</h3>

        <div class="options">
            <form action="${pageContext.request.contextPath}/passenger_balance" method="post">
                <input type="hidden" name="rfid" value="${rfid}">
                <button type="submit" class="button">Check Balance</button>
            </form>

            <form action="${pageContext.request.contextPath}/passenger_recharge_form" method="get">
                <input type="hidden" name="rfid" value="${rfid}">
                <button type="submit" class="button">Recharge Card</button>
            </form>

            <form action="${pageContext.request.contextPath}/passenger_recharge_history" method="get">
                <input type="hidden" name="rfid" value="${rfid}">
                <button type="submit" class="button">View Recharge History</button>
            </form>
        </div>

        <a href="${pageContext.request.contextPath}/" class="button">Back to Home</a>
    </div>
</body>
</html>