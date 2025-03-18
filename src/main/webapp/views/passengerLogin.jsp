<!DOCTYPE html>
<html>
<head>
    <title>Passenger Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="login-container">
        <h1>Passenger Login</h1>
        <form action="${pageContext.request.contextPath}/passenger_login" method="post">
            <div class="form-group">
                <label for="rfid">RFID No:</label>
                <input type="text" id="rfid" name="rfid" required>
            </div>
            <button type="submit" class="button">Submit</button>
        </form>
    </div>
</body>
</html>