<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Routes</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>Add Routes</h1>

        <form action="/admin/saveRoute" method="post">
            <label for="routeNo">Route No:</label>
            <input type="text" id="routeNo" name="routeNo" required>
            <br>
            <label for="source">Source:</label>
            <input type="text" id="source" name="source" required>
            <br>
            <label for="destination">Destination:</label>
            <input type="text" id="destination" name="destination" required>
            <br>
            <button type="submit" class="button">Add Route</button>
        </form>

        <br>
        <a href="/admin/dashboard" class="button">Back to Dashboard</a>
    </div>
</body>
</html>