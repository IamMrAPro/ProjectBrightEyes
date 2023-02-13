<%-- 
    Document   : ManageCustomer
    Created on : Feb 11, 2023, 1:44:19 PM
    Author     : Ao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <style>
        .sort-icon {
            width: 25px;
            height: 25px;
            border-radius: 50%;
            background-color: #5a6f80;
            color: white;
            text-align: center;
            line-height: 25px;
            cursor: pointer;
        }
        
        #table-head {
            background-color: #5bc1ac;
        }
    </style>
    <body onload="getPositionNavBar(2)">
        <form action="manageCustomer" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->
                <input name="setPosition" type="text" value="1" class="d-none">
<!--            --------------------------------------------------------------------->
            <%@include file="../admin-layout/admin-navbar.jsp" %>
            <div class="main-view main-view-content">
                <h2>Manage Customer</h2>
                <br>
                <% int count = 0;%>
                <table class="table table-bordered">
                    <thead id="table-head">
                        <tr>
                            <th>No.</th>
                            <th>
                                <div class="d-flex justify-content-between">
                                    <div>Name</div>
                                    <div>
                                        <input type="submit" name="sortByName" id="sort-name" value="sort" class="d-none">
                                        <label for="sort-name" class="sort-icon"><i class="fa-solid fa-sort"></i></label>
                                    </div>
                                </div>
                            </th>
                            <th>Email</th>
                            <th>Status</th>
                            <th>Current interaction</th>
                            <th>Manage</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listCustomer}" var="c">
                            <tr>
                                <th><% count++;
                                    out.print(count);%></th>
                                <th>${c.getFullname()}</th>
                                <th>${c.getEmail()}</th>
                                <th>Online</th>
                                <th>Buy glass</th>
                                <th>
                                    <div class="btn btn-success">
                                        <i class="fa-brands fa-facebook-messenger"></i>
                                    </div>
                                </th>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>
    </body>
</html>
