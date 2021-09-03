<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Players</title>
</head>
<body>
<form method="post">
    Player Name
    <input type="text" name="playerName"/>
    <input type="submit" value="Create"/>
</form>
<ui>
    <c:forEach items="${players}" var="player">
        <li>${player.name} - ${player.age}</li>
    </c:forEach>
</ui>
</body>
</html>