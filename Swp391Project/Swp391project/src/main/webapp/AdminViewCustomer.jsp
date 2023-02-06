
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="layout/head.jsp" %>
    <style>
        .select-all {
            margin-left: 30px;
        }
    </style>
    <body>
        <header class="align-items-centers d-flex justify-content-between mt-3">
            <div class="d-flex">
                <a href="AddStaff.jsp" class="btn btn-success text-center">+ ADD A NEW CUSTOMER</a>
            </div>
            <div class="input-group">
                <input type="text" class="form-control" name="customerSearch" placeholder="Search">
                <button class="input-group-text" name="searchStaff"><i class="fa-solid fa-magnifying-glass"></i></button>
            </div>

        </header>

        <br>
        <div class="select-all">
            <input type="checkbox" name="selectAllCustomer" id="select-all" onclick="selectAll()"> 
            <label for="select-all" onclick="selectAll()">Select All</label>
        </div>
        <table class="table table-bordered table-staff">
            <tr class="bg-info">
                <th></th>
                <th>Status</th>
                <th>Full name</th>
                <th>Gender</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Options</th>
            </tr>

            <c:forEach items="${listCustomer}" var="user">
                <tr>
                <input name="deleteStaff" type="text" value="${user.getUserId()}" class="d-none">
                <td><input type="checkbox" name="getCustomer" value="${user.getUserId()}"></td>
                <td>Offline</td>
                <td>${user.getFullname()}</td>
                <td>${user.getGender()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getPhonenumber()}</td>
                <td class="d-flex"> <a href="" class="btn btn-success">Manager</a> | <button class="btn btn-danger">Delete</button></td>
            </tr>
        </c:forEach>
    </table>

    <script>
        function selectAll() {
            var allCustomer = document.getElementsByName("getCustomer");
            var len = allCustomer.length;
            var select = document.getElementById('select-all');
            if (select.checked) {
                for (var i = 0; i < len; i++) {
                    allCustomer[i].checked = true;
                }
            } else {
                for (var i = 0; i < len; i++) {
                    allCustomer[i].checked = false;
                }
            }
        }

    </script>
</body>
</html>