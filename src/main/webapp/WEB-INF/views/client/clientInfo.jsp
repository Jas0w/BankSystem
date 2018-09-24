
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client info</title>
</head>
<body>
    CLIENT INFO<br/>
    ID: <b>${client.id}</b><br/>
    First name: <b>${client.firstName}</b><br/>
    Last name: <b>${client.lastName}</b><br/>
    Phone number: <b>${client.phoneNumber}</b><br/>
    Address: <b>${client.address}</b><br/>
    Email: <b>${client.email}</b><br/>

    <a href="clients/delete/${client.id}/update">Update</a><br/>

    Тут еще аккаунты будут

</body>
</html>
