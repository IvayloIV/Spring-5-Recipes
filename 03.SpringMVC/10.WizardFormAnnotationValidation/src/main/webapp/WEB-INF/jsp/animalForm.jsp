<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Animal From</title>
    <style>
        .error {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <f:form method="post" action="create" modelAttribute="player">
        <table>
            <tr>
                <td>Animal information</td>
                <td>Name: <f:input path="animal.name" /></td>
                <td><f:errors path="animal.name" cssClass="error" /></td>
                <td>Type: <f:select path="animal.animalType" items="${animalTypes}" /></td>
                <td><f:errors path="animal.animalType" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="hidden" value="1" name="_page" />
                    <input type="submit" value="Previous" name="_target0" />
                    <input type="submit" value="Finish" name="_finish" />
                    <input type="submit" value="Cancel" name="_cancel" />
                </td>
            </tr>
        </table>
    </f:form>
</body>
</html>
