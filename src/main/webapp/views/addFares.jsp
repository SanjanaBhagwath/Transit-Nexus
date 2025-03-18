<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Fares</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>Add Fares</h1>

        <form action="/admin/saveFare" method="post">
            <label for="fare">Fare:</label>
            <input type="number" step="0.01" id="fare" name="fare" required>
            <br>
            <label for="station1">Station 1:</label>
            <input type="text" id="station1" name="station1" required>
            <br>
            <label for="station2">Station 2:</label>
            <input type="text" id="station2" name="station2" required>
            <br>
            <label for="routeNo">Route No:</label>
            <input type="text" id="routeNo" name="routeNo" required>
            <br>
            <button type="submit" class="button">Add Fare</button>
        </form>

        <br>
        <a href="/admin/dashboard" class="button">Back to Dashboard</a>
    </div>
</body>
</html>