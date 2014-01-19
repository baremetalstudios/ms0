<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <title><fmt:message key="company.name"/></title>
</head>
<body>
<header><h2><fmt:message key="welcome"/></h2></header>
<div>
    <jsp:include page="./component/search.jsp"/>
</div>
</body>
</html>
