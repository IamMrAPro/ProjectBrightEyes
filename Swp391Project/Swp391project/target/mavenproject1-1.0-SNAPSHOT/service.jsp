<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>

        <div class="container">
            <div class="row">
                <div class="col-md-1">

                </div>


<<<<<<< Updated upstream:Swp391Project/Swp391project/target/mavenproject1-1.0-SNAPSHOT/service.jsp
                <div style="background-color: rgb(238, 238, 238) ">
                    <div>
=======
                <div>
                    <div class="col-md-6" style="background-color:rgb(238, 238, 238);padding: 15px 40px;border-radius: 10px;margin-top: 15px;margin-bottom: 10px ">

>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/webapp/service.jsp
                        <h1>Medical Examination Service</h1>
                        <form action="getService"> 
                            <c:forEach items="${listService}" var="p">

<<<<<<< Updated upstream:Swp391Project/Swp391project/target/mavenproject1-1.0-SNAPSHOT/service.jsp
                                <div class="col-md-6" style="background-color:rgb(238, 238, 238);padding: 15px 40px;border-radius: 10px ">

                                    <div style="border-radius: 10px ; background-color: white; padding: 10px 20px"> 
=======
                               
                                    <div style="border-radius: 10px ; background-color: white; padding: 10px 20px; margin-bottom: 20px"> 
>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/webapp/service.jsp
                                        <div style="display: inline-flex; align-items: center">

                                            <ion-icon style="font-size: 25px; margin-top: 5px" name="eye-outline"></ion-icon>
                                            <h3 style="margin-left: 10px">${p.getService()}</h3>
                                        </div>
                                        <p>${p.getDescription()}</p>
<<<<<<< Updated upstream:Swp391Project/Swp391project/target/mavenproject1-1.0-SNAPSHOT/service.jsp
                                        <p style="color:rgb(74, 192, 164) ">${p.getPrice()}</p>
                                    </div>

                                </div>
=======
                                        <p style="color:rgb(74, 192, 164);margin-left: 10px ">${p.getPrice()} VND/lần</p>
                                    </div>

                                
>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/webapp/service.jsp
                            </c:forEach>
                        </form>
                    </div>
                </div>





<<<<<<< Updated upstream:Swp391Project/Swp391project/target/mavenproject1-1.0-SNAPSHOT/service.jsp
                <div class="col-md-4" style="position: fixed; top: 190px; right: 0;">
                    Không chuyển động
=======
                <div class="col-md-4">
                    
>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/webapp/service.jsp
                </div>
                <div class="col-md-1">

                </div>
            </div>
        </div>

        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
        <script>
            const medicalTitle = document.querySelector("h1");
            const serviceList = document.querySelector(".service-list");

            medicalTitle.addEventListener("click", () => {
                if (serviceList.style.display === "block") {
                    serviceList.style.display = "none";
                } else {
                    serviceList.style.display = "block";
                }
            });
        </script>
    </body>
</html>