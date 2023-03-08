<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <jsp:include page="layout/head.jsp"/>
    <head>
<<<<<<< Updated upstream
         <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
=======
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
>>>>>>> Stashed changes
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="assets/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="assets/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/css/util.css">
        <link rel="stylesheet" type="text/css" href="assets/css/main.css">
    </head>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
        <section class="bg-half-170 d-table w-100 bg-light">
            <div class="container">
                <div class="row mt-5 justify-content-center">
                    <div class="col-12">
                        <div class="section-title text-center">
                            <h3 class="sub-title mb-4">Book Consulting</h3>
                            <p class="para-desc mx-auto text-muted">Great doctor if you need your family member to get effective immediate assistance, emergency treatment or a simple consultation.</p>


                        </div>
                    </div>
                </div>
            </div>
        </section>
        <div class="position-relative">
            <div class="shape overflow-hidden text-white">
                <svg viewBox="0 0 2880 48" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M0 48H1437.5H2880V0H2160C1442.5 52 720 0 720 0H0V48Z" fill="currentColor"></path>
                </svg>
            </div>
        </div>

        <section class="section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <div class="card border-0 shadow rounded overflow-hidden">
                            <div class="tab-content p-4" id="pills-tabContent">
                                <form action="booking" method="get" onsubmit="setSubmitTime()">
                                    <div class="row">
                                        <div class="p-6">
                                            <h6 class="mb-0">Patient information</h6>
                                        </div>
                                        <br><br>
                                        <div class="col-lg-6">
                                            <div class="mb-3">
                                                <label class="form-label" name="">Name</label>
                                                <input name="name" class="form-control" >
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="mb-3">
                                                <label class="form-label" >Phone</label>
<<<<<<< Updated upstream
                                                <input type="text"name="phone" validate-input class="form-control" ">
=======
                                                <input type="text"name="phone" minlength="10" maxlength="10" validate-input class="form-control" ">
>>>>>>> Stashed changes
                                            </div>
                                        </div>
                                        <div class="col-lg-12">
                                            <div class="mb-3">
                                                <label class="form-label" >Email</label>
<<<<<<< Updated upstream
                                                <input type="text" name="email" data-validate="Email is required" validate-input class="form-control">
=======
                                                <input type="text" name="email" data-validate="Email is required" required class="form-control">
>>>>>>> Stashed changes
                                            </div>
                                        </div>
                                        <br>
                                        <div class="p-6">
                                            <h6 class="mb-0">Appointment information</h6>
                                        </div>
                                        <br><br>
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label class="form-label" for="dateInput">Select a date:</label>
                                                <input type="date" id="dateInput" class="flatpickr flatpickr-input form-control" name="dateInput" onchange="checkDateInput()">

                                            </div>


                                        </div>

                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label class="form-label">Time</label>
                                                <select required="" name="time" class="form-control department-name select2input">
                                                    <option value="7:00">7:00 am</option>
                                                    <option value="8:00">8:00 am</option>
                                                    <option value="9:00">9:00 am</option>
                                                    <option value="10:00">10:00 am</option>
                                                    <option value="11:00">11:00 am</option>
                                                    <option value="14:00">14:00 pm</option>
                                                    <option value="15:00">15:00 pm</option>
                                                    <option value="16:00">16:00 pm</option>
                                                    <option value="17:00">17:00 pm</option>
                                                </select>
                                            </div>
                                        </div><!--end col-->

                                        <div class="col-lg-12">
                                            <div class="mb-3">
                                                <label class="form-label">Medical information<span class="text-danger">*</span></label>
                                                <textarea required="" name="description" id="comments2" rows="4" class="form-control"></textarea>
                                            </div>
                                        </div><!--end col-->

                                        <div class="col-md-12">
                                            <div class="mb-3">
                                                <label class="form-label">Payment methods</label>
                                                <select name="payment" oninvalid="Select(this);" oninput="Select(this);" id="mySelect" class="form-control department-name select2input">
                                                    <option selected="">Chọn phương thức thanh toán</option>
                                                    <option value="default">Select a payment method</option>
                                                    <option value="vnpay">Payment through VNPay</option>
                                                </select>
                                            </div>
                                        </div><!--end col-->

                                        <div class="col-lg-12">
                                            <div class="d-grid">
                                                <button type="submit" style="display: none" name="submit_time" id="booking" class="default btn btn-primary">Đặt lịch</button>
<<<<<<< Updated upstream
                                                <button type="submit"  style="display: none" name="submit_time"  id="booking" class="vnpay btn btn-primary">Thanh toán</button>
=======
                                                <button type="submit"  style="display: none" name="submit_time"  id="booking" class="vnpay btn btn-primary"><a href="url">Thanh toán</a>   </button>
>>>>>>> Stashed changes
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </section>
        <br><!-- comment -->
        <br><!-- comment -->
        <br><!-- comment -->
        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>




<<<<<<< Updated upstream
    <script src="assets/vendor/jquery/jquery-3.2.1.min.js"></script>
=======
        <script src="assets/vendor/jquery/jquery-3.2.1.min.js"></script>
>>>>>>> Stashed changes
        <!--===============================================================================================-->
        <script src="assets/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/bootstrap/js/popper.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/daterangepicker/moment.min.js"></script>
        <script src="assets/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="assets/js/main.js"></script>
        <script>
<<<<<<< Updated upstream
            $("#checkin-date").flatpickr({
                defaultDate: "today",
                minDate: "today",
                maxDate: new Date().fp_incr(14),
                dateFormat: "d/m/Y",
                locale: "vn"
            });
            function Select(text) {
                if (text.value == "") {
                    $(".default").hide();
                    $(".vnpay").hide();
                } else if (text.value == "default") {
                    $(".default").show();
                    $(".vnpay").hide();
                } else if (text.value == "vnpay") {
                    $(".vnpay").show();
                    $(".default").hide();
                } else {
                    $(".default").hide();
                    $(".vnpay").hide();
                }
            }
            function setSubmitTime() {
                var now = new Date();
                document.getElementById("booking").value = now.toISOString();
            }
=======
                                                    $("#checkin-date").flatpickr({
                                                        defaultDate: "today",
                                                        minDate: "today",
                                                        maxDate: new Date().fp_incr(14),
                                                        dateFormat: "d/m/Y",
                                                        locale: "vn"
                                                    });
                                                    function Select(text) {
                                                        if (text.value == "") {
                                                            $(".default").hide();
                                                            $(".vnpay").hide();
                                                        } else if (text.value == "default") {
                                                            $(".default").show();
                                                            $(".vnpay").hide();
                                                        } else if (text.value == "vnpay") {
                                                            $(".vnpay").show();
                                                            $(".default").hide();
                                                        } else {
                                                            $(".default").hide();
                                                            $(".vnpay").hide();
                                                        }
                                                    }
                                                    function checkDateInput() {
                                                        var dateInput = document.getElementById("dateInput").value;
                                                        var currentDate = new Date();
                                                        var inputDate = new Date(dateInput);
                                                        if (inputDate < currentDate) {
                                                            alert("Please select a future date!");
                                                            document.getElementById("dateInput").value = "";
                                                        }
                                                    }
>>>>>>> Stashed changes

        </script>

    </body>

</html>