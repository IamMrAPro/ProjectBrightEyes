<%-- 
    Document   : AdminViewItem
    Created on : Feb 5, 2023, 8:43:45 PM
    Author     : Ao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" href="assets/css/admin-view-item.css"/>
    </head>
    <body>
        <header class="align-items-centers d-flex justify-content-between mt-3">
            <div class="d-flex">
                <a href="AddItem.jsp" class="btn btn-success text-center">+ ADD A NEW ITEM</a>
            </div>
            <div class="input-group">
                <input type="text" class="form-control" name="itemSearch" placeholder="Search">
                <button class="input-group-text" name="searchItem"><i class="fa-solid fa-magnifying-glass"></i></button>
            </div>

        </header>

        <br>
        <div class="select-all">
            <input type="checkbox" name="selectAllCustomer" id="select-all" onclick="selectAll()"> 
            <label for="select-all" onclick="selectAll()">Select All</label>
        </div>

        <br>
        <div id="main-item" class="d-flex">
            <div id="list-glass">
                <div class="text-center fs-3">List Glasses</div>
                <table class="table table-bordered">
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Color</td>
                        <td>Gender</td>
                        <td>Material</td>
                        <td>Style</td>
                        <td>Image</td>
                        <td>Price</td>
                    </tr>
                    <c:forEach items="${listGlass}" var="g">
                        <tr>
                            <td>${g.getGlassID()}</td>
                            <td>${g.getGlassName()}</td>
                            <td>${g.getColor()}</td>
                            <td>${g.getGender()}</td>
                            <td>${g.getMaterial()}</td>
                            <td>${g.getStyle()}</td>
                            <td>${g.getImage()}</td>
                            <td>${g.getPrice()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div id="item-chart">
                <div class="fs-3 fw-bold text-center">Item Sales</div>
                <canvas id="glass-chart"></canvas>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script>
                function selectAll() {
                    var allCustomer = document.getElementsByName("getCustomer");
                    var len = allCustomer.length;
                    var select = document.getElementById('select-all');
                    if (select.checked) {
                        for (var i = 0; i < len; i++) {
                            allCustomer[i].checked = true;
                        }
                    } else {
                        for (var i = 0; i < len; i++) {
                            allCustomer[i].checked = false;
                        }
                    }
                }

                const chart = document.getElementById("glass-chart");
                new Chart(chart, {
                    type: 'doughnut',
                    data: {
                        labels: [
                            'Store',
                            'Shipping',
                            'Sales'
                        ],
                        datasets: [{
                                label: 'My First Dataset',
                                data: [300, 50, 100],
                                backgroundColor: [
                                    'rgb(255, 99, 132)',
                                    'rgb(54, 162, 235)',
                                    'rgb(255, 205, 86)'
                                ],
                                hoverOffset: 4
                            }]
                    }
                });
        </script>
    </body>
</html>
