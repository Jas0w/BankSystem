<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>

    <table border="1px">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Workers</th>
            <th>Clients</th>
        </tr>

        <c:forEach items="${banks}" var="bank">
            <tr>
                <td>${bank.id}</td>
                <td>${bank.name}</td>
                <td><a href="/banks/${bank.id}/employees">Employees</a></td>
                <td><a href="/banks/${bank.id}/clients">Clients</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
