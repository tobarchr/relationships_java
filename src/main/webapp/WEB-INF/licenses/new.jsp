<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
        crossorigin="anonymous">
    <title>New License</title>
</head>

<body>
    <div class="container mx-auto mt-5" style="width: 500px;">
        <h1>New License</h1>
        <form:form action="/licenses" method="post" modelAttribute="license">
            <div class="form-group mb-3">
                <form:label path="person" class="form-label">Person:</form:label>
                <form:errors path="person" class="form-text"></form:errors>
                <form:select path="person" class="form-select">
                    <c:forEach items="${person}" var="p">
                        <form:option value="${p.id}">${p.firstName} ${p.lastName}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group mb-3">
                <form:label path="expirationDate" class="form-label">Expiration Date:</form:label>
                <form:errors path="expirationDate" class="form-text"></form:errors>
                <form:input path="expirationDate" class="form-control" type="date"></form:input>
            </div>
            <div class="form-group mb-3">
                <form:label path="state" class="form-label">State:</form:label>
                <form:errors path="state" class="form-text"></form:errors>
                <form:input path="state" class="form-control"></form:input>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</body>

</html>