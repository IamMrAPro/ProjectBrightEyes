<%-- 
    Document   : ManageCustomer
    Created on : Feb 11, 2023, 1:44:19 PM
    Author     : Ao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
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
        
        .pagination {
            height: 80px;
        }
    </style>

    <body onload="getPositionNavBar(2)">
        <form action="manageCustomer" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->
            <input name="setPosition" type="text" value="3" class="d-none">
            <!--            --------------------------------------------------------------------->
            <%@include file="../admin-layout/admin-navbar.jsp" %>

            <div class="main-view main-view-content">
                <div class="d-flex justify-content-between header-staff-list align-items-center mb-4">
                    <h2 class="text-center w-100">MANAGE CUSTOMER</h2>
                </div>
                <br>
                <% int count = 0;%>
                <div class="mb-5 mx-3">
                    <div class="row align-items-center justify-content-between">
                        <div class="d-flex">
                            <div class="select">
                                <select>
                                    <option value="1">Display All</option>
                                    <option value="2">Working</option>
                                    <option value="3">Stop</option>
                                </select>
                            </div>

                            <a href="addUser" class="cssbuttons-io-button mx-3">
                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24"><path fill="none" d="M0 0h24v24H0z"></path><path fill="currentColor" d="M11 11V5h2v6h6v2h-6v6h-2v-6H5v-2z"></path></svg>
                                <span>ADD NEW</span>
                            </a>
                        </div>

                        <!--                        <div class="form-floating align-items-center d-flex" id="search-staff">
                                                    <input name="staffSearch" type="text" id="search-staff-content" placeholder="Search by name">
                                                    <button id="staff-search-btn"><i class="fa-solid fa-magnifying-glass"></i></button>
                                                </div>-->
                    </div>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Add a new staff</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <%@include file="UserBasicInformation.jsp" %>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <input type="submit" name="addNewStaff" class="btn btn-primary" value="SAVE">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead id="table-head">
                        <tr>
                            <th>No.</th>
                            <th>
                                <div class="d-flex justify-content-between">
                                    <div>Name</div>
                                    <div>
                                        <input type="submit" name="sortByName" id="sort-name" value="sort" class="d-none">
                                        <label for="sort-name" class="sort-icon"><i class="fa-solid fa-sort"></i></label>
                                    </div>
                                </div>
                            </th>
                            <th>Gender</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Status</th>
                            <th>Manage</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listCustomer}" var="c">
                        <input type="hidden" value="${c.getAccount()}" id="acc">
                            <tr>
                                <th><% count++;
                                    out.print(count);%></th>
                                <th>${c.getFullname()}</th>
                                <th>${c.getGender()}</th>
                                <th>${c.getEmail()}</th>
                                <th>${c.getAddress()}</th>
                                <th>Online</th>
                                <th>
                                    <div class="d-flex align-items-center">
                                        <!--<input type="submit" name="viewProfile" value="${c.getAccount()}" class="d-none" id="${c.getUserId()}">-->
                                        <a href="adminViewUserProfile?account=${c.getAccount()}" class="btn btn-success m-auto"><i class="fa-solid fa-pen"></i></a>
<!--                                        <label for="${c.getUserId()}" class="btn btn-success m-auto">
                                            <i class="fa-solid fa-pen"></i>
                                        </label>-->
                                        <div class="btn btn-success m-auto chatboxClass" id="chat${c.getAccount()}" >
                                            
                                            chat
                                            
                                        </div>
                                    </div>
                                </th>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
                
                <div class="pagination">
                    <c:if test="${currentPage > 1}">
                        <a href="?page=${currentPage-1}">&laquo; Previous</a>
                    </c:if>
                        
                    <c:forEach var="page" begin="1" end="${numPages}">
                        <c:choose>
                            <c:when test="${page == currentPage}">
                                <a href="manageCustomer?page=${page}" class="active">${page}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="manageCustomer?page=${page}">${page}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:if test="${currentPage < numPages}">
                        <a href="manageCustomer?page=${currentPage+1}">Next &raquo;</a>
                    </c:if>
                </div>
            </div>
        </form>
        <%@include file="../admin-layout/chatbotofAdmin.jsp" %>
    </body>
</html>
