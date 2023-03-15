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
    <body class="vw-100">
        <form action="takeAttendance" method="post" class="row justify-content-center mt-5">
            <div class="card card-body col-sm-4">
                <h2 class="text-center">TAKE ATTENDANCE</h2>
                <small class="w-100 text-center">FOR</small>
                <h4 class="text-center">${staffName}</h4>
                <div class="text-center" style="color: red;">${message}</div>
                <div class="mb-3">
                    <label class="">Date:</label>
                    <input type="date" name="date" value="${today}" class="form-control" required="">
                </div>
                <div class="mb-5">
                    <label class="">Time:</label>
                    <input type="time" name="time" id="time" class="form-control" value="${nowTime}" required="">
                </div>

                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    SUBMIT
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                Modal body text goes here.
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="d-flex">
                    <input type="date" name="searchDateValue" value="${today}" class="form-control">
                    <input type="submit" name="searchDate" value="Search" class="btn btn-success">
                </div>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Time</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <% int count = 0; %>
                    <c:forEach items="${listAtt}" var="at">
                        <tbody>
                            <tr>
                                <td><% count++;
                                    out.print(count);%></td>
                                <td>${at.getTime()}</td>
                                <td>
                                    <input type="text" name="update" value="${at.getId()}" id="${at.getId()}" class="d-none">
                                    <label for="${at.getId()}" class="btn btn-success">
                                        Edit
                                    </label>
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
        </form>
    </body>
</html>
