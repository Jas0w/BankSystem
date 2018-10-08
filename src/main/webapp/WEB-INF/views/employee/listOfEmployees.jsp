<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of employees</title>
</head>
<body>
    <table>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Phone number</th>
            <th></th>
        </tr>

        <c:forEach items="${employees}" var="employee">
        <tr>
            <td><a href="employees/${employee.id}">${employee.id}</a></td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.phoneNumber}</td>
            <td><a href="employees/${employee.id}/delete">delete</a><br/></td>
        </tr>
        </c:forEach>

    </table>

    <a href="addEmployee">New employee</a><br/>
    <a href="/banks">Back to banks list</a>

</body>
</html>
