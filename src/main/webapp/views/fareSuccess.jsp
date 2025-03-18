<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fare Added Successfully</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>${message}</h1> <!-- Display the success message -->
        <a href="/admin/dashboard" class="button">Back to Dashboard</a> <!-- Link back to the admin dashboard -->
    </div>
</body>
</html>