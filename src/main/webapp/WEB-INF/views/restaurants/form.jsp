<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ADDRESTAURANT</title>
</head>
<body>
<form:form action="/addRestaurant" modelAttribute="restaurant">
    ID:
    <form:input path="id"/>
    <form:errors path="id"/><br/>

    Name:
    <form:input path="name"/>
    <form:errors path="name"/><br/>

    Owner:
    <form:input path="owner"/>
    <form:errors path="owner"/><br/>

    <input type="submit"/><form:errors/>
</form:form>
</body>
</html>