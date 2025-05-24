<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Book</title>
</head>
<body>
    <h1>Add a New Book</h1>

    <form:form method="POST" action="${pageContext.request.contextPath}/add" modelAttribute="book">
        <table>
            <tr>
                <td>Title:</td>
                <td><form:input path="title" /></td>
            </tr>
            <tr>
                <td>Author:</td>
                <td><form:input path="author" /></td>
            </tr>
            <tr>
                <td>Category:</td>
                <td><form:input path="category" /></td>
            </tr>
        </table>
        <br>
        <button type="submit">Add Book</button>
    </form:form>

    <br>
    <a href="${pageContext.request.contextPath}/">Back to Home</a>
</body>
</html>
