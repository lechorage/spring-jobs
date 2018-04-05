<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Listing Jobs</h1>
<div>
    <c:forEach items="${jobs}" var="job">
        <ul>
            <li>${job.desc}</li>
            <li>${job.company}</li>
            <li>${job.url}</li>
        </ul>
    </c:forEach>
</div>
</body>
</html>
