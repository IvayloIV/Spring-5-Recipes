<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Reservation Form</title>
    <style>
        .error {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="player">
    <form:errors path="*" cssClass="error" />
    <table>
        <tr>
            <td>Name</td>
            <td><form:input path="name" /></td>
            <td><form:errors path="name" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><form:input path="age" /></td>
            <td><form:errors path="age" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Pet name</td>
            <td><form:input path="pet.name" /></td>
            <td><form:errors path="pet.name" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Sport Type</td>
            <td><form:select path="sport" items="${sports}"
                             itemValue="id" itemLabel="name" /></td>
            <td><form:errors path="sport" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>