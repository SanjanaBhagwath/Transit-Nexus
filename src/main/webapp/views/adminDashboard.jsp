<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container"> <!-- Added container for styling -->
        <h1>Admin Dashboard</h1>

        <h2>Options:</h2>
        <ul class="dashboard-options">
            <li><a href="/admin/addRoutes" class="button">Add Routes</a></li>
            <li><a href="/admin/addStations" class="button">Add Stations</a></li>
            <li><a href="/admin/addFares" class="button">Add Fares</a></li>
            <li><a href="/admin/addPassengers" class="button">Add Passengers</a></li>
            <li><a href="/admin/viewReports" class="button">View Reports</a></li>
        </ul>
    </div> <!-- End of container -->
</body>
</html>