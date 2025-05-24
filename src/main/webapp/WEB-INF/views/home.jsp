<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Library - Home</title>
</head>
<body>
    <h1>Library Book List</h1>

    <c:if test="${not empty message}">
        <p style="color: green;">${message}</p>
    </c:if>

    <a href="${pageContext.request.contextPath}/add">Add New Book</a>

    <table border="1" cellpadding="10" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Category</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.category}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/edit/${book.id}">Edit</a> |
                        <a href="${pageContext.request.contextPath}/delete/${book.id}" onclick="return confirm('Are you sure?');">Delete</a>
                    </td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
