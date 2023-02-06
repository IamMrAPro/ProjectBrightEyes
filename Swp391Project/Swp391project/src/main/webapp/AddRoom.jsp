<%-- 
    Document   : AddRoom
    Created on : Feb 5, 2023, 10:33:20 AM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="layout/head.jsp" %>
    <body class="align-items-centers">
        <br>
        <br>
        <form action="addRoom" class="m-auto card" id="add-room-form" method="post">
            <div class="card-header text-center fw-bold fs-3">
                ADD A NEW STAFF
            </div>
            <div class="card-body">
                <div>
                    <label for="room-id" class="form-label">Room ID:</label>
                    <input name="roomID" id="room-id" type="text" class="form-control">
                </div>
                <br>
                <div>
                    <label for="room-name" class="form-label">Room name:</label>
                    <input name="roomName" id="room-name" type="text" class="form-control">
                </div>
                <br>
                <div>
                    <label for="room-function" class="form-label">Room function:</label>
                    <input name="roomFunction" id="room-function" type="text" class="form-control">
                </div>
                
                <button class="btn btn-success fs-4 fw-bold" id="add-room-btn">SUBMIT</button>
            </div>
            
        </form>
    </body>
</html>
