<%-- 
    Document   : ManageGlass
    Created on : Feb 12, 2023, 7:45:09 PM
    Author     : Ao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <style>
        .glasses-search {
            width: 300px;
            height: 40px;
        }

        #glass-search-btn {
            width: 50px;
            border: 0.5px solid black;
            outline: none;
        }
<<<<<<< Updated upstream
=======

        .table-header-glass {
            background-color: #5bc1ac;
        }

        .hidden {
            display: none;
        }

        .display {
            display: block !important;
        }
>>>>>>> Stashed changes
    </style>
    <body onload="getPositionNavBar(4)">
        <form action="manageGlasses" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->
            <input name="setPosition" type="text" value="5" class="d-none">
            <!--            --------------------------------------------------------------------->
            <%@include file="../admin-layout/admin-navbar.jsp" %>
            <div class="main-view main-view-content">
                <div class="alert alert-success alert-dismissible hidden ${display}">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    ${message}
                </div>
                <div class="d-flex justify-content-between mt-3">
                    <div style="font-size: 2em;"><b>List Glasses</b></div>
                    <div class="d-flex glasses-search">
                        <input type="text" name="searchGlass" id="search-glass" class="form-control">
                        <button id="glass-search-btn"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
                <div class="row justify-content-start">
                    <a href="addGlass" class="btn btn-success col-sm-1">Create</a>
                </div>
                <% int count = 0;%>
                <table class="table table-bordered mt-4">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Color</th>
                            <th>Gender</th>
                            <th>Material</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listGlasses}" var="g">
                            <tr>
<<<<<<< Updated upstream
                                <td><% count++; out.print(count);%></td>
                                <td>${g.getImage()}</td>
=======
                                <td><% count++;
                                    out.print(count);%></td>
                                <td><img src="${g.getImage()}" width="60" height="70"alt="alt"/></td>
>>>>>>> Stashed changes
                                <td>${g.getGlassName()}</td>
                                <td>${g.getColor()}</td>
                                <td>${g.getGender()}</td>
                                <td>${g.getMaterial()}</td>
                                <td>100</td>
<<<<<<< Updated upstream
                                <td class="d-flex justify-content-around h-100">
                                    <a href=""><i class="fa-solid fa-pen"></i></a>
                                    <a href=""><i class="fa-solid fa-cart-shopping"></i></a>
                                    <a href=""><i class="fa-solid fa-arrow-right"></i></a>
=======
                                <td>
                                    <div class="d-flex justify-content-around h-100">
                                        <a href="addGlass?updateGlassID=${g.getGlassID()}"><i class="fa-solid fa-pen"></i></a>
                                        <a href=""><i class="fa-solid fa-cart-shopping"></i></a>
                                        <a href="DeleteGlasses?idGlasses=${g.getGlassID()}"><i class="fa-solid fa-close"></i></a>
                                    </div>
>>>>>>> Stashed changes
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>
    </body>
</html>
