<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ADDCHEF</title>
</head>
<body>
<form:form action="/addChef?restaurant=${restaurant}" modelAttribute="chef">
    Name:
    <form:input path="name"/>
    <form:errors path="name"/><br/>


    Nationality:
    <form:input path="nationality"/>
    <form:errors path="nationality"/><br/>

    Speciality:
    <form:input path="speciality"/>
    <form:errors path="speciality"/><br/>

    Stars:
    <form:input path="stars"/>
    <form:errors path="stars"/><br/>

    <input type="submit" value="Add Chef"/><form:errors/>
</form:form>
</body>
</html>