<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Player not found!</title>
</head>
<body>
<p>Not Found player</p>
<p>${pageContext.exception.name}</p>
<p>${pageContext.exception.message}</p>
</body>
</html>