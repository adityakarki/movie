package com.example.movie.auth.controller;

import com.example.movie.auth.dao.AuthDao;
import com.example.movie.auth.dao.AuthDaoFactory;
import com.example.movie.auth.dto.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Author: Pramod Bhandari
 * Date: 3/26/13
 * Time: 8:46 PM
 */
public class Signup extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AuthDao dao;
        String firstname = new String();
        String lastname = new String();
        String username = new String();
        String password = new String();
        String repassword = new String();
        User user;
        try {
            dao = AuthDaoFactory.getAuthDao();
            firstname = request.getParameter("firstname");
            lastname = request.getParameter("lastname");
            username = request.getParameter("username");
            password = request.getParameter("password");
            repassword = request.getParameter("repassword");
            if (validateSignup(firstname, lastname, username, password, repassword)) {
                user = dao.signup(firstname, lastname, username, password);
                return;
            } else {
                request.setAttribute("firstname", firstname);
                request.setAttribute("lastname", lastname);
                request.setAttribute("username", username);
                RequestDispatcher view;
                view = request.getRequestDispatcher("/pages/auth/signup.jsp");
                view.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String redirectUrl = response.encodeRedirectURL(request.getContextPath() + "/auth/signup");
            response.sendRedirect(redirectUrl);
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher view;
        view = request.getRequestDispatcher("/pages/auth/signup.jsp");
        view.forward(request, response);

    }

    private boolean validateSignup(String firstname, String lastname, String username, String password, String repassword) {
        boolean valid = true;
        try {
            AuthDao dao = AuthDaoFactory.getAuthDao();
            valid = valid && !firstname.trim().isEmpty();
            valid = valid && (!dao.existsUsername(username));
            valid = valid && password.equals(repassword);
        } catch (Exception e) {
            e.printStackTrace();
            valid = false;
        }
        return valid;
    }
}
