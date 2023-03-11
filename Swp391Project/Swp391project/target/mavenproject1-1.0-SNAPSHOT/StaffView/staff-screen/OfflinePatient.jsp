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
        <form action="manageCustomer" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->           
            <!--            --------------------------------------------------------------------->
            <%@include file="../Staff-layout/staff-navbar.jsp" %>
            <div class="main-view main-view-content">
                <br><br>
                <div class="d-flex justify-content-between header-staff-list align-items-center mb-4">
                    <h2 class="text-center w-100">PATIENT OFF MANAGEMENT </h2>
                </div>
                <br>

                <div class="row">
                    <div class=" col-md-3"></div>
                    <div class=" col-md-6">

                        <h1 style="margin-bottom: 30px;display: flex; justify-content: center">MEDICAL REPORT FORM</h1>
                        <div style="display: flex; justify-content: space-between">
                            <p>Patient's Full Name<input style="width: 250px" name="patientName" type="text" "></p> 
                            <p>Date of Birth<input type="date" name ="dob" ></p>
                        </div>
                        <p style="margin-top: 20px">Address<input type="text" name="adress" style="width: 100%"></p> 
                        <div style="display: flex; justify-content: space-between">
                            <p>Phone Number<input style="width: 250px" name="phone" type="text" "></p> 
                            <p>Email address<input type="text" name ="email" "></p>
                            <p>Gender:<br></p> 
                            <select style="height: 28px; width: 100px" name="gender">
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                            </select>
                        </div>

                        <p>Symton</p>
                        <textarea style="width: 100%" name="symptom" rows="5" cols="30"></textarea>

                        <div  style="margin-top: 20px;display: flex;justify-content: space-between">
                            <p>ID Card:<input type="text" name="idcard"> </p>
                            <p>Choose doctor: </p>
                            <select style="height: 28px; width: 25%" name="doctor">

                            </select>
                        </div>

                        <div style="margin: 20px;display: flex;justify-content: center"><input style="justify-content: center" type="submit" value="Add Report"></div>
                    </div>
                    <div class=" col-md-3"></div>
                </div>




            </div>
        </form>
    </body>
</html>
