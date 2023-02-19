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
        
        .table-header-glass {
            background-color: #5bc1ac;
        }
    </style>
    <body onload="getPositionNavBar(4)">
        <form action="manageGlasses" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->
                <input name="setPosition" type="text" value="1" class="d-none">
<!--            --------------------------------------------------------------------->
            <%@include file="../admin-layout/admin-navbar.jsp" %>
            <div class="main-view main-view-content">
                <div class="d-flex justify-content-between mt-3">
                    <div>List Glasses</div>
                    <div class="d-flex glasses-search">
                        <input type="text" name="searchGlass" id="search-glass" class="form-control">
                        <button id="glass-search-btn"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
                
                <% int count = 0;%>
                <table class="table table-bordered mt-4">
                    <thead class="table-header-glass">
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
                                <td><% count++; out.print(count);%></td>
                                <td><img src="${g.getImage()}" width="60" height="70"alt="alt"/></td>
                                <td>${g.getGlassName()}</td>
                                <td>${g.getColor()}</td>
                                <td>${g.getGender()}</td>
                                <td>${g.getMaterial()}</td>
                                <td>100</td>
                                <td class="d-flex justify-content-around h-100">
                                    <a href=""><i class="fa-solid fa-pen"></i></a>
                                    <a href=""><i class="fa-solid fa-cart-shopping"></i></a>
                                    <a href="DeleteGlasses?idGlasses=${g.getGlassID()}"><i class="fa-solid fa-close"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>
    </body>
</html>
