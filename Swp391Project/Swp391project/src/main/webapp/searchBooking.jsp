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
                        <c:if test="${check ne null}" >
                            <p style="color: red;font-size: 20px">${check}</p>
                        </c:if>
                    </form>
                </div>


            </div>

            <div class="row align-items-center">
                <div class="col">

                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Day</th>
                                <th>Time</th>
                                <th>Medical Information</th>
                                <th>Payment</th>
                                <th></th>
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
                                    <td>${p.getMedical()}</td>
                                    <td>${p.getPayment()}</td>
                                    <td>${p.getSbtime()}</td>
                                    <td>Delete</td>
                                </tr>
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

            if (email === "" && phone === "") {
                alert("Vui lòng nhập ít nhất một trong hai ô tìm kiếm");
                return false;
            }
            return true;
        }
    </script>
</html>
