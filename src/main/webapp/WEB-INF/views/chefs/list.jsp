<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Chefs</title>
</head>
<body>
<c:forEach items="${chefs}" var="chefs">
    <p> Name: ${chefs.name}<br>
        Nationality: ${chefs.nationality}<br>
        Speciality: ${chefs.speciality}<br>
        Stars: ${chefs.stars}<br>
    </p>
</c:forEach>
    <a href="/newChef?restaurant=${restaurant}">[Add Chef]</a>

</body>
</html>