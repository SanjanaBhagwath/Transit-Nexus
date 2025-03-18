<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Stations</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>Add Stations</h1>

        <form action="/admin/saveStation" method="post">
            <label for="routeNo">Route No:</label>
            <input type="text" id="routeNo" name="routeNo" required>
            <br>
            <label for="stationName">Station Name:</label>
            <input type="text" id="stationName" name="stationName" required>
            <br>
            <label for="stationOrder">Station Order:</label>
            <input type="number" id="stationOrder" name="stationOrder" required>
            <br>
            <button type="submit" class="button">Add Station</button>
        </form>

        <br>
        <a href="/admin/dashboard" class="button">Back to Dashboard</a>
    </div>
</body>
</html>