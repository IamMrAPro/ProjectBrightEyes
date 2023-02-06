<%-- 
    Document   : AdminViewStaff
    Created on : Feb 1, 2023, 10:25:27 PM
    Author     : Ao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="layout/head.jsp" %>
    <body>
        <header class="align-items-centers d-flex justify-content-between mt-3">
            <div class="d-flex">
                <a href="AddStaff.jsp" class="btn btn-success text-center">+ ADD A NEW STAFF</a>
            </div>
            <div class="input-group">
                <input type="text" class="form-control" name="listStaffSearch" placeholder="Search">
                <button class="input-group-text" name="searchStaff"><i class="fa-solid fa-magnifying-glass"></i></button>
            </div>
        </header>

        <br>
        <table class="table table-bordered table-staff">
            <tr class="bg-info">
                <th>Status</th>
                <th>Full name</th>
                <th>Gender</th>
                <th>Function</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Options</th>
            </tr>

            <c:forEach items="${listUser}" var="user">
                <tr>
                    <input name="deleteStaff" type="text" value="${user.getUserId()}" class="d-none">
                    <td>Offline</td>
                    <td>${user.getFullname()}</td>
                    <td>${user.getGender()}</td>
                    <td>${user.getRole()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getPhonenumber()}</td>
                    <td class="d-flex"> <a href="" class="btn btn-success">Manager</a> | <button class="btn btn-danger">Delete</button></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
