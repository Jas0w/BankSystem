<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form modelAttribute="newBank" method="post" action="/addBank">
        <form:label path="name">Enter name of bank:</form:label>
        <form:input path="name"/>

        <input type="submit" value="Add"/>
    </form:form>
</body>
</html>
