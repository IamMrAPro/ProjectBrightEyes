<%-- 
    Document   : AddStaff
    Created on : Feb 2, 2023, 8:55:19 AM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="layout/head.jsp" %>
    <body class="align-items-centers">
        <br>
        <br>
        <form class="card m-auto" id="add-staff-form" action="addStaff" method="post">
            <div class="card-header text-center">
                ADD NEW USER
            </div>
            <div class="card-body">
                <div>
                    <label for="staff-name" class="form-label">Full name:</label>
                    <input name="staffName" id="staff-name" type="text" class="form-control">
                </div>
                <div class="staff-form-group d-flex align-items-centers">
                    <div class="staff-mid-frame">
                        <label for="staff-id" class="form-label">ID:</label>
                        <input name="staffID" id="staff-id" type="text" class="form-control">
                    </div>
                    <div class="staff-mid-frame">
                        <select class="form-select" name="staffGender" id="staff-gender">
                            <option value="-1" selected="">Gender:</option>
                            <option value="1">Male</option>
                            <option value="0">Female</option>
                        </select>
                    </div>
                </div>

                <div class="staff-form-group d-flex align-items-centers">
                    <div class="staff-mid-frame">
                        <label for="staff-email" class="form-label">Email:</label>
                        <input name="staffEmail" id="staff-email" type="email" class="form-control">
                    </div>
                    <div class="staff-mid-frame">
                        <select class="form-select" name="staffFunction" id="staff-function">
                            <option value="-1" selected="">Select function:</option>
                            <option value="admin">Admin</option>
                            <option value="doctor">Doctor</option>
                            <option value="casher">Casher</option>
                            <option value="staff">Staff</option>
                            <option value="customer">Customer</option>
                        </select>
                    </div>
                </div>

                <div class="staff-form-group d-flex align-items-centers">
                    <div class="staff-mid-frame">
                        <label for="staff-account" class="form-label">Account:</label>
                        <input name="staffAccount" id="staff-account" type="text" class="form-control">
                    </div>
                    <div class="staff-mid-frame">
                        <div class="staff-mid-frame" id="staff-mid-phone">
                        <label for="staff-phone" class="form-label">Phone:</label>
                        <input name="staffPhone" id="staff-phone" type="text" class="form-control">
                    </div>
                    </div>
                </div>
                
                <div>
                    <label for="staff-address" class="form-label">Address:</label>
                    <input name="staffAddress" id="staff-address" type="int" class="form-control">
                </div>
                <button id="add-staff-btn" class="btn mt-5">SAVE</button>
            </div>
        </form>
    </body>
</html>
