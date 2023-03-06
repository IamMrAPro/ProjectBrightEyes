<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <style>
        .carousel{
            padding:   8%

        }
        .bt-next{
            margin:  10%
        }
        input[type="text" ] {
            padding: 1px 2px;
        }
        input {
            writing-mode: horizontal-tb !important;
            font-style: ;
            font-variant-ligatures: ;
            font-variant-caps: ;
            font-variant-numeric: ;
            font-variant-east-asian: ;
            font-weight: ;
            font-stretch: ;
            font-size: ;
            font-family: ;
            text-rendering: auto;
            color: fieldtext;
            letter-spacing: normal;
            word-spacing: normal;
            line-height: normal;
            text-transform: none;
            text-indent: 0px;
            text-shadow: none;
            display: inline-block;
            text-align: start;
            appearance: auto;
            -webkit-rtl-ordering: logical;
            cursor: text;
            background-color: field;
            margin: 0em;
            padding: 1px 2px;
            border-width: 2px;
            border-style: inset;
            border-color: -internal-light-dark(rgb(118, 118, 118), rgb(133, 133, 133));
            border-image: initial;
        }
        .text-box {
            text-align: center;
            text-transform: uppercase;
            letter-spacing: 5px;
            height: 32px;
        }
        #step1text {
            font-family: gotham-medium;
            font-size: 19px;
            font-style: normal;
            font-weight: 700;
            font-variant: normal;
            text-transform: uppercase;
            color: #000;
            letter-spacing: 5px;
        }
        #step2text {
            font-family: gotham-medium;
            font-size: 17px;
            font-style: normal;
            font-weight: 700;
            font-variant: normal;
            text-transform: uppercase;
            color: #000;
            letter-spacing: 5px;
        }
        #step3text {
            font-family: gotham-medium;
            font-size: 14.5px;
            font-style: normal;
            font-weight: 700;
            font-variant: normal;
            text-transform: uppercase;
            color: #000;
            letter-spacing: 5px;
        }
        #step4text {
            font-family: gotham-medium;
            font-size: 11px;
            font-style: normal;
            font-weight: 700;
            font-variant: normal;
            text-transform: uppercase;
            color: #000;
            letter-spacing: 5px;
        }
        #step5text {
            font-family: gotham-medium;
            font-size: 9px;
            font-style: normal;
            font-weight: 700;
            font-variant: normal;
            text-transform: uppercase;
            color: #000;
            letter-spacing: 5px;
        }
        #step6text {
    font-family: gotham-medium;
    font-size: 7px;
    font-style: normal;
    font-weight: 700;
    font-variant: normal;
    text-transform: uppercase;
    color: #000;
    letter-spacing: 5px;
}
    </style>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>

        <div id="carouselExampleCaptions" class="carousel slide text-center">
            <h2>ONLINE EYES TEST</h2>
            <br><!-- comment -->
            <form action="testEyes" method="post" id="clicks">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3" aria-label="Slide 4"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="4" aria-label="Slide 5"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="5" aria-label="Slide 6"></button>
                </div>

                <div class="carousel-inner">

                    <div class="carousel-item active">


                        <input type="hidden" name="chars1" value="${sessionScope.testcase1}"><!-- comment -->
                        <p><strong id="step1text">${sessionScope.testcase1}</strong></p>
                        <input type="text" name="stepInput1" class="text-box">

                    </div>
                    <div class="carousel-item">

                        <input type="hidden" name="chars2" value="${sessionScope.testcase2}"><!-- comment -->
                        <p><strong id="step2text">${sessionScope.testcase2}</strong></p>
                        <input type="text" name="stepInput2" class="text-box">

                    </div>
                    <div class="carousel-item">

                        <input type="hidden" name="chars3" value="${sessionScope.testcase3}"><!-- comment -->
                        <p><strong id="step3text">${sessionScope.testcase3}</strong></p>
                        <input type="text" name="stepInput3" class="text-box">

                    </div>
                    <div class="carousel-item">

                        <input type="hidden" name="chars4" value="${sessionScope.testcase4}"><!-- comment -->
                        <p><strong id="step4text">${sessionScope.testcase4}</strong></p>
                        <input type="text" name="stepInput4" class="text-box">

                    </div>
                    <div class="carousel-item">

                        <input type="hidden" name="chars5" value="${sessionScope.testcase5}"><!-- comment -->
                        <p><strong id="step5text">${sessionScope.testcase5}</strong></p>
                        <input type="text" name="stepInput5" class="text-box">
                        

                    </div>
                        <div class="carousel-item">

                        <input type="hidden" name="chars6" value="${sessionScope.testcase5}"><!-- comment -->
                        <p><strong id="step6text">${sessionScope.testcase6}</strong></p>
                        <input type="text" name="stepInput6" class="text-box">
                       

                    </div>
                </div>

                        <button id="button" onClick="onClick()" class="bt-next btn btn-success" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                    Next
                </button>
            </form>
        </div>

        <script type="text/javascript">
            var clicks = 0;

            function onClick() {
                clicks += 1;
                if (clicks == 5) {
                    document.getElementById("button").textContent="Submit";
                   
                }
                if (clicks == 6) {
                    
                    document.getElementById("clicks").submit();
                }
                // document.getElementById("clicks").innerHTML = clicks;
            }
            ;
        </script>


        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>

