<%-- 
    Document   : ListNews
    Created on : Feb 5, 2023, 12:24:34 PM
    Author     : nguye
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>

        <main>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center mb-4">

                        <br>  <h2>News </h2>
                    </div>
                    <c:forEach items="${listNews}" var="item">
                        <div class="col-lg-4 col-md-6 col-3 mb-4 ">
                            <div class="custom-block-wrap">
                                <img src="assets/images/news/${item.getImages1()}" class="custom-block-image img-fluid" alt="">
                                <div class="custom-block" >                                   
                                    <div class="custom-block-body">
                                            ${item.getCategory()}
                                        <h6>${item.getNewsname()}</h6>
                                        
                                        <div class="d-flex align-items-center my-2">
                                            <p class="ms-auto mb-0">
                                                <strong> ${item.getDatepublic()}</strong>

                                            </p>
                                        </div>
                                    </div>

                                    <a href="singleNewsController?newsname=${item.getNewsname()}" class="custom-btn  btn-lg text-center" > <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
                                      </svg> Xem chi tiết </a>
                                </div>
                            </div>
                        </div>

                    </c:forEach>
                </div>
            </div>
        </main>
        <br><!-- comment -->
        <br><!-- comment -->

        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>


