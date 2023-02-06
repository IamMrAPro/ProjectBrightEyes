<%-- 
    Document   : AdminViewRoom
    Created on : Feb 5, 2023, 10:31:20 AM
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
                <a href="AddRoom.jsp" class="btn btn-success text-center">+ ADD A NEW ROOM</a>
            </div>
            <div class="input-group">
                <input type="text" class="form-control" name="roomSearch" placeholder="Search">
                <button class="input-group-text" name="searchStaff"><i class="fa-solid fa-magnifying-glass"></i></button>
            </div>
        </header>
        <br>
        <div id="room-view">
            <c:forEach items="${listRoom}" var="room">
                <a href="" class="card card-room">
                    <div class="card-header fs-4 fw-bold text-center">
                        ${room.getRoomName()}
                    </div>
                    <div class="card-body">
                        <div>Room ID: ${room.getRoomID()}</div>
                        <div>Room Function: ${room.getRoomFunction()}</div>
                    </div>
                </a>
            </c:forEach>
        </div>

    </body>
</html>
