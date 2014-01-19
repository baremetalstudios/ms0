<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <title><fmt:message key="company.short.name"/> search result</title>
</head>
<body>
<div>
    <jsp:include page="search.jsp"/>
</div>
<div>
    <p id="resTotal">Total : ${fn:length(components)}</p>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
        </tr>
        <c:forEach var="component" items="${components}">
            <tr>
                <td>
                        ${component.id}
                </td>
                <td>${component.name}</td>
                <td>${component.description}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>