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
            .card{
                padding: 10px 25%;
            }
        </style>
    </header>
    <body>

        <div class="d-flex">

            <!--            set position for not select case-->           
            <!--            --------------------------------------------------------------------->
            <%@include file="../Staff-layout/staff-navbar.jsp" %>
            <div class="card ">
                <div class="card-body">
                    <div class="container col-md-12">
                        <div class="row d-flex align-items-baseline">

                            <div class=" float-end">
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
                                    <h1>Bill</h1>
                                    <p class="pt-0">Bright eye Clinic</p>
                                </div>

                            </div>


                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-12">
                                    To : <input type="text" name="name"  class="form-control"  >
                                </div>

                                <div class="col-lg-6 col-md-6 col-12">
                                    Phone :<input type="text" name="phone" class="form-control" >
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-12">
                                    Address : <input type="text" name="first-name"  class="form-control"  >
                                </div>

                                <div class="col-lg-6 col-md-6 col-12">
                                    Id cart :<input type="text" name="last-name" class="form-control" >
                                </div>

                            </div>

                            <div class="row my-2 mx-1 justify-content-center">
                                <table class="table table-striped table-borderless">
                                    <thead style="background-color:#84B0CA ;" class="text-white">
                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">Service</th>
                                            <th scope="col">Quantity</th>
                                            <th scope="col">Unit Price</th>
                                            <th scope="col">Amount</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td><input class="form-control" type="text" name="service3"></td>
                                            <td><input type="number" name="quantity" class="quantity" min="1" max="5"></td>
                                            <td>$<input type="number" name="price" class="price" ></td>
                                            <td>$ <span class="total" ></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">2</th>
                                            <td><input class="form-control" type="text" name="service3"></td>
                                            <td><input type="number" name="quantity" class="quantity" min="1" max="5"></td>
                                            <td>$<input type="number" name="price" class="price" ></td>
                                            <td>$ <span class="total" ></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">3</th>
                                            <td><input class="form-control" type="text" name="service3"></td>
                                            <td><input type="number" name="quantity" class="quantity" min="1" max="5"></td>
                                            <td>$<input type="number" name="price" class="price" ></td>
                                            <td>$ <span class="total" ></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">4</th>
                                            <td><input class="form-control" type="text" name="service3"></td>
                                            <td><input type="number" name="quantity" class="quantity" min="1" max="5"></td>
                                            <td>$<input type="number" name="price" class="price" ></td>
                                            <td>$ <span class="total" ></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">5</th>
                                            <td><input class="form-control" type="text" name="service3"></td>
                                            <td><input type="number" name="quantity" class="quantity" min="1" max="5"></td>
                                            <td>$<input type="number" name="price" class="price" ></td>
                                            <td>$ <span class="total" ></span></td>
                                        </tr>
                                    </tbody>

                                </table>
                            </div>
                            <div class="row">

                                <div class="col-md-12">

                                    <p class="text-black float-start"><span class="text-black me-3"> Total Amount</span><span
                                            style="font-size: 25px;">$1221</span></p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-xl-10">
                                    <p>Thank you for you medical examination at here</p>
                                </div>
                                <div class="col-xl-4 ">
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
    <script>
        const prices = document.querySelectorAll('.price');
        const quantities = document.querySelectorAll('.quantity');
        const totals = document.querySelectorAll('.total');

        // tính tổng giá của từng sản phẩm và hiển thị kết quả
        for (let i = 0; i < prices.length; i++) {
            const price = parseInt(prices[i].value);
            const quantity = parseInt(quantities[i].value);
            const total = price * quantity;
            totals[i].textContent = total;
        }
    </script>
</html>
