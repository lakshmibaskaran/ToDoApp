<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <%-- Embed files for Bootstrap CSS --%>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <title> To do List </title>
</head>

<body>

    <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
        <a class="navbar-brand m-1" href="/" > Todo for kiddies </a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="/GetTodos">    </a></li>
            </ul>
        </div>
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
        </ul>
    </nav>

    <div class="container">
        <center>
        <b> To do List for ${name}</b>
        </center>

        <br>
        <br>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th> ID </th>
                    <th> Description </th>
                    <th> Target Date </th>
                    <th> Task Finished </th>
                    <th> </th>
                    <th> </th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${todo}" var="todo">
                    <tr>
                        <td> ${todo.toDoId} </td>
                        <td> ${todo.toDoDescription} </td>
                        <td> ${todo.toDoByDate} </td>
                        <td> ${todo.toDoActivityFinished} </td>
                        <td> <a href="delete-todo?id=${todo.toDoId}" class="btn btn-warning"> Delete </td>
                        <td> <a href="update-todo?id=${todo.toDoId}" class="btn btn-success"> Update </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <%-- Add a button for a new To do --%>
        <a href="add-todo" class="btn btn-success"> Add ToDo </a>

        <%-- Embed Java Script files for Bootstrap CSS--%>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"> </script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"> </script>
    </div>
</body>

</html>
