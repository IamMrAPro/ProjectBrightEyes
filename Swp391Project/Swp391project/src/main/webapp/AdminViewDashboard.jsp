<%-- 
    Document   : AdminViewDashboard
    Created on : Feb 6, 2023, 7:37:01 AM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="layout/head.jsp" %>
    <link rel="stylesheet" href="assets/css/admin-view-dashboard.css"/>
    <body>
        <div id="main-view-dashboard">
            <div id="rate-of-custumor">
                <canvas id="rate-customer-chart"></canvas>
            </div>
            <div>
                <canvas id="revenue-chart"></canvas>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script>
            const rateCustomer = document.getElementById('rate-customer-chart');
            new Chart(rateCustomer, {
            type: 'line',
                    data: {
                    labels: ["8h", "9h", "10h", "11h", "12h", "13h", "14h", "15h"],
                            datasets: [{
                            label: 'Rate of customer on today',
                                    data: [2, 5, 10, 8, 3, 7, 15, 8],
                                    fill: false,
                                    borderColor: 'rgb(75, 192, 192)',
                                    tension: 0.1
                            }]
                    }
            });
            const revenue = document.getElementById('revenue-char');
//            new Chart(revenue, {
//                    type: 'bar',
//                    data: {
//                    labels: ["8h", "9h", "10h", "11h", "12h", "13h", "14h", "15h"],
//                    datasets: [{
//                    label: 'Revenue at today',
//                            data: [65, 59, 80, 81, 56, 55, 40],
//                            backgroundColor: [
//                                    'rgba(255, 99, 132, 0.2)',
//                                    'rgba(255, 159, 64, 0.2)',
//                                    'rgba(255, 205, 86, 0.2)',
//                                    'rgba(75, 192, 192, 0.2)',
//                                    'rgba(54, 162, 235, 0.2)',
//                                    'rgba(153, 102, 255, 0.2)',
//                                    'rgba(201, 203, 207, 0.2)'
//                            ],
//                            borderColor: [
//                                    'rgb(255, 99, 132)',
//                                    'rgb(255, 159, 64)',
//                                    'rgb(255, 205, 86)',
//                                    'rgb(75, 192, 192)',
//                                    'rgb(54, 162, 235)',
//                                    'rgb(153, 102, 255)',
//                                    'rgb(201, 203, 207)'
//                            ],
//                            borderWidth: 1
//                    }]},
//                    options: {
//                    scales: {
//                    y: {
//                    beginAtZero: true
//                    }
//                    }
//                    },
//            };
//            });
        </script>
    </body>
</html>
