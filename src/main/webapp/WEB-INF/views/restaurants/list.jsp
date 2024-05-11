<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Restaurants</title>
</head>
<body>
<c:forEach items="${restaurants}" var="restaurants">
    <p>Name: ${restaurants.name}<br>
        Owner: ${restaurants.owner}<br>
        <a href="/chefs?restaurant=${restaurants.id}">[View Chefs]</a></p>
</c:forEach>
<p><a href="/newrestaurants">[Add Restaurant]</a></p>
</body>
</html>