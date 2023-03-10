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
<<<<<<< Updated upstream
        
        #search-staff-content {
=======
        .card .body {
            font-size: 14px;
            color: #424242;
            padding: 20px;
            font-weight: 400;
        }
        .profile-page .profile-header {
            position: relative
        }

        .profile-page .profile-header .profile-image img {
            border-radius: 50%;
            width: 140px;
            border: 3px solid #fff;
            box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23)
        }

        .profile-page .profile-header .social-icon a {
            margin: 0 5px
        }

        .profile-page .profile-sub-header {
            min-height: 60px;
            width: 100%
        }

        .profile-page .profile-sub-header ul.box-list {
            display: inline-table;
            table-layout: fixed;
            width: 100%;
            background: #eee
        }

        .profile-page .profile-sub-header ul.box-list li {
            border-right: 1px solid #e0e0e0;
            display: table-cell;
            list-style: none
        }

        .profile-page .profile-sub-header ul.box-list li:last-child {
            border-right: none
        }

        .profile-page .profile-sub-header ul.box-list li a {
            display: block;
            padding: 15px 0;
            color: #424242
        }

        .staff-info-card {
            /*            border: 1px solid red;*/
            /*width: 550px;*/
            height: 255px;
            margin-right: 40px;
            margin-bottom: 30px;
            border-radius: 5px;
            background-color: #f0f8ff;
        }

        .staff-info-card:hover{
            box-shadow: 0px 0px 7px 0px;
        }
        .staff-content-block {
            margin-left: 5%;
        }

        .profile-image {
            width: 140px;
            height: 140px;
            /*            margin-left: 20px;*/
            border: 3px solid #fff;
            box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
            border-radius: 50%;
        }
        .profile-image img {
            width: 100%;
            height: 100%;
            border-radius: 50%;
        }

        .staff-list {
            display: flex;
            flex-flow: row wrap;
        }

        .edit-profile {
            color: white !important;
        }

        .staff-main-content {
            width: 60%;
        }

        .staff-image-box {
            margin-right: 5%;
        }

        .staff-link-media a {
            margin: 10px;
        }

        .profile-header, .body {
            height: 233px;
            margin: 0;
            padding: 0;
            background: rgba(0,0,0,0);
        }

        /*------------Main------------------*/
        .main-view-content {
            background-color: white;
            margin: 0 !important;
            padding-left: 30px;
        }

        .staff-head-title {
            font-size: 2em;
        }

        #staff-head-title {
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
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
=======
                <div class="mb-5 mx-3">
                    <div class="row mb-5">
                        <div class="m-auto d-flex" id="staff-head-title">
                            <p class="staff-head-title">MANAGE</p>
                            <select class="mx-2 staff-head-title">
                                <option class="fw-bold" value="" selected="">STAFF</option>
                                <option class="fw-bold" value="">FORMER STAFF</option>
                                <option class="fw-bold" value="">ALL</option>
                            </select>
                        </div>
                    </div>
                    <div class="row align-items-center">
                        <div class="d-flex">
                            <a href="addUser?backPage=manageStaff&userRole=doctor" class="btn btn-success">ADD NEW</a>
                            <a href="takeAttendance" class="btn btn-success mx-3">TAKE ATTENDANCE</a>
                        </div>
                        <div id="search" class="d-flex">
                            <input type="text" name="search" id="search-text" placeholder="Search by name">
                            <button id="search-submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                        </div>
                    </div>
                </div>
                <div class="flex-wrap staff-list">
                    <c:forEach items="${listUser}" var="s">
                        <div class="staff-info-card col-sm-5">
                            <div class="card profile-header">
                                <div class="body">
                                    <div class="row staff-content-block">
                                        <div class="col-lg-4 col-md-4 col-12 staff-image-box">
                                            <div class="profile-image float-md-right"> <img src="https://bootdey.com/img/Content/avatar/avatar2.png" alt=""> </div>
                                        </div>
                                        <div class="staff-main-content">
                                            <h4 class="m-t-0 m-b-0"><b>${s.getFullname()}</b></h4>
                                            <div class="d-flex text-center align-items-center"><i class="fa-solid fa-desktop"></i> <div class="mx-2 text-success">Online</div></div>
                                            <div class="job_post d-flex text-center align-items-center"><i class="fa-solid fa-user-nurse"></i> <div class="mx-2">${s.getRole()}</div></div>
                                            <div class="d-flex text-center align-items-center"><i class="fa-solid fa-phone"></i> <div class="mx-2">${s.getPhonenumber()}</div></div>
                                            <div class="staff-link mt-4">
                                                <a href="adminViewUserProfile?account=${s.getAccount()}&&backPage=manageStaff" class="btn btn-primary btn-round edit-profile">View profile</a>
                                                <div class="btn btn-primary btn-round btn-simple">Message</div>
                                                <a href="takeAttendance?staffAccount=${s.getAccount()}" class="btn btn-primary btn-round edit-profile mt-2">Take attendance</a>
                                            </div>
                                            <p class="social-icon m-t-5 m-b-0 staff-link-media">
                                                <a title="Twitter" href="javascript:void(0);"><i class="fa-brands fa-twitter"></i></a>
                                                <a title="Facebook" href="javascript:void(0);"><i class="fa-brands fa-facebook"></i></a>
                                                <a title="Google-plus" href="javascript:void(0);"><i class="fa-brands fa-instagram"></i></a>
                                                <a title="Behance" href="javascript:void(0);"><i class="fa-brands fa-telegram"></i></a>
                                                <!--                                                    <a title="Instagram" href="javascript:void(0);"><i class="fa fa-instagram "></i></a>-->
                                            </p>
                                        </div>                
>>>>>>> Stashed changes
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
