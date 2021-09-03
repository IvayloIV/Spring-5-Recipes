<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Players</title>
</head>
<body>
<ui>
    <c:forEach items="${players}" var="player">
        <li>${player.name} - ${player.age} - ${player.animal.name} - ${player.animal.animalType}</li>
    </c:forEach>
</ui>
</body>
</html>