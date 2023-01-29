<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="layout/head.jsp"/>
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
                                <form action="#" method="POST">
                                    <div class="row">
                                        <div class="p-6">
                                            <h6 class="mb-0">Patient information</h6>
                                        </div>
                                        <br><br>
                                        <div class="col-lg-6">
                                            <div class="mb-3">
                                                <label class="form-label">Name</label>
                                                <input class="form-control" >
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="mb-3">
                                                <label class="form-label">Phone</label>
                                                <input type="text" class="form-control" ">
                                            </div>
                                        </div>
                                        <div class="col-lg-12">
                                            <div class="mb-3">
                                                <label class="form-label">Email</label>
                                                <input type="text" class="form-control">
                                            </div>
                                        </div>
                                        <br>
                                        <div class="p-6">
                                            <h6 class="mb-0">Appointment information</h6>
                                        </div>
                                        <br><br>
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label class="form-label"> Day : </label>
                                                <input required="" name="date" type="text" class="flatpickr flatpickr-input form-control" id="checkin-date">
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
                                                <button type="submit" style="display: none" id="booking" class="default btn btn-primary">Đặt lịch</button>
                                                <button type="submit"  style="display: none" id="booking" class="vnpay btn btn-primary">Thanh toán</button>
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
       
            
        

        
        <script>
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
            
           
        </script>

    </body>

</html>