<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Records</title>
</head>
<body>
    <h1>All Records</h1>
    <table>
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>License</th>
                <th>State</th>
                <th>Expiration Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${people}" var="person">
            <tr>
                <td><c:out value="${person.firstName}"/></td>
                <td><c:out value="${person.lastName}"/></td>
                <td><c:out value="${person.license.number}"/></td>
                <td><c:out value="${person.license.state}"/></td>
                <td><c:out value="${person.license.expirationDate}"/></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>