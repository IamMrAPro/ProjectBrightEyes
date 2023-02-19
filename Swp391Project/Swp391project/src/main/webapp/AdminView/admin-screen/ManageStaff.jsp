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
    <!--<<link rel="stylesheet" href="MyCSS/check-box-button.css"/>-->
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

        .admin-edit {
            width: 40px;
            height: 40px;
            background-color: #cccccc;
            line-height: 40px;
            border-radius: 5px;
        }

        .status-stick {
            width: 2px;
            height: 20px;
            background-color: #5a6f80;
            margin-left: 5px;
            margin-right: 5px;
        }
        /*--------------------------------------*/
    </style>
    <body onload="getPositionNavBar(1)">
        <form action="manageStaff" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->
            <input name="setPosition" type="text" value="2" class="d-none">
            <!--            --------------------------------------------------------------------->

            <%@include file="../admin-layout/admin-navbar.jsp" %>
            <div class="main-view main-view-content">
                <div class="d-flex justify-content-between header-staff-list align-items-center mb-4">
                    <h2>MANAGE STAFF</h2>
                    <div class="form-floating align-items-center d-flex" id="searchStaff">
                        <input name="staffSearch" type="text" id="search-staff-content" class="form-control" placeholder="Search by name">
                        <button id="staff-search-btn"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
                <div class="table-responsive">
                    <% int count = 0;%>
                    <div class="d-flex align-items-center">
                        <div class="d-flex mb-3">
                            <div>Display: </div>
                            <select class="mx-2">
                                <option value="working" selected="">Working</option>
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
                                <th class="text-center">#</th>
                                <th>
                                    <div class="d-flex justify-content-between">
                                        <div>Name</div>
                                        <div>
                                            <input type="submit" name="sortByName" id="sort-name" value="sort" class="d-none">
                                            <label for="sort-name" class="sort-icon"><i class="fa-solid fa-sort"></i></label>
                                            <!--                                            <input type="text" name="typeOfSort" value="" class="d-none">-->
                                        </div>
                                    </div>
                                </th>
                                <th>Job Title</th>
                                <th>Number Phone</th>
                                <th>
                                    <div class="d-flex justify-content-between">
                                        <div>Status</div>
                                        <!--                                        <div>
                                                                                    <input type="submit" name="sortByName" id="sort-name" value="sort" class="d-none">
                                                                                    <label for="sort-name" class="sort-icon"><i class="fa-solid fa-sort"></i></label>
                                                                                </div>-->
                                    </div>
                                </th>
                                <th class="text-center">Attendance</th>
                                <th class="text-center">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listUser}" var="u">
                                <tr class="align-items-center">
                                    <th class="text-center"><% count++;
                                            out.print(count);%></th>
                                    <th>${u.getFullname()}</th>
                                    <th>Doctor</th>
                                    <th>0961973785</th>
                                    <th>
                                        <div class="d-flex">
                                            <div>Working</div>
                                            <div class="status-stick"></div>
                                            <div>Online</div>
                                        </div>
                                    </th>
                                    <th>
                                        <div class="d-flex justify-content-between">
                                            <input type="radio" name="attendance" id="attendace-absent">
                                            <label for="attendace-absent">Absent</label>
                                            <input type="radio" name="attendance" id="attendace-present">
                                            <label for="attendace-present">Present</label>
                                        </div>
                                    </th>
                                    <th>
                                        <div class="d-flex justify-content-between">
                                            <a href="editUser"><i class="fa-solid fa-pen"></i></a>
                                            <div class="btn btn-success">
                                                <i class="fa-brands fa-facebook-messenger"></i>
                                            </div>
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
