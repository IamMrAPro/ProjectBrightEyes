<%-- 
    Document   : MedicalRecord
    Created on : Mar 7, 2023, 9:52:37 AM
    Author     : nguye
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../doctor-layout/doctor-head.jsp" %>

    <head>
        <script>
            function showAlert(name, phone, idcard, status) {
                // Create a div element to hold the alert message
                var alertDiv = document.createElement("div");
                alertDiv.style.position = "fixed";
                alertDiv.style.top = "50%";
                alertDiv.style.left = "50%";
                alertDiv.style.transform = "translate(-50%, -50%)";
                alertDiv.style.backgroundColor = "white";
                alertDiv.style.width = "700px";


                alertDiv.style.borderRadius = "5px";
                alertDiv.style.boxShadow = "0px 0px 10px rgba(0, 0, 0, 0.5)";
                alertDiv.style.zIndex = "9999";
                alertDiv.style.display = "flex";
                alertDiv.style.flexDirection = "column";
                alertDiv.style.alignItems = "center";

                // Create the alert message
                var alertMessage = document.createElement("p");
                alertMessage.textContent = "Thông tin bệnh nhân:";
                alertMessage.style.marginTop = "0px";
                alertMessage.style.marginBottom = "20px";

                // Create the name element
                var nameElement = document.createElement("p");
                nameElement.textContent = "Tên: " + name;
                nameElement.style.marginTop = "0px";
                nameElement.style.marginBottom = "10px";

                // Create the phone element
                var phoneElement = document.createElement("p");
                phoneElement.textContent = "Số điện thoại: " + phone;
                phoneElement.style.marginTop = "0px";
                phoneElement.style.marginBottom = "10px";

                // Create the id card element
                var idCardElement = document.createElement("p");
                idCardElement.textContent = "CMND: " + idcard;
                idCardElement.style.marginTop = "0px";
                idCardElement.style.marginBottom = "10px";

                // Create the status element
                var statusElement = document.createElement("p");
                statusElement.textContent = "Tình trạng: " + status;
                statusElement.style.marginTop = "0px";
                statusElement.style.marginBottom = "10px";

                // Create the close button
                var closeButton = document.createElement("button");
                closeButton.textContent = "Đóng";
                closeButton.style.marginTop = "20px";
                closeButton.style.padding = "10px 20px";
                closeButton.style.backgroundColor = "#007bff";
                closeButton.style.border = "none";
                closeButton.style.borderRadius = "5px";
                closeButton.style.color = "white";
                closeButton.style.cursor = "pointer";
                closeButton.addEventListener("click", function () {
                    alertDiv.parentNode.removeChild(alertDiv);
                });

                // Add all elements to the alert div
                alertDiv.appendChild(alertMessage);
                alertDiv.appendChild(nameElement);
                alertDiv.appendChild(phoneElement);
                alertDiv.appendChild(idCardElement);
                alertDiv.appendChild(statusElement);
                alertDiv.appendChild(closeButton);

                // Add the alert div to the page
                document.body.appendChild(alertDiv);
            }
        </script>
    </head>
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



        .dialog p {
            padding: 10px;
            font-size: 16px;
            line-height: 1.5;

        }

        .dialog .close {
            position: absolute;
            top: 5px;
            right: 10px;
            font-size: 24px;
            font-weight: bold;
            color: #aaaaaa;
            cursor: pointer;
        }

    </style>
    <body>
        <form action="medicalRecord" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->           
            <!--            --------------------------------------------------------------------->
            <%@include file="../doctor-layout/doctor-navbar.jsp" %>
            <div class="main-view main-view-content">
                <br><br>

                <br>
                <% int count = 0;%>
                <!-- Modal -->
                <c:forEach items="${listInformationPatient}" var="c">

                <form action="medicalRecord" method="POST">
                    <div class="row">
                      
                            <div class=" col-md-3"></div>

                            <div class=" col-md-6">
                                <h1 style="margin-bottom: 30px;display: flex; justify-content: center">MEDICAL REPORT FORM</h1>
                                <div style="display: flex; justify-content: space-between">
                                    <p>Patient's Full Name<input style="width: 250px" name="namePatient" type="text" value="${c.getPatientName()} " readonly></p> 
                                    <p>Date of Birth<input type="text" name ="dobPatient" value="${c.getBod()} "readonly ></p>
                                </div>
                                <div style="display: flex; justify-content: space-between">
                                    <p>Phone Number<input style="width: 250px" name="phonePatient" type="text" value="${c.getPhone()} "readonly></p> 

                                    <p>Gender:<input type="text" name ="emailPatient" value="${c.getGender()} "readonly></p>
                                </div>
                                <p style="margin-top: 20px">Address<input type="text" name="addressPatient" style="width: 100%" value="${c.getAddress()} "readonly></p>                                
                                <p style="margin-top: 20px">Email<input type="text" name="addressPatient" style="width: 100%" value="${c.getEmail()} "readonly></p>
                                <div style="display: flex; justify-content: space-between">
                                    <p>ID Card:<input type="text" name="Idcard" value="${c.getIdcard()} "readonly> </p>

                                    <a href="#" onclick="showAlert('${c.getPatientName()}', '${c.getPhone()}', '${c.getIdcard()}', '${c.getStatus()}')" class="dialog">View Medical History</a>
                                </div>                                   
                                <p>Symtom </p>
                                <textarea style="width: 100%" name="symptom" rows="5" cols="30"></textarea>
                                <p>Conclude </p>
                                <textarea style="width: 100%" name="conclude" rows="5" cols="30"></textarea>
                                <p>Medicine </p>
                                <textarea style="width: 100%" name="medicine" rows="5" cols="30"></textarea>


                                <div style="margin: 20px;display: flex;justify-content: center">
                                    <input style="justify-content: center" type="submit" value="Submit"></div>
                            </div>
                        
                        <div class=" col-md-3"></div>
                    </div>
                               
                       
        </c:forEach>

    </div>
 </form>      
</body>
</html>
