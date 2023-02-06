<%-- 
    Document   : AddItem
    Created on : Feb 5, 2023, 8:53:27 PM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="layout/head.jsp" %>
    <link rel="stylesheet" href="assets/css/add-item-form.css"/>
    <body class="align-items-centers">
        <form class="card" id="add-item-form" action="addGlass" method="post">
            <div class="card-header text-center fs-3 fw-bold">
                ADD A NEW GLASS
            </div>
            <div class="card-body">
                <div class="group-form d-flex">
                    <div class="group-form-id">
                        <label for="glass-id" class="form-label">Glass ID:</label>
                        <input name="glassID" id="glass-id" type="text" class="form-control">
                    </div>
                    <div class="group-form-name">
                        <label for="glass-name" class="form-label">Glass Name:</label>
                        <input name="glassName" id="glass-name" type="text" class="form-control">
                    </div>
                </div>
                <br>
                <div class="group-form d-flex">
                    <div class="group-form-mid">
                        <label for="glass-material" class="form-label">Glass material:</label>
                        <input name="glassMaterial" id="glass-material" type="text" class="form-control">
                    </div>
                    <div class="group-form-mid glass-color">
                        <select class="form-select" name="glassColor" id="glass-color">
                            <option value="0" selected="">Color:</option>
                            <option value="white">White</option>
                            <option value="yellow">Yellow</option>
                            <option value="black">Black</option>
                        </select>
                    </div>
                </div>
                <br>
                <div class="group-form d-flex">
                    <div class="group-form-mid">
                        <select class="form-select" name="glassStyle" id="glass-style">
                            <option value="0" selected="">Style:</option>
                            <option value="rectangule eye">Rectangule eyes</option>
                            <option value="cirle">Circle</option>
                        </select>
                    </div>
                    <div class="group-form-mid glass-gender">
                        <select class="form-select" name="glassGender" id="glass-gender">
                            <option value="-1" selected="">Gender:</option>
                            <option value="1">Male</option>
                            <option value="0">Female</option>
                        </select>
                    </div>
                </div>
                <br>
                <div>
                    <label for="glass-price" class="form-label">Enter price:</label>
                    <input name="glassPrice" id="glass-price" type="text" class="form-control">
                </div>
                <br>
                <div class="group-form d-flex">
                    <div class="glass-image">
                        <label for="glass-material" class="form-label">Enter link:</label>
                        <input name="glassMaterial" id="glass-material" type="text" class="form-control">
                    </div>
                    <div>
                        <label for="glass-upload-image" class="form-label btn btn-success glass-upload">Upload image</label>
                        <input name="glassUpload" id="glass-upload-image" type="file" class="form-control d-none">
                    </div>
                </div>
                <br>
                <button class="btn btn-success fs-4 fw-bold">SAVE</button>
            </div>
            
        </form>
    </body>
</html>
