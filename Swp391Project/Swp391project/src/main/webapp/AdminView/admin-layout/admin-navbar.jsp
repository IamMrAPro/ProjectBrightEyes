<%-- 
    Document   : admin-navbar
    Created on : Feb 10, 2023, 8:12:56 AM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" href="../admin-assets/css/bootstrap.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">

        <style>
            .admin-nav {
                width: 260px;
                /*border: 1px solid red;*/
                background-color: #5a6f80;
            }

            .admin-link {
                line-height: 50px;
            }

            .admin-link label {
                color: white;
                font-size: large;
            }
            .admin-link i {
                width: 40px;
                text-align: center;
            }

            .admin-link:hover {
                background-color: #5bc1ac;
                color: #5a6f80;
            }

            .admin-nav-title {
                color: white;
                font-size: x-large;
            }
            
            .admin-info {
                color: white;
            }
            
            .admin-info:hover {
                color: #5bc1ac;
            }
            
            .btn-logout {
                width: 70%;
                margin-left: 15%;
                height: 40px;
                background-color: white;
                color: #5a6f80;
            }
        </style>
        <script>
            function getPositionNavBar(x) {
                const labels = document.getElementsByClassName('admin-nav-label');
                console.log('Total labels: ' + labels.length);
                labels[x].style.backgroundColor = "white";
                labels[x].style.color = "#5a6f80";
            }
        </script>
    </head>
    <body>
        <div class="admin-nav vh-100">
            <a href="profile" class="text-center text-decoration-none admin-info">
                <div class="fs-2"><i class="fa-solid fa-user"></i></div>
                <div>${username}</div>
            </a>

            <br>
            <div>
                <div class=" fw-bold admin-nav-title mx-1">MANAGEMENT</div>
                <div>
                    <div class="admin-link">
                        <input type="submit" name="position" value="1" id="dashboard" class="d-none">
                        <label for="dashboard" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-layer-group"></i>
                            <div class="mx-2">Dashboard</div>
                        </label>
                    </div>
                    <div class="admin-link">
                        <input type="submit" name="position" value="2" id="staff" class="d-none">
                        <label for="staff" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-user-nurse"></i>
                            <div class="mx-2">Staff</div>
                        </label>
                    </div>
                    <div class="admin-link">
                        <input type="submit" name="position" value="3" id="customer" class="d-none">
                        <label for="customer" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-user-plus"></i>
                            <div class="mx-2">Customer</div>
                        </label>
                    </div>
                    <div class="admin-link">
                        <input type="submit" name="position" value="4" id="room" class="d-none">
                        <label for="room" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-house-medical"></i>
                            <div class="mx-2">Room</div>
                        </label>
                    </div>
                    <div class="admin-link">
                        <input type="submit" name="position" value="5" id="glass" class="d-none">
                        <label for="glass" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-glasses"></i>
                            <div class="mx-2">Glass</div>
                        </label>
                    </div>
                    <div class="admin-link">
                        <input type="submit" name="position" value="6" id="feedback" class="d-none">
                        <label for="feedback" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-face-smile"></i>
                            <div class="mx-2">Feedback</div>
                        </label>
                    </div>
                     <div class="admin-link">
                        <input type="submit" name="position" value="6" id="feedback" class="d-none">
                        <label for="feedback" class="d-flex px-4 align-items-center admin-nav-label">
                            <ion-icon name="bookmarks-outline"></ion-icon>
                            <div class="mx-2"><a href="">Booking</a></div>
                        </label>
                    </div>
                </div>

                <br>
                <div class="fw-bold admin-nav-title mx-1">CLINIC NEWS</div>
                <div class="admin-link ">
                    <input type="submit" name="position" value="7" id="news-new" class="d-none">
                    <label for="news-new" class="d-flex px-4 align-items-center admin-nav-label">
                        <i class="fa-solid fa-square-plus"></i>
                        <div class="mx-2">Create new</div>
                    </label>
                </div>
                <div class="admin-link ">
                    <input type="submit" name="position" value="8" id="news-list" class="d-none">
                    <label for="news-list" class="d-flex px-4 align-items-center admin-nav-label">
                        <i class="fa-solid fa-list"></i>
                        <div class="mx-2">List news</div>
                    </label>
                </div>
            </div>
            
            <input type="submit" name="home" value="Logout" class="btn btn-logout">
        </div>

    </body>
</html>
