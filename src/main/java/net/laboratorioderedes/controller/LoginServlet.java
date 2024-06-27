/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package net.laboratorioderedes.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.laboratorioderedes.bean.LoginBean;
import net.laboratorioderedes.dao.LoginDao;
import net.laboratorioderedes.dao.LoginDaoImpl;

/**
 *
 * @author cerso
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("Inside servlet");

        LoginBean loginBean = new LoginBean();

        loginBean.setUserName(userName);
        loginBean.setPassword(password);

        LoginDao loginDao = new LoginDaoImpl();

        String userValidate = loginDao.authenticateUser(loginBean);

        if (userValidate.equals("Admin_Role")) {
            System.out.println("Admin's Home");

            HttpSession session = request.getSession(); //Creating a session
            session.setAttribute("Admin", userName); //setting session attribute
            request.setAttribute("userName", userName);

            request.getRequestDispatcher("/JSP/Admin.jsp").forward(request, response);
        } else if (userValidate.equals("Editor_Role")) {
            System.out.println("Editor's Home");

            HttpSession session = request.getSession();
            session.setAttribute("Editor", userName);
            request.setAttribute("userName", userName);

            request.getRequestDispatcher("/JSP/Editor.jsp").forward(request, response);
        } else if (userValidate.equals("User_Role")) {
            System.out.println("User's Home");

            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10 * 60);
            session.setAttribute("User", userName);
            request.setAttribute("userName", userName);

            request.getRequestDispatcher("/JSP/User.jsp").forward(request, response);
        } else {
            System.out.println("Error message = " + userValidate);
            request.setAttribute("errMessage", userValidate);

            request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
        }
    }
 
  
} //End of doPost()



