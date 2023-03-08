<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check date input in JSP</title>
    <script>
        function checkDateInput() {
            var dateInput = document.getElementById("dateInput").value;
            var currentDate = new Date();
            var inputDate = new Date(dateInput);
            if (inputDate < currentDate) {
                alert("Please select a future date!");
                document.getElementById("dateInput").value = "";
            }
        }
    </script>
</head>
<body>
    <form>
        <label for="dateInput">Select a date:</label>
        <input type="date" id="dateInput" name="dateInput" onchange="checkDateInput()">
    </form>
</body>
</html>