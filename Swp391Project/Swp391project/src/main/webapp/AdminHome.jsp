

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="layout/head.jsp" %>
    <body onload="getChoose()">

        <%
            String userChoose = "";
        %>
        
        <div class="container-fluid d-flex">
            <!-- Set selected nav bar button -->
            <div class="d-none">
                <input type="text" name="sendChoose" id="send-choose">
                <input type="text" name="getChoose" value="${getChoose}" id="get-choose">
            </div>

            <!-- -------------------------------------------------- -->
            <nav class="admin-nav">
                <div id="admin-info" class="align-items-centers">
                    <div class="fs-3 text-center mt-2">
                        <i class="fa-solid fa-user"></i>
                    </div>
                    <div class="text-center">
                        ${username}
                    </div>
                </div>

                <div id="admin-control">

                    <div class="fs-3 fw-bold admin-nav-title">MANAGEMENT</div>
                    <ul class="admin-choose">
                        <li class="nav-link">
                            <input name="adminChoose" type="radio" class="d-none" id="dashboard" checked="" value="0" onclick="<%userChoose = "0";%>">
                            <label for="dashboard" class="d-flex text-center" onclick="setView(0)"><i class="fa-sharp fa-solid fa-chart-simple"></i> <div class="nav-title">Dashboard</div></label>
                        </li>
                        <li class="nav-link align-items-centers">
                            <input name="adminChoose" type="radio" class="d-none" id="staff" value="1" onclick="<%userChoose = "1";%>">
                            <label for="staff" class="d-flex text-center" onclick="setView(1)"><i class="fa-solid fa-user-nurse"></i> <div class="nav-title">Staff</div></label>
                        </li>
                        <li class="nav-link">
                            <input name="adminChoose" type="radio" class="d-none" id="customer" value="2" onclick="<%userChoose = "2";%>">
                            <label for="customer" class="d-flex text-center" onclick="setView(2)"><i class="fa-solid fa-user-plus"></i> <div class="nav-title">Customer</div></label>
                        </li>
                        <li class="nav-link">
                            <input name="adminChoose" type="radio" class="d-none" id="room" value="3" onclick="<%userChoose = "3";%>">
                            <label for="room" class="d-flex text-center" onclick="setView(3)"><i class="fa-solid fa-hospital"></i> <div class="nav-title">Room</div></label>
                        </li>
                        <li class="nav-link">
                            <input name="adminChoose" type="radio" class="d-none" id="item" value="4" onclick="<%userChoose = "4";%>">
                            <label for="item" class="d-flex text-center" onclick="setView(4)"><i class="fa-solid fa-glasses"></i> <div class="nav-title">Item</div></label>
                        </li>
                        <li class="nav-link">
                            <input name="adminChoose" type="radio" class="d-none" id="feedback" value="5" onclick="<%userChoose = "5";%>">
                            <label for="feedback" class="d-flex text-center" onclick="setView(5)"><i class="fa-solid fa-face-smile"></i> <div class="nav-title">Feedback</div></label>
                        </li>
                        <li class="nav-link">
                            <input name="adminChoose" type="radio" class="d-none" id="setting" value="6" onclick="<%userChoose = "6";%>">
                            <label for="setting" class="d-flex text-center" onclick="setView(6)"><i class="fa-solid fa-gear"></i> <div class="nav-title">Setting</div></label>
                        </li>
                    </ul>

                    <div class="fs-3 fw-bold admin-nav-title">ADMIN POST</div>
                    <ul class="admin-choose">
                        <li class="nav-link">
                            <input name="adminChoose" type="radio" class="d-none text-center" id="new-post" value="7" onclick="<%userChoose = "7";%>">
                            <label for="new-post" class="d-flex text-center" onclick="setView(7)"><i class="fa-solid fa-circle-plus"></i> <div class="nav-title">New Post</div></label>
                        </li>
                        <li class="nav-link">
                            <input name="adminChoose" type="radio" class="d-none" id="list-post" value="8" onclick="<%userChoose = "8";%>">
                            <label for="list-post" class="d-flex text-center" onclick="setView(8)"><i class="fa-solid fa-list"></i> <div class="nav-title">List Posts</div></label>
                        </li>
                    </ul>

                    <div id="logout" class="fs-5 btn btn-warning mt-lg-5 d-flex text-center">
                        <i class="fa-solid fa-right-from-bracket"></i> <div class="mr-3">Logout</div>
                    </div>
                </div>
            </nav>
            <div class="col-md-10 main-view">
                <form action="adminHome" method="post">
                    <div id="admin-view-dashboard" class="admin-view-display display">
                        <%@include file="AdminViewDashboard.jsp" %>
                    </div>
                    <div id="admin-view-staff" class="admin-view-display">
                        <%@include file="AdminViewStaff.jsp" %>
                    </div>
                    <div id="admin-view-customer" class="admin-view-display">
                        <%@include file="AdminViewCustomer.jsp" %>
                    </div>
                    <div id="admin-view-room" class="admin-view-display">
                        <%@include file="AdminViewRoom.jsp" %>
                    </div>
                    <div id="admin-view-item" class="admin-view-display">
                        <%@include file="AdminViewItem.jsp" %>
                    </div>
                    <div id="admin-view-staff" class="admin-view-display">

                    </div>
                    <div id="admin-view-staff" class="admin-view-display">

                    </div>
                    <div id="admin-view-staff" class="admin-view-display">

                    </div>
                    <div id="admin-view-staff" class="admin-view-display">

                    </div>

                </form>
                <%
                    pageContext.setAttribute("userChoose", userChoose, PageContext.APPLICATION_SCOPE);
                %>
            </div>
        </div>
        <script>

            function getChoose() {
                var getChoose = document.getElementById('get-choose').value;
                var choose = document.getElementsByName('adminChoose');
                for (var i = 0; i < choose.length; i++) {
                    if (i === getChoose) {
                        choose[i].checked = true;
                    } else
                        choose[i].checked = false;
                }
            }
            function  setView(x) {
                var view = document.getElementsByClassName('admin-view-display');
                var sendChoose = document.getElementById('send-choose');
                var len = view.length;
                for (var i = 0; i < len; i++) {
                    if (i === x) {
                        view[i].classList.add("display");
                        sendChoose.value = i + "";
                    } else {
                        view[i].classList.remove("display");
                    }
                }
                console.log('You are clicked in element ' + x);
                console.log('Send choose value = ' + sendChoose.value);
            }

        </script>
    </body>
</html>
