<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
<<<<<<< Updated upstream:Swp391Project/Swp391project/target/mavenproject1-1.0-SNAPSHOT/record.jsp
        <form action="record">

            <div class="row">
                <div class=" col-md-3"></div>
                <div class=" col-md-6">
=======
        <form action="">
                
            <div class="row">
                <div class=" col-md-3"></div>
                <div class=" col-md-6">
                
>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/webapp/record.jsp
                    <h1 style="margin-bottom: 30px;display: flex; justify-content: center">MEDICAL REPORT FORM</h1>
                    <div style="display: flex; justify-content: space-between">
                        <p>Patient's Full Name<input style="width: 250px" name="namePatient" type="text"></p> 
                        <p>Date of Birth<input type="date" name ="dobPatient" ></p>
                    </div>
                    <p style="margin-top: 20px">Address<input type="text" name="addressPatient" style="width: 100%"></p> 
                    <div style="display: flex; justify-content: space-between">
                        <p>Phone Number<input style="width: 250px" name="phonePatient" type="text"></p> 
                        <p>Email address<input type="text" name ="emailPatient" ></p>
                        <p>Gender:<br></p> 
                        <select style="height: 28px; width: 100px" name="genderPatient">
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                        </select>
                    </div>
                     <p>Symton</p>
                    <textarea style="width: 100%" name="recordPatient" rows="5" cols="30"></textarea>

                    <div  style="margin-top: 20px;display: flex;justify-content: space-between">
                        <p>ID Card:<input type="text" name="cccdPatient"> </p>
                    <p>Choose doctor: </p>
                    <select style="height: 28px; width: 25%" name="doctor">
<<<<<<< Updated upstream:Swp391Project/Swp391project/target/mavenproject1-1.0-SNAPSHOT/record.jsp
                        <option value="1">Vu</option>
                        <option value="2">Tuan</option>
=======
                        <c:forEach items="${listrole}" var="l">
                            <option>${l.getRole()}</option>
                        </c:forEach>
>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/webapp/record.jsp
                    </select>
                    </div>
                    
                    <div style="margin: 20px;display: flex;justify-content: center"><input style="justify-content: center" type="submit" value="Add Report"></div>
                </div>
                <div class=" col-md-3"></div>
            </div>
<<<<<<< Updated upstream:Swp391Project/Swp391project/target/mavenproject1-1.0-SNAPSHOT/record.jsp

=======
                
>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/webapp/record.jsp
        </form>
    </main>
    <jsp:include page="layout/chatbot.jsp"/>
    <jsp:include page="layout/footer.jsp"/>
</body>
<<<<<<< Updated upstream:Swp391Project/Swp391project/target/mavenproject1-1.0-SNAPSHOT/record.jsp
</html>

=======
</html>
>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/webapp/record.jsp
