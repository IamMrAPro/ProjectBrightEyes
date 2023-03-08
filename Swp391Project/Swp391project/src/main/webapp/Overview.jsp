<%-- 
    Document   : Overview
    Created on : Feb 15, 2023, 8:51:51 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
        <div class="jieh-title-36-48 jieh-text">
        <h2 style="font-size: 50px;color: #E55F67;margin-left: 8%; margin-top: 7%">
            Vì bệnh nhân và<br>
            tương lai của bệnh nhân!</h2>
        <br> <br>
        </div>
        
        <c:forEach items="${listOv}" var="p">
        <div class="row">
            <div class=" col-md-1"></div>
                <div class=" col-md-7">
                    <div class="jieh-text description">${p.getText1()}</div>
                </div>
                <div class=" col-md-4"></div>
                    </div>
        
        <div class="row">
            <div class=" col-md-3"></div>
            <div class=" col-md-9">
      <img src="assets/images/backgroud_overviews.png" style="width: 90%;height: 100%;margin-left: 5%;margin-right: 5%"class="custom-block-image img-fluid" alt="">
        </div>
          
        </div>
         
                <div class="row" style="margin-top: 4%">
              <div class=" col-md-1"></div>
              <div class=" col-md-4" style="margin-bottom: 5%; height: 70% ">
                   <img src="https://jieh.vn/upload/images/about/tong-quan-benh-vien-jieh.png" style="width: 90%;height: 100%;margin-left: 5%;margin-right: 5%"class="custom-block-image img-fluid" alt="">
              </div>
                <div class=" col-md-6">
                    <div class="jieh-text description">${p.getText2()}</div>
                 
                    <ul style="margin-top: 3% ">
                        <li style="font-weight: bold; color: #ff6666">ĐỘI NGŨ BÁC SĨ CÓ TRÌNH ĐỘ CHUYÊN MÔN CAO, LUÔN TẬN TÂM VÌ BỆNH NHÂN</li>
	<li style="font-weight: bold; color: #ff6666 ">HỆ THỐNG TRANG THIẾT BỊ HIỆN ĐẠI</li>
	<li style="font-weight: bold;  color: #ff6666">MÔI TRƯỜNG KHÁM CHỮA BỆNH SẠCH VÀ VĂN MINH</li>
	<li style="font-weight: bold; color: #ff6666">QUY TRÌNH KHÁM CHỮA BỆNH TỐI ƯU, TIẾT KIỆM THỜI GIAN VÀ CHI PHÍ</li>
	<li style="font-weight: bold; color: #ff6666">DỊCH VỤ ĐA DẠNG, CÔNG NGHỆ ĐIỀU TRỊ TIÊN TIẾN NHẤT</li>
</ul>
                    </div>
                </div>
               
                    </div>       
                
            
        
        </c:forEach>
        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>
