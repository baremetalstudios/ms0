<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <form id="searchForm" action="<c:url value="/component/find" />" method="get">
        <label for="q">Search:</label>
        <input id="q" name="q" type="text"/>
        <button type="submit">Find components</button>
    </form>
</div>
<div>
    <small>In order to show all components use empty search criterion</small>
</div>
