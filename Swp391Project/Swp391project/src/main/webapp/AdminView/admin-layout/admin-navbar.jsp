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
                border: 1px solid red;
                background-color: #5a6f80;
            }

            .admin-link {
                line-height: 50px;
            }

            .admin-link a {
                color: white;
                font-size: x-large;
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
                font-size: xx-large;
            }
        </style>
        <script>
            function getPosition(x){
                
            }
        </script>
    </head>
    <body>
        <div class="admin-nav vh-100">
            <a href="" class="text-center">
                <div class="fs-2"><i class="fa-solid fa-user"></i></div>
                <div>User name</div>
            </a>

            <br>
            <div>
                <div class=" fw-bold admin-nav-title mx-1">MANAGEMENT</div>
                <div>
                    <div class="admin-link">
                        <a href="" class="d-flex px-4 align-items-center text-decoration-none">
                            <i class="fa-solid fa-layer-group"></i>
                            <div class="mx-2">Dashboard</div>
                        </a>
                    </div>
                    <div class="admin-link">
                        <a href="" class="d-flex px-4 align-items-center text-decoration-none">
                            <i class="fa-solid fa-user-nurse"></i>
                            <div class="mx-2">Staff</div>
                        </a>
                    </div>
                    <div class="admin-link">
                        <a href="" class="d-flex px-4 align-items-center text-decoration-none">
                            <i class="fa-solid fa-user-plus"></i>
                            <div class="mx-2">Customer</div>
                        </a>
                    </div>
                    <div class="admin-link">
                        <a href="" class="d-flex px-4 align-items-center text-decoration-none">
                            <i class="fa-solid fa-house-medical"></i>
                            <div class="mx-2">Room</div>
                        </a>
                    </div>
                    <div class="admin-link">
                        <a href="" class="d-flex px-4 align-items-center text-decoration-none">
                            <i class="fa-solid fa-glasses"></i>
                            <div class="mx-2">Glass</div>
                        </a>
                    </div>
                </div>

                <br>
                <div class="fw-bold admin-nav-title mx-1">CLINIC NEWS</div>
                <div class="admin-link ">
                    <a href="" class="d-flex px-4 align-items-center text-decoration-none">
                        <i class="fa-solid fa-square-plus"></i>
                        <div class="mx-2">Create new</div>
                    </a>
                </div>
                <div class="admin-link ">
                    <a href="" class="d-flex px-4 align-items-center text-decoration-none">
                        <i class="fa-solid fa-list"></i>
                        <div class="mx-2">List news</div>
                    </a>
                </div>
            </div>
        </div>

    </body>
</html>
