<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <jsp:include page="layout/head.jsp"/>
    <style>
       
        .title{
            margin-bottom: 5vh;
        }
        .card{
            margin: auto;
            max-width: 90%;
            width: 90%;
            box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            border-radius: 1rem;
            border: transparent;
        }
        @media(max-width:767px){
            .card{
                margin: 3vh auto;
            }
        }
        .cart{
            background-color: #fff;
            padding: 4vh 5vh;
            border-bottom-left-radius: 1rem;
            border-top-left-radius: 1rem;
        }
        @media(max-width:767px){
            .cart{
                padding: 4vh;
                border-bottom-left-radius: unset;
                border-top-right-radius: 1rem;
            }
        }
        .summary{
            background-color: #ddd;
            border-top-right-radius: 1rem;
            border-bottom-right-radius: 1rem;
            padding: 4vh;
            color: rgb(65, 65, 65);
        }
        @media(max-width:767px){
            .summary{
                border-top-right-radius: unset;
                border-bottom-left-radius: 1rem;
            }
        }
        .summary .col-2{
            padding: 0;
        }
        .summary .col-10
        {
            padding: 0;
        }
        .row{
            margin: 0;
        }
        .title b{
            font-size: 1.5rem;
        }
        .main{
            margin: 0;
            padding: 2vh 0;
            width: 100%;
        }
        .col-2, .col{
            padding: 0 1vh;
        }
        a{
            padding: 0 1vh;
        }
        .close{
            margin-left: auto;
            font-size: 1.7rem;
        }
        img{
            width: 10.5rem;
        }
        .back-to-shop{
            margin-top: 4.5rem;
        }
        h5{
            margin-top: 4vh;
        }
        hr{
            margin-top: 1.25rem;
        }
        form{
            padding: 2vh 0;
        }
        select{
            border: 1px solid rgba(0, 0, 0, 0.137);
            padding: 1.5vh 1vh;
            margin-bottom: 4vh;
            outline: none;
            width: 100%;
            background-color: rgb(247, 247, 247);
        }
        input{
            border: 1px solid rgba(0, 0, 0, 0.137);
            padding: 1vh;
            margin-bottom: 4vh;
            outline: none;
            width: 100%;
            background-color: rgb(247, 247, 247);
        }
        input:focus::-webkit-input-placeholder
        {
            color:transparent;
        }
        .btn{
            background-color: #000;
            border-color: #000;
            color: white;
            width: 100%;
            font-size: 0.7rem;
            margin-top: 4vh;
            padding: 1vh;
            border-radius: 0;
        }
        .btn:focus{
            box-shadow: none;
            outline: none;
            box-shadow: none;
            color: white;
            -webkit-box-shadow: none;
            -webkit-user-select: none;
            transition: none;
        }
        .btn:hover{
            color: white;
        }
        a{
            color: black;
        }
        a:hover{
            color: black;
            text-decoration: none;
        }
        #code{
            background-image: linear-gradient(to left, rgba(255, 255, 255, 0.253) , rgba(255, 255, 255, 0.185)), url("https://img.icons8.com/small/16/000000/long-arrow-right.png");
            background-repeat: no-repeat;
            background-position-x: 95%;
            background-position-y: center;
        }
    </style>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
        <br><!-- comment -->
        <br><!-- comment -->
        <br><!-- comment -->
        <main>
            <div class="card">
                <div class="row">
                    <div class="col-md-8 cart">
                        <div class="title">
                            <div class="row">
                                <div class="col"><h4><b>Shopping Glasses</b></h4></div>
                                
                            </div>
                        </div>
                                <c:set var="o" value="${requestScope.cart}"  />
                                <c:forEach items="${o.items}" var="i">
                        <div class="row border-top border-bottom">
                            <div class="row main align-items-center">
                                <div class="col-2"><img class="img-fluid" src="${i.getGlass().getImage()} "></div>
                                <div class="col">
                                    <div class="row text-muted">${i.getGlass().getGlassName()}</div>
                                    <div class="row">${i.getGlass().getColor()}</div>
                                </div>
                                <div class="col">
                                    <a href="process?num=-1&id=${i.getGlass().getGlassID()}">-</a><a class="border">${i.getQuantity()}</a>
                                    <a href="process?num=+1&id=${i.getGlass().getGlassID()}"">+</a>
                                </div>
                                <div class="col">${i.getGlass().getPrice()} VND </div>
                                <div class="col">
                                    <form action="process" method="post">
                                        <input type="hidden" name="id" value="${i.getGlass().getGlassID()}"/>
                                        <input class="btn" type="submit" value="Return item"/>
                                    </form>
                                </div>
                                <div class="col">
                                    <a href="deleteCart??glassesId=${i.getGlass().getGlassID()}"><span class="close">&#10005;</span></a> 
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                        <div class="back-to-shop"><a href="home">&leftarrow;<span class="text-muted">Back to home</span></div></a>
                    </div>
                    <div class="col-md-4 summary">
                        <div><h5><b>Summary</b></h5></div>
                       
                        <form>
                            <p>SHIPPING BY</p>
                            <select>
                                <option class="text-muted">VNpost – EMS</option>
                                <option class="text-muted">Giao hàng tiết kiệm</option>
                                <option class="text-muted">Giao hàng Nhanh</option>
                            </select>
<!--                            <p>GIVE CODE</p>
                            <input id="code" placeholder="Enter your code">-->
                        </form>
                        <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                            <div class="col">TOTAL PRICE</div>
                            <div class="col text-right">${o.getTotalMoney()}</div>
                        </div>
                        <form action="checkout" method="post">
                            <input class="btn"value="CHECKOUT"/> 
                        </form>
                        
                    </div>
                </div>

            </div>

        </main>
        <br><!-- comment -->
        <br><!-- comment -->

        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>

