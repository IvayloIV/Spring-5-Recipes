<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Welcome to Player Reservation System</h2>
<spring:message code="welcome.title" text="Default message"/>.
<br/>
Locale: ${pageContext.response.locale}
</body>
</html>