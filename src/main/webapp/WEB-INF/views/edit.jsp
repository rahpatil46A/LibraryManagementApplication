<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Book</title>
</head>
<body>
    <h1>Edit Book</h1>

    <form:form method="POST" action="${pageContext.request.contextPath}/update" modelAttribute="book">
        <input type="hidden" path="id" value="${book.id}" />

        <table>
            <tr>
                <td>Title:</td>
                <td><form:input path="title" value="${book.title}" /></td>
            </tr>
            <tr>
                <td>Author:</td>
                <td><form:input path="author" value="${book.author}" /></td>
            </tr>
            <tr>
                <td>Category:</td>
                <td><form:input path="category" value="${book.category}" /></td>
            </tr>
        </table>
        <br>
        <button type="submit">Update Book</button>
    </form:form>

    <br>
    <a href="${pageContext.request.contextPath}/">Back to Home</a>
</body>
</html>
