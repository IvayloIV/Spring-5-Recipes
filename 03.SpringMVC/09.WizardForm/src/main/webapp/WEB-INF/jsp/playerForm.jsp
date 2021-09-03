<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Player From</title>
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
                <td>Player information</td>
                <td>Name: <f:input path="name" /></td>
                <td><f:errors path="name" cssClass="error" /></td>
                <td>Age: <f:input path="age" /></td>
                <td><f:errors path="age" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="hidden" value="0" name="_page" />
                    <input type="submit" value="Next" name="_target1" />
                    <input type="submit" value="Cancel" name="_cancel" />
                </td>
            </tr>
        </table>
    </f:form>
</body>
</html>
