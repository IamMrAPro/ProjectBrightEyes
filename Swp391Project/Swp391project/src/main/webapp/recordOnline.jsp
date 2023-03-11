<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
        <form action="recordOnline" method="post">
              <c:forEach items="${listid}" var="ld">
                  
                   
            <div class="row">
                <div class=" col-md-3"></div>
                <div class=" col-md-6">
                
                    <h1 style="margin-bottom: 30px;display: flex; justify-content: center">MEDICAL REPORT FORM</h1>
                    <div style="display: flex; justify-content: space-between">
                        <p>Patient's Full Name<input style="width: 250px" name="patientName" type="text" value="${ld.getName()}"></p> 
                        <p>Date of Birth<input type="date" name ="bod" ></p>
                    </div>
                    <p style="margin-top: 20px">Address<input type="text" name="address" style="width: 100%"></p> 
                    <div style="display: flex; justify-content: space-between">
                        <p>Phone Number<input style="width: 250px" name="phone" type="text" value="${ld.getPhone()}"></p> 
                        <p>Email address<input type="text" name ="email" value="${ld.getEmail()}"></p>
                        <p>Gender:<br></p> 
                        <select style="height: 28px; width: 100px" name="gender">
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                        </select>
                        <input type="text" name="time" value="${ld.getTime()}" hidden="" >
                    </div>
                    </c:forEach>   
                     <p>Symton</p>
                    <textarea style="width: 100%" name="symptom" rows="5" cols="30"></textarea>

                    <div  style="margin-top: 20px;display: flex;justify-content: space-between">
                        <p>ID Card:<input minlength="12" maxlength="12" type="text" name="idcard"> </p>
                    <p>Choose doctor: </p>
                    <select style="height: 28px; width: 25%" name="doctor">
                        <c:forEach items="${listrole}" var="l">
                            <option>${l.getFullname()}</option>
                        </c:forEach>
                    </select>
                    </div>
                    
                    <div style="margin: 20px;display: flex;justify-content: center"><input style="justify-content: center" type="submit" value="Add Report"></div>
                </div>
                <div class=" col-md-3"></div>
            </div>
                
        </form>
    </main>
    <jsp:include page="layout/chatbot.jsp"/>
    <jsp:include page="layout/footer.jsp"/>
</body>
</html>