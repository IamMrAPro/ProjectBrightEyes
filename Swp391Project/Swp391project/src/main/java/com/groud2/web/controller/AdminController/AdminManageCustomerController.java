/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ao
 */
public class AdminManageCustomerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDAO u = new userDAO();
        ArrayList<user> listCustomer = u.getListCustomer("");
        String page = req.getParameter("page");

        int currentPage;
        if (page != null) {
            currentPage = Integer.parseInt(req.getParameter("page"));
        } else {
            currentPage = 1;
        }
        int recordsPerPage = 10;
        int startGetCustomerToPage = (currentPage - 1) * recordsPerPage;
        int numberPage = listCustomer.size() / recordsPerPage + 1;
        int endCount = startGetCustomerToPage + recordsPerPage;
        if (endCount > (listCustomer.size())) {
            endCount = listCustomer.size();
        }
        ArrayList<user> listCustomerInPage = new ArrayList<>();
        for (int i = startGetCustomerToPage; i < endCount; i++) {
            listCustomerInPage.add(listCustomer.get(i));
        }
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("id");
        req.setAttribute("username", username);
        req.setAttribute("numPages", numberPage);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("listCustomer", listCustomerInPage);
        req.getRequestDispatcher("AdminView/admin-screen/ManageCustomer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get request from client
        String position = req.getParameter("position");
        String setPos = req.getParameter("setPosition");
        String page = req.getParameter("page");
        if (position == null) {
            position = setPos;
        }
        //Handle request
        if (!position.equals("3")) {
            changePosition(position, req, resp);
        } else {
            String viewProfile = req.getParameter("viewProfile");
            String search = req.getParameter("search");
            String sort = req.getParameter("sortByName");
            userDAO u = new userDAO();

            int currentPage;
            if (page != null) {
                currentPage = Integer.parseInt(req.getParameter("page"));
            } else {
                currentPage = 1;
            }

            int recordsPerPage = 10;
            int startGetCustomerToPage = (currentPage - 1) * recordsPerPage;
            ArrayList<user> listCustomerSearch = u.getListCustomer(search);
            int numberPage = listCustomerSearch.size() / recordsPerPage + 1;
            int endCount = startGetCustomerToPage + recordsPerPage;
            if (endCount > (listCustomerSearch.size())) {
                endCount = listCustomerSearch.size();
            }
            ArrayList<user> listCustomerInPage = new ArrayList<>();
            for (int i = startGetCustomerToPage; i < endCount; i++) {
                listCustomerInPage.add(listCustomerSearch.get(i));
            }

            if (sort != null) {
                Collections.sort(listCustomerInPage, new Comparator<user>() {
                    @Override
                    public int compare(user u1, user u2) {
                        String[] name1 = u1.getFullname().split(" ");
                        String[] name2 = u2.getFullname().split(" ");
                        return name1[name1.length - 1].compareToIgnoreCase(name2[name2.length - 1]);
                    }
                });
            }
            if (viewProfile != null) {

                //req.setAttribute("account", viewProfile);
                resp.sendRedirect("adminViewUserProfile?account=" + viewProfile);
            }

            req.setAttribute("numPages", numberPage);
            req.setAttribute("currentPage", currentPage);
            req.setAttribute("listCustomer", listCustomerInPage);
            req.getRequestDispatcher("AdminView/admin-screen/ManageCustomer.jsp").forward(req, resp);
        }
    }

    private void changePosition(String pos, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            switch (pos) {
                case "1":
                    resp.sendRedirect("adminDashboard");
                    break;
                case "2":
                    resp.sendRedirect("manageStaff");
                    break;
                case "3":
                    resp.sendRedirect("manageCustomer");
                    break;
                case "4":
                    resp.sendRedirect("manageRoom");
                    break;
                case "5":
                    resp.sendRedirect("manageGlasses");
                    break;
                case "6":
                    resp.sendRedirect("feedback");
                    break;
                case "7":
                    resp.sendRedirect("adminDashboard");
                    break;
                case "8":
                    resp.sendRedirect("adminDashboard");
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println("Change position page error: " + e.getMessage());
        }
    }
}
