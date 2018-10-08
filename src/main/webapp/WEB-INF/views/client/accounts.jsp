<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<table border="1px">
    <tr>
        <th>Id</th>
        <th>Currency</th>
        <th>Amount</th>
        <th>Amount of credit</th>
        <th></th>
    </tr>

    <c:forEach items="${accounts}" var="account">
        <tr>
            <td><a href="clients/${account.id}">${account.id}</a></td>
            <td>${account.currency}</td>
            <td>${account.amount}</td>
            <td>${account.amountOfCredit}</td>
            <td><a href="clients/${account.id}/delete">delete</a><br/></td>
        </tr>
    </c:forEach>
</table>

<a href="addClient">New client</a><br/>
<a href="/banks">Back to banks list</a>
</body>
</html>
