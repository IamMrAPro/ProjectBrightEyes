/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller.TestEyes;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Random;

/**
 *
 * @author anhha
 */
public class TestController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        for (int i = 0; i < 6; i++) {

            String randomString = generateRandomString();

            session.setAttribute("testcase" + (i + 1), randomString);

        }
        request.getRequestDispatcher("test.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String[] listTest = new String[6];
        String[] listInputTest = new String[6];
        int equal = 0;
        String mess = null;
        
        System.out.println("charts" + request.getParameter("chars1"));
        for (int i = 0; i <= 5; i++) {
            listTest[i] = (String) request.getParameter("chars" + (i + 1));
            listInputTest[i] = (String) request.getParameter("stepInput" + (i + 1));
        }

        for (int i = 0; i <= 5; i++) {
            if (!listTest[i].equalsIgnoreCase(listInputTest[i])) {
                equal += 1;
            }
        }
        if(equal<=1){
            mess = " Congratulations if you could read up to step six: this gives you 'normal' "
                    + "vision of "+(6-equal)+"/6, or 20/20. Despite popular belief, a score of 6/6 doesn't equal "
                    + "'perfect' vision, since it is both possible and common to see better than 6/6. In fact,"
                    + " it's believed that the human eye has a maximum acuity of 6/3 without visual aids such as "
                    + "binoculars. To fly a plane, you'll need to either have 6/6 vision or have your vision corrected to 6/6.\n";
           
        }else if(equal>1){
            mess = " Congratulations if you could read up to step six: this gives you not 'normal' "
                    + "vision of "+(6-equal)+"/6, or 20/20";
           
        }
        request.setAttribute("mess",mess);
        
        request.getRequestDispatcher("testOnline.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public static String generateRandomString() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }
        return sb.toString();
    }
}
