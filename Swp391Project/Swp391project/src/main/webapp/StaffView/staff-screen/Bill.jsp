<%-- 
    Document   : ListWattingPatient
    Created on : Mar 6, 2023, 10:47:17 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../Staff-layout/staff-head.jsp" %>
    <header> <script>
        function redirectToServlet() {
            const selectedOption = document.getElementById("selectOption").value;
            if (selectedOption !== "") {
                window.location.href = "ChooseOn_Of?option=" + selectedOption;
            }
        }
        </script>
        <style>
            .sort-icon {
                width: 25px;
                height: 25px;
                border-radius: 50%;
                background-color: #5a6f80;
                color: white;
                text-align: center;
                line-height: 25px;
                cursor: pointer;
            }

            #table-head {
                background-color: #5bc1ac;
            }

            #search-staff-content {
                height: 40px;
            }

            #staff-search-btn {
                width: 70px;
                height: 40px;
                outline: none;
                border: 1px solid black;
            }

            /*------------------*/
            .cssbuttons-io-button {
                display: flex;
                align-items: center;
                font-family: inherit;
                font-weight: 500;
                font-size: 16px;
                padding: 0.7em 1.4em 0.7em 1.1em;
                color: white;
                background: #ad5389;
                background: linear-gradient(0deg, rgba(20,167,62,1) 0%, rgba(102,247,113,1) 100%);
                border: none;
                box-shadow: 0 0.7em 1.5em -0.5em #14a73e98;
                letter-spacing: 0.05em;
                border-radius: 20em;
            }

            .cssbuttons-io-button svg {
                margin-right: 6px;
            }

            .cssbuttons-io-button:hover {
                box-shadow: 0 0.5em 1.5em -0.5em #14a73e98;
            }

            .cssbuttons-io-button:active {
                box-shadow: 0 0.3em 1em -0.5em #14a73e98;
            }

            /*--------------------------------------------*/
            select {
                /* Reset Select */
                appearance: none;
                outline: 0;
                border: 0;
                box-shadow: none;
                /* Personalize */
                flex: 1;
                padding: 0 1em;
                color: white;
                background-color: #5a6f80;
                background-image: none;
                cursor: pointer;
            }
            /* Remove IE arrow */
            select::-ms-expand {
                display: none;
            }
            /* Custom Select wrapper */
            .select {
                position: relative;
                display: flex;
                width: 10em;
                height: 3em;
                border-radius: .25em;
                overflow: hidden;
            }
            /* Arrow */
            .select::after {
                content: '\25BC';
                position: absolute;
                top: 0;
                right: 0;
                padding: 1em;
                background-color: #5a6f80;
                transition: .25s all ease;
                pointer-events: none;
            }
            /* Transition */
            .select:hover::after {
                color: #f39c12;
            }
        </style>
    </header>
    <body>

        <div class="vw-100 vh-100 d-flex">

            <!--            set position for not select case-->           
            <!--            --------------------------------------------------------------------->
            <%@include file="../Staff-layout/staff-navbar.jsp" %>
            <div class="card">
                <div class="card-body">
                    <div class="container mb-5 mt-3">
                        <div class="row d-flex align-items-baseline">
                            <div class="col-xl-9">
                                <p style="color: #7e8d9f;font-size: 20px;">Invoice >> <strong>ID: #123-123</strong></p>
                            </div>
                            <div class="col-xl-3 float-end">
                                <a class="btn btn-light text-capitalize border-0" data-mdb-ripple-color="dark"><i
                                        class="fas fa-print text-primary"></i> Print</a>
                                <a class="btn btn-light text-capitalize" data-mdb-ripple-color="dark"><i
                                        class="far fa-file-pdf text-danger"></i> Export</a>
                            </div>
                            <hr>
                        </div>

                        <div class="container">
                            <div class="col-md-12">
                                <div class="text-center">
                                    <i class="fab fa-mdb fa-4x ms-0" style="color:#5d9fc5 ;"></i>
                                    <p class="pt-0">MDBootstrap.com</p>
                                </div>

                            </div>


                            <div class="row">
                                <div class="col-xl-8">
                                    <ul class="list-unstyled">
                                        <li class="text-muted">To: <span style="color:#5d9fc5 ;">John Lorem</span></li>
                                        <li class="text-muted">Street, City</li>
                                        <li class="text-muted">State, Country</li>
                                        <li class="text-muted"><i class="fas fa-phone"></i> 123-456-789</li>
                                    </ul>
                                </div>
                                <div class="col-xl-4">
                                    <p class="text-muted">Invoice</p>
                                    <ul class="list-unstyled">
                                        <li class="text-muted"><i class="fas fa-circle" style="color:#84B0CA ;"></i> <span
                                                class="fw-bold">ID:</span>#123-456</li>
                                        <li class="text-muted"><i class="fas fa-circle" style="color:#84B0CA ;"></i> <span
                                                class="fw-bold">Creation Date: </span>Jun 23,2021</li>
                                        <li class="text-muted"><i class="fas fa-circle" style="color:#84B0CA ;"></i> <span
                                                class="me-1 fw-bold">Status:</span><span class="badge bg-warning text-black fw-bold">
                                                Unpaid</span></li>
                                    </ul>
                                </div>
                            </div>

                            <div class="row my-2 mx-1 justify-content-center">
                                <table class="table table-striped table-borderless">
                                    <thead style="background-color:#84B0CA ;" class="text-white">
                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">Description</th>
                                            <th scope="col">Qty</th>
                                            <th scope="col">Unit Price</th>
                                            <th scope="col">Amount</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>Pro Package</td>
                                            <td>4</td>
                                            <td>$200</td>
                                            <td>$800</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">2</th>
                                            <td>Web hosting</td>
                                            <td>1</td>
                                            <td>$10</td>
                                            <td>$10</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">3</th>
                                            <td>Consulting</td>
                                            <td>1 year</td>
                                            <td>$300</td>
                                            <td>$300</td>
                                        </tr>
                                    </tbody>

                                </table>
                            </div>
                            <div class="row">
                                <div class="col-xl-8">
                                    <p class="ms-3">Add additional notes and payment information</p>

                                </div>
                                <div class="col-xl-3">
                                    <ul class="list-unstyled">
                                        <li class="text-muted ms-3"><span class="text-black me-4">SubTotal</span>$1110</li>
                                        <li class="text-muted ms-3 mt-2"><span class="text-black me-4">Tax(15%)</span>$111</li>
                                    </ul>
                                    <p class="text-black float-start"><span class="text-black me-3"> Total Amount</span><span
                                            style="font-size: 25px;">$1221</span></p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-xl-10">
                                    <p>Thank you for your purchase</p>
                                </div>
                                <div class="col-xl-2">
                                    <button type="button" class="btn btn-primary text-capitalize"
                                            style="background-color:#60bdf3 ;">Pay Now</button>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>




        </div>
    </body>
</html>
