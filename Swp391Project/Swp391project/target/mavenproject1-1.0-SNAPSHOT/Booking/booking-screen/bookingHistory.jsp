<%-- 
    Document   : ManageStaff
    Created on : Feb 10, 2023, 8:18:34 PM
    Author     : Ao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../booking-layout/booking-navbar.jsp" %>
    <!--<<link rel="stylesheet" href="MyCSS/check-box-button.css"/>-->
    <style>

    </style>
    <body onload="getPositionNavBar(1)">
       
        <%@include file="../booking-layout/booking-navbar.jsp" %>
              <div class="container">



            <div class="row align-items-start">


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
                                    <th>Time Booking</th>
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
        
 
</body>
</html>
