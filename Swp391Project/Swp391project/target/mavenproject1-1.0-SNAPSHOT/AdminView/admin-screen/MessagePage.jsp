<%-- 
    Document   : MessagePage
    Created on : Mar 14, 2023, 10:02:48 PM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <style>
        .dot-pulse {
            position: relative;
            left: -9999px;
            width: 10px;
            height: 10px;
            border-radius: 5px;
            background-color: #9880ff;
            color: #9880ff;
            box-shadow: 9999px 0 0 -5px;
            animation: dot-pulse 1.5s infinite linear;
            animation-delay: 0.25s;
        }
        .dot-pulse::before, .dot-pulse::after {
            content: "";
            display: inline-block;
            position: absolute;
            top: 0;
            width: 10px;
            height: 10px;
            border-radius: 5px;
            background-color: #9880ff;
            color: #9880ff;
        }
        .dot-pulse::before {
            box-shadow: 9984px 0 0 -5px;
            animation: dot-pulse-before 1.5s infinite linear;
            animation-delay: 0s;
        }
        .dot-pulse::after {
            box-shadow: 10014px 0 0 -5px;
            animation: dot-pulse-after 1.5s infinite linear;
            animation-delay: 0.5s;
        }

        @keyframes dot-pulse-before {
            0% {
                box-shadow: 9984px 0 0 -5px;
            }
            30% {
                box-shadow: 9984px 0 0 2px;
            }
            60%, 100% {
                box-shadow: 9984px 0 0 -5px;
            }
        }
        @keyframes dot-pulse {
            0% {
                box-shadow: 9999px 0 0 -5px;
            }
            30% {
                box-shadow: 9999px 0 0 2px;
            }
            60%, 100% {
                box-shadow: 9999px 0 0 -5px;
            }
        }
        @keyframes dot-pulse-after {
            0% {
                box-shadow: 10014px 0 0 -5px;
            }
            30% {
                box-shadow: 10014px 0 0 2px;
            }
            60%, 100% {
                box-shadow: 10014px 0 0 -5px;
            }
        }
    </style>
    <body>
        <div class="d-flex justify-content-center mt-5 pt-5">
            <div class="col-3">
                <div class="snippet" data-title="dot-pulse">
                    <div class="stage">
                        <div class="dot-pulse"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
