<%-- 
    Document   : TakeStaffAttendance
    Created on : Feb 26, 2023, 6:42:28 PM
    Author     : Ao
--%>

<%@page import="com.groud2.web.model.user"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <body>
        <form action="takeAttendance" method="post">
            <div>
                <%
                    LocalDate today = LocalDate.now();
                    String todayStr = today.toString();
                %>
                <select name="date">
                    <option value="<% out.print(todayStr);%>" selected=""><% out.print(todayStr);%></option>
                    <c:forEach items="${listAttendance}" var="a">
                        <option value="${a.getAttendanceDate()}" selected="">${a.getAttendanceDate()}</option>
                    </c:forEach>
                </select>

            </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Full name</th>
                        <th>Check in</th>
                        <th>Check out</th>
                        <th>Check in</th>
                        <th>Check out</th>
                        <th>Check in</th>
                        <th>Check out</th>
                        <th>Check in</th>
                        <th>Check out</th>
                    </tr>
                </thead>

                <% ArrayList<user> list = (ArrayList) session.getAttribute("listStaff"); %>
                <tbody>
                    <% for (user u : list) {
                    %>
                    <tr>
                <input type="text" class="d-none" value="<%out.print(u.getUserId()); %>" name="recordID">
                <input type="text" class="d-none" value="<% out.print(u.getFullname()); %>" name="recordUser">
                <td><%out.print(u.getUserId()); %></td>
                <td><%out.print(u.getFullname()); %></td>
                <td>
                    <input type="time" name="checkin1">
                </td>
                <td>
                    <input type="time" name="checkout1">
                </td>
                <td>
                    <input type="time" name="checkin1">
                </td>
                <td>
                    <input type="time" name="checkout1">
                </td>
                <td>
                    <input type="time" name="checkin1">
                </td>
                <td>
                    <input type="time" name="checkout1">
                </td>
                <td>
                    <input type="time" name="checkin1">
                </td>
                <td>
                    <input type="time" name="checkout1">
                </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>

            <div>
                <button>SAVE</button>
            </div>
        </form>
    </body>
</html>
