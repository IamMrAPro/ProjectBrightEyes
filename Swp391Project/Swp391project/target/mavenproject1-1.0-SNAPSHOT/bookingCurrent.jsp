<%-- 
    Document   : detail
    Created on : Jan 29, 2023, 9:40:02 PM
    Author     : asus
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>

        </style>
    </head>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>


        <div class="container">



            <div class="row align-items-start">
                <div class="section-title text-center" style="margin: 20px">

                    <form method="post" action="searchBooking" onsubmit="return validateSearch()">
                        <label for="email">Email:</label>
                        <input type="email" name="email" id="email">

                        <label for="phone">Số điện thoại:</label>
                        <input type="tel" name="phone" id="phone">

                        <button type="submit">Search</button>
                        <button ><a href="Register.jsp">Add Patient</a></button>
                        <select name="kind_date" style="float: right">
                            <option value="0" selected>Current date</option>
                            <option value="1">All date</option>

                        </select>
                        <c:if test="${check ne null}" >
                            <p style="color: red;font-size: 20px">${check}</p>
                        </c:if>
                    </form>
                </div>


            </div>

            <div class="row align-items-center">
                <div class="col">

                    <table class="table table-bordered">
                        <thead  style="background-color: #5bc1ac;">
                            <tr>
                                <th style="text-align:center">ID</th>
                                <th style="text-align:center">Name</th>
                                <th style="text-align:center">Phone</th>
                                <th style="text-align:center">Email</th>
                                <th style="text-align:center">Day</th>
                                <th style="text-align:center">Time</th>
                                <th style="text-align:center">Date Booking</th>
                                <th style="text-align:center">Add</th>
                            </tr>
                        </thead>


                        <c:forEach items="${list}" var="p">
                            <tbody> 
                                <tr><td>${p.getBookingId()} </td>
                                    <td>${p.getName()}</td>
                                    <td>${p.getPhone()}</td>
                                    <td>${p.getEmail()}</td>
                                    <td>${p.getDay()}</td>
                                    <td>${p.getTime()}</td>

                                    <td>${p.getSbtime()}</td>
                                    <td style="text-align: center; vertical-align: middle;">
                                        <a href="record?account=${c.getAccount()}">
                                            <ion-icon style="font-size: 20px;" name="add-circle-outline"></ion-icon>
                                        </a>
                                    </td></tr>
                            </tbody>
                        </c:forEach>

                    </table>

                </div>

            </div>

            <div class="row align-items-end">


            </div>



        </div>

        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
    </body>
    <script>
        function validateSearch() {
            var email = document.getElementById("email").value;
            var phone = document.getElementById("phone").value;

            if (email === "" || phone === "") {
                alert("Vui lòng nhập đầy đủ thông tin tìm kiếm");
                return false;
            }
            return true;
        }
    </script>
</html>
