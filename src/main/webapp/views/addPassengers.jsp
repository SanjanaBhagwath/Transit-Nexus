<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Passengers</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>Add Passengers</h1>

        <form action="/admin/savePassenger" method="post">
            <label for="rfid">RFID No.:</label>
            <input type="number"  id="fare" name="rfid" required>
            <br>
            <label for="balance">Initial balance:</label>
            <input type="number" id="balance" name="balance" required>
            <br>
            <button type="submit" class="button">Add Passenger</button>
        </form>

        <br>
        <a href="/admin/dashboard" class="button">Back to Dashboard</a>
    </div>
</body>
</html>