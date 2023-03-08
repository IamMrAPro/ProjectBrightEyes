/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.Attendance;
import com.groud2.web.model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ao
 */
public class TakeStaffAttendanceController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        userDAO u = new userDAO();
        HttpSession session = req.getSession();
        String adminAccount = (String) session.getAttribute("id");
        String staffAccount = (String) session.getAttribute("staffAccount");
        // data
//        String staffAccount = req.getParameter("staffAccount");
        String staffId = req.getParameter("staffId");

        String date = req.getParameter("date");
        String time = req.getParameter("time");
        String dateOfList = req.getParameter("dateOfList");
        String update = req.getParameter("update");
        // button
        String submitAtt = req.getParameter("submitAttendance");
        String searchListByDate = req.getParameter("searchDate");

        if (submitAtt != null) {
            int id = u.getLastID();
            id++;

            //Validate: cannot take attendance for 
            LocalDateTime localDate = LocalDateTime.now();

            DateTimeFormatter f1 = DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            String today = f2.format(localDate);
            String currentTime = f1.format(localDate);

            if (isTime(time) == false) {
                ArrayList<user> staff = null;
                System.out.println("Staff account is: " + staffAccount);
                try {
                    staff = u.getAllByAcc(staffAccount);
                } catch (SQLException ex) {
                    Logger.getLogger(TakeStaffAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<Attendance> listAt = u.listAttendance(date, staffAccount);
                req.setAttribute("message", "You time is invalid!");
                req.setAttribute("listAtt", listAt);
                req.setAttribute("adminAccount", adminAccount);
                req.setAttribute("today", today);
                req.setAttribute("nowTime", currentTime);
                req.setAttribute("staff", staff);
                req.getRequestDispatcher("AdminView/admin-screen/TakeStaffAttendance.jsp").forward(req, resp);
            } else {
                int compareTime = compareTime(currentTime, time);
                System.out.println("compare time = " + compareTime);
                SimpleDateFormat fm1 = new SimpleDateFormat("dd-MM-yyyy");
                Date todayDate = new Date();
                try {
                    todayDate = fm1.parse(today);
                } catch (ParseException ex) {
                    Logger.getLogger(TakeStaffAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Date inputDate = new Date();
                try {
                    inputDate = fm1.parse(date);
                } catch (ParseException ex) {
                    Logger.getLogger(TakeStaffAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
                }
                int compareDate = inputDate.compareTo(todayDate);
                System.out.println("Date input = " + inputDate);
                System.out.println("today is " + todayDate);
                System.out.println("Compare date = " + compareDate);
                if (isDateValid(date) == false) {
                    ArrayList<user> staff = null;
                    System.out.println("Staff account is: " + staffAccount);
                    try {
                        staff = u.getAllByAcc(staffAccount);
                    } catch (SQLException ex) {
                        Logger.getLogger(TakeStaffAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ArrayList<Attendance> listAt = u.listAttendance(date, staffAccount);
                    req.setAttribute("message", "You date is invalid!");
                    req.setAttribute("listAtt", listAt);
                    req.setAttribute("adminAccount", adminAccount);
                    req.setAttribute("today", today);
                    req.setAttribute("nowTime", currentTime);
                    req.setAttribute("staff", staff);
                    req.getRequestDispatcher("AdminView/admin-screen/TakeStaffAttendance.jsp").forward(req, resp);
                }

                if ((compareDate < 0) || (compareDate == 0 && compareTime < 0)) {
                    ArrayList<user> staff = null;
                    System.out.println("Staff account is: " + staffAccount);
                    try {
                        staff = u.getAllByAcc(staffAccount);
                    } catch (SQLException ex) {
                        Logger.getLogger(TakeStaffAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ArrayList<Attendance> listAt = u.listAttendance(date, staffAccount);
                    req.setAttribute("message", "You cannot take attendance for future!");
                    req.setAttribute("listAtt", listAt);
                    req.setAttribute("adminAccount", adminAccount);
                    req.setAttribute("today", today);
                    req.setAttribute("nowTime", currentTime);
                    req.setAttribute("staff", staff);
                    req.getRequestDispatcher("AdminView/admin-screen/TakeStaffAttendance.jsp").forward(req, resp);
                } else {
                    if (u.takeAttendance(String.valueOf(id), staffId, date, time)) {
                        resp.sendRedirect("manageStaff");
                    } else {

                        ArrayList<user> staff = null;
                        try {
                            staff = u.getAllByAcc(staffAccount);
                        } catch (SQLException ex) {
                            Logger.getLogger(TakeStaffAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ArrayList<Attendance> listAt = u.listAttendance(date, staffAccount);

                        req.setAttribute("listAtt", listAt);
                        req.setAttribute("today", date);
                        req.setAttribute("nowTime", time);
                        req.setAttribute("staff", staff);
                        req.setAttribute("message", "Oh no!\nThere are some error occur during taking attendance");
                        req.getRequestDispatcher("AdminView/admin-screen/TakeStaffAttendance.jsp").forward(req, resp);
                    }
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        userDAO u = new userDAO();
        HttpSession session = req.getSession();
        String adminAccount = (String) session.getAttribute("id");
        String staffAccount = req.getParameter("staffAccount");
        session.setAttribute("staffAccount", staffAccount);
        ArrayList<user> staff = null;
        try {
            staff = u.getAllByAcc(staffAccount);
        } catch (SQLException ex) {
            Logger.getLogger(TakeStaffAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // get today date
        LocalDateTime localDate = LocalDateTime.now();

        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String today = f2.format(localDate);
        String currentTime = f1.format(localDate);

        ArrayList<Attendance> listAt = new ArrayList<>();
        if (staff != null) {
            listAt = u.listAttendance(today, staff.get(0).getUserId());
        }
        System.out.println("today is: " + today);
        System.out.println("This account staff is " + staffAccount);
        req.setAttribute("listAtt", listAt);
        req.setAttribute("adminAccount", adminAccount);
        req.setAttribute("today", today);
        req.setAttribute("nowTime", currentTime);
        req.setAttribute("staff", staff);
        req.getRequestDispatcher("AdminView/admin-screen/TakeStaffAttendance.jsp").forward(req, resp);
    }

    public int compareTime(String time1, String time2) {
        String[] ct1 = time1.split(":");
        String[] ct2 = time2.split(":");
        System.out.println("ct1 size = " + ct1.length);
        System.out.println("ct2 size = " + ct2.length);
        int t1 = Integer.parseInt(ct1[0]) * 3600 + Integer.parseInt(ct1[1]) * 60 + Integer.parseInt(ct1[2]);
        int t2 = Integer.parseInt(ct2[0]) * 3600 + Integer.parseInt(ct2[1]) * 60 + Integer.parseInt(ct2[2]);
        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
        if (t1 > t2) {
            return 1;
        } else if (t1 < t2) {
            return -1;
        }
        return 0;
    }

    public boolean isDateValid(String dateStr) {
        try {
            LocalDate.parse(dateStr, java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean isTime(String time) {
        String TIME = "^([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$";
        Pattern p = Pattern.compile(TIME);
        Matcher m = p.matcher(time);
        return m.matches();
    }
}
