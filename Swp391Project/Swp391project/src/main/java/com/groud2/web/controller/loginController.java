package com.groud2.web.controller;


import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//=======
import jakarta.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/java/loginController.java

/**
 *
 * @author anhha
 */
public class loginController extends HttpServlet {


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
//<<<<<<< Updated upstream:Swp391Project/Swp391project/src/main/java/com/groud2/web/controller/loginController.java

            out.println("<title>Servlet loginController</title>");            

            out.println("<title>Servlet loginController</title>");

//=======
            out.println("<title>Servlet loginController</title>");
//>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/java/loginController.java
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginController at " + request.getContextPath() + "</h1>");
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

    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    request.getRequestDispatcher("Login.jsp").forward(request, response);
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//<<<<<<< Updated upstream:Swp391Project/Swp391project/src/main/java/com/groud2/web/controller/loginController.java

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        
        try {
            password = encyptPass(password);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("encode password error: " + ex.getMessage());
        }
        
        System.out.println("password = " + password);
        //Xu ly           
        userDAO u = new userDAO();
        user loginOK;
        try {
            loginOK = u.checklogin(account, password);
            if (loginOK != null) {
                HttpSession session = request.getSession();

                String role = u.getUserRole(account);
                System.out.println("User role: " + role);
                System.out.println("Login Account: " + account);
                session.setAttribute("id", account);
                if(role.equals("admin")){
                    response.sendRedirect("adminHome");
                }
                else {
                    response.sendRedirect("home");
                }
            } else {
                response.sendRedirect("loginuser");

            }
        } catch (SQLException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Tra ket qua ve cho View

//=======
//        processRequest(request, response);
    }

    String encyptPass(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toLowerCase();
        return myHash;
//>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/java/loginController.java
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
