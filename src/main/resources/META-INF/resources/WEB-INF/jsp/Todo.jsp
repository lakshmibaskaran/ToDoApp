<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <%-- Embed files for Bootstrap CSS --%>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
    <title> To do  </title>
</head>

<body>

    <div class="container">
        <center>
        <b> To do </b>
        </center>

        <form:form method="post" modelAttribute="todo">

            <%-- Create a fieldset for Description --%>
            <fieldset class="mb-3">
                <%-- The form element in Springboot has a label attribute that makes label look nicer --%>
                <form:label path="toDoDescription"> Description </form:label>
                <form:input type="text" path="toDoDescription"/>
                <form:errors path="toDoDescription" cssClass="text-warning"/>
            </fieldset>

            <%-- Create a fieldset for Date --%>
                <fieldset class="mb-3">
                    <form:label path="toDoByDate"> Todo Date </form:label>
                    <form:input type="text" path="toDoByDate"/>
                    <form:errors path="toDoByDate" cssClass="text-warning"/>
                </fieldset>

            <form:input type="hidden" path="toDoId" />
            <form:input type="hidden" path="toDoActivityFinished"/>
            <br>
            <input type="submit" class="btn btn-success"/>
        </form:form>

        <%-- Embed Java Script files for Bootstrap CSS--%>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"> </script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"> </script>
        <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"> </script>

        <script type="text/javascript">
        $('#toDoByDate').datepicker({
            format:'yyyy-mm-dd'
            });
        </script>

    </div>
</body>

</html>



