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
        
        #search-staff-content {
            height: 40px;
        }

        #staff-search-btn {
            width: 70px;
            height: 40px;
            outline: none;
            border: 1px solid black;
        }
    </style>
    <body onload="getPositionNavBar(2)">
        <form action="manageCustomer" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->
            <input name="setPosition" type="text" value="1" class="d-none">
            <!--            --------------------------------------------------------------------->
            <%@include file="../admin-layout/admin-navbar.jsp" %>
            <div class="main-view main-view-content">
                <div class="d-flex justify-content-between header-staff-list align-items-center mb-4">
                    <h2>MANAGE CUSTOMER</h2>
                    <div class="form-floating align-items-center d-flex" id="searchStaff">
                        <input name="staffSearch" type="text" id="search-staff-content" class="form-control" placeholder="Search by name">
                        <button id="staff-search-btn"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
                <br>
                <% int count = 0;%>

                <div class="d-flex align-items-center">
                    <div class="d-flex mb-3">
                        <div>Display: </div>
                        <select class="mx-2">
                            <option value="working" selected="">Current interaction</option>
                            <option value="stopWorking">Stop work</option>
                            <option value="all">All</option>
                        </select>
                    </div>

                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary mb-3" data-toggle="modal" data-target="#exampleModal">
                        CREATE NEW
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Add a new staff</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <%@include file="UserBasicInformation.jsp" %>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <input type="submit" name="addNewStaff" class="btn btn-primary" value="SAVE">
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
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
