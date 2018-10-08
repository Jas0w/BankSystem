<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <table border="1px">
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Phone number</th>
            <th>Address</th>
            <th>Email</th>
            <th></th>
        </tr>

        <c:forEach items="${clients}" var="account">
            <tr>
                <td><a href="clients/${account.id}">${account.id}</a></td>
                <td>${account.firstName}</td>
                <td>${account.lastName}</td>
                <td>${account.phoneNumber}</td>
                <td>${account.address}</td>
                <td>${account.email}</td>
                <td><a href="clients/${account.id}/delete">delete</a><br/></td>
            </tr>
        </c:forEach>
    </table>

    <a href="addClient">New client</a><br/>
    <a href="/banks">Back to banks list</a>
</body>
</html>
