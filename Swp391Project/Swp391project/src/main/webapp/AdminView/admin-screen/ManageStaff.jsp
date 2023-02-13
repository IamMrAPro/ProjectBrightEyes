<%-- 
    Document   : ManageStaff
    Created on : Feb 10, 2023, 8:18:34 PM
    Author     : Ao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <style>
        #searchStaff {
            width: 450px;
            height: 70px;
        }
        
        .header-staff-list {
            height: 70px;
        }
        
        #table-head {
            background-color: #5bc1ac;
        }
        
        #search-staff-content {
            height: 40px;
        }
        
        #staff-search-btn {
            width: 70px;
            height: 40px;
            outline: none;
            border: 1px solid black;
        }
        
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
    </style>
    <body onload="getPositionNavBar(1)">
        <form action="manageStaff" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->
                <input name="setPosition" type="text" value="2" class="d-none">
<!--            --------------------------------------------------------------------->

            <%@include file="../admin-layout/admin-navbar.jsp" %>
            <div class="main-view main-view-content">
                <div class="d-flex justify-content-between header-staff-list align-items-center mb-4">
                    <h2>LIST STAFF</h2>
                    <div class="form-floating align-items-center d-flex" id="searchStaff">
                        <input name="staffSearch" type="text" id="search-staff-content" class="form-control" placeholder="Search by name">
                        <button id="staff-search-btn"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
                <div class="table-responsive">
                    <% int count = 0;%>
                    <table class="table table-bordered">
                        <thead id="table-head">
                            <tr>
                                <th class="text-center">#</th>
                                <th>
                                    <div class="d-flex justify-content-between">
                                        <div>Name</div>
                                        <div>
                                            <input type="submit" name="sortByName" id="sort-name" value="sort" class="d-none">
                                            <label for="sort-name" class="sort-icon"><i class="fa-solid fa-sort"></i></label>
                                        </div>
                                    </div>
                                </th>
                                <th>Job Title</th>
                                <th>Since</th>
                                <th>
                                    <div class="d-flex justify-content-between">
                                        <div>Salary</div>
                                        <div>
                                            <input type="submit" name="sortByName" id="sort-name" value="sort" class="d-none">
                                            <label for="sort-name" class="sort-icon"><i class="fa-solid fa-sort"></i></label>
                                        </div>
                                    </div>
                                </th>
                                <th class="text-right">Status</th>
                                <th class="text-right">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listUser}" var="u">
                            <tr>
                                <th class="text-center"><% count++; out.print(count);%></th>
                                <th>${u.getFullname()}</th>
                                <th>Doctor</th>
                                <th>1/1/2020</th>
                                <th class="text-right">500$</th>
                                <th class="text-right">Online</th>
                                <th class="text-right">
                                    <div class="btn btn-success">
                                        <i class="fa-brands fa-facebook-messenger"></i>
                                    </div>
                                </th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    
                    <div>This table show <% out.print(count);%> staff(s)</div>
                </div>
            </div>
        </form>
    </body>
</html>
