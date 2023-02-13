<%-- 
    Document   : AdminDashboard
    Created on : Feb 10, 2023, 7:50:47 PM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <body onload="getPositionNavBar(0)">
        <form action="adminDashboard" class="vw-100 vh-100 d-flex" method="post">
<!--            set position for not select case-->
                <input name="setPosition" type="text" value="1" class="d-none">
<!--            --------------------------------------------------------------------->
             <%@include file="../admin-layout/admin-navbar.jsp" %>
            <div class="main-view main-view-content">
                
            </div>
        </form>
           
        </div>
    </body>
</html>
